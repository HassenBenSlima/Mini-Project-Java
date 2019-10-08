
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			// InetAddress serveur = InetAddress.getByName("localhost");
			Socket sock = new Socket("localhost", 1234);

			OutputStream os = sock.getOutputStream();
			InputStream is = sock.getInputStream();

			Scanner scanner = new Scanner(System.in);
			System.out.println(" Donner un nombre : ");
			int nb = scanner.nextInt();
			os.write(nb);//envoyer vers le serveur

			//j'attend la reponce
			int req = is.read();// bloquant
			System.out.print(" Resultat=" + req);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
