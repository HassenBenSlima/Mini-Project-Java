package tp2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Exercice2 {

	public static String fileCaracterPath = "/media/akram/stock/akram/enseignement/2018/systemes_communicants/tp/util/test3.txt";
	public static String fileBinPath = "/media/akram/stock/akram/enseignement/2018/systemes_communicants/tp/util/arrows.png";

	public static void main(String[] args) throws IOException {

	}

	public static void testOutDataPrintFilters() throws IOException {
		OutputStream outputStream = new FileOutputStream(fileCaracterPath);
		
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		

		for (int i = 0; i <= 10; i++) {
			dataOutputStream.writeDouble(5);
		}

		dataOutputStream.close();

		InputStream reader = new FileInputStream(fileCaracterPath);
		DataInputStream dataInputStream = new DataInputStream(reader);

		PrintStream printStream = new PrintStream(dataOutputStream);

		while (dataInputStream.available() > 0) {

			printStream.println(dataInputStream.readInt());

		}

		dataInputStream.close();
	}

}
