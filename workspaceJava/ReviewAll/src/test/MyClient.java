package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) {
		try {

			InetAddress serveur = InetAddress.getByName("127.0.0.1");
			Socket socket = new Socket(serveur, 50000);
			Scanner sc = new Scanner(System.in);
			String reply = "";
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			System.out.println("Connect to server");
			while (true) {
				System.out.print("Client: ");
				reply = sc.nextLine();

				if (reply.equals("bye")) {
					System.out.println("Im out");
					break;
				}
				if (!reply.equals(null)) {

					out.println(reply);
					out.flush();
				}

				String request = in.readLine();
				if (!request.equals(null)) {

					System.out.print("Server: ");
					System.out.println(request);
				}
			}

			socket.close();
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
