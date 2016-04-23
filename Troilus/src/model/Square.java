package model;

// TODO: Shouldn't this be an interface now that we aren't storing anything?

/**
 * Class allows for consistent manipulation of square structure.
 * 
 * Allows for implementation of squares for Kabasuji. Squares can be
 * valid or invalid and have a type.
 * 
 * @author Maddy
 * @author Kunal Shah
 *
 */
public abstract class Square {
	int row;
	int col;
	boolean isValid;
	
	public Square(int row, int col, boolean isValid) {
		this.row = row;
		this.col = col;
		this.isValid = isValid;
	}
	
	public boolean isValid() {
		return true;
	}
	
	public abstract String getType();
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
}