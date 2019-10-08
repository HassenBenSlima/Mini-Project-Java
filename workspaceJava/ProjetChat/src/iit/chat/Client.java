package iit.chat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
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
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(28, 119, 483, 294);
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(28, 424, 483, 72);
		frame.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(527, 117, 210, 378);
		frame.getContentPane().add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(28, 25, 709, 83);
		frame.getContentPane().add(panel_3);
	}
}
