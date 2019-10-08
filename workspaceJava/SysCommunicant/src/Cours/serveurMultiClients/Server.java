//package Cours.serveurMultiClients;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//	public static void main(String[] args) throws IOException {
//
//		ServerSocket serverSocket = new ServerSocket(50000);
//		while (true) {
//			Socket clientServiceSocket = serverSocket.accept();
//			Service myService = new Service(clientServiceSocket);
//			// crée un nouveau thread pour le nouveau client
//			myService.start();
//			// lance l’exécution du thread
//		}
//	}
//}