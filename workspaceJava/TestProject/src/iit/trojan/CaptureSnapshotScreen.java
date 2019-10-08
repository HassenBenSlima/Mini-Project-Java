package iit.trojan;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CaptureSnapshotScreen {

	public static void imagePicture() throws InterruptedException {

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

	public static void main(String[] args) throws Exception {
		imagePicture();
	}
}
