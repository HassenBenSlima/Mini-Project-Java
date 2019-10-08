package Cours.socketsTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(50000); 
		Socket c = s.accept();//bloquant
		
		OutputStream os = c.getOutputStream();
		os.write(2) ;
		
		InputStream is = c.getInputStream();
		int y = is.read();//bloquant
		System.out.print(" y= "+y) ;
		c.close();
		s.close();
	}

}
