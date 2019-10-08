package chapitre1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Test1 {

	public static String file1Path = "/home/akram/Desktop/test.txt";

	public static void main(String[] args) throws Exception {
		//
		testFileReader();

	}

	public static void listFiles() throws IOException {
		Path path = Paths.get(file1Path);

		Files.list(Paths.get("/")).forEach(System.out::println);
	}

	public static void pontOutputStreamToWriter() throws IOException {

		OutputStream os = new FileOutputStream(file1Path);
		Writer osr = new OutputStreamWriter(os);

		osr.write("hello");

		osr.close();
	}

	public static void pontInputStreamToReader() throws IOException {

		FileInputStream is = new FileInputStream(file1Path);
		Reader isr = new InputStreamReader(is);

		int b;
		byte[] bytes = { 0, 1 };
		while ((b = is.read(bytes)) != -1) {

			System.out.print((char) b);
		}
		isr.close();
		is.close();

	}

	public static void testProcess() throws IOException {
		// ls | grep src
		Runtime rt = Runtime.getRuntime();
		Process lsProc = rt.exec("ls");
		// Lire le flux de sortie
		InputStream inLsProc = lsProc.getInputStream();
		Process grepProc = rt.exec("grep src");
		// Ecriture dans le flux d’entrée
		OutputStream outGrepProc = grepProc.getOutputStream();
		int b;
		while ((b = inLsProc.read()) != -1) {
			System.out.write(b);
			outGrepProc.write(b);
		}
		inLsProc.close();
		outGrepProc.close();
		InputStream inGrepProc = grepProc.getInputStream();
		while ((b = inGrepProc.read()) != -1)
			System.out.write(b);
		inGrepProc.close();
	}

	public static void testPipe() throws IOException {
		final PipedOutputStream output = new PipedOutputStream();
		final PipedInputStream input = new PipedInputStream(output);

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					output.write("Hello world, pipe!".getBytes());
				} catch (IOException e) {
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int data = input.read();
					while (data != -1) {
						System.out.print((char) data);
						data = input.read();
					}
				} catch (IOException e) {
				}
			}
		});
		thread1.start();
		thread2.start();
	}

	public static void testOutputInputStream() throws IOException {
		OutputStream outputStream = new FileOutputStream(file1Path);

		byte[] bytes = { 127, 0, 1, 0, 1, 0 };

		outputStream.write(bytes);
		outputStream.write('\n');
		outputStream.write('b');

		// writer.flush();

		outputStream.close();

		// InputStream inputStream = new BufferedInputStream(new
		// FileInputStream(file1Path));

		InputStream inputStream = new FileInputStream(file1Path);
		System.out.println(inputStream.available());
		System.out.println(inputStream.read());

		inputStream.close();
	}

	public static void testReaderWriter() throws IOException {
		Writer writer = new FileWriter(file1Path);

		char[] chars = { 'a', 'c' };

		writer.write(chars);
		writer.write('\n');
		writer.write('b');

		// writer.flush();

		writer.close();

		Reader reader = new FileReader(file1Path);
		System.out.println(reader.ready());
		System.out.println(reader.read());

		reader.close();
	}

	public static void test1() throws IOException {
		int inChar;
		System.out.println("Enter a Character:");
		try {
			inChar = System.in.read();
			System.out.print("You entered ");
			// code ascii
			System.out.println(inChar);
		} catch (Exception e) {
			System.err.println("Error reading from user");
		}
	}

	public static void test2() throws IOException {
		File f = new File("test.txt");
		System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
		System.out.println("Nom du fichier : " + f.getName());
		System.out.println("Est-ce qu'il existe ? " + f.exists());
		System.out.println("Est-ce un répertoire ? " + f.isDirectory());
		System.out.println("Est-ce un fichier ? " + f.isFile());

		System.out.println("Affichage des lecteurs à la racine du PC : ");
		for (File file : File.listRoots()) {
			System.out.println(file.getAbsolutePath());
			try {
				int i = 1;
				// On parcourt la liste des fichiers et répertoires
				for (File nom : file.listFiles()) {
					// S'il s'agit d'un dossier, on ajoute un "/"
					System.out.print("\t\t" + ((nom.isDirectory()) ? nom.getName() + "/" : nom.getName()));

					if ((i % 4) == 0) {
						System.out.print("\n");
					}
					i++;
				}
				System.out.println("\n");
			} catch (NullPointerException e) {
				// L'instruction peut générer une NullPointerException
				// s'il n'y a pas de sous-fichier !
			}
		}
	}

	public static void testFileReader() throws IOException, InterruptedException {
		// Récupération du flux
		Reader reader = new FileReader(file1Path);
		// Utilisation du flux

		int data;
		while ((data = reader.read()) != -1) {
			// do something with data...

			char dataChar = (char) data;
			System.out.print(dataChar);
		}

	}

	public static void testFileReader2() throws IOException, InterruptedException {
		// Récupération du flux
		Reader reader = new FileReader(file1Path);
		// Utilisation du flux

		char[] chars = new char[99];

		int data;
		while ((data = reader.read(chars)) != -1) {
			// do something with data...

			char dataChar = (char) data;
			System.out.print(data);

		}
		System.out.println(chars);
	}

	public static void test4() {
		InputStream input = null;

		try {
			input = new FileInputStream(file1Path);
			int data = input.read();
			while (data != -1) {
				// do something with data...

				data = input.read();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (input != null)
			System.out.println("ok");

	}
}
