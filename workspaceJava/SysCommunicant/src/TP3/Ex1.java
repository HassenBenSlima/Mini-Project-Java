package TP3;

import java.util.concurrent.ThreadLocalRandom;

public class Ex1 {

	private static String path1 = "/Works/files/in.txt";
	private static String path2 = "/Works/files/in.txt";
	private static String path3 = "/Works/files/hassenF/text.txt";

	public static void main(String[] args) {
		int random=ThreadLocalRandom.current().nextInt(-1,2);
		System.out.println(random);
	}
	
}
