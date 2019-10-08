package chat.client.iit;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import chat.dowload.iit.ServerDownload;
import chat.dowload.iit.UploadClient;
import chat.zoom.frame.gui.ChatFrame;

public class SocketClient implements Runnable {

	public int port;
	public String serverAddr;
	public Socket socket;
	public ChatFrame ui;
	public ObjectInputStream in;
	public ObjectOutput out;
	public boolean keepRunning = true;

	public SocketClient(ChatFrame frame) throws IOException {
		this.ui = frame;
		this.serverAddr = ui.serverAddr;
		this.port = ui.port;
		this.socket = new Socket(InetAddress.getByName(serverAddr), port);

		this.out = new ObjectOutputStream(socket.getOutputStream());
		out.flush();
		this.in = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		while (keepRunning) {
			try {
				Message msg = (Message) in.readObject();

				System.out.println("Incoming: " + msg.toString());
				if (msg.type.equals("message")) {
					if (msg.recipient.equals(ui.username)) {

						/*
						 * write message to the recipient
						 */
						ui.jtextArea1.append("[" + msg.sender + " > Me] : " + msg.content + "\n");

					} else {
						/*
						 * write message to the current user 'sender'
						 */
						ui.jtextArea1.append("[" + msg.sender + " > " + msg.recipient + "] : " + msg.content + "\n");

					}
				} else if (msg.type.equals("login")) {

					if (msg.content.equals("TRUE")) {

						ui.jtextArea1.append("[SERVER > ME] :Login Successful \n ");
					} else {
						ui.jtextArea1.append("[SERVER > ME] :Login Failed \n ");

					}
				} else if (msg.type.equals("test")) {

					ui.jbtnConnect1.setEnabled(false);
					ui.jtextField1.setEditable(false);
					ui.jtextField2.setEnabled(false);
					/**
					 * show buttons Connection good
					 */

				} else if (msg.type.equals("newuser")) {
					if (!msg.content.equals(ui.username)) {
						boolean exists = false;
						for (int i = 0; i < ui.model.getSize(); i++) {
							if (ui.model.getElementAt(i).equals(msg.content)) {
								exists = true;
								break;
							}
						}

						if (!exists) {
							ui.model.addElement(msg.content);
						}

					}

				} else if (msg.type.equals("signup")) {
					if (msg.content.equals("TRUE")) {
						ui.jtextArea1.append("[SEVER > Me]: Signup Successful \n");
					} else {
						ui.jtextArea1.append("[SEVER > Me]: Signup Failed \n");

					}

				} else if (msg.type.equals("signout")) {
					if (msg.content.equals(ui.username)) {
						ui.jtextArea1.append("[" + msg.sender + ">Me]: Bye \n");

						for (int i = 0; i < ui.model.size(); i++) {
							ui.model.removeElementAt(i);
						}
						ui.clientThread.interrupt();
					} else {
						ui.model.removeElement(msg.content);
						ui.jtextArea1.append("[" + msg.sender + " > All] : " + " has signed out \n");
					}

				} else if (msg.type.equals("upload_req")) {

					if ((JOptionPane.showConfirmDialog(ui.frmMessanger,
							"Accept " + msg.content + " from " + msg.sender + " ?")) == 0) {
						JFileChooser jf = new JFileChooser();
						jf.setSelectedFile(new File(msg.content));
						int returnVal = jf.showSaveDialog(ui.frmMessanger);
						String saveTo = jf.getSelectedFile().getPath();
						if (saveTo != null && returnVal == JFileChooser.APPROVE_OPTION) {
							ServerDownload dwn = new ServerDownload(saveTo, ui);
							Thread t = new Thread(dwn);
							t.start();

							send(new Message("upload_res", ui.username, ("" + dwn.port), msg.sender));
						} else {
							send(new Message("upload_res", ui.username, "NO", msg.sender));

						}

					} else {
						send(new Message("upload_res", ui.username, "NO", msg.sender));

					}

				} else if (msg.type.equals("upload_res")) {
					if (!msg.content.equals("NO")) {
						int port = Integer.parseInt(msg.content);
						String addr = msg.sender;
						UploadClient upl = new UploadClient(addr, port, ui.file, ui);
						Thread t = new Thread(upl);
						t.start();
					} else {
						ui.jtextArea1.append("[SERVER > Me] : " + msg.sender + " rejected file request \n");

					}
				} else {
					ui.jtextArea1.append("[SERVER > ME] :Unkown message type \n ");
				}

				if (Thread.interrupted()) {
					// We've been interrupted: no more crunching.
					return;
				}
			} catch (Exception e) {

				ui.jtextArea1.append("[Application > ME] : Connection Failure \n ");

				for (int i = 0; i < ui.model.size(); i++) {
					ui.model.removeElementAt(i);
				}
				ui.clientThread.interrupt();
				System.out.println("Exception SocketClient run()");

				e.printStackTrace();
			}
		}
	}

	public void send(Message msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("outgoing :" + msg.toString());
		} catch (IOException e) {
			System.out.println("Exception SocketClient send ()");
			// e.printStackTrace();
		}

	}

}
