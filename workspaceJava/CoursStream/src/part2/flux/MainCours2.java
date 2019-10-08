package part2.flux;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class MainCours2 {

	public static void main(String[] args) {
		
		File file = new File("fichier.txt");
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//true: on veut ecrire a la suite de la fichier pour ne fait pas l'ecrasement
		try (PrintWriter print =new PrintWriter( new FileOutputStream(file,true))){
			
			print.print("message de test\n");
			print.print(false);
		}catch (IOException e) {
			e.printStackTrace();
			
		}
	
	}
	
}
