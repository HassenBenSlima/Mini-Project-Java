package Tp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class App4 {
	//COMPRESSION D'UN FISHIER
	public static void main(String[] args) {
	try {
		//lire un fichier
		File f= new File("doc.docx");
		FileInputStream fis=new FileInputStream(f);
		BufferedInputStream bis=new BufferedInputStream(fis);//lire une serie d'octet
		
		//ecrire sur un fichier
		File f2=new File("doc.zip");
		FileOutputStream fos=new FileOutputStream(f2);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		ZipOutputStream zos= new ZipOutputStream(bos); //compression =>ecrire
		zos.setMethod(ZipOutputStream.DEFLATED);//compraission par defaut
		zos.putNextEntry(new ZipEntry(f.getName()));//cree une entrer
				
		int c;
		while((c=bis.read())!=-1){
			zos.write(c);			
		}
		zos.close();
		bis.close();

	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}

}
