package iit.trojan;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sarxos.webcam.Webcam;

/**
 * Example of how to take single picture on button press.
 * 
 * @author Bartosz Firyn (SarXos)
 */
public class Test3 {
	/**
	 * Logger instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(Test3.class);

	public static void main(String[] args) throws InterruptedException {

		Webcam webcam = Webcam.getDefault();
		Thread.sleep(000);
		webcam.open();

		try {
			String name = String.format("test-%d.jpg", System.currentTimeMillis());
			ImageIO.write(webcam.getImage(), "JPG", new File(name));
			System.out.format("File %s has been saved\n", name);
			LOG.info("bien");
		} catch (IOException t) {
			t.printStackTrace();
		} finally {
			webcam.close();
		}
	}

}
