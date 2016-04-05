package MockupGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Splash_Screen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash_Screen window = new Splash_Screen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Splash_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 534, 305);
		panel.setBorder(null);
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Kabasuji");
		label.setBounds(151, 38, 248, 108);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("PT Sans Caption", Font.BOLD, 55));
		panel.add(label);
		
		JLabel lblTroilus = new JLabel("Troilus");
		lblTroilus.setHorizontalAlignment(SwingConstants.CENTER);
		lblTroilus.setForeground(Color.LIGHT_GRAY);
		lblTroilus.setFont(new Font("PT Sans Caption", Font.BOLD, 26));
		lblTroilus.setBounds(151, 133, 248, 108);
		panel.add(lblTroilus);
	}

}
