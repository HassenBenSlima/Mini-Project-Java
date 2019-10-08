
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat extends Thread {

	Socket socket;

	public ClientChat(String ip, int port) {
		try {
			this.socket = new Socket(ip, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// Code de la conversation
		try {
			/*
			 * lire
			 */
			InputStream is = socket.getInputStream();
			// read catacters
			InputStreamReader isr = new InputStreamReader(is);
			// read chaine de Caractere
			BufferedReader br = new BufferedReader(isr);

			/*
			 * envoyer
			 */

			// conversation
			new WriteChat(socket).start();
			while (true) {

				String req;
				while ((req = br.readLine()) != null) {
					System.out.println(req);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public class WriteChat extends Thread {

		Scanner sc;
		String reply;
		Socket socket;
		PrintWriter pw;
		OutputStream os;

		public WriteChat(Socket socket) {
			super();
			try {
				this.sc = new Scanner(System.in);
				this.socket = socket;
				os = socket.getOutputStream();
				pw = new PrintWriter(os, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while ((reply = sc.nextLine()) != null) {
				pw.println(reply);
			}
		}
	}

	public static void main(String[] args) {
		new ClientChat("localhost", 234).start();
	}

}
