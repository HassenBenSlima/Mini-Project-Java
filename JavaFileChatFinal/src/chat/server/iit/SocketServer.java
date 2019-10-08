package chat.server.iit;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.socket.database.DBManager;

import chat.client.iit.Message;
import chat.zoom.frame.gui.ServerFrame;

class ServerThread extends Thread {

	public SocketServer server;
	public Socket socket;
	public int id = -1;// client port
	public String username = "";
	public ObjectInputStream streamIn;
	public ObjectOutputStream streamOut;
	public ServerFrame ui;

	public ServerThread(SocketServer serverToClient, Socket socketClient) {
		this.server = serverToClient;
		this.socket = socketClient;
		this.id = socket.getPort();
		this.ui = serverToClient.ui;

	}

	public int getID() {
		return id;
	}

	public void openStream() throws IOException {
		streamOut = new ObjectOutputStream(socket.getOutputStream());
		streamOut.flush();
		streamIn = new ObjectInputStream(socket.getInputStream());
	}

	public void closeStream() throws IOException {
		if (socket != null) {
			socket.close();
		}
		if (streamIn != null) {
			streamIn.close();
		}
		if (streamOut != null) {
			streamOut.close();
		}
	}

	public void send(Message msg) {
		try {
			streamOut.writeObject(msg);
			streamOut.flush();
		} catch (IOException e) {
			System.out.println("Exception [SocketClient : send (...)]");
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		ui.jtextArea1.append("\n Server Thread " + id + " running.");
		while (true) {
			try {
				Message msg = (Message) streamIn.readObject();
				server.handle(id, msg);
				
				if (Thread.interrupted()) {
					// We've been interrupted: no more crunching.
					return;
				}

			} catch (Exception e) {
				System.out.println(id + " ERROR reading: " + e.getMessage());
				e.printStackTrace();
				server.remove(id);

				interrupt();
				break;
			}

		}

	}

}

public class SocketServer implements Runnable {

	public ServerThread clients[];
	public ServerSocket serverClient;
	public Thread thread;
	public int clientCount = 0;
	public int port = 50000;
	public DBManager db;
	public ServerFrame ui;

	// there are two constructor
	public SocketServer(ServerFrame frame) {
		this.clients = new ServerThread[50];
		this.ui = frame;
		this.db = new DBManager();

		try {
			this.serverClient = new ServerSocket(port);
			this.port = serverClient.getLocalPort();
			ui.jtextArea1.append(
					"Server start. IP :" + InetAddress.getLocalHost() + ", Port : " + serverClient.getLocalPort());

			startServer();
		} catch (IOException e) {
			ui.jtextArea1.append("\n Can not bind to port " + port + " : " + e.getMessage());
			e.printStackTrace();
		}

	}

	public SocketServer(ServerFrame frame, int port) {
		this.clients = new ServerThread[50];
		this.ui = frame;
		this.port = port;
		this.db = new DBManager();

		try {
			this.serverClient = new ServerSocket(port);
			this.port = serverClient.getLocalPort();
			ui.jtextArea1.append(
					"Server start. IP :" + InetAddress.getLocalHost() + ", Port : " + serverClient.getLocalPort());

			startServer();
		} catch (IOException e) {
			ui.jtextArea1.append("\n Can not bind to port " + port + " : " + e.getMessage());
			e.printStackTrace();
		}

	}

	private void startServer() {
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

	@Override
	public void run() {

		while (true) {
			try {
				ui.jtextArea1.append("\n Waiting for client ...");
				Socket socketOfClient = serverClient.accept();
				addThread(socketOfClient);
				if (Thread.interrupted()) {
					// We've been interrupted: no more crunching.
					return;
				}
			} catch (Exception e) {
				ui.jtextArea1.append(" \n Server accept error. \n");
				ui.retryStart(0);
				// e.printStackTrace();
			}
		}

	}

	public ServerThread findUserThread(String user) {
		for (int i = 0; i < clientCount; i++) {
			if (user.equals(clients[i].username)) {
				return clients[i];
			}
		}
		return null;
	}

	private void addThread(Socket socketOfClient) {
		if (clientCount < clients.length) {
			ui.jtextArea1.append("\n Client accept:" + socketOfClient);
			clients[clientCount] = new ServerThread(this, socketOfClient);

			try {
				clients[clientCount].openStream();
				clients[clientCount].start();
				clientCount++;
			} catch (IOException e) {
				ui.jtextArea1.append("\n Error opening Thread :" + e);
				e.printStackTrace();
			}

//			for (int i = 0; i < clients.length; i++) {
//				System.out.println(clients[i].id + "coucou");
//			}

		} else {
			ui.jtextArea1.append("\n Client refused : maximum " + clients.length + "reached.");
		}
	}

	public int findClient(int id) {

		for (int i = 0; i < clientCount; i++) {
			if (clients[i].getID() == id) {
				return i;
			}
		}

		return -1;
	}

	public synchronized void remove(int id) {
		int pos = findClient(id);
		if (pos >= 0) {
			ServerThread toTermnate = clients[pos];
			ui.jtextArea1.append("\n Removing client thread" + id + " at " + pos);
			if (pos < clientCount - 1) {
				for (int i = pos + 1; i < clientCount; i++) {
					clients[i - 1] = clients[i];
				}
			}
			clientCount--;
			try {
				toTermnate.closeStream();
			} catch (Exception e) {
				ui.jtextArea1.append("\n Error closing Thread :" + e);
				e.printStackTrace();
			}
			toTermnate.interrupt();
		}

	}

	public synchronized void handle(int id, Message msg) {

		if (msg.type.equals("login")) {
			System.out.println("Ok");
			System.out.println(msg);
			if (findUserThread(msg.sender) == null) {

				if (db.checkLogin(msg.sender, msg.content)) {
					clients[findClient(id)].username = msg.sender;
					clients[findClient(id)].send(new Message("login", "SERVER", "TRUE", msg.sender));
					/*
					 * refresh list of people that they are connecting on other instance
					 */
					announce("newuser", "SERVER", msg.sender);
					/*
					 * refresh list of people that they are connecting in the current instance
					 */
					sendUserList(msg.sender);

				} else {
					clients[findClient(id)].send(new Message("login", "SERVER", "FALSE", msg.sender));
				}

			} else {
				clients[findClient(id)].send(new Message("login", "SERVER", "FALSE", msg.sender));

			}

		} else if (msg.type.equals("message")) {

			if (msg.recipient.equals("All")) {
				announce("message", msg.sender, msg.content);
			} else {
				/*
				 * Send message to one peolpe is connecting
				 */

				/*
				 * write message to recepient
				 */
				findUserThread(msg.recipient).send(new Message(msg.type, msg.sender, msg.content, msg.recipient));
				/*
				 * Write message to the sender
				 */
				clients[findClient(id)].send(new Message(msg.type, msg.sender, msg.content, msg.recipient));

			}

		} else if (msg.type.equals("test")) {
			clients[findClient(id)].send(new Message("test", "SERVER", "OK", msg.sender));
		} else if (msg.type.equals("signup")) {
			if (findUserThread(msg.sender) == null) {

				if (!db.userExists(msg.sender)) {
					db.addUser(msg.sender, msg.content);
					clients[findClient(id)].username = msg.sender;
					clients[findClient(id)].send(new Message("signup", "SERVER", "FALSE", msg.sender));
					clients[findClient(id)].send(new Message("login", "SERVER", "FALSE", msg.sender));
					announce("newuser", "SERVER", msg.sender);
					sendUserList(msg.sender);
				} else {
					clients[findClient(id)].send(new Message("signup", "SERVER", "FALSE", msg.sender));
				}

			} else {
				clients[findClient(id)].send(new Message("signup", "SERVER", "FALSE", msg.sender));

			}

		} else if (msg.type.equals("upload_req")) {
			if (msg.recipient.equals("All")) {
				clients[findClient(id)].send(new Message("message", "SERVER",
						"You can't send to all peoples, choose only one :) .", msg.sender));
			} else {
				/*
				 * start server Donwload for one client
				 */
				findUserThread(msg.recipient).send(new Message("upload_req", msg.sender, msg.content, msg.recipient));
			}
		} else if (msg.type.equals("upload_res")) {
			if (!msg.content.equals("NO")) {
				/*
				 * get ip address of the sender,
				 */
				/*
				 * there is the port of ServeDowload in 'msg.content'
				 */
				String ip = findUserThread(msg.sender).socket.getInetAddress().getHostAddress();
				/*
				 * Send ip of the client in 'msg.sender'
				 */
				findUserThread(msg.recipient).send(new Message("upload_res", ip, msg.content, msg.recipient));

			} else {
				/*
				 * reject Message
				 */

				findUserThread(msg.recipient).send(new Message("upload_res", msg.sender, msg.content, msg.recipient));
			}
		}

	}

	public void sendUserList(String toWho) {
		for (int i = 0; i < clientCount; i++) {
			findUserThread(toWho).send(new Message("newuser", "SERVER", clients[i].username, toWho));
		}
	}

	public void announce(String type, String sender, String content) {
		Message msg = new Message(type, sender, content, "All");
		for (int i = 0; i < clientCount; i++) {
			clients[i].send(msg);
		}
	}

}
