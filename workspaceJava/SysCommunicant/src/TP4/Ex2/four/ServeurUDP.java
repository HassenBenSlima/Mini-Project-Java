package TP4.Ex2.four;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServeurUDP {

	public static void main(String[] args) {

		try {
			DatagramSocket s = new DatagramSocket(50000);

			byte msg[] = new byte[50];

			DatagramPacket in = new DatagramPacket(msg, 50);
			s.receive(in);

			FileOutputStream fileOutputStream = new FileOutputStream("file2.txt");
			fileOutputStream.write(msg);
			fileOutputStream.close();

			s.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
