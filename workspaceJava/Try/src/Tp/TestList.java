package Tp;

import java.util.ArrayList;

public class TestList {
	public static void main(String[] args) {

		ArrayList<String> l = new ArrayList<>();

		l.add("a");
		l.add("b");
		l.add("c");

		for (String string : l) {

			System.out.println(l.indexOf(string) + " : " + string);
		}

		l.remove(1);

		System.out.println("-----------------------");
		for (String string : l) {

			System.out.println(l.indexOf(string) + " : " + string);
		}

	}
}
