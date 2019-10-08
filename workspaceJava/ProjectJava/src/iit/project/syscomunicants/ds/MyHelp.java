package iit.project.syscomunicants.ds;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 * c'est un class help viewer
 **/
public class MyHelp {

	public MyHelp() {

		/**
		 * cree jeditorpane
		 */
		JEditorPane jEditorPane = new JEditorPane();

		/**
		 * read-only
		 */
		jEditorPane.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(jEditorPane);

		/**
		 * ajouter html editor kit
		 */
		HTMLEditorKit kit = new HTMLEditorKit();
		jEditorPane.setEditorKit(kit);

		/**
		 * ajouter quelque styles au html
		 */
		StyleSheet styleSheet = kit.getStyleSheet();
		styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
		styleSheet.addRule("h1 {color: blue;}");
		styleSheet.addRule("h2 {color: #ff0000;}");
		styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");

		/**
		 * cree simple html comme un string
		 **/
		String htmlString = "<html><body><h1>Help :</h1> <h2>Realized by: Hassen Ben Slima</h2></br>"
				+ "<p>this application allow us to encrypt or decrypt file by three types of filter</p>"
				+ "<p>Buffred</p></br><p>Cipher</p></br>"
				+ "<p>GZIP</p></br>"
				+ "<p> when you want to encrypt file you must choose one ,"
				+ "then the content of the file will appear in the the textArea.<br>"
				+ "when you want to decrypt file you must choose the old file that you already encrypt it,"
				+ "then the original content will appear in the text area after"
				+ " you clic on decrypt button. <br> <br>"
				+ "the clear button will be used to clean the textarea , the path and the error msg."
				+ "</p>";
		/**
		 * cree un document
		 */
		Document doc = kit.createDefaultDocument();
		jEditorPane.setDocument(doc);
		jEditorPane.setText(htmlString);

		/**********************************/
		JFrame j = new JFrame("Help");
		j.getContentPane().add(scrollPane, BorderLayout.CENTER);
		j.setSize(new Dimension(500, 600));
		j.setLocationRelativeTo(null);
		j.setVisible(true);
		/**********************************/

	}

}
