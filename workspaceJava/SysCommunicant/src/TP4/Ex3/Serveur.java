package TP4.Ex3;

import java.io.InputStream;
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
			System.out.println("Message Receive from client:");
			String msg = new String(bytes);

			Runtime rt = Runtime.getRuntime();
			Process lsProc = rt.exec(msg);

			InputStream inLsProc = lsProc.getInputStream();

			int b;
			while ((b = inLsProc.read()) != -1) {
				System.out.write(b);
			}

			c.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
