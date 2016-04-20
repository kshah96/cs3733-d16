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
import model.LightningLevel;
import model.Palette;
import model.PuzzleLevel;
import view.LevelEditorView;
import view.LevelLoaderView;


/**
 * Controls the creation of a new puzzle level in the level builder.
 * Upon the designer requesting to create a new puzzle level, this
 * controller creates the new level, adds it to the level builder's list 
 * of levels, and shows the level editor screen for the newly created level.
 * 
 * @author Connor Weeks
 * @author Alexander Kasparek
 */
public class NewPuzzleLevelController implements ActionListener {
	LevelBuilder builder;
	LevelLoaderView levelLoader;

	public NewPuzzleLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Bullpen bpen = new Bullpen();
		Board board = new Board();
		Palette p = new Palette();
		PuzzleLevel p2 = new PuzzleLevel(0, true, bpen, board, p, 0);
		builder.addLevel(p2);
		builder.setActiveLevel(p2);
		System.out.println(builder.getActiveLevel());

		// TODO Auto-generated method stub
		final LevelEditorView newPuzzleLevel = new LevelEditorView(builder, levelLoader);
		newPuzzleLevel.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				newPuzzleLevel.dispose();
				levelLoader.setVisible(true);
			}      
		});
		// Since this only varies by Level type and must also be done in gameplay, we
		// might be able to have an Initialize() method for each Level subclass that
		// sets the appropriate visibility...
		newPuzzleLevel.setMaxMovesPanelVisibility(true);
		newPuzzleLevel.setReleaseSquarePanelVisibility(false);
		newPuzzleLevel.setTimeLimitPanelVisibility(false);

		levelLoader.setVisible(false);
		newPuzzleLevel.setVisible(true);

	}	
}