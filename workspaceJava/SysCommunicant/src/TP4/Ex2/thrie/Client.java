package TP4.Ex2.thrie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Socket socket;
		try {
			Scanner sc = new Scanner(System.in);
			InetAddress serveur = InetAddress.getByName("127.0.0.1");
			socket = new Socket(serveur, 50000);

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Message recu: " + in.readLine());
			String msg = sc.nextLine();

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(msg);
			out.flush();

			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
