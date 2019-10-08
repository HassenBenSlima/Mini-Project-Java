package Cours.socketsTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		InetAddress serveur =
				InetAddress.getByName("127.0.0.1");
				Socket c = new Socket(serveur, 50000);
				
				InputStream is = c.getInputStream();
				int x = is.read();//bloquant
				System.out.print(" x="+x);
				OutputStream os = c.getOutputStream();
				os.write(x+1);
				x = is.read() ;
				System.out.print(" x= "+x);
				c.close();
	}

}
