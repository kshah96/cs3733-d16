package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.NewPuzzleLevelController;
import controller.NewLightningLevelController;
import controller.NewReleaseLevelController;


import model.LevelBuilder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class LevelLoaderView extends JFrame {

	LevelBuilder lb;
	
	/**
	 * Create the frame.
	 */
	
	public LevelLoaderView(LevelBuilder lb) {
		this.lb = lb;
		initialize();
	}
	
	void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 103, 649, 409);
		getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("Game Levels");
		label_1.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		label_1.setBounds(299, 0, 117, 16);
		panel_1.add(label_1);
		
		JButton button_1 = new JButton("Level 1: Puzzle");
		button_1.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_1.setBackground(UIManager.getColor("Button.background"));
		button_1.setBounds(6, 17, 136, 29);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Level 4: Puzzle");
		button_2.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_2.setBackground(UIManager.getColor("Button.background"));
		button_2.setBounds(6, 45, 136, 29);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Level 7: Puzzle");
		button_3.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_3.setBackground(UIManager.getColor("Button.background"));
		button_3.setBounds(6, 75, 136, 29);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Level 10: Puzzle");
		button_4.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_4.setBackground(UIManager.getColor("Button.background"));
		button_4.setBounds(6, 102, 136, 29);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("Level 13: Puzzle");
		button_5.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_5.setBackground(UIManager.getColor("Button.background"));
		button_5.setBounds(6, 130, 136, 29);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("Level 2: Lightning");
		button_6.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_6.setBackground(UIManager.getColor("Button.background"));
		button_6.setBounds(224, 17, 148, 29);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("Level 5: Lightning");
		button_7.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_7.setBackground(UIManager.getColor("Button.background"));
		button_7.setBounds(224, 44, 148, 29);
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("Level 8: Lightning");
		button_8.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_8.setBackground(UIManager.getColor("Button.background"));
		button_8.setBounds(224, 72, 148, 29);
		panel_1.add(button_8);
		
		JButton button_9 = new JButton("Level 11: Lightning");
		button_9.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_9.setBackground(UIManager.getColor("Button.background"));
		button_9.setBounds(224, 101, 148, 29);
		panel_1.add(button_9);
		
		JButton button_10 = new JButton("Level 14: Lightning");
		button_10.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_10.setBackground(UIManager.getColor("Button.background"));
		button_10.setBounds(224, 130, 148, 29);
		panel_1.add(button_10);
		
		JButton button_11 = new JButton("Level 3: Release");
		button_11.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_11.setBackground(UIManager.getColor("Button.background"));
		button_11.setBounds(471, 17, 148, 29);
		panel_1.add(button_11);
		
		JButton button_12 = new JButton("Level 6: Release");
		button_12.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_12.setBackground(UIManager.getColor("Button.background"));
		button_12.setBounds(471, 46, 148, 29);
		panel_1.add(button_12);
		
		JButton button_13 = new JButton("Level 9: Release");
		button_13.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_13.setBackground(UIManager.getColor("Button.background"));
		button_13.setBounds(471, 76, 148, 29);
		panel_1.add(button_13);
		
		JButton button_14 = new JButton("Level 12: Release");
		button_14.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_14.setBackground(UIManager.getColor("Button.background"));
		button_14.setBounds(471, 105, 148, 29);
		panel_1.add(button_14);
		
		JButton button_15 = new JButton("Level 15: Release");
		button_15.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_15.setBackground(UIManager.getColor("Button.background"));
		button_15.setBounds(471, 130, 148, 29);
		panel_1.add(button_15);
		
		JButton button_16 = new JButton("Level 16: Puzzle");
		button_16.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button_16.setBackground(UIManager.getColor("Button.background"));
		button_16.setBounds(6, 161, 136, 29);
		panel_1.add(button_16);
		
		JButton btnLevelRelease = new JButton("Level 17: Release");
		btnLevelRelease.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease.setBackground(UIManager.getColor("Button.background"));
		btnLevelRelease.setBounds(224, 161, 148, 29);
		panel_1.add(btnLevelRelease);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 0, 655, 48);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLevelEditor = new JLabel("Level Loader");
		lblLevelEditor.setBounds(238, 6, 210, 38);
		panel_2.add(lblLevelEditor);
		lblLevelEditor.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelEditor.setForeground(Color.LIGHT_GRAY);
		lblLevelEditor.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		
		JButton btnNewPuzzleLevel = new JButton("New Puzzle Level");
		btnNewPuzzleLevel.addMouseListener(new NewPuzzleLevelController(lb, this));
		btnNewPuzzleLevel.setBounds(10, 54, 130, 37);
		getContentPane().add(btnNewPuzzleLevel);
		
		JButton btnNewLightningLevel = new JButton("New Lightning Level");
		btnNewLightningLevel.addMouseListener(new NewLightningLevelController(lb, this));
		btnNewLightningLevel.setBounds(152, 54, 146, 37);
		getContentPane().add(btnNewLightningLevel);
		
		JButton btnNewReleaseLevel = new JButton("New Release Level");
		btnNewReleaseLevel.addMouseListener(new NewReleaseLevelController(lb, this));
		btnNewReleaseLevel.setBounds(310, 54, 137, 37);
		getContentPane().add(btnNewReleaseLevel);

		setSize(new Dimension(650,550));
	}

}
