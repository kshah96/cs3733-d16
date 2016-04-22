package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.Palette;
import model.ReleaseLevel;
import model.ReleaseSquare;
import model.Square;
import view.LevelEditorView;
import view.LevelLoaderView;


/**
 * Controls the creation of a new release level in the level builder.
 * Upon the designer requesting to create a new release level, this
 * controller creates the new level, adds it to the level builder's list 
 * of levels, and shows the level editor screen for the newly created level.
 * 
 * @author Connor Weeks
 * @author Alexander Kasparek
 */
public class NewReleaseLevelController implements ActionListener {
	LevelBuilder builder;
	LevelLoaderView levelLoader;

	public NewReleaseLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		// Create a new Bullpen, Palette and Board for the Level
		Bullpen bpen = new Bullpen();
		Square[][] squares = new ReleaseSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for(int i = 0; i < Board.BOARD_WIDTH; i++){
			for(int j = 0; j < Board.BOARD_HEIGHT; j++){
				squares[i][j] = new ReleaseSquare(i, j, true);
			}
		}
		
		Board board = new Board(squares);
				
		Palette p = new Palette();
		ReleaseLevel r = new ReleaseLevel(builder.getLevels().size(), true, bpen, board, p);
		builder.addLevel(r);
		builder.setActiveLevel(r);

		// TODO Auto-generated method stub
		final LevelEditorView newReleaseLevel = new LevelEditorView(builder, levelLoader, r);

		newReleaseLevel.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				newReleaseLevel.dispose();
				levelLoader.setVisible(true);
			}      
		});

		//Show/hide specific elements to only show things relevant to release levels
		newReleaseLevel.setLevelType("Release");
		newReleaseLevel.setMaxMovesPanelVisibility(false);
		newReleaseLevel.setReleaseSquarePanelVisibility(true);
		newReleaseLevel.setTimeLimitPanelVisibility(false);

		levelLoader.setVisible(false);
		newReleaseLevel.setVisible(true);
	}
}