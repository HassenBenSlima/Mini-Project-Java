package TP2.Ex4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class Ex4 {

	static String filePath = "/home/hassen/Desktop/tp2.ex4.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		// writeObject();
		// ReadObject();
		testCypher();
	}

	public static void writeObject() throws IOException {
		CompteBank c1 = new CompteBank(5225, "tijeri");
		CompteBank c2 = new CompteBank(5225, "biat");
		CompteBank[] banks = { c1, c2 };
		OutputStream outputStream = new FileOutputStream(filePath);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

		Personne personneOut = new Personne(1, "Ben Slima", "Hassen", "****", banks);
		objectOutputStream.writeObject(personneOut);
		objectOutputStream.close();
	}

	public static void ReadObject() throws IOException, ClassNotFoundException {

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
		Personne personneIn = (Personne) objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(personneIn);
		System.out.print(personneIn.password);
	}

	public static void testCypher() throws IOException, ClassNotFoundException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException {
		String filepath2 = "/home/hassen/Desktop/tp2.ex4.txt";
		CompteBank c1 = new CompteBank(5000, "BIAT");
		CompteBank c2 = new CompteBank(5623, "TIJERI");
		CompteBank banks[] = { c1, c2 };
		Personne personneOut = new Personne(5000, "hamouda", "elkapou", "**-**", banks);
		// aes criptage
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		Key k = keygen.generateKey();
		Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		aes.init(Cipher.ENCRYPT_MODE, k);

		CipherOutputStream cipherOutputStream = new CipherOutputStream(new FileOutputStream(filepath2), aes);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(cipherOutputStream);
		objectOutputStream.writeObject(personneOut);
		cipherOutputStream.close();

		aes.init(Cipher.DECRYPT_MODE, k);

		CipherInputStream cipherInputStream = new CipherInputStream(new FileInputStream(filepath2), aes);
		ObjectInputStream objectInputStream = new ObjectInputStream(cipherInputStream);
		
//		Personne personneIn =(Personne) objectInputStream.readObject();
//		System.out.println(personneIn);
		Object x;
		Personne personneIn;
		while ((personneIn =(Personne) objectInputStream.readObject())!=null) {
			 System.out.println(personneIn);
		 }
		 
		objectInputStream.close();
		cipherInputStream.close();

	}

}
