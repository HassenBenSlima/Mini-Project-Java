package iit.ens.projetpp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Buff {

	private String FILENAME;

	public Buff(String FILENAME) {
		this.FILENAME = FILENAME;
	}

	@SuppressWarnings("finally")
	public String bufferedwriter() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String s = "";
		try {
			Reader r = new FileReader(FILENAME);
			StringBuffer buf = new StringBuffer();

			int octet = 0;
			while (octet != -1) {
				octet = r.read();
				if (octet == -1)
					break;
				buf.append((char) octet);
			}

			r.close();

			String content = buf.toString();

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			s += e.toString();

		} finally {

			try {

				bw.close();

				fw.close();
				return s;
			} catch (IOException ex) {

				return ex.toString();
			}

		}

	}

	@SuppressWarnings("finally")
	public String bufferedreader() {
		BufferedReader br = null;
		FileReader fr = null;
		String er = "";
		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String s = "";

			String sCurrentLine = "";

			while ((sCurrentLine = br.readLine()) != null) {

				s += sCurrentLine;
			}

			System.out.println("buffffff");

			Writer w = new FileWriter(FILENAME);
			w.write(s);
			w.close();
			return s;

		} catch (IOException e) {

			er += e.toString();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
				return er;

			} catch (IOException ex) {

				return ex.toString();

			}

		}
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * BufferedWriter bw = null; FileWriter fw = null;
	 * 
	 * try {
	 * 
	 * String content = "This is the content to write into file\n";
	 * 
	 * fw = new FileWriter(FILENAME); bw = new BufferedWriter(fw);
	 * bw.write(content);
	 * 
	 * System.out.println("Done");
	 * 
	 * } catch (IOException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } finally {
	 * 
	 * try {
	 * 
	 * if (bw != null) bw.close();
	 * 
	 * if (fw != null) fw.close();
	 * 
	 * } catch (IOException ex) {
	 * 
	 * ex.printStackTrace();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\/
	 * /\\
	 * 
	 * 
	 * BufferedReader br = null; FileReader fr = null;
	 * 
	 * try {
	 * 
	 * //br = new BufferedReader(new FileReader(FILENAME)); fr = new
	 * FileReader(FILENAME); br = new BufferedReader(fr);
	 * 
	 * String sCurrentLine;
	 * 
	 * while ((sCurrentLine = br.readLine()) != null) {
	 * System.out.println(sCurrentLine); }
	 * 
	 * } catch (IOException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } finally {
	 * 
	 * try {
	 * 
	 * if (br != null) br.close();
	 * 
	 * if (fr != null) fr.close();
	 * 
	 * } catch (IOException ex) {
	 * 
	 * ex.printStackTrace();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

}