package TP2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex3CopyFile {

	static void copy() throws IOException {
		File file= new File("file.txt");
		File file2 = new File("fichier.txt");
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			FileReader fr= new FileReader(file);
			FileWriter fw =new FileWriter(file2);
		
		int x;
		while((x=fr.read())!=-1) {
			fw.write((char)x);
		}
		fr.close();
		fw.close();
	}
	
	public static void main(String[] args) {
		try {
			copy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
