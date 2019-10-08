import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMT extends Thread {

	// on donne un numero pour chaque client
	int nbClient = 0;
	private int nombreSecret;
	private boolean fin;// pour indiquer que le jeu est terminé
	// enregistrer le gagnant
	private String gagant;
	private static ServeurMT me;

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(234);
			// gerer le nombre secret
			nombreSecret = (int) (Math.random() * 1000);

			/*
			 * le serveur soit cappable de connecté le client a n'import qu elle moment
			 * donner
			 * 
			 */
			while (true) {
				Socket s = ss.accept();
				++nbClient;
				new Conversation(s, nbClient).start();
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

		private Socket socket;
		private int numeroClient;

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
				pw.println("Devinez le nombre secret entre 0 et 1000");
				// conversation
				while (true) {
					String req;
					while ((req = br.readLine()) != null) {
						System.out.println(ip + " a envoye " + req);
						int nb = Integer.parseInt(req);

						if (fin == false) {
							if (nb < nombreSecret) {
								pw.println("votre nombre est plus petit");
							} else if (nb > nombreSecret) {
								pw.println("votre nombre est plus grand");

							} else {
								synchronized (me) {
									gagant = ip;
									fin = true;
								}
								pw.println("Bravo, vous avez gagné...");
								pw.println("************************");
								pw.println("BRAVO mr " + ip);
								pw.println("************************");

							}
						} else {
							pw.println("le jeu est terminé, le gagant est :" + gagant);

						}
						String rep = "Size=" + req.length();
						// j'envoie la reponse
						pw.println(rep);
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		me = new ServeurMT();
		me.start();

	}

}
