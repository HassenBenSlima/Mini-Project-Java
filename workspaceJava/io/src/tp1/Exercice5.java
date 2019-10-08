package tp1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import tp2.MajusculeFilter;

public class Exercice5 {
	
	
	public static String fileCaracterPath = "/home/akram/Desktop/test3.txt";
	
	public static void main(String[] args) throws IOException {
		
		
		MajusculeFilter filter = new MajusculeFilter(new FileReader(fileCaracterPath));
		
		filter.read();
		
		filter.close();
	}

}
