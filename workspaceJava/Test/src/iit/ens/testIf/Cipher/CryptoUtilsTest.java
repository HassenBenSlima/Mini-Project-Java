package iit.ens.testIf.Cipher;

import java.io.File;

/**
 * A tester for the CryptoUtils class.
 * 
 * @author www.codejava.net
 *
 */
public class CryptoUtilsTest {
	public static void main(String[] args) {
		String key = "hassen";
		File inputFile = new File("document.txt");
		File encryptedFile = new File("document.encrypted");
		File decryptedFile = new File("document.decrypted");

		try {
			CryptoUtils.encrypt(key, inputFile, encryptedFile);
			CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
		} catch (CryptoException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}