package TP4.Ex2.Two;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur {
	public static void main(String[] args) {

		try {
			ServerSocket s = new ServerSocket(50000);
			Socket c = s.accept();

			InputStream is = c.getInputStream();

			byte[] bytes = new byte[100];
			is.read(bytes);
			System.out.println("Message Receive from Client:");
			System.out.println(new String(bytes));
			OutputStream os = c.getOutputStream();
			System.out.println("Message Server :");
			Scanner scanner = new Scanner(System.in);
			String st = scanner.nextLine();
			os.write(st.getBytes());
			// os.flush();
			c.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
