package Cours;

import java.net.InetAddress;
import java.util.Arrays;

public class ClassInetAdress {
	public static void main(String[] args) {
		try {
			InetAddress adrLocale = InetAddress.getLocalHost();
			System.out.println("Adresse locale = " + adrLocale.getHostAddress());
			System.out.println("Tableau adr = " + Arrays.toString(adrLocale.getAddress()));

			InetAddress adrServeur = InetAddress.getByName("www.google.com");
			System.out.println("Adresse Google = " + adrServeur.getHostAddress());

			InetAddress[] adrServeurs = InetAddress.getAllByName("www.google.com");
			System.out.println("Adresses Google : ");
			for (int i = 0; i < adrServeurs.length; i++) {
				System.out.println(" " + adrServeurs[i].getHostAddress());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}