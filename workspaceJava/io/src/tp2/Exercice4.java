package tp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class Exercice4 {

	static String filePath = "/home/akram/Desktop/obj.bin";

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException {

		testCypher();

	}

	public static void WriteObject() throws FileNotFoundException, IOException {

		CompteBank c1 = new CompteBank(5225, "tijeri");
		CompteBank c2 = new CompteBank(48419, "STB");

		CompteBank[] banks = { c1, c2 };

		Personne personneOut = new Personne(1, "ahmed", "ali", "mYpASSWord", banks);

		// FileOutputStream f = new FileOutputStream(filePath);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
		objectOutputStream.writeObject(personneOut);
	}

	public static void readObject() throws IOException, ClassNotFoundException {

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

		Personne personneIn = (Personne) objectInputStream.readObject();
		objectInputStream.close();

		System.out.println(personneIn);
		System.out.println(personneIn.password);
	}

	public static void testCypher() throws IOException, ClassNotFoundException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException {

		String filePath = "/home/akram/Desktop/obj.bin";

		CompteBank c1 = new CompteBank(5225, "tijeri");
		CompteBank c2 = new CompteBank(48419, "STB");

		CompteBank[] banks = { c1, c2 };

		Personne personneOut = new Personne(1, "ahmed", "ali", "mYpASSWord", banks);

		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		Key k = keygen.generateKey();

		Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		aes.init(Cipher.ENCRYPT_MODE, k);

		CipherOutputStream cipherOutputStream = new CipherOutputStream(new FileOutputStream(filePath), aes);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(cipherOutputStream);

		objectOutputStream.writeObject(personneOut);

		cipherOutputStream.close();

		aes.init(Cipher.DECRYPT_MODE, k);

		CipherInputStream cipherInputStream = new CipherInputStream(new FileInputStream(filePath), aes);

		ObjectInputStream objectInputStream = new ObjectInputStream(cipherInputStream);

		Personne personneIn = (Personne) objectInputStream.readObject();
		objectInputStream.close();

		System.out.println(personneIn);
	}
}
