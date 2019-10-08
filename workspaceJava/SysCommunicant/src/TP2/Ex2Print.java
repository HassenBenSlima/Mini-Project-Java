package TP2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Ex2Print {
	public static String fileCaracterPath = "/home/hassen/Desktop/tp2ex2.txt";
	public static String fileBinPath = "/home/hassen/Desktop/Tp2ex2.txt";

	public static void main(String[] args) throws IOException {
		try {
			testDataOutputStreamFilter();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void testDataOutputStreamFilter() throws IOException {

		OutputStream OutputStream = new FileOutputStream(fileCaracterPath);
		DataOutputStream dataOutputStream = new DataOutputStream(OutputStream);

		for (int i = 0; i <= 10; i++) {
			dataOutputStream.writeDouble(5);
		}

		dataOutputStream.close();

		InputStream reader = new FileInputStream(fileCaracterPath);
		DataInputStream dataInputStream = new DataInputStream(reader);
		PrintStream printStream = new PrintStream(dataOutputStream);
		while (dataInputStream.available() > 0) {
			printStream.println(dataInputStream.readDouble());
		}

	}


	public static void writeWithPrint() throws FileNotFoundException {
		File file = new File("file.txt");

		// true: on veut ecrire a la suite de la fichier pour ne fait pas l'ecrasement
		OutputStream os = new FileOutputStream(file, true);
		PrintWriter print = new PrintWriter(os);
		print.print("message de test\n");
		print.print(false);
		print.close();
	}

	public static void testOutputStreamWithPrint() throws FileNotFoundException {
		File file = new File("file.txt");

		// true: on veut ecrire a la suite de la fichier pour ne fait pas l'ecrasement
		OutputStream os = new FileOutputStream(file, true);

		PrintStream print = new PrintStream(os);
		print.print("message de test\n");
		print.print(false);
		print.close();

	}

	
}
