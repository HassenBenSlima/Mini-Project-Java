package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServerUniClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(50000);
		Socket socket = serverSocket.accept();

		try {
			String reply = "";
			/*
			 * write with keyboerd
			 */
			Scanner sc = new Scanner(System.in);
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());

			System.out.println("Client connected");
			while (true) {

				String request = is.readLine();

				if (reply.equals("bye")) {
					System.out.println("Im out");
					break;
				}

				if (request != null) {

					System.out.println("Client : " + request);

					reply = sc.nextLine();
					if (!reply.equals(null)) {
						System.out.print("Server: ");
						out.println(reply);
						out.flush();
					}
				} else {
					System.out.println("Client : out");
					break;
				}

			}

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
