package iit.project.syscomunicants.ds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;

/**
 * 
 * @author Hassen Ben Slima {@link BuffredFile qui est responsable sur
 *         l'encryptage et le decryptage de fichier en utilisant Buffred }
 *
 */
public class BuffredFile {
	/**
	 * encrypt buffred
	 */
	public void encrypteBuffred(String filename) {
		try {

			String theString;
			File file = new File(filename);
			FileInputStream in = new FileInputStream(file);
			theString = IOUtils.toString(in, "UTF-8");
			in.close();
			FileOutputStream out = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			bos.write(theString.getBytes());
			bos.close();
			out.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * decrypt buffred
	 */
	public void decrypteBuffred(String filename) {
		try {

			File file = new File(filename);
			FileInputStream in = new FileInputStream(file);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
			String theString = IOUtils.toString(bufferedInputStream, "UTF-8");
			bufferedInputStream.close();
			in.close();
			FileOutputStream out = new FileOutputStream(file);
			out.write(theString.getBytes());
			out.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
