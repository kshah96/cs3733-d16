package controller;

import model.Board;
import model.Level;
import model.Piece;

/**
 * Class for implementation of moving a piece on the board.
 * @author Alex Kasparek
 * @author Maddy Longo
 * @author Dan Alfred
 * @author Kunal Shah
 *
 */
public class BoardToBoardMove extends Move{
	/** The level this move acts on. */
	Level level;

	/** The piece utilized during the move. */
	Piece movingPiece;

	/** The column on the board for destination. */
	int col;

	/** The row on the board for destination. */
	int row;

	/** movingPiece's previous row **/
	int previousRow;

	/** movingPiece's previous column**/
	int previousCol;

	/**
	 * Creates a new instance of a BoardToBoardMove with the given parameters.
	 * @param level The level to complete the move on
	 * @param col The column of the destination square on the board
	 * @param row The row of the anchor square on the board
	 * @param previousCol The current column of the anchor square on the board
	 * @param previousRow The current row of the anchor square on the board
	 */
	public BoardToBoardMove(Level level, int col, int row, int previousCol, int previousRow) {
		super();

		this.level = level;
		this.movingPiece = level.getBoard().getPiece(previousCol, previousRow);	
		this.col = col;
		this.row = row;

		this.previousCol = previousCol;
		this.previousRow = previousRow;

		System.out.println("previous Col, Row: " + previousCol + ", " + previousRow);
	}

	/**
	 * Completes this instance of BoardToBoardMove.
	 * @return True if the move completed successfully, or false if an error occurred.
	 */
	public boolean doMove() {
		// First check if the move is valid. Return false if invalid
		if (!isValid()) {
			System.out.println("Invalid move!");
			return false;
		}

		// Obtain a reference to the board and add the piece at the specified location
		Board board  = level.getBoard();
		board.addPiece(movingPiece, col, row);

		// Remove the active piece stored in level, and signal to update
		level.removeActivePiece();
		// set end game status
		endGameStatus = level.updateAfterMove();

		return true;
	}

	/**
	 * Checks if this BoardToBoardMove is valid with the given parameters<br />
	 * -Valid if all squares inside the piece are not on an invalid squares and <br />
	 * -There are no pieces underneath the requested piece 
	 * @return True if this BoardToBoardMove is valid with the given parameters, false otherwise
	 */
	public boolean isValid() {
		// TODO add test for ReleaseLevel, etc.
		return level.getBoard().validPlacement(movingPiece, col, row);
	}

	/**
	 * Undoes this BoardToBoardMove.
	 * @return True if the move was undone successfully, false otherwise.
	 */
	public boolean undo() {
		// TODO see if a check is needed here
		//if (isValidUndo()) {
			level.getBoard().addPiece(movingPiece, previousCol, previousRow);
			System.out.println("Piece moves back to: " + movingPiece.getCol() + ", " + movingPiece.getRow());
			System.out.println("Previous Col, Row: " + previousCol + ", " + previousRow);
			level.removeActivePiece();
			return true;
		//}
		//return false;
	}

	/**
	 * Determines if undoing this move is valid.
	 * @return True if the move can be undone, false if not.
	 */
	public boolean isValidUndo() {
		return level.getBoard().validPlacement(movingPiece, previousCol, previousRow);
	}
}