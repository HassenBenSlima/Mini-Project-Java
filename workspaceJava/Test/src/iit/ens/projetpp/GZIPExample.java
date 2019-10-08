package iit.ens.projetpp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPExample {

	private String FILENAME;
	private static String path = "/home/hassen/Desktop/file.txt.gz";

	public static String decompressGzipFile() {
		try {
			FileInputStream fis = new FileInputStream(path);

			FileOutputStream fos = new FileOutputStream(path.replace(".gz", ""));

			GZIPInputStream gzipOS = new GZIPInputStream(fis);

			byte[] buffer = new byte[1024 * 1024];
			int len;
			while ((len = gzipOS.read(buffer)) != -1) {
				fos.write(buffer, 0, len);

			}
			System.out.println(new String(buffer));

			// close resources
			gzipOS.close();
			fos.close();
			fis.close();
			System.out.println("decomp done");
			return "";
		} catch (IOException e) {
			return e.toString();
		}

	}

	public static String compressGzipFile() {
		try {
			FileInputStream fis = new FileInputStream(path);

			FileOutputStream fos = new FileOutputStream(path + ".gz");

			GZIPOutputStream gzipOS = new GZIPOutputStream(fos);

			byte[] buffer = new byte[1024 * 1024];
			int len;
			while ((len = fis.read(buffer)) != -1) {

				gzipOS.write(buffer, 0, len);
				System.out.println(buffer);
			}

			// close resources
			gzipOS.close();
			fos.close();
			fis.close();

			System.out.println(" compression done ");
			return "";
		} catch (IOException e) {
			return e.toString();
		}

	}

	public static void main(String[] args) {

		// compressGzipFile();

		decompressGzipFile();
	}

}