package com.socket.client.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import com.socket.Message;
import com.socket.SocketClient;

public class ChatFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SocketClient client;
	public int port;
	public String serverAddr;
	public String username;
	public String password;
	public Thread clientThread;
	public DefaultListModel<String> model;
	public File file;

	public ChatFrame() {
		initComponents();
		this.setTitle("jMessenger");
		model.addElement("All");
		jList1.setSelectedIndex(0);

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					client.send(new Message("message", username, ".bye", "SERVER"));
					clientThread.interrupt();
				} catch (Exception ex) {
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
		});

	}

	public boolean isWin32() {
		return System.getProperty("os.name").startsWith("Windows");
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new JLabel();
		jTextField1 = new JTextField();
		jLabel2 = new JLabel();
		jTextField2 = new JTextField();
		jButton1 = new JButton();
		jTextField3 = new JTextField();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jButton3 = new javax.swing.JButton();
		jPasswordField1 = new JPasswordField();
		jSeparator1 = new JSeparator();
		jScrollPane1 = new JScrollPane();
		jScrollPane2 = new JScrollPane();
		jList1 = new JList<String>();
		jLabel5 = new JLabel();
		jTextField4 = new JTextField();
		jButton4 = new JButton();
		jButton2 = new JButton();
		jSeparator2 = new JSeparator();
		jTextField5 = new JTextField();
		jButton5 = new JButton();
		jButton6 = new JButton();
		jLabel6 = new JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Host Address : ");

		jTextField1.setText("localhost");

		jLabel2.setText("Host Port : ");

		jTextField2.setText("50000");

		jButton1.setText("Connect");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTextField3.setText("hassen");
		jTextField3.setEnabled(false);

		jLabel3.setText("Password :");

		jLabel4.setText("Username :");

		jButton3.setText("SignUp");
		jButton3.setEnabled(false);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jPasswordField1.setText("password");
		jPasswordField1.setEnabled(false);

		jList1.setModel((model = new DefaultListModel<>()));
		jScrollPane2.setViewportView(jList1);

		jLabel5.setText("Message : ");

		jButton4.setText("Send Message ");
		jButton4.setEnabled(false);
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton2.setText("Login");
		jButton2.setEnabled(false);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton5.setText("...");
		jButton5.setEnabled(false);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("Send");
		jButton6.setEnabled(false);
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jLabel6.setText("File :");
		jTextArea1 = new javax.swing.JTextArea();

		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
		jTextArea1.setRows(5);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel6)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(jButton6,
										GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(jLabel1)
										.addComponent(jLabel4))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(jTextField3, 112, 112, 112)
										.addComponent(jTextField1, 112, 112, 112))
								.addGap(18)
								.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(jLabel2)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel3).addGap(91)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(jTextField2, 126, 126, 126)
										.addComponent(jPasswordField1, 126, 126, 126))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 70,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(jButton3,
														GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
						.addGroup(layout.createSequentialGroup().addGap(56)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(jTextArea1).addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 108,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING,
												layout.createSequentialGroup().addComponent(jLabel5)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(jTextField4, 380, 380, 380).addGap(18)
														.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 108,
																GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addContainerGap()
										.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1)
												.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2)
												.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton1))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3).addComponent(jLabel4).addComponent(jButton3)
												.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton2))
										.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
										.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 264,
																Short.MAX_VALUE)
														.addComponent(jTextArea1, GroupLayout.PREFERRED_SIZE, 268,
																GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jButton4)
												.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(Alignment.BASELINE, false)
												.addComponent(jButton6, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jButton5, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel6).addComponent(jTextField5,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}
	// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		serverAddr = jTextField1.getText();
		port = Integer.parseInt(jTextField2.getText());

		if (!serverAddr.isEmpty() && !jTextField2.getText().isEmpty()) {
			try {
				client = new SocketClient(this);
				clientThread = new Thread(client);
				clientThread.start();

				client.send(new Message("test", "testUser", "testContent", "SERVER"));

			} catch (Exception ex) {
				jTextArea1.append("[Application > Me] : Server not found\n");
			}
		}
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		username = jTextField3.getText();
		password = String.valueOf(jPasswordField1.getPassword());
		// jPasswordField1.getText();

		if (!username.isEmpty() && !password.isEmpty()) {
			client.send(new Message("login", username, password, "SERVER"));
		}
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		String msg = jTextField4.getText();
		String target = jList1.getSelectedValue().toString();

		if (!msg.isEmpty() && !target.isEmpty()) {
			jTextField4.setText("");
			client.send(new Message("message", username, msg, target));
		}
	}// GEN-LAST:event_jButton4ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		username = jTextField3.getText();
		password = String.valueOf(jPasswordField1.getPassword());

		if (!username.isEmpty() && !password.isEmpty()) {
			client.send(new Message("signup", username, password, "SERVER"));
		}
	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showDialog(this, "Select File");
		file = fileChooser.getSelectedFile();

		if (file != null) {
			if (!file.getName().isEmpty()) {
				jButton6.setEnabled(true);
				String str;

				if (jTextField5.getText().length() > 30) {
					String t = file.getPath();
					str = t.substring(0, 20) + " [...] " + t.substring(t.length() - 20, t.length());
				} else {
					str = file.getPath();
				}
				jTextField5.setText(str);
			}
		}
	}// GEN-LAST:event_jButton5ActionPerformed

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
		long size = file.length();
		if (size < 120 * 1024 * 1024) {
			client.send(new Message("upload_req", username, file.getName(), jList1.getSelectedValue().toString()));
		} else {
			jTextArea1.append("[Application > Me] : File is size too large\n");
		}
	}// GEN-LAST:event_jButton6ActionPerformed

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			System.out.println("Look & Feel exception");
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ChatFrame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	public javax.swing.JButton jButton1;
	public javax.swing.JButton jButton2;
	public javax.swing.JButton jButton3;
	public javax.swing.JButton jButton4;
	public javax.swing.JButton jButton5;
	public javax.swing.JButton jButton6;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	public javax.swing.JList<String> jList1;
	public javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	public javax.swing.JTextArea jTextArea1;
	public javax.swing.JTextField jTextField1;
	public javax.swing.JTextField jTextField2;
	public javax.swing.JTextField jTextField3;
	public javax.swing.JTextField jTextField4;
	public javax.swing.JTextField jTextField5;
	// End of variables declaration//GEN-END:variables
}
