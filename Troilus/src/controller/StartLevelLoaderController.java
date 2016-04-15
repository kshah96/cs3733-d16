package controller;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;

import model.LevelBuilder;
import model.Level;
import view.LevelLoaderView;

public class StartLevelLoaderController {
	LevelBuilder builder;
	LevelLoaderView levelLoaderView;

	public StartLevelLoaderController(LevelLoaderView levelLoaderView, LevelBuilder builder) {
		this.levelLoaderView = levelLoaderView;
		this.builder = builder;
	}

	public void process() {
		ArrayList<Level> levels = builder.getLevels();
		int numLevels = levels.size();
		
		ArrayList<JButton> buttons = levelLoaderView.getLevelButtons();
		// first set all buttons to invisible and disabled
		for (JButton button : buttons) {
			button.setVisible(false);
			button.setEnabled(false);
		}
		
		for (int i = 0; i < numLevels; i++) {
			// enable buttons if level exists
			buttons.get(i).setVisible(true);
			buttons.get(i).setEnabled(true);
		}
	}
}