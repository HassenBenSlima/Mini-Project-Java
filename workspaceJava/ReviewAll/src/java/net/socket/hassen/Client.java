package java.net.socket.hassen;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		InetAddress serveur = InetAddress.getByName("localhost");
		Socket c = new Socket(serveur, 1234);
		
		OutputStream os = c.getOutputStream();
		InputStream is = c.getInputStream();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Donner un nombre : ");
		int nb = scanner.nextInt();
		os.write(nb);

		int req = is.read();// bloquant
		System.out.print(" Resultat=" + req);

		c.close();
	}

}
