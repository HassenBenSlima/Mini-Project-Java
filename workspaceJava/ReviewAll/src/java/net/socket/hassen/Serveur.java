package java.net.socket.hassen;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] args) throws Exception {
		ServerSocket s = new ServerSocket(1234);
		System.out.println("J'attend la connexion d'un client ");
		Socket c = s.accept();// bloquant
		
		InputStream is = c.getInputStream();
		OutputStream os = c.getOutputStream();
		System.out.println("J'attend un nombre");
		int nb = is.read();// bloquant
		int req = nb * 8;
		System.out.println("J'envoie la reponse "); 
		os.write(req);
		s.close();

	}

}
