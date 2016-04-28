package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelPlayerView;

/**
 * Controls the actions required to exit a level and display the level selector.
 * This controller saves the plaer's progress, disposes of the current level view,
 * and returns the player to the level selector screen, where he / she may select a 
 * new level to play.
 * 
 * @author Connor Weeks
 *
 */
public class ExitLevelController implements ActionListener {
	/** The game */
	Kabasuji game;
	
	/** The levelview for the current level */
	LevelPlayerView levelView;

	/**
	 * Creates a new ExitLevelController for the given parameters
	 * @param levelView Boundary object for the current level
	 * @param game Reference to the main game entity
	 */
	public ExitLevelController(LevelPlayerView levelView, Kabasuji game) {
		this.levelView = levelView;
		this.game = game;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}

	/**
	 * Completes the exiting of the current level
	 */
	public void process() {
		// TODO save level progress?
		levelView.dispose();
		game.initialize();
		// create new window
		LevelSelectorView window = new LevelSelectorView(game);

		// allow controller to set up GUI based on the levels loaded by 'game'
		StartLevelSelectorController selectorController = new StartLevelSelectorController(window, game);
		selectorController.process();

		// show window
		window.setVisible(true);
	}
}