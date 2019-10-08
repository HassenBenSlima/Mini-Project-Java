package chapitre1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LinearInputStream extends FilterInputStream {
	int a, b;

	public LinearInputStream(InputStream is, int a, int b) throws FileNotFoundException {
		super(is);
		this.a = a;
		this.b = b;
		
		Scanner in = new Scanner(System.in);  // System.in is an InputStream

		Scanner inFile = new Scanner(new FileReader("myFile"));
		
	}

	@Override
	public int read() throws IOException {
		int xASCII = super.read();

		int x = Integer.valueOf(Character.toString((char) xASCII));

		return a * x + b;
	}

	public static void main(String[] args) throws IOException {

		OutputStream os = new FileOutputStream("/home/akram/Desktop/test2.txt");
		os.write('1');
		os.close();

		InputStream is = new FileInputStream("/home/akram/Desktop/test2.txt");
		LinearInputStream lis = new LinearInputStream(is, 2, 3);
		int y = lis.read();
		System.out.println("y=" + y);
		lis.close();

	}
}
