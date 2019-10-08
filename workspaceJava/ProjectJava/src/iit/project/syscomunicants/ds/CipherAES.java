package iit.project.syscomunicants.ds;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.IOUtils;

/**
 * 
 * @author Hassen Ben Slima {@link CipherAES qui est responsable sur
 *         l'encryptage et le decryptage de fichier en utilisant Cipher }
 *
 */
public class CipherAES {

	private SecretKeySpec secretKey;
	private byte[] key;
	/**
	 * key de cypherAES
	 */
	final String secret = "Hassen_Hsouna";

	/**
	 * Convert Key
	 */
	public void setKey(String myKey) {
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

	/**
	 * 
	 * encrypt cypher
	 */
	public void encrypt(String filename) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

			File file = new File(filename);
			FileInputStream in = new FileInputStream(file);
			/*
			 * recupirer les donnée dans un variable de type STRING j'ai utilisé ub lib
			 * "commons-io-2.1.jar" vous la trouver dans le dossier "lib"/commons-io-2.1.jar
			 * dans la projet
			 */
			String theString = IOUtils.toString(in, "UTF-8");
			in.close();
			System.out.println(theString);
			String msgCrypter = Base64.getEncoder().encodeToString(cipher.doFinal(theString.getBytes("UTF-8")));
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(msgCrypter.getBytes());
			fileOutputStream.close();
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
	}

	/**
	 * decrypt Cipher
	 */
	public void decrypt(String filename) {
		try {

			File file = new File(filename);
			FileInputStream in = new FileInputStream(file);
			/*
			 * recupirer les donneé dans un string
			 */
			String theString = IOUtils.toString(in, "UTF-8");
			in.close();
			System.out.println(theString);
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			String msg = new String(cipher.doFinal(Base64.getDecoder().decode(theString)));
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(msg.getBytes());
			fileOutputStream.close();
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
	}

}