package iit.trojan;

import static org.bytedeco.javacpp.opencv_core.cvFlip;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.VideoInputFrameGrabber;

/**
 * Created by gtiwari on 1/3/2017.
 */

public class Test4 implements Runnable {
	final int INTERVAL = 100;/// you may use interval
	CanvasFrame canvas = new CanvasFrame("Web Cam");

	public Test4() {
		canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	}

	public void run() {

		FrameGrabber grabber = new VideoInputFrameGrabber(0); // 1 for next camera
		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
		IplImage img;
		int i = 0;
		try {
			grabber.start();
			while (true) {
				Frame frame = grabber.grab();

				img = converter.convert(frame);

				// the grabbed frame will be flipped, re-flip to make it right
				cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise

				// save
				// cvSaveImage((i++) + "-aa.jpg", img);

				canvas.showImage(converter.convert(img));

				Thread.sleep(INTERVAL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Test4 gs = new Test4();
		Thread th = new Thread(gs);
		th.start();
	}
}
