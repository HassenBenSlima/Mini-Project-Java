package tp1;

public class Clavier {
	public static char unChar() {
		char i = (char) 0;
		try {
			i = (char) System.in.read();
		} catch (Exception e) {
			System.out.println("Error");
		}
		return i;
	}

	public static String unString() {
		StringBuilder s = new StringBuilder();
		char a;
		do {
			a = unChar();
			if (a != '\r')
				s.append(a);

		} while (a != '\n');
		return (s.toString());
	}

	public static int unEntier() {
		String s = unString();
		s = s.substring(0, s.length() - 1);
		return (Integer.parseInt(s));
	}

	public static int fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return n * fact(n - 1);
	}

	public static void main(String[] args) {

		int c = Clavier.unEntier();
		System.out.println(c);

	}
}