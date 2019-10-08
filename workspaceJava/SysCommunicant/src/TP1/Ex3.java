package TP1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex3 {
	// octet:-127|127
	// char:- 2puissance 24 >2puissance 24
	/*
	 * 
	 * */
	public static void main(String[] args) throws IOException {
		/*
		 *  ls | head -3 | tail -1
		 * */
		Runtime rt = Runtime.getRuntime();// recuperer l'instantce de system

		Process lsProcess = rt.exec("ls -a");
		Process headProcess = rt.exec("head -5");
		Process tailProcess = rt.exec("tail -2");

		InputStream lsInputStream = lsProcess.getInputStream();
		OutputStream headOutputStream = headProcess.getOutputStream();

		// OutputStream outGrepProc=headProc.getOutputStream();
		int lsRes = 0;
		while (lsRes != -1) {
			lsRes = lsInputStream.read();
			headOutputStream.write(lsRes);
			//System.out.print((char)lsRes);
		}
		lsInputStream.close();
		headOutputStream.close();

		InputStream headIntputStream = headProcess.getInputStream();
		OutputStream tailOutputStream = tailProcess.getOutputStream();

		int headRes = 0;
		while (headRes != -1) {
			headRes = headIntputStream.read();
			//System.out.print((char)headRes);
			tailOutputStream.write(headRes);

		}
		headIntputStream.close();
		tailOutputStream.close();

		InputStream tailIntputStream = tailProcess.getInputStream();

		int tailRes = 0;
		while (tailRes != -1) {
			tailRes = tailIntputStream.read();
			System.out.write(tailRes);
		}

		tailIntputStream.close();
	}

}
