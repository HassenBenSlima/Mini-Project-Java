package com.socket.media;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.beans.Encoder;
import java.io.File;
import java.io.IOException;

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

public class MediaSocket {

	public static int port;

	public MediaSocket(int portClient) {
		this.port = portClient;
	}

	public String takePictureCam() {
		Webcam webcam = null;
		String filePhoto = "B:\\Works\\workspaceJava\\JavaFileChat\\dowloadMedia\\myPhoto" + port + ".jpg";
		try {
			// get default webcam and open it
			webcam = Webcam.getDefault();
			webcam.setViewSize(WebcamResolution.VGA.getSize());
			webcam.open();
			// get image
			BufferedImage image = webcam.getImage();

			// save image to jpg file
			ImageIO.write(image, "jpg", new File(filePhoto));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			webcam.close();
		}
		return filePhoto;
	}

	public String imageScreen() {
		String fileName = "B:\\Works\\workspaceJava\\JavaFileChat\\dowloadMedia\\FullScreenshot" + port + ".jpg";
		try {
			/*
			 * Let the program wait for 5 seconds to allow you to open the window whose
			 * screenshot has to be captured
			 */
			Thread.sleep(1000);
			Robot robot = new Robot();
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, "jpg", new File(fileName));

		} catch (AWTException | IOException | InterruptedException ex) {
			System.err.println(ex);
		}
		return fileName;
	}

	public void detectCam() {
		Webcam webcam = Webcam.getDefault();
		if (webcam != null) {
			System.out.println("Webcam: " + webcam.getName());
		} else {
			System.out.println("No webcam detected");
		}
	}

	public String encoder() {
		String videofile = "B:\\Works\\workspaceJava\\JavaFileChat\\dowloadMedia\\video" + port + ".mp4";
		try {

			File file = new File(videofile);

			IMediaWriter writer = ToolFactory.makeWriter(file.getAbsolutePath());
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
		return videofile;
	}

}
