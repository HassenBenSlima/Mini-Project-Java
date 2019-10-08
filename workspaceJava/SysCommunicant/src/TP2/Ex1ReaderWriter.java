package TP2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.concurrent.TimeUnit;

public class Ex1ReaderWriter {

	public static void writeInFile() throws IOException {

		File f1 = new File("file.txt");
		Writer writer = new FileWriter(f1);
		for (int i = 0; i < 2000; i++)
			writer.write("a");
		writer.close();

	}

	public static void testReader() throws IOException {

		File f1 = new File("file.txt");
		Reader reader = new FileReader(f1);
		int x;
		while ((x = reader.read()) != -1)
			System.out.println((char) x);

	}

	public static void testBufferReader() throws IOException {
		File f = new File("file.txt");
		FileReader f1 = new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(f1);
		long starttime = System.currentTimeMillis();
		int x;
		while ((x = bufferedReader.read()) != -1)
			System.out.println((char) x);
		bufferedReader.close();
		long starttime2 = System.currentTimeMillis();

		long timeMillis = starttime2 - starttime;
		System.out.println(timeMillis);
		long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
		
		
		System.out.println(timeSeconds);// plus performe que writer

	}

	public static void testInputstream() throws IOException {

		File f1 = new File("file.txt");
		InputStream is = new FileInputStream(f1);
		BufferedInputStream bf = new BufferedInputStream(is);
		long starttime = System.currentTimeMillis();
		int x;
		while ((x = bf.read()) != -1)
			System.out.println((char) x);
		long starttime2 = System.currentTimeMillis();
		System.out.println(starttime2 - starttime);// plus performe que writer

	}

	public static void testInputstream2() throws IOException {

		File f1 = new File("file.txt");
		InputStream is = new FileInputStream(f1);
		int x;
		while ((x = is.available()) != 0) {

			System.out.print((char) is.read());
			System.out.println((char) is.available());
		}
		is.close();
	}

	public static void testOutputStream() throws IOException {
		OutputStream outputStream = new FileOutputStream("file.txt");

		for (int i = 0; i < 2000; i++)
			outputStream.write('a');
		outputStream.close();
	}

	public static void testBuffer() {

	}

	public static void main(String[] args) {
		try {
			// testInputstream2();

			// testReader();
			testBufferReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
