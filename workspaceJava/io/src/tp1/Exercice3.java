package tp1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Exercice3 {

	public static String fileCaracterPath = "/home/akram/Desktop/test3.txt";
	public static String fileBinPath = "/home/akram/Desktop/arrows.png";

	public static void main(String[] args) throws IOException {

		// ls chemin | head -3 | tail -1

		String chemin = "/home/akram/Desktop/test";

		Runtime rt = Runtime.getRuntime();

		Process lsProc = rt.exec("ls " + chemin);
		Process headProc = rt.exec("head -3");
		Process tailProc = rt.exec("tail -1");

		InputStream inLsProc = lsProc.getInputStream();
		OutputStream outHeadProc = headProc.getOutputStream();

		int b;
		while ((b = inLsProc.read()) != -1) {
			// System.out.write(b);
			outHeadProc.write(b);
		}

		inLsProc.close();
		outHeadProc.close();

		InputStream inHeadProc = headProc.getInputStream();
		OutputStream outTailProc = tailProc.getOutputStream();

		while ((b = inHeadProc.read()) != -1) {
			// System.out.write(b);
			outTailProc.write(b);
		}

		inHeadProc.close();
		outTailProc.close();

		InputStream inTailProc = tailProc.getInputStream();
		while ((b = inTailProc.read()) != -1)
			System.out.write(b);

		inTailProc.close();

	}

//	public static void testSequenceFilter() throws IOException {
//
//		Runtime rt = Runtime.getRuntime();
//
//		Process lsProc = rt.exec("ls " + fileCaracterPath);
//		Process headProc = rt.exec("head -3");
//		Process tailProc = rt.exec("tail -1");
//
//		InputStream inLsProc = lsProc.getInputStream();
//		InputStream inHeadProc = headProc.getInputStream();
//		InputStream inTailProc = tailProc.getInputStream();
//
//		Vector<InputStream> inputStreams = new Vector<InputStream>();
//		inputStreams.add(inLsProc);
//		inputStreams.add(inHeadProc);
//		inputStreams.add(inTailProc);
//
//		Enumeration<InputStream> enu = inputStreams.elements();
//		SequenceInputStream sequenceInputStream = new SequenceInputStream(enu);
//
//		int oneByte;
//		while ((oneByte = sequenceInputStream.read()) != -1) {
//			System.out.write(oneByte);
//		}
//		System.out.flush();
//		
//		sequenceInputStream.close();
//
//	}
//
//	public static void testPipe() throws IOException {
//
//		Runtime rt = Runtime.getRuntime();
//
//		Process lsProc = rt.exec("ls " + fileCaracterPath);
//		Process headProc = rt.exec("head -3");
//		Process tailProc = rt.exec("tail -1");
//
//		InputStream inLsProc = lsProc.getInputStream();
//		InputStream inHeadProc = headProc.getInputStream();
//		InputStream inTailProc = tailProc.getInputStream();
//
//		OutputStream outHeadProc = headProc.getOutputStream();
//		OutputStream outTailProc = tailProc.getOutputStream();
//
//		PipedOutputStream pos = new PipedOutputStream();
//		PipedInputStream pis = new PipedInputStream(pos);
//
//		PrintStream ps = new PrintStream(pos);
//	}

}
