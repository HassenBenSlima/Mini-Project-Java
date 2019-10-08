package TP1;

import java.io.IOException;

public class ex2 {
	
	
	public static void main(String[] args) throws IOException {

		
		System.out.println("Donner un caracter");
		System.out.println(unString());
		
	}
	
	public static char unChar() throws IOException{
		char result=(char)System.in.read();
		
		return result;
	
	}
	public static String unString() throws IOException{
		String result="";
		char a;
		while((a=unChar())!='\n')
		result+=a;
		return result;
	
	}
	
	public static String unString2() throws IOException{
		StringBuilder result=new StringBuilder();
		char a;
		while((a=unChar())!='\n')
		result.append(a);
		return result.toString();
	
	}	
	
	
	
}