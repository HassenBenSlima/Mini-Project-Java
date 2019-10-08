package iit.trojan;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

public class Test2 {
	public static void capture() throws IOException, InterruptedException {
		Webcam webcam = Webcam.getDefault();
		Thread.sleep(5000);
		webcam.open();
		ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));

	}

	public static void main(String[] args) throws Exception {
		capture();
	}

}
