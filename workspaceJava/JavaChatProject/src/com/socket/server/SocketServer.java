package com.socket.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.socket.Message;
import com.socket.database.DBManager;

class ServerThread extends Thread {

	public SocketServer server;
	public Socket socket;
	public int ID = -1;
	public String username = "";
	public ObjectInputStream streamIn;
	public ObjectOutputStream streamOut;
	public ServerFrame ui;

	public ServerThread(SocketServer serverOnly, Socket socketClient) {
		server = serverOnly;
		socket = socketClient;
		ID = socket.getPort();
		ui = serverOnly.ui;
	}

	public void send(Message msg) {
		try {
			streamOut.writeObject(msg);
			streamOut.flush();
		} catch (IOException ex) {
			System.out.println("Exception [SocketClient : send(...)]");
		}
	}

	public int getID() {
		return ID;
	}

	public void run() {
		ui.jTextArea1.append("\nServer Thread " + ID + " running.");
		while (true) {
			try {
				Message msg = (Message) streamIn.readObject();
				server.handle(ID, msg);

				if (Thread.interrupted()) {
					// We've been interrupted: no more crunching.
					return;
				}

			} catch (Exception ioe) {
				System.out.println(ID + " ERROR reading: " + ioe.getMessage());
				server.remove(ID);
				interrupt();
			}
		}
	}

	public void open() throws IOException {
		streamOut = new ObjectOutputStream(socket.getOutputStream());
		streamOut.flush();
		streamIn = new ObjectInputStream(socket.getInputStream());
	}

	public void close() throws IOException {
		if (socket != null)
			socket.close();
		if (streamIn != null)
			streamIn.close();
		if (streamOut != null)
			streamOut.close();
	}
}

public class SocketServer implements Runnable {

	public ServerThread clients[];
	public ServerSocket serverClient;
	public Thread thread;
	public int clientCount = 0;
	public int port = 50000;
	public ServerFrame ui;
	// public Database db;
	public DBManager db;

	public SocketServer(ServerFrame frame) {

		this.clients = new ServerThread[50];
		this.ui = frame;
		// db = new Database(ui.filePath);
		db = new DBManager();

		try {
			serverClient = new ServerSocket(port);
			port = serverClient.getLocalPort();
			ui.jTextArea1.append(
					"Server startet. IP : " + InetAddress.getLocalHost() + ", Port : " + serverClient.getLocalPort());
			startServer();
		} catch (IOException ioe) {
			ui.jTextArea1.append("Can not bind to port : " + port + "\nRetrying");
			ui.RetryStart(0);
		}
	}

	public SocketServer(ServerFrame frame, int Port) {

		clients = new ServerThread[50];
		ui = frame;
		port = Port;
		// db = new Database(ui.filePath);
		db = new DBManager();
		try {
			serverClient = new ServerSocket(port);
			port = serverClient.getLocalPort();
			ui.jTextArea1.append(
					"Server startet. IP : " + InetAddress.getLocalHost() + ", Port : " + serverClient.getLocalPort());
			startServer();
		} catch (IOException ioe) {
			ui.jTextArea1.append("\nCan not bind to port " + port + ": " + ioe.getMessage());
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				ui.jTextArea1.append("\n Waiting for a client ...");
				Socket socketOfClient = serverClient.accept();
				addThread(socketOfClient);

				if (Thread.interrupted()) {
					// We've been interrupted: no more crunching.
					return;
				}

			} catch (Exception ioe) {
				ui.jTextArea1.append("\nServer accept error: \n");
				ui.RetryStart(0);
			}
		}
	}

	public void startServer() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {
		if (thread != null) {
			thread.interrupt();

		}
	}

	private int findClient(int ID) {
		for (int i = 0; i < clientCount; i++) {
			if (clients[i].getID() == ID) {
				return i;
			}
		}
		return -1;
	}

	public synchronized void handle(int ID, Message msg) {
		if (msg.content.equals(".bye")) {
			Announce("signout", "SERVER", msg.sender);
			remove(ID);
		} else {

			if (msg.type.equals("login")) {
				if (findUserThread(msg.sender) == null) {
					if (db.checkLogin(msg.sender, msg.content)) {
						clients[findClient(ID)].username = msg.sender;
						clients[findClient(ID)].send(new Message("login", "SERVER", "TRUE", msg.sender));
						Announce("newuser", "SERVER", msg.sender);
						SendUserList(msg.sender);
					} else {
						clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender));
					}
				} else {
					clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender));
				}
			} else if (msg.type.equals("message")) {

				if (msg.recipient.equals("All")) {
					Announce("message", msg.sender, msg.content);
				} else {

					findUserThread(msg.recipient).send(new Message(msg.type, msg.sender, msg.content, msg.recipient));
					clients[findClient(ID)].send(new Message(msg.type, msg.sender, msg.content, msg.recipient));
				}
			} else if (msg.type.equals("test")) {
				clients[findClient(ID)].send(new Message("test", "SERVER", "OK", msg.sender));
			} else if (msg.type.equals("signup")) {
				if (findUserThread(msg.sender) == null) {
					if (!db.userExists(msg.sender)) {
						db.addUser(msg.sender, msg.content);
						clients[findClient(ID)].username = msg.sender;
						clients[findClient(ID)].send(new Message("signup", "SERVER", "TRUE", msg.sender));
						clients[findClient(ID)].send(new Message("login", "SERVER", "TRUE", msg.sender));
						Announce("newuser", "SERVER", msg.sender);
						SendUserList(msg.sender);
					} else {
						clients[findClient(ID)].send(new Message("signup", "SERVER", "FALSE", msg.sender));
					}
				} else {
					clients[findClient(ID)].send(new Message("signup", "SERVER", "FALSE", msg.sender));
				}
			} else if (msg.type.equals("upload_req")) {
				if (msg.recipient.equals("All")) {
					clients[findClient(ID)]
							.send(new Message("message", "SERVER", "Uploading to 'All' forbidden", msg.sender));
				} else {
					findUserThread(msg.recipient)
							.send(new Message("upload_req", msg.sender, msg.content, msg.recipient));
				}
			} else if (msg.type.equals("upload_res")) {
				if (!msg.content.equals("NO")) {
					String IP = findUserThread(msg.sender).socket.getInetAddress().getHostAddress();
					findUserThread(msg.recipient).send(new Message("upload_res", IP, msg.content, msg.recipient));
				} else {
					findUserThread(msg.recipient)
							.send(new Message("upload_res", msg.sender, msg.content, msg.recipient));
				}
			}
		}
	}

	public void Announce(String type, String sender, String content) {
		Message msg = new Message(type, sender, content, "All Except me");
		for (int i = 0; i < clientCount; i++) {
			clients[i].send(msg);
		}
	}

	public void SendUserList(String toWhom) {
		for (int i = 0; i < clientCount; i++) {
			findUserThread(toWhom).send(new Message("newuser", "SERVER", clients[i].username, toWhom));
		}
	}

	public ServerThread findUserThread(String usr) {
		for (int i = 0; i < clientCount; i++) {
			if (clients[i].username.equals(usr)) {
				return clients[i];
			}
		}
		return null;
	}

	public synchronized void remove(int ID) {
		int pos = findClient(ID);
		if (pos >= 0) {
			ServerThread toTerminate = clients[pos];
			ui.jTextArea1.append("\nRemoving client thread " + ID + " at " + pos);
			if (pos < clientCount - 1) {
				for (int i = pos + 1; i < clientCount; i++) {
					clients[i - 1] = clients[i];
				}
			}
			clientCount--;
			try {
				toTerminate.close();
			} catch (IOException ioe) {
				ui.jTextArea1.append("\nError closing thread: " + ioe);
			}
			toTerminate.interrupt();
		}
	}

	private void addThread(Socket socket) {
		if (clientCount < clients.length) {
			ui.jTextArea1.append("\nClient accepted: " + socket);
			clients[clientCount] = new ServerThread(this, socket);
			try {
				clients[clientCount].open();
				clients[clientCount].start();
				clientCount++;
			} catch (IOException ioe) {
				ui.jTextArea1.append("\nError opening thread: " + ioe);
			}
		} else {
			ui.jTextArea1.append("\nClient refused: maximum " + clients.length + " reached.");
		}
	}
}
