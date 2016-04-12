package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import model.LevelBuilder;
import controller.ExitLevelEditorController;

public class LevelEditorView extends JFrame {

	private JTextField boardWidthField;
	private JTextField boardHeightField;
	private JTextField maxMovesField;
	private JTextField timeMinutesField;
	private JTextField timeSecondsField;
	JLabel levelTypeLabel;
	JPanel maxMovesPanel;
	JPanel releaseSquareOptionsPanel;
	JPanel timePanel;
	
	LevelLoaderView levelLoader;
	LevelBuilder builder;

	/**
	 * Create the application.
	 */
	public LevelEditorView(LevelBuilder builder, LevelLoaderView levelLoader){
		this.builder = builder;
		this.levelLoader = levelLoader;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(null);
		boardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		boardPanel.setBackground(Color.LIGHT_GRAY);
		boardPanel.setBounds(0, 113, 685, 408);
		getContentPane().add(boardPanel);
		
		JPanel bullPenPanel = new JPanel();
		bullPenPanel.setLayout(null);
		bullPenPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		bullPenPanel.setBackground(Color.LIGHT_GRAY);
		bullPenPanel.setBounds(685, 38, 457, 484);
		getContentPane().add(bullPenPanel);
		
		JPanel bullPenOptionsPanel = new JPanel();
		bullPenOptionsPanel.setLayout(null);
		bullPenOptionsPanel.setBackground(Color.LIGHT_GRAY);
		bullPenOptionsPanel.setBounds(6, 6, 446, 33);
		bullPenPanel.add(bullPenOptionsPanel);
		
		JLabel label_3 = new JLabel("Bullpen");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		label_3.setBounds(6, 6, 80, 23);
		bullPenOptionsPanel.add(label_3);
		
		JButton button_2 = new JButton("Rotate CW");
		button_2.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		button_2.setBounds(76, 4, 87, 29);
		bullPenOptionsPanel.add(button_2);
		
		JButton button_3 = new JButton("Rotate CCW");
		button_3.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		button_3.setBounds(158, 4, 87, 29);
		bullPenOptionsPanel.add(button_3);
		
		JButton btnFlipHorizontal = new JButton("Flip Horizontal");
		btnFlipHorizontal.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnFlipHorizontal.setBounds(237, 4, 105, 29);
		bullPenOptionsPanel.add(btnFlipHorizontal);
		
		JButton btnFlipVertical = new JButton("Flip Vertical");
		btnFlipVertical.setBounds(335, 4, 105, 29);
		bullPenOptionsPanel.add(btnFlipVertical);
		btnFlipVertical.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(0, 0, 1137, 38);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		saveButton.setBounds(0, 0, 102, 38);
		panel_4.add(saveButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(256, 0, 149, 38);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		levelTypeLabel = new JLabel("Puzzle");
		levelTypeLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		levelTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelTypeLabel.setBounds(6, 6, 124, 26);
		panel_5.add(levelTypeLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(404, 0, 351, 38);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JButton levelLoaderButton = new JButton("Level Loader");
		levelLoaderButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		levelLoaderButton.setBounds(871, 0, 199, 38);
		levelLoaderButton.addMouseListener(new ExitLevelEditorController(builder, this, levelLoader));
		panel_4.add(levelLoaderButton);
		
		JButton undoButton = new JButton("Undo");
		undoButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		undoButton.setBounds(102, 0, 74, 38);
		panel_4.add(undoButton);
		
		JButton redoButton = new JButton("Redo");
		redoButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		redoButton.setBounds(176, 0, 74, 38);
		panel_4.add(redoButton);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(0, 37, 686, 40);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblBoardSize = new JLabel("Board:");
		lblBoardSize.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblBoardSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoardSize.setBounds(0, 0, 74, 32);
		panel_7.add(lblBoardSize);
		
		boardWidthField = new JTextField();
		boardWidthField.setBounds(70, 1, 50, 28);
		panel_7.add(boardWidthField);
		boardWidthField.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBackground(Color.LIGHT_GRAY);
		lblX.setBounds(120, 10, 25, 13);
		panel_7.add(lblX);
		
		boardHeightField = new JTextField();
		boardHeightField.setColumns(10);
		boardHeightField.setBounds(148, 1, 50, 28);
		panel_7.add(boardHeightField);
		
		
		JButton btnNew = new JButton("Set");
		btnNew.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnNew.setBounds(209, -2, 74, 38);
		panel_7.add(btnNew);
		
		maxMovesPanel = new JPanel();
		maxMovesPanel.setBounds(286, 0, 184, 40);
		panel_7.add(maxMovesPanel);
		maxMovesPanel.setLayout(null);
		maxMovesPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		maxMovesPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblMaximumMoves = new JLabel("Maximum Moves:");
		lblMaximumMoves.setBounds(0, 0, 99, 32);
		maxMovesPanel.add(lblMaximumMoves);
		lblMaximumMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximumMoves.setFont(new Font("PT Sans Caption", Font.BOLD, 11));
		
		maxMovesField = new JTextField();
		maxMovesField.setBounds(101, 4, 74, 28);
		maxMovesPanel.add(maxMovesField);
		maxMovesField.setColumns(10);
		
		
		timePanel = new JPanel();
		timePanel.setBounds(469, 1, 217, 38);
		panel_7.add(timePanel);
		timePanel.setLayout(null);
		timePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		timePanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("PT Sans Caption", Font.BOLD, 11));
		lblTime.setBounds(2, 3, 42, 32);
		timePanel.add(lblTime);
		
		timeMinutesField = new JTextField();
		timeMinutesField.setColumns(10);
		timeMinutesField.setBounds(42, 5, 35, 28);
		timePanel.add(timeMinutesField);
		
		
		JLabel lblMinutes = new JLabel("minutes");
		lblMinutes.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblMinutes.setBounds(76, 13, 49, 13);
		timePanel.add(lblMinutes);
		
		timeSecondsField = new JTextField();
		timeSecondsField.setColumns(10);
		timeSecondsField.setBounds(120, 4, 35, 28);
		timePanel.add(timeSecondsField);
		
		
		JLabel lblSeconds = new JLabel("seconds");
		lblSeconds.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblSeconds.setBounds(156, 10, 48, 16);
		timePanel.add(lblSeconds);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_8.setBounds(0, 520, 972, 209);
		getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 199, 425, -14);
		panel_8.add(scrollPane);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 0, 88, 36);
		panel_8.add(panel_9);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.setLayout(null);
		
		JLabel lblPalette = new JLabel("Palette");
		lblPalette.setFont(new Font("PT Sans Caption", Font.BOLD, 14));
		lblPalette.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalette.setBounds(6, 6, 76, 24);
		panel_9.add(lblPalette);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 76, 685, 38);
		getContentPane().add(panel_1);
		
		JButton btnRemove = new JButton("Toggle");
		btnRemove.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnRemove.setBounds(437, 0, 115, 38);
		panel_1.add(btnRemove);
		
		JButton btnToggleHint = new JButton("Hint");
		btnToggleHint.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnToggleHint.setBounds(564, 0, 91, 38);
		panel_1.add(btnToggleHint);
		
		JLabel lblSquare = new JLabel("Square:");
		lblSquare.setHorizontalAlignment(SwingConstants.CENTER);
		lblSquare.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblSquare.setBounds(0, 2, 70, 32);
		panel_1.add(lblSquare);
		
		releaseSquareOptionsPanel = new JPanel();
		releaseSquareOptionsPanel.setBounds(84, 0, 341, 40);
		panel_1.add(releaseSquareOptionsPanel);
		releaseSquareOptionsPanel.setLayout(null);
		releaseSquareOptionsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		releaseSquareOptionsPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setBounds(6, 11, 61, 16);
		releaseSquareOptionsPanel.add(lblNumber);
		lblNumber.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		
		JComboBox releaseNumberComboBox = new JComboBox();
		releaseNumberComboBox.setBounds(66, 5, 85, 27);
		releaseSquareOptionsPanel.add(releaseNumberComboBox);
		releaseNumberComboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5", "6"}));
		
		JLabel lblNumberColor = new JLabel("Number Color:");
		lblNumberColor.setBounds(150, 11, 97, 16);
		releaseSquareOptionsPanel.add(lblNumberColor);
		lblNumberColor.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		
		JComboBox releaseColorComboBox = new JComboBox();
		releaseColorComboBox.setBounds(250, 5, 85, 27);
		releaseSquareOptionsPanel.add(releaseColorComboBox);
		releaseColorComboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Red", "Green", "Yellow"}));
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 1143, 751);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setLevelType(String type){
		levelTypeLabel.setText(type);
		//this.initialize();
	}
	
	public void setMaxMovesPanelVisibility(boolean which){
			maxMovesPanel.setVisible(which);
	}
	
	public void setReleaseSquareOptionsPanel(boolean which){
		releaseSquareOptionsPanel.setVisible(which);

	}
	public void setTimePanel(boolean which){
		timePanel.setVisible(which);

	}
}