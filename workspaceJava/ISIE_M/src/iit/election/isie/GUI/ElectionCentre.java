package iit.election.isie.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ElectionCentre {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElectionCentre window = new ElectionCentre();
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
	public ElectionCentre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 685, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 21, 614, 396);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(88, 50, 429, 40);
		panel.add(panel_1);
		
		JLabel label = new JLabel("\u0627\u0633\u0645 \u0645\u0631\u0643\u0632 \u0627\u0644\u0627\u0642\u062A\u0631\u0627\u0639");
		label.setBounds(302, 11, 117, 14);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 8, 282, 20);
		panel_1.add(textField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(88, 112, 429, 40);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("\u0639\u062F\u062F \u0645\u0631\u0627\u0643\u0632 \u0627\u0644\u0627\u0642\u062A\u0631\u0627\u0639");
		label_1.setBounds(302, 11, 117, 14);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 8, 282, 20);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(88, 270, 468, 40);
		panel.add(panel_3);
		
		JButton button = new JButton("\u062A\u0633\u062C\u064A\u0644");
		button.setBounds(44, 11, 89, 23);
		panel_3.add(button);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(88, 173, 429, 40);
		panel.add(panel_4);
		
		JLabel label_2 = new JLabel("\u0639\u062F\u062F \u0627\u0644\u0645\u0633\u062E\u0644\u064A\u0646 \u0627\u0644\u0645\u062F\u0646\u064A\u0646");
		label_2.setBounds(302, 11, 117, 14);
		panel_4.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 8, 282, 20);
		panel_4.add(textField_2);
	}

}
