package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Set;

import model.Bullpen;
import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import model.PuzzleLevel;
import model.Square;
import view.BoardView;
import view.BullpenView;
import view.ILevelView;
import view.LevelEditorView;
import view.LevelPlayerView;

/**
 * Class that handles events related to Bullpen.
 * @author Maddy
 * @author Alex
 * @author Connor
 * @author Kunal
 * @author Dan
 * 
 */
public class BullpenController extends MouseAdapter {
	/** The level that this bullpen is in */
	protected Level level;

	/** The view for this bullpen */
	protected BullpenView bullpenView;

	/** The view for the level containing this bullpen */
	ILevelView levelView;

	/** Any active piece in the level */
	Piece activePiece;

	/** The view for the board in this level */
	BoardView boardView;

	LevelBuilder builder;
	Kabasuji game;

	/**
	 * Creates a new instance of the BullpenController with the given parameters
	 * @param level The level of this bullpen
	 * @param levelView The view for the level of this bullpen
	 */
	public BullpenController(Level level, ILevelView levelView, LevelBuilder builder) {
		super();
		this.level = level;
		this.levelView = levelView;
		this.bullpenView = levelView.getBullpenView();
		this.boardView = levelView.getBoardView();
		this.builder = builder;
		boardView.removeDraggedPiece();
	}

	public BullpenController(Level level, ILevelView levelView, Kabasuji game) {
		super();
		this.level = level;
		this.levelView = levelView;
		this.bullpenView = levelView.getBullpenView();
		this.boardView = levelView.getBoardView();
		this.game = game;
		boardView.removeDraggedPiece();
	}

	// TODO why do this??
	public void mousePressed(MouseEvent me) {
		handleMousePressed(me.getPoint(), me.getButton());
	}

	void handleMousePressed(Point p, int mouseButton) {
		int x = p.x;
		int y = p.y;

		if (mouseButton == MouseEvent.BUTTON3) { // right click
			System.out.println("Right click");
			if (boardView.getDraggedPiece() != null) { // right click and dragging
				boardView.removeDraggedPiece();
				level.removeActivePiece();
				level.setMoveSource(null);
			} else if (builder != null) { // right click and not dragging
				level.getBullpen().removePiece(getClickedPiece(x, y));
				boardView.removeDraggedPiece();
				level.removeActivePiece();
				level.setMoveSource(null);
			}
		} else {
			System.out.println("Left click");
			if (boardView.getDraggedPiece() != null) { // left-click while dragging
				System.out.println("Dragging a piece");
				if (level.getMoveSource() == level.getBoard()) { // Move from Board
					Move m = new BoardToBullpenMove(level, level.getActivePiece());
					if (m.doMove()) {
						// TODO fix copy-pasted code!!!
						if (builder != null) {
							// if we are in the level builder
							builder.pushMove(m);

						} else {
							// if we are in the player
							// end game if needed
							if (m.getEndGameStatus()) {
								new ExitLevelController((LevelPlayerView)levelView, game, level).process();
							}
						}
						// If the move is valid (and completed), we remove the source and active pieces
						boardView.removeDraggedPiece();
						level.setMoveSource(null);
						level.setActivePiece(null);
					}
				} else { // Click in bullpen
					if (level.getMoveSource() == level.getBullpen()) { // Piece came from bullpen
						boardView.removeDraggedPiece();
						level.setMoveSource(null);
						level.setActivePiece(null);
					} else { // Piece came from board
						// TODO fix this bad code!
						Move btbm = new BoardToBullpenMove(level, level.getActivePiece());
						if (btbm.doMove()) {
							if (builder != null) {
								builder.pushMove(btbm);
							} else if (level instanceof PuzzleLevel) {
								if (btbm.getEndGameStatus()) {
									new ExitLevelController((LevelPlayerView)levelView, game, level).process();
								}
							} else { // Not a valid move!
								levelView.refresh();
								return;
							}
							boardView.addDraggedPiece(getClickedPiece(x, y), p);
							level.setMoveSource(level.getBullpen());
							level.setActivePiece(getClickedPiece(x, y));
						}
					}
				}
			} else { // left-click while not dragging
				System.out.println("Not dragging a piece");
				Piece clickedPiece = getClickedPiece(x, y);
				if (clickedPiece != null) { // Clicked a piece
					boardView.addDraggedPiece(clickedPiece, p);
					level.setMoveSource(level.getBullpen());
					level.setActivePiece(clickedPiece);
					System.out.println("Clicked piece is not null");
				}
				System.out.println("Clicked piece is null");
			}
		}
		levelView.refresh();
	}

	// Ugly quick hack to get stuff working quickly
	Piece getClickedPiece(int x, int y) {
		// find the piece that was clicked
		Hashtable<Piece, Point> pieces = bullpenView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();
		activePiece = null;

		int size = BullpenView.SQUARE_SIZE;
		// check anchor square and relative squares for each piece in the bullpen
		for (Piece piece : keySet) {
			int aCol = pieces.get(piece).x;
			int aRow = pieces.get(piece).y;

			// Piece was clicked if the x coordinate is within the SQUARE_SIZE constant of each point's
			// x coordinate and the SQUARE_SIZE constant of each point's y coordinate
			for (Square s : piece.getAllSquares()) {
				int sCol = s.getCol();
				int sRow = s.getRow();

				if ((aCol + (sCol * size) <= x) && 
						(aCol + (sCol * size) + size >= x) && 
						(aRow + (sRow * size) <= y) && 
						(aRow + (sRow * size) + size >= y)) {
					activePiece = piece;
					break;
				}
			}

			// If we have found a piece, exit the for loop
			if (activePiece != null) {
				return activePiece;
			}
		}

		return activePiece;
	}

	void handleMousePressed_old(Point p, int mouseButton) {
		// If a piece is being dragged we don't want to interact with the bullpen
		//if(boardView.getDraggedPiece() != null) { return; }

		// First obtain the x and y coordinates from the mouse press
		int x = p.x;
		int y = p.y;

		System.out.println(x);
		System.out.println(y);

		// Create a reference to the bullpen
		Bullpen bullpen = level.getBullpen();

		// find the piece that was clicked
		Hashtable<Piece, Point> pieces = bullpenView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();
		activePiece = null;

		int size = BullpenView.SQUARE_SIZE;
		// check anchor square and relative squares for each piece in the bullpen
		for (Piece piece : keySet) {
			int aCol = pieces.get(piece).x;
			int aRow = pieces.get(piece).y;

			// Piece was clicked if the x coordinate is within the SQUARE_SIZE constant of each point's
			// x coordinate and the SQUARE_SIZE constant of each point's y coordinate
			for (Square s : piece.getAllSquares()) {
				int sCol = s.getCol();
				int sRow = s.getRow();

				if ((aCol + (sCol * size) <= x) && 
						(aCol + (sCol * size) + size >= x) && 
						(aRow + (sRow * size) <= y) && 
						(aRow + (sRow * size) + size >= y)) {
					activePiece = piece;
					break;
				}
			}

			// If we have found a piece, exit the for loop
			if (activePiece != null) {
				break;
			}
		}

		// check if we didn't find a piece, deselect currently selected piece
		if (activePiece == null && level.getMoveSource() == bullpen) {
			level.setActivePiece(null);
			boardView.removeDraggedPiece();
			bullpenView.repaint();
			boardView.repaint();
			return;
		}

		// a right click will remove the selected piece from the bullpen
		if(boardView.getDraggedPiece() == null) {
			if (mouseButton == MouseEvent.BUTTON3) {
				if(levelView instanceof LevelEditorView) {
					bullpen.removePiece(activePiece);
					level.setActivePiece(null);
				}
			} else {
				if (level.getActivePiece() == activePiece) {
					// if the piece is already selected, deselect it
					level.setActivePiece(null);
				} else {
					// set piece as active piece and set the source as the bullpenview and redraw
					level.setMoveSource(bullpenView);
					level.setActivePiece(activePiece); 
				}
			}
		} else {
			if (mouseButton == MouseEvent.BUTTON3) {
				if(levelView instanceof LevelEditorView) {
					bullpen.addPiece(level.getActivePiece());
					boardView.removeDraggedPiece();
					level.setMoveSource(null);
					level.setActivePiece(null);
					bullpenView.repaint();
					boardView.repaint();
				}
			} else {
				if (boardView.getDraggedPiece() == activePiece) {
					// if the piece is already selected, deselect it
					boardView.removeDraggedPiece();
					level.setActivePiece(null);
					
				} else {
					// set piece as active piece and set the source as the bullpenview and redraw
					level.setMoveSource(bullpenView);
					level.setActivePiece(activePiece); 
					//boardView.removeDraggedPiece();
					boardView.repaint();
				}
			}
		}
		// Refresh view regardless of what happened
		levelView.refresh();
	}
}
