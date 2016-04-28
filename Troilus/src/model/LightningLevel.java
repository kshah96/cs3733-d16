package model;

import java.util.Random;
import java.util.Set;

/**
 * Represents a Level of game type Lightning in the Kabasuji game.
 * 
 * The LightningLevel structure stores the time limit in seconds the Level
 * must be completed in and the number of squares that have been covered by Piece(s).
 * 
 * @author Kunal Shah
 * @author Maddy
 */
public class LightningLevel extends Level{
	protected int coveredSquares;
	protected int validSquares;
	protected int timeLimit;
	
	public LightningLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette, int timeLimit) {
		super(levelNum, locked, bullpen, board, palette);
		
		this.timeLimit = timeLimit;
		this.countValidSquares();
		this.coveredSquares = 0;
	}

	public void updateAfterMove() {
		coverSquares();
		replacePiece();
		countValidSquares(); // Just in case in Level Editor
		calcNumStars();
	}
	
	/** Generate a new random piece and put in bullpen */
	private void replacePiece() {
		Random rand = new Random();
		int randNum = rand.nextInt(36);
		System.out.println(randNum);
		Piece newPiece = PieceFactory.getPiece(randNum);
		bullpen.addPiece(newPiece);
	}
	
	/** Replace any pieces with covered squares on the board */
	private void coverSquares() {
		Set<Piece> pSet = board.getPieces().keySet();
		for (Piece piece : pSet) {
			int anchorCol = board.getPieces().get(piece).x;
			int anchorRow = board.getPieces().get(piece).y;
			
			((LightningSquare) board.squares[anchorCol][anchorRow]).isCovered = true;
			for (PieceSquare square : piece.getSquares()) {
				int currentCol = anchorCol + square.getCol();
				int currentRow = anchorRow + square.getRow();

				((LightningSquare) board.squares[currentCol][currentRow]).isCovered = true;
			}
			
			board.removePiece(piece);
		}
	}
	
	@Override
	/** 1 star if covered all but 12 squares, 2 if covered all but 6, 3 if won */
	public void calcNumStars() {
		int squaresLeft = validSquares - coveredSquares;
		
		if (squaresLeft > 12) {
			numStars = 0;
		} else if (squaresLeft > 6) {
			numStars = 1;
		} else if (squaresLeft > 0) {
			numStars = 2;
		} else {
			numStars = 3;
		}
	}
	
	/** Count the number of squares on the board (needed for LevelEditor) */
	void countValidSquares() {
		int squareCounter = 0;
		
		for (Square[] col : board.squares) {
			for (Square square : col) {
				if (square.isValid()) {
					squareCounter++;
				}
			}
		}
		
		validSquares = squareCounter;
	}
	
	// TODO make this reachable from Board/etc.
	public void updateSquaresCovered(int i) {
		coveredSquares += i;
	}
	
	public boolean canMove() {
		return timeLimit > 0;
	}
	
	public String getName() {
		return "Lightning";
	}
	
	public int getTime() {
		return timeLimit;
	}
	
	public boolean setTimeLimit(int limit) {
		if (limit < 0) {
			System.out.println("Error! Invalid time limit.");
			return false;
		} else {
			this.timeLimit = limit;
			return true;
		}	
	}
}