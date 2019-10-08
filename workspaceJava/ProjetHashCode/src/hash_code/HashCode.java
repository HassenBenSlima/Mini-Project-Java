package hash_code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HashCode {
	private static BufferedReader br;

	/*
	 * Lire et Écrire sur un fichier texte ligne par ligne : Streams de traitement :
	 * BufferedReader et BufferedWriter
	 */
	public static void main(String[] args) {

		try {

			File f = new File("a_example.in");
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
			String s;
			int nb = 0;
			int p = 0;
			while ((s = br.readLine()) != null)// null parce que une chaine de // caractere
			{
				++nb;
				String[] tab = s.split(" ");

				int note = Integer.parseInt(tab[0]);
				Integer note2 = Integer.parseInt(tab[1]);
				Integer note3 = Integer.parseInt(tab[2]);
				Integer note4 = Integer.parseInt(tab[3]);
				Integer note5 = Integer.parseInt(tab[4]);
				Integer note6 = Integer.parseInt(tab[5]);

				int[][] matrice = new int[note][note2];

				for (int i = 0; i < note; i++) {

					for (int j = 0; j < note2; j++) {
						matrice[i][j] = 0;
						System.out.print(matrice[i][j]);
					}

					System.out.println();

				}
				System.out.println();
				System.out.println(note);
				System.out.println(note2);
				System.out.println(note3);
				System.out.println("//" + note4);
				System.out.println(note5);
				System.out.println(note6);

				Point[] pointDepart = new Point[note3];
				Point[] pointDestination = new Point[note3];

				while (nb < note4) {

					++p;
					pointDepart[p].x = Integer.parseInt(tab[0]);
					pointDepart[p].y = Integer.parseInt(tab[1]);

					pointDestination[p] = new Point(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]));
					// System.out.println(pointDepart[p] + " // " + pointDestination[p]);

				}

				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
