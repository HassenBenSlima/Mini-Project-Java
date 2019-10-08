package iit.ens.projetpp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CipherSample {
	private static SecretKeySpec secretKey;
	private static byte[] key;

	// private String FILENAME;

	// public CipherSample(String FILENAME) {
	// this.FILENAME = FILENAME;
	// }

	public static String encrypt(String FILENAME) {
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
			String s = buf.toString();
			System.out.println(s);

			final String secret = "ssshhhhhhhhhhh!!!!";
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			s = Base64.getEncoder().encodeToString(cipher.doFinal(s.getBytes("UTF-8")));

			Writer w = new FileWriter(FILENAME);
			w.write(s);
			w.close();

			// System.out.println(cipherBytes);

			System.out.println("CRUPTED DATA : " + s);
			return "";

		} catch (Exception ex) {
			return ex.toString();
		}

	}

	public static String decrypt(String FILENAME) {
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
			// System.out.println(buf.toString());
			final String secret = "ssshhhhhhhhhhh!!!!";
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			String s = new String(cipher.doFinal(Base64.getDecoder().decode(buf.toString())));

			System.out.println("DECRUPTED DATA : " + s);

			Writer w = new FileWriter(FILENAME);
			w.write(s);
			w.close();

			return "";

		} catch (Exception ex) {
			System.out.println("Error while decrypting: " + ex.toString());
			return ex.toString();
		}
	}

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// encrypt("/home/hassen/Desktop/file.txt");

		decrypt("/home/hassen/Desktop/file.txt");
	}

}