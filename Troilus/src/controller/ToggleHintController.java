package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import view.BoardView;

/**
 * Toggles the selected Square on the board to be or not be a hint square, depending on its current state.
 * <p>
 * level = the current level being edited. <br>
 * <p>
 * @author Alexander Kasparek
 */
public class ToggleHintController implements ActionListener {
	/** The level to toggle hints on */
	Level level;
	
	/** The view for the board in this level */
	BoardView boardView;

	/**
	 * Creates a new instance of ToggleHintController with the following parameters
	 * @param level Reference to the level entity being edited
	 * @param boardView Reference to the view of the board in this level
	 */
	public ToggleHintController(Level level, BoardView boardView) {
		this.level = level;
		this.boardView = boardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Need to implement this.");
		
		// Toggles the hint on the board and updates the view
		level.getBoard().toggleHint();
		boardView.repaint();
	}
}