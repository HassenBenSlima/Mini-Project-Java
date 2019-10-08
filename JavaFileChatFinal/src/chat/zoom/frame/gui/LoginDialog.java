package chat.zoom.frame.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import chat.client.iit.Message;
import chat.client.iit.SocketClient;

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
import javax.swing.ImageIcon;

public class LoginDialog {

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;
	public SocketClient currentClient;
	public ChatFrame messanger;

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
					LoginDialog window = new LoginDialog();
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
	public LoginDialog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 389);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Authentication", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(32, 98, 315, 167);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(125, 56, 158, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setBounds(22, 59, 61, 14);
		panel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(22, 90, 61, 14);
		panel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(125, 87, 158, 20);
		panel.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(0, 191, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginactionPerformed(e);
			}
		});
		btnLogin.setBounds(194, 133, 89, 23);
		panel.add(btnLogin);

		JButton btnSignup = new JButton("Signup");
		btnSignup.setBackground(new Color(0, 191, 255));
		btnSignup.setBounds(103, 133, 89, 23);
		panel.add(btnSignup);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignupactionPerformed(e);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("ChatClient");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 42));
		lblNewLabel_1.setBounds(99, 27, 181, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("B:\\Works\\workspaceJava\\JavaFileChat\\pictures\\multi-user-comment-icon.png"));
		label.setBounds(343, 11, 118, 136);
		frame.getContentPane().add(label);
	}

	public void btnLoginactionPerformed(ActionEvent e) {
		messanger.username = textField.getText();
		messanger.password = String.valueOf(passwordField.getPassword());

		if (!messanger.username.isEmpty() && !messanger.password.isEmpty()) {
			currentClient.send(new Message("login", messanger.username, messanger.password, "SERVER"));
		}

		this.frame.setVisible(false);

	}

	public void btnSignupactionPerformed(ActionEvent e) {

		messanger.username = textField.getText();
		messanger.password = String.valueOf(passwordField.getPassword());

		if (!messanger.username.isEmpty() && !messanger.password.isEmpty()) {
			currentClient.send(new Message("signup", messanger.username, messanger.password, "SERVER"));
		}

		this.frame.setVisible(false);
	}

	public void getChatFrame(SocketClient client, ChatFrame chatUi) {
		currentClient = client;
		messanger = chatUi;
	}
}
