package iit.election.isie.GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManGUI window = new ManGUI();
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
	public ManGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(28, 22, 536, 564);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(33, 87, 358, 40);
		panel_1.add(panel_2);

		JLabel label = new JLabel("\u0627\u0644\u0644\u0642\u0628");
		label.setBounds(302, 11, 46, 14);
		panel_2.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 8, 282, 20);
		panel_2.add(textField_1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(33, 138, 358, 40);
		panel_1.add(panel_3);

		JLabel lblCin = new JLabel("CIN");
		lblCin.setBounds(302, 11, 46, 14);
		panel_3.add(lblCin);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 8, 282, 20);
		panel_3.add(textField_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(33, 186, 404, 40);
		panel_1.add(panel_4);

		JLabel lblNomEtPrenom = new JLabel("nom et prenom 'fr' ");
		lblNomEtPrenom.setBounds(299, 11, 90, 14);
		panel_4.add(lblNomEtPrenom);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 8, 279, 20);
		panel_4.add(textField_3);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(56, 458, 358, 40);
		panel_1.add(panel_6);

		JButton btnNewButton = new JButton("\u062A\u0633\u062C\u064A\u0644");
		btnNewButton.setBounds(44, 11, 89, 23);
		panel_6.add(btnNewButton);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(33, 237, 381, 40);
		panel_1.add(panel_7);

		JLabel label_3 = new JLabel("\u0627\u0644\u0647\u0627\u062A\u0641 \u0627\u0644\u062C\u0648\u0627\u0644");
		label_3.setBounds(302, 11, 59, 14);
		panel_7.add(label_3);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 8, 282, 20);
		panel_7.add(textField_6);

		JPanel panel = new JPanel();
		panel.setBounds(33, 36, 358, 40);
		panel_1.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0627\u0644\u0627\u0633\u0645 ");
		lblNewLabel.setBounds(302, 11, 46, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(10, 8, 282, 20);
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(33, 288, 381, 40);
		panel_1.add(panel_8);

		JLabel label_4 = new JLabel("\u0631\u0642\u0645 \u0627\u062E\u0631 \u0644\u0644\u0647\u0627\u062A\u0641");
		label_4.setBounds(302, 11, 69, 14);
		panel_8.add(label_4);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 8, 282, 20);
		panel_8.add(textField_7);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(33, 339, 381, 40);
		panel_1.add(panel_9);

		JLabel label_5 = new JLabel("\u0627\u0644\u0628\u0644\u062F\u064A\u0629");
		label_5.setBounds(302, 11, 69, 14);
		panel_9.add(label_5);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 8, 282, 20);
		panel_9.add(comboBox);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(33, 397, 381, 40);
		panel_1.add(panel_5);

		JLabel lblNewLabel_1 = new JLabel("\u062E\u0628\u0631\u0629");
		lblNewLabel_1.setBounds(325, 11, 46, 14);
		panel_5.add(lblNewLabel_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("2014");
		chckbxNewCheckBox.setBounds(19, 7, 97, 23);
		panel_5.add(chckbxNewCheckBox);

		JCheckBox checkBox = new JCheckBox("2011");
		checkBox.setBounds(197, 7, 97, 23);
		panel_5.add(checkBox);
	}
}
