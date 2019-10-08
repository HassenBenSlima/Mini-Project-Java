package TP4.Ex3;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		try {
			InetAddress serveur = InetAddress.getByName("127.0.0.1");
			Socket c = new Socket(serveur, 50000);
					
			OutputStream os = c.getOutputStream();
			System.out.println("Message C :");
			Scanner scanner = new Scanner(System.in);
			String st = scanner.nextLine();
			os.write(st.getBytes());
			
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
