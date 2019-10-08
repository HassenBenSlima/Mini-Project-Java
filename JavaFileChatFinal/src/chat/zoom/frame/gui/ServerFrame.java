package chat.zoom.frame.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import chat.server.iit.SocketServer;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ServerFrame {

	private JFrame frmSeverMessanger;
	public JTextArea jtextArea1;
	public SocketServer server;
	public Thread serverThread;
	public JScrollPane scrollPane;
	private JLabel lblNewLabel;

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
					ServerFrame window = new ServerFrame();
					window.frmSeverMessanger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeverMessanger = new JFrame();
		frmSeverMessanger.getContentPane().setBackground(new Color(51, 204, 255));
		frmSeverMessanger.setTitle("Sever Messanger");
		frmSeverMessanger.setBounds(100, 100, 748, 380);
		frmSeverMessanger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 555, 319);

		jtextArea1 = new JTextArea();
		jtextArea1.setEnabled(false);
		jtextArea1.setBackground(new Color(248, 248, 255));
		scrollPane.setViewportView(jtextArea1);

		JButton jbtnStartServer = new JButton("Start server");
		jbtnStartServer.setBounds(571, 213, 151, 117);
		jbtnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnStartServerActionPerformed(e);
			}

		});
		frmSeverMessanger.getContentPane().setLayout(null);
		frmSeverMessanger.getContentPane().add(scrollPane);
		frmSeverMessanger.getContentPane().add(jbtnStartServer);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("B:\\Works\\workspaceJava\\JavaFileChat\\pictures\\rss-feed-wifi-icon.png"));
		lblNewLabel.setBounds(587, 11, 135, 138);
		frmSeverMessanger.getContentPane().add(lblNewLabel);
	}

	public void jbtnStartServerActionPerformed(ActionEvent e) {

		server = new SocketServer(this);

	}

	public void retryStart(int port) {
		if (server != null) {
			server.stop();
		}
		server = new SocketServer(this, port);

	}

}
