package model;

/**
 * Represents a Level of game type Puzzle in the Kabasuji game
 * 
 * The PuzzleLevel structure stores the the maximum number of moves the Player is allowed to perform as well as the number of moves remaining
 * 
 * @author Kunal Shah
 *
 */
public class PuzzleLevel extends Level {
	int maxMoves;
	int movesLeft;
	
	public PuzzleLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette, int maxMoves) {
		super(levelNum, locked, bullpen, board, palette);
		
		this.maxMoves = maxMoves;
		this.movesLeft = this.maxMoves; // TODO: Can I do dis
	}

	@Override
	public void calcNumStars() {
		// TODO Implement this
	}
	
	public void updateMovesLeft(int i) {
		movesLeft += i;
	}
	
	public String getName() {
		return "Puzzle";
	}
	
	public int getMaxMoves() {
		return maxMoves;
	}
	
	public void setMaxMoves(int maxMoves){
		this.maxMoves = maxMoves;
	}
}