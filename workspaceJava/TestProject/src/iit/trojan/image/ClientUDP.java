package iit.trojan.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.imageio.ImageIO;

public class ClientUDP {

	public static void main(String[] args) {

		try {

			BufferedImage img = ImageIO.read(new File("test.png"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(img, "png", baos);
			baos.flush();
			byte[] buffer = baos.toByteArray();

			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName("localhost");
			System.out.println(buffer.length);

			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, IPAddress, 50000);

			clientSocket.send(packet);

			System.out.println("To port : " + packet.getPort());

			clientSocket.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
