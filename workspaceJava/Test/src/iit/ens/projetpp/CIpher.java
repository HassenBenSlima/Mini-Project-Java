package iit.ens.projetpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

public class CIpher {

	public static Key k;
	public static Cipher aes;

	public Key getK() {
		return k;
	}

	public static Key generateKey() {
		try {
			if (k == null) {
				KeyGenerator keygen = KeyGenerator.getInstance("AES");
				k = keygen.generateKey();
				System.out.println(k.getEncoded().toString().getBytes());
			}
			return k;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void testCipher(Key k) {
		try {

			aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
			System.out.println(k.getEncoded().toString().getBytes());
			aes.init(Cipher.ENCRYPT_MODE, k);

			File file = new File("/home/hassen/Desktop/file.txt");
			FileInputStream fileInputStream = new FileInputStream(file);

			File file_2 = new File("/home/hassen/Desktop/file2.txt");
			FileOutputStream fileOutputStream = new FileOutputStream(file_2);

			CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, aes);
			byte[] c = new byte[1024 * 1024];
			fileInputStream.read(c);
			cipherOutputStream.write(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void decripted(Key k) {
		try {
			aes.init(Cipher.DECRYPT_MODE, k);
			File file_2 = new File("/home/hassen/Desktop/file2.txt");

			FileInputStream in = new FileInputStream(file_2);
			CipherInputStream cipherInputStream = new CipherInputStream(in, aes);

			byte[] buffer = new byte[1024 * 1024];
			cipherInputStream.read(buffer);

			System.out.println("*******************");

			FileOutputStream fos = new FileOutputStream(file_2 + ".txt");
			fos.write(buffer);

			String hh = k.getEncoded().toString();

			FileOutputStream bobo = new FileOutputStream(file_2 + ".key:" + k);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//
//	public static void main(String[] args) {
//
//		Key hassen = generateKey();
//		System.out.println(hassen.getEncoded());
//		testCipher(hassen);
//		decripted(hassen);
//
//	}

}
