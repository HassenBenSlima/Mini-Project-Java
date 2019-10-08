//package iit.trojan.image;
//
//import java.io.ByteArrayInputStream;
//import java.io.FileOutputStream;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//
//import javax.imageio.ImageIO;
//
//public class ServeurUDP {
//
//	public static void main(String[] args) {
//
//		try {
//			DatagramSocket s = new DatagramSocket(50000);
//
//			ByteArrayInputStream baos = new ByteArrayInputStream(null);
//			ImageIO.write(img, "png", baos);
//			baos.flush();
//			byte[] buffer = baos.toByteArray();
//
//			DatagramPacket in = new DatagramPacket(buffer, buffer.length);
//			s.receive(in);
//
//			FileOutputStream fileOutputStream = new FileOutputStream("test2.png");
//			fileOutputStream.write(msg);
//			fileOutputStream.close();
//
//			s.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
