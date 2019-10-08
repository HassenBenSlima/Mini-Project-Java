package iit.election.isie.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Affectation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Affectation window = new Affectation();
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
	public Affectation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 673, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(38, 33, 583, 375);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(39, 43, 468, 58);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(28, 11, 311, 31);
		panel_2.add(comboBox);

		JLabel label = new JLabel("\u0627\u0644\u0628\u0644\u062F\u064A\u0629");
		label.setBounds(360, 19, 69, 14);
		panel_2.add(label);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(39, 122, 468, 58);
		panel_1.add(panel_3);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(28, 11, 311, 31);
		panel_3.add(comboBox_1);

		JLabel label_1 = new JLabel(
				"\u0639\u0646\u0648\u0627\u0646 \u0627\u0642\u0631\u0628 \u0645\u062F\u0631\u0633\u0629");
		label_1.setBounds(360, 19, 98, 14);
		panel_3.add(label_1);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(39, 255, 468, 58);
		panel_1.add(panel_4);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(28, 11, 311, 31);
		panel_4.add(comboBox_2);

		JLabel label_2 = new JLabel("\u0627\u0644\u062E\u0637\u0629");
		label_2.setBounds(360, 19, 98, 14);
		panel_4.add(label_2);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(39, 324, 468, 40);
		panel_1.add(panel_5);

		JButton button = new JButton("\u062A\u0633\u062C\u064A\u0644");
		button.setBounds(44, 11, 89, 23);
		panel_5.add(button);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(39, 186, 468, 58);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(28, 11, 311, 31);
		panel_6.add(comboBox_3);

		JLabel label_3 = new JLabel("\u0627\u0644\u0639\u0636\u0648");
		label_3.setBounds(360, 19, 98, 14);
		panel_6.add(label_3);
	}

}
