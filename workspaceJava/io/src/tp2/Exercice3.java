package tp2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercice3 {
	
	public static String fileIn = "/media/akram/stock/akram/enseignement/2018/systemes_communicants/tp/util/in.txt";
	public static String fileOut = "/media/akram/stock/akram/enseignement/2018/systemes_communicants/tp/util/out.txt";

	public static void main(String[] args) throws IOException {
		
		
		FileReader fileReader = new FileReader(fileIn);
		
		FileWriter fileWriter = new FileWriter(fileOut);
		
		int a;
		while((a=fileReader.read()) != -1)
		{
			System.out.print( (char) a);
			fileWriter.write(a);
		}
		
		fileWriter.close();
		fileReader.close();
		
		
		
		
	}

}
