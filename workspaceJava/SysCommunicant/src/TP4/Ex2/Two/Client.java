package TP4.Ex2.Two;

import java.io.InputStream;
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
			System.out.println("Message Client :");
			Scanner scanner = new Scanner(System.in);
			String st = scanner.nextLine();
			os.write(st.getBytes());
			// os.flush();
			InputStream is = c.getInputStream();
			byte[] bytes = new byte[100];
			is.read(bytes);
			System.out.println("Message Receive from Server:");
			System.out.println(new String(bytes));
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
