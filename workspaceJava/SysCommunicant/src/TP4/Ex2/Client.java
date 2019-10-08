package TP4.Ex2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		try {
			InetAddress serveur = InetAddress.getByName("127.0.0.1");
			Socket c = new Socket(serveur, 50000);
			OutputStream os = c.getOutputStream();
			os.write("Hello by Client".getBytes());
			os.flush();

			InputStream is = c.getInputStream();

			byte[] bytes = new byte[100];
			is.read(bytes);
			System.out.println(new String(bytes));

			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
