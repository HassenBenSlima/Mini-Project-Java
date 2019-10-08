package Tp;

import java.io.File;

public class App1 {

	public static void main(String[] args) {
		File f= new File("c:/");
		if(f.exists()){
			String[]contenu=f.list();
			
			for(int i=0;i<contenu.length;i++){
				File f2=new File("c:/"+contenu[i]);
				if(f2.isDirectory()){
					System.out.println("Rep:"+contenu[i]);
								
				}else{
					System.out.println("Fichier:"+contenu[i]+"  Size="+f2.length());
					
				}
			}
		}
	}
}
