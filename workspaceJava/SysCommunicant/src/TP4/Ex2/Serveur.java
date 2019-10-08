package TP4.Ex2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	public static void main(String[] args) {

		try {
			ServerSocket s = new ServerSocket(50000);
			Socket c = s.accept();

			InputStream is = c.getInputStream();

			byte[] bytes = new byte[100];
			is.read(bytes);

			System.out.println(new String(bytes));
			System.out.println("ok");

			OutputStream os = c.getOutputStream();
			os.write("Hello by Server".getBytes());
			os.flush();

			c.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
