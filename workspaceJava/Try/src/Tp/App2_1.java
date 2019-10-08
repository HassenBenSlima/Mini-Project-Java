package Tp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App2_1 {
	/* Copier un fichier Text:lire et ecrire sur fichier text */
	public static void main(String[] args) {
		try {
			File f1 = new File("notes.txt");
			FileReader fr = new FileReader(f1);

			File f2 = new File("copie.txt");
			FileWriter fw = new FileWriter(f2);
			int c;
			while ((c = fr.read()) != -1) {
				fw.write(c);
			}
			fr.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
