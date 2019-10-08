package iit.project.syscomunicants.ds;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 
 * @author Hassen Ben Slima {@link GZIP qui est responsable sur l'encryptage et
 *         le decryptage de fichier en utilisant GZIP }
 *
 */
public class GZIP {
	/**
	 * compressé un GZIP file
	 */
	public void compressGzipFile(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			filename = filename + ".gz";
			FileOutputStream fos = new FileOutputStream(filename);
			GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
			byte[] buffer = new byte[1024 * 1024];
			int len;
			while ((len = fis.read(buffer)) != -1) {

				gzipOS.write(buffer, 0, len);
			}

			gzipOS.close();
			fos.close();
			fis.close();

		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

	/**
	 * decompressé un GZIP file
	 */
	public void decompressGzipFile(String filename) {
		try {
			FileInputStream fis = new FileInputStream(filename);
			filename = filename.replace(".gz", "");
			FileOutputStream fos = new FileOutputStream(filename);

			GZIPInputStream gzipOS = new GZIPInputStream(fis);

			byte[] buffer = new byte[1024 * 1024];
			int len;
			while ((len = gzipOS.read(buffer)) != -1) {
				fos.write(buffer, 0, len);

			}

			gzipOS.close();
			fos.close();
			fis.close();

		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

}