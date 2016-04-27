package model;

/**
 * Class allows for storage and manipulation of Puzzle Square.
 * 
 * Allows for implementation of Puzzle-level squares in Kabasuji.
 * 
 * @author Maddy
 * @author Kunal Shah
 *
 */
public class PuzzleSquare extends Square {
	
	/**
	 * Creates a PuzzleSquare with the following parameters.
	 * @param col
	 * @param row
	 * @param isValid
	 */
	public PuzzleSquare(int col, int row, boolean isValid) {
		super(col, row, isValid);
	}
	
	/**
	 * Creates a LightningSquare with the following parameters.
	 * @param col The column of the square
	 * @param row The row of the square
	 * @param isValid If the square is valid
	 * @param isHint If the square is to be highlighted as a hint
	 */
	public PuzzleSquare(int col, int row, boolean isValid, boolean isHint) {
		super(col, row, isValid, isHint);
	}


	@Override
	public String getType() {
		return "PuzzleSquare";
	}
}