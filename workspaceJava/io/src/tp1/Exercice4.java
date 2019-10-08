package tp1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class Exercice4 {

	public static String fileCaracterPath = "/home/akram/Desktop/test3.txt";
	public static String fileBinPath = "/home/akram/Desktop/arrows.png";

	public static void main(String[] args) throws IOException {

	}

	

	public static void testOutputStreamBuffer() throws IOException {
		OutputStream outputStream = new FileOutputStream(fileCaracterPath);

		BufferedOutputStream write = new BufferedOutputStream(outputStream);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i <= 10000; i++) {
			write.write('a');
		}

		write.close();

		System.out.println((System.currentTimeMillis() - startTime) + "ms");

	}

	public static void testWriterBuffer() throws IOException {
		Writer w = new FileWriter(fileCaracterPath);

		BufferedWriter write = new BufferedWriter(w);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i <= 10000; i++) {
			write.write("Hello world !!\n");
		}

		write.close();

		System.out.println((System.currentTimeMillis() - startTime) + "ms");

	}

	public static void testReaderBuffer() throws IOException {

		long startTime = System.currentTimeMillis();
		Reader reader = new FileReader(fileCaracterPath);

		BufferedReader bufferedReader = new BufferedReader(reader);

		String line;

		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);

		}

		reader.close();

		System.out.println((System.currentTimeMillis() - startTime) + "ms");

	}

	public static void testInputStreamBuffer() throws IOException {

		long startTime = System.currentTimeMillis();
		InputStream reader = new FileInputStream(fileCaracterPath);

		BufferedInputStream bufferedInputStream = new BufferedInputStream(reader);

		int b;
		while (bufferedInputStream.available() > 0) {

			b = bufferedInputStream.read();
			System.out.print((char) b);
		}
		bufferedInputStream.close();

		System.out.println((System.currentTimeMillis() - startTime) + "ms");

	}
}
