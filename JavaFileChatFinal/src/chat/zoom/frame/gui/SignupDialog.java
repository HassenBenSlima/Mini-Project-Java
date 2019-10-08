package chat.zoom.frame.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupDialog {

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;
	public JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			System.out.println("Look & Feel exception");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupDialog window = new SignupDialog();
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
	public SignupDialog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 389);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "signup", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(79, 98, 315, 192);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(128, 46, 158, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setBounds(25, 49, 61, 14);
		panel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(25, 80, 61, 14);
		panel.add(lblPassword);

		JLabel lblConfirm = new JLabel("Confirm :");
		lblConfirm.setBounds(25, 111, 46, 14);
		panel.add(lblConfirm);

		passwordField = new JPasswordField();
		passwordField.setBounds(128, 77, 158, 20);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(128, 108, 158, 20);
		panel.add(passwordField_1);

		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignupactionPerformed(e);
			}
		});
		btnSignup.setBounds(195, 158, 89, 23);
		panel.add(btnSignup);

		JLabel lblNewLabel_1 = new JLabel("ChatClient");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 42));
		lblNewLabel_1.setBounds(147, 45, 181, 42);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void btnSignupactionPerformed(ActionEvent e) {

		this.frame.setVisible(false);
		

	}
}
