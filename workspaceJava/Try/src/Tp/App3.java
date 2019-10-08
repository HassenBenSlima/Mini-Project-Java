package Tp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App3 {
	/*
	 * Lire et Écrire sur un fichier texte ligne par ligne : Streams de
	 * traitement : BufferedReader et BufferedWriter
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			File f = new File("notes.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String s;
			double somme = 0;
			int nb = 0;
			while ((s = br.readLine()) != null)// null parce que une chaine de
												// caractere
			{
				++nb;
				String[] tab = s.split(";");
				double note = Double.parseDouble(tab[2]);
				somme = somme + note;
			}
			System.out.println("Moyenne=" + somme / nb);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
