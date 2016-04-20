package model;

/**
 * Class allows for storage and manipulation of Lightning Square.
 * 
 * @author Maddy
 *
 */
public class LightningSquare extends Square {
	boolean isCovered;
	
	public LightningSquare() {
		super();
	}

	/** Returns true if square is not already covered
	 * 
	 */
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "LightningSquare";
	}
}