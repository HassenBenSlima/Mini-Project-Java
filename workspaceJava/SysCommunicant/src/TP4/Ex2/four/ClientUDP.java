package TP4.Ex2.four;

import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {

	public static void main(String[] args) {

		try {
			DatagramSocket s = new DatagramSocket();
			FileInputStream fileInputStream = new FileInputStream("file.txt");

			byte msg[] = new byte[50];
			fileInputStream.read(msg);

			InetAddress localhost = InetAddress.getByName("localhost");

			DatagramPacket out = new DatagramPacket(msg, 0, msg.length, localhost, 50000);
			s.send(out);

			System.out.println("To port : " + out.getPort());

			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
