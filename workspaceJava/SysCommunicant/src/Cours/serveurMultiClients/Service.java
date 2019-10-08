//package Cours.serveurMultiClients;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class Service extends Thread {
//	Socket socket;
//	String request, reply = "Hello";
//
//	public Service(Socket socket) {
//		this.socket = socket;
//	}
//
//	public void run() {
//		try {
//			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			request = in.readLine();
//			// exécuter le service et traiter request pour fournir reply
//			out.println(reply); 
//			out.flush();
//			catch (IOException e) { 
//				e.printStackTrace(); 
//			}	
//		}
//	}
//}