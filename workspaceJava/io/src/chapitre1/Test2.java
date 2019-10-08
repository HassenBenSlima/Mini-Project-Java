package chapitre1;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] arags) throws IOException, InterruptedException {
		Process p = new ProcessBuilder("java", "-cp", "bin", "stackoverflow.ChildProcess").start();
		// receive from child
		new Thread(() -> {
			try {
				int c;
				while ((c = p.getInputStream().read()) != -1)
					System.out.write((byte) c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		// send to child
		try (Writer w = new OutputStreamWriter(p.getOutputStream(), "UTF-8")) {
			w.write("send to child\n");
		}
		System.out.println("rc=" + p.waitFor());
	}

}

class ChildProcess {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// receive from parent and send to parent
		System.out.println("child recevied: " + s.nextLine());
	}

}
