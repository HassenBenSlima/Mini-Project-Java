package tp1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class Exercice1 {

	public static String fileCaracterPath = "/home/akram/Desktop/test2.txt";
	public static String fileBinPath = "/home/akram/Desktop/arrows.png";

	public static void main(String[] args) throws IOException {

		// testOutputStreamEuro();
		testWriterEuro();
		testInputStream();
		System.out.println();
		testReader();

		// Unicode (extended ASCII)
		// ASCII

	}

	public static void testOutputStream() throws IOException {
		OutputStream outputStream = new FileOutputStream(fileCaracterPath);

		for (byte b = 97; b < 123; b++) {
			outputStream.write(b);
		}
		outputStream.close();

	}

	public static void testOutputStreamEuro() throws IOException {
		OutputStream outputStream = new FileOutputStream(fileCaracterPath);

		outputStream.write(8364);
		outputStream.close();

	}

	public static void testWriter() throws IOException {
		Writer writer;

		writer = new FileWriter(fileCaracterPath);

		for (byte b = 97; b < 123; b++) {
			writer.write(b);
		}

		writer.flush();

		writer.close();

	}

	public static void testWriterEuro() throws IOException {
		Writer writer;

		writer = new FileWriter(fileCaracterPath);

		writer.write(8364);

		writer.flush();

		writer.close();

	}

	public static void testInputStream() throws IOException {

		InputStream inputStream = new FileInputStream(fileCaracterPath);

		int b;
		while ((b = inputStream.read()) != -1)
			System.out.print(b + " ");

		System.out.flush();

		inputStream.close();
	}

	public static void testReader() throws IOException {
		Reader reader;

		reader = new FileReader(fileCaracterPath);

		int caractere;

		while ((caractere = reader.read()) != -1) {
			System.out.print(caractere + " ");

		}

		reader.close();

	}

}
