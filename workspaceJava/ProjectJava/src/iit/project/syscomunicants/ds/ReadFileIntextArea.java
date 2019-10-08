package iit.project.syscomunicants.ds;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JTextArea;

/**
 * @author Hassen Ben Slima {@link ReadFileIntextArea qui est responsable de la
 *         lecture de fichier dans un tex area }
 *
 */
public class ReadFileIntextArea {

	public ReadFileIntextArea() {

	}

	/**
	 * Cette methode permet d'ouvrir un fichier dans un textArea
	 */
	public void openFileInTextArea(String filename, JTextArea textArea) {
		try {

			textArea.setText("");
			File file = new File(filename);
			FileInputStream in = new FileInputStream(file);
			int x;
			String text;
			while ((x = in.read()) != -1) {
				text = (char) x + "";
				textArea.append(text);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			textArea.requestFocus();
		}
	}

}
