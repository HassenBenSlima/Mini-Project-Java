package Cours;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestURLConnection {
	public static void main(String[] args) {

		try {
			URL monURL = new URL("http://google.com");
			HttpURLConnection connexion = (HttpURLConnection) monURL.openConnection();
			InputStream flux = connexion.getInputStream();
			BufferedInputStream in = new BufferedInputStream(flux);

			int a;
			while ((a = in.read()) != -1) {
				System.out.print((char) a);
			}
			flux.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}