package TP4.Ex2.thrie;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur {

	private static Scanner sc;

	public static void main(String[] args) throws IOException {

		ServerSocket s;

		s = new ServerSocket(50000);
		Socket c = s.accept();
		
	
		String msg="";
		String bye="bye";
		while(true)
		{
		sc = new Scanner(System.in);
		msg = sc.nextLine();
		
		
		PrintWriter out = new PrintWriter(c.getOutputStream());
		out.println(msg);
		out.flush();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
		System.out.println("message recu: "+in.readLine());
		
		
		
	}
		
		//c.close();
		//s.close();

	}

}