package Cours;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestURLConnection2 {
	public static void main(String[] args) {

		try {
			URL monURL = new URL("http://google.com");
			HttpURLConnection connexion = (HttpURLConnection) monURL.openConnection();
			InputStream flux = connexion.getInputStream();

			int a;
			while ((a = flux.read()) != -1) {
				System.out.print((char) a);
			}
			flux.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}