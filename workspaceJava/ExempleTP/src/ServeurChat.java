import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServeurChat extends Thread {

	// on donne un numero pour chaque client
	int nbClient = 0;
	// liste de socket ou une list de conversation
	private List<Conversation> clientsConnectes = new ArrayList<>();
	private ServerSocket ss;

	@Override
	public void run() {
		try {
			ss = new ServerSocket(234);

			/*
			 * le serveur soit cappable de connecté le client a n'import qu elle moment
			 * donner
			 * 
			 */
			while (true) {
				Socket s = ss.accept();
				/*
				 * a chaque fois le client est connecté on ajoute le socket
				 */

				++nbClient;
				Conversation c = new Conversation(s, nbClient);
				/*
				 * avant que le client connect on va ajouter le client a la list de client
				 * connecté
				 */
				clientsConnectes.add(c);
				c.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * liste des clients connecté qui permet de quffusé le message a tous clients
	 * connecté
	 */
	public void broadCast(String message, int[] numeroClients) {
		try {
			for (Conversation c : clientsConnectes) {
				/*
				 * pour chaque socket 'client' je l'envoie le message
				 */
				/*
				 * quant est ce que je peut envoyer un message
				 */
				boolean trouve = false;
				// synchronized (this) {
				for (int i = 0; i < numeroClients.length; i++) {
					if (c.numeroClient == numeroClients[i]) {
						trouve = true;
						break;
					}
					// }
				}
				if (trouve == true) {
					PrintWriter pw = new PrintWriter(c.socket.getOutputStream(), true);
					pw.println(message);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class Conversation extends Thread {
		/*
		 * la class conversation pour qu il puisse communiqué avec le client il a besion
		 * de la socket
		 */

		protected Socket socket;
		protected int numeroClient;

		public Conversation(Socket socket, int num) {
			super();
			this.socket = socket;
			this.numeroClient = num;
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
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os, true);
				String ip = socket.getRemoteSocketAddress().toString();
				System.out.println("Connection de client numero " + numeroClient + " IP=" + ip);
				pw.println("Bienvienue , vousetes le clients numéro " + numeroClient);
				// conversation
				while (true) {
					String req;
					while ((req = br.readLine()) != null) {
						String[] t = req.split("-");
						// form du message : message -4,6,1
						String message = t[0];
						String[] t2 = t[1].split(",");

						int[] numeroClients = new int[t2.length];
						for (int i = 0; i < t2.length; i++) {
							numeroClients[i] = Integer.parseInt(t2[i]);
							System.out.println(ip + " a envoyé " + req);
						}
						// qu 'est ce que je vais envoyer comme reponce
						broadCast(message, numeroClients);
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new ServeurChat().start();
	}

}
