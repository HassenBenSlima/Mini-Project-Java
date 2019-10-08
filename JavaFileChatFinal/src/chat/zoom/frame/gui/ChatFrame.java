package chat.zoom.frame.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.socket.media.MediaSocket;

import chat.client.iit.Message;
import chat.client.iit.SocketClient;

public class ChatFrame {

	public JFrame frmMessanger;
	public JTextField jtextField5;
	public JTextField jtextField4;
	public JTextField jtextField1;
	public JTextField jtextField2;
	public JTextArea jtextArea1;
	public JList<String> jList1;

	/*
	 * Buttons
	 **/
	public JButton jbutton5;
	public JButton jbtnSendFile6;
	public JButton jbtnConnect1;
	public JButton jbtnSendMessage4;

	/*
	 * My variables
	 **/

	public SocketClient client;
	public Thread clientThread;
	public int port;

	public String serverAddr;
	public String username;
	public String password;
	public DefaultListModel<String> model;
	public File file;
	private JButton buttonReconnect;
	public MediaSocket mediaSocket;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

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
					ChatFrame window = new ChatFrame();
					window.frmMessanger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChatFrame() {
		initialize();
		model.addElement("All");
		jList1.setSelectedIndex(0);

		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setBounds(10, 11, 46, 14);
		frmMessanger.getContentPane().add(lblAdress);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(10, 55, 46, 14);
		frmMessanger.getContentPane().add(lblPort);

		buttonReconnect = new JButton("Reconnect");
		buttonReconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonReconnectactionPerformed(e);
			}
		});
		buttonReconnect.setBounds(919, 25, 108, 59);
		frmMessanger.getContentPane().add(buttonReconnect);

		JSeparator separator = new JSeparator();
		separator.setBounds(794, 106, 332, 12);
		frmMessanger.getContentPane().add(separator);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("B:\\Works\\workspaceJava\\JavaFileChat\\pictures\\Occupations-Musician-Male-Light-icon.png"));
		label_1.setBounds(794, 11, 101, 96);
		frmMessanger.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("B:\\Works\\workspaceJava\\JavaFileChat\\pictures\\favourites-icon.png"));
		label_2.setBounds(916, 470, 111, 69);
		frmMessanger.getContentPane().add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("B:\\Works\\workspaceJava\\JavaFileChat\\pictures\\map-icon.png"));
		label_3.setBounds(1049, 470, 91, 69);
		frmMessanger.getContentPane().add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("B:\\Works\\workspaceJava\\JavaFileChat\\pictures\\comments-icon.png"));
		label_4.setBounds(794, 470, 91, 69);
		frmMessanger.getContentPane().add(label_4);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMessanger = new JFrame();
		frmMessanger.setFocusTraversalPolicyProvider(true);
		frmMessanger.setTitle("Messanger <3");
		frmMessanger.getContentPane().setBackground(new Color(230, 230, 250));
		frmMessanger.setBounds(100, 100, 1166, 589);
		frmMessanger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMessanger.getContentPane().setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 255)));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(176, 27, 608, 436);
		frmMessanger.getContentPane().add(scrollPane_1);

		jtextArea1 = new JTextArea();
		jtextArea1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		jtextArea1.setDisabledTextColor(new Color(0, 0, 128));
		jtextArea1.setEnabled(false);
		scrollPane_1.setViewportView(jtextArea1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(10, 161, 146, 378);
		frmMessanger.getContentPane().add(scrollPane_2);

		jList1 = new JList<>();
		jList1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 19));
		jList1.setSelectionBackground(new Color(144, 238, 144));
		jList1.setModel((model = new DefaultListModel<>()));
		scrollPane_2.setViewportView(jList1);

		jtextField5 = new JTextField();
		jtextField5.setEnabled(false);
		jtextField5.setColumns(10);
		jtextField5.setBounds(794, 425, 348, 38);
		frmMessanger.getContentPane().add(jtextField5);

		jbtnSendMessage4 = new JButton("Send Message");
		jbtnSendMessage4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jButton4ActionPerformed(e);

			}

		});
		jbtnSendMessage4.setBounds(676, 472, 108, 67);
		frmMessanger.getContentPane().add(jbtnSendMessage4);

		jbtnSendFile6 = new JButton("Send File");
		jbtnSendFile6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSendFile6actionPerformed(e);
			}
		});
		jbtnSendFile6.setEnabled(false);
		jbtnSendFile6.setBounds(916, 375, 111, 39);
		frmMessanger.getContentPane().add(jbtnSendFile6);

		jbutton5 = new JButton("...");
		jbutton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbutton5actionPerformed(e);
			}
		});
		jbutton5.setBounds(864, 375, 31, 39);
		frmMessanger.getContentPane().add(jbutton5);

		JButton btnScreen = new JButton("Screen");
		btnScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnScreenactionPerformed(e);
			}
		});
		btnScreen.setBounds(919, 131, 108, 44);
		frmMessanger.getContentPane().add(btnScreen);

		JButton btnTakeVido = new JButton("Take video");
		btnTakeVido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTakeVidoactionPerformed(e);
			}
		});
		btnTakeVido.setBounds(919, 186, 108, 44);
		frmMessanger.getContentPane().add(btnTakeVido);

		JButton btnTakeAPhoto = new JButton("Take photo");
		btnTakeAPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTakeAPhotoactionPerformed(e);
			}
		});
		btnTakeAPhoto.setBounds(919, 233, 108, 44);
		frmMessanger.getContentPane().add(btnTakeAPhoto);

		JButton btnSendMedia = new JButton("Send media");
		btnSendMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSendMediaactionPerformed(e);
			}
		});
		btnSendMedia.setBounds(919, 288, 108, 47);
		frmMessanger.getContentPane().add(btnSendMedia);

		jbtnConnect1 = new JButton("Connect");
		jbtnConnect1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConnect1ActionPerformed(e);
			}
		});
		jbtnConnect1.setBounds(10, 106, 146, 44);
		frmMessanger.getContentPane().add(jbtnConnect1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("B:\\Works\\workspaceJava\\JavaFileChat\\pictures\\chat-bubbles-icon.png"));
		label.setBounds(804, 190, 75, 69);
		frmMessanger.getContentPane().add(label);

		JSeparator separator = new JSeparator();
		separator.setBounds(804, 346, 322, 12);
		frmMessanger.getContentPane().add(separator);

		jtextField4 = new JTextField();
		jtextField4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		jtextField4.setColumns(10);
		jtextField4.setBounds(176, 472, 490, 67);
		frmMessanger.getContentPane().add(jtextField4);

		jtextField1 = new JTextField();
		jtextField1.setText("localhost");
		jtextField1.setColumns(10);
		jtextField1.setBounds(10, 27, 146, 20);
		frmMessanger.getContentPane().add(jtextField1);

		jtextField2 = new JTextField();
		jtextField2.setText("50000");
		jtextField2.setColumns(10);
		jtextField2.setBounds(10, 75, 146, 20);
		frmMessanger.getContentPane().add(jtextField2);

	}

	public void btnSendMediaactionPerformed(ActionEvent e) {

		String target = jList1.getSelectedValue().toString();
		long size = file.length();// size of file

		if (size < 1024 * 1024) {
			client.send(new Message("upload_req", username, file.getName(), target));
		} else {
			jtextArea1.append("[Messanger > Me] : Size of file is large \n");
		}
	}

	public void btnTakeAPhotoactionPerformed(ActionEvent e) {
		file = new File(mediaSocket.takePictureCam());

	}

	public void btnTakeVidoactionPerformed(ActionEvent e) {
		file = new File(mediaSocket.encoder());

	}

	public void btnScreenactionPerformed(ActionEvent e) {
		file = new File(mediaSocket.imageScreen());
	}

	/*
	 * Upload file
	 */
	protected void jbutton5actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showDialog(frmMessanger, "Select File");
		file = fileChooser.getSelectedFile();
		if (file != null) {
			if (!file.getName().isEmpty()) {
				jbtnSendFile6.setEnabled(true);
				String str;
				str = file.getPath();
				jtextField5.setText(str);
			}
		}
	}

	/*
	 * Send File
	 */
	protected void jbtnSendFile6actionPerformed(ActionEvent e) {
		String target = jList1.getSelectedValue().toString();
		long size = file.length();// size of file
		if (size < 1024 * 1024) {
			client.send(new Message("upload_req", username, file.getName(), target));
		} else {
			jtextArea1.append("[Messanger > Me] : Size of file is large \n");
		}

	}

	/*
	 * Connect
	 */
	public void btnConnect1ActionPerformed(ActionEvent e) {
		serverAddr = jtextField1.getText();
		port = Integer.parseInt(jtextField2.getText());

		if (!serverAddr.isEmpty() && !jtextField2.getText().isEmpty()) {

			try {
				client = new SocketClient(this);
				clientThread = new Thread(client);
				clientThread.start();

				client.send(new Message("test", "testUser", "testContent", "SERVER"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			 mediaSocket = new MediaSocket(client.port);

		}
	}

	public void buttonReconnectactionPerformed(ActionEvent e) {
		 LoginDialog lg;
		 lg = new LoginDialog();
		 lg.getChatFrame(client, this);
		 lg.frame.setVisible(true);
	}

	/*
	 * login
	 * 
	 * public void jbutton1actionPerformed(ActionEvent e) { username =
	 * jtextField3.getText(); password =
	 * String.valueOf(jpasswordField1.getPassword());
	 * 
	 * if (!username.isEmpty() && !password.isEmpty()) { client.send(new
	 * Message("login", username, password, "SERVER")); } }
	 * 
	 * 
	 * Signup
	 * 
	 * public void btnSignupactionPerformed(ActionEvent e) { username =
	 * jtextField3.getText(); password =
	 * String.valueOf(jpasswordField1.getPassword());
	 * 
	 * if (!username.isEmpty() && !password.isEmpty()) { client.send(new
	 * Message("signup", username, password, "SERVER")); }
	 * 
	 * }
	 */

	/**
	 * Send Message
	 */
	public void jButton4ActionPerformed(ActionEvent e) {
		String msg = jtextField4.getText();
		String target = jList1.getSelectedValue().toString();

		if (!msg.isEmpty() && !target.isEmpty()) {
			jtextField4.setText("");
			client.send(new Message("message", username, msg, target));
		}

	}
}
