package TP2;

import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class Ex5MajusculeFilter extends FilterReader {
	Reader in;

	public Ex5MajusculeFilter(Reader in) {
		super(in);
		this.in = in;
	}

	@Override
	public int read() throws IOException {

		int a;
		while ((a = in.read()) != -1) {
			System.out.println(Character.toUpperCase((char)a));
		}

		return 0;
	}

	public static void main(String[] args) throws IOException {
		String path = "/home/hassen/Desktop/test.txt";

		Reader in = new FileReader(path);

		Ex5MajusculeFilter mf = new Ex5MajusculeFilter(in);
		
		System.out.println(mf.read());
	}

}
