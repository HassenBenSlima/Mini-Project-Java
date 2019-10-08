package iit.project.syscomunicants.ds;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/***
 * 
 * @author Hassen Ben Slima c'est interface graphique de la programme
 * 
 *
 */

public class FirstView {

	private JFrame frmJavaFile;
	/* partie a gauche */
	private File file;
	private String filename;
	private JTextArea txtrOriginalText;
	private JTextField orderBuffered;
	private JTextField orderCipher;
	private JTextField orderGZIP;
	private JTextArea textArea_2;
	ArrayList<String> list = new ArrayList<String>();
	private JTextField textField_1;
	/* partie a doite */
	private JTextArea txtrDecrptedtext;
	private File file_2;
	private String filename_2;
	private JTextField orderBuffered_2;
	private JTextField orderCipher_2;
	private JTextField orderGZIP_2;
	private JTextArea textArea_4;
	ArrayList<String> list_2 = new ArrayList<String>();
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstView window = new FirstView();
					window.frmJavaFile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstView() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJavaFile = new JFrame();
		frmJavaFile.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmJavaFile.setResizable(false);
		frmJavaFile.setTitle("JAVA FILE FROM HASSEN BEN SLIMA :)");
		frmJavaFile.setBounds(100, 100, 693, 635);
		frmJavaFile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("Encrypt file");
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 12));
		lblNewLabel.setBounds(36, 12, 87, 28);
		/***************************/
		/******* PARTI GAUCHE ********/
		/***************************/

		/**
		 * 
		 * icon du boutton choose file
		 */
		JButton btnChoosefile = new JButton("Choose file");
		File folder_win = new File("pictures/Folder-Windows.png");
		btnChoosefile.setIcon(new ImageIcon(folder_win.toString()));

		/**
		 * 
		 * methode de  choisir un fichier
		 */
		btnChoosefile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser;
				try {
					/*
					 * choisir un fichier
					 */
					chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					file = chooser.getSelectedFile();
					/*
					 * filename: c'est le nom du fichier
					 */
					filename = file.getAbsolutePath();
					ReadFileIntextArea readFileIntextArea = new ReadFileIntextArea();
					/*
					 * methode qui permet d'ouvrir un fichier dans un textarea
					 */
					readFileIntextArea.openFileInTextArea(filename, txtrOriginalText);
					/*
					 * afficher le Path dans la zone "path"
					 */
					textField_1.setText(filename);
					/*
					 * vider la message d'erreur du text area
					 */
					textArea_2.setText("");
				} catch (Exception ex) {

					System.out.println(ex.getMessage());
				}

			}
		});
		btnChoosefile.setBounds(36, 38, 295, 25);

		JLabel lblFiltres = new JLabel("Filtres:");
		lblFiltres.setBounds(36, 95, 66, 29);

		JLabel lblOrder = new JLabel("Order:");
		lblOrder.setBounds(188, 95, 45, 29);

		/**
		 * ******boutton checkbox buffred*******
		 * 
		 * 
		 * l'ordre de compression va prendre l'ordre de la clic sur le checkbox .
		 * j'ai utilité un list ordre et je prend a chaque fois son indice 
		 *  j' ajoute a la list le caractere "a" lorsque je clique sur checkbox buffrred,
		 *   j' ajoute a la list le caractere "b" lorsque je clique sur checkbox Cipher, 
		 *   j' ajoute a la list le caractere "c" lorsque je clique sur checkbox GZIP.
		 * 
		 * je supprime le "a" lorsque je désélectionner le checkbox buffrred et je fais le decalage,
		 *  je supprime le "b" lorsque je désélectionner le checkbox Cipher, et je fais le decalage, 
		 *  je supprime le "c" lorsque je désélectionner le checkbox GZIP et je fais le decalage.
		 * 
		 * 
		 * le meme traitment pour les autres bouttons checkbox
		 ****************************************************/
		JCheckBox chckbxBuffered = new JCheckBox("Buffered");
		chckbxBuffered.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					/*
					 * if checkbix is checked
					 */
					if (e.getStateChange() == 1) {

						list.add("a");

						orderBuffered.setText(list.indexOf("a") + 1 + "");

					} else {
						System.out.println("chckbxBuffered is unchecked");
						orderBuffered.setText("");
						list.remove(list.indexOf("a"));
						if (list.indexOf("b") + 1 != 0)
							orderCipher.setText(list.indexOf("b") + 1 + "");
						if (list.indexOf("c") + 1 != 0)
							orderGZIP.setText(list.indexOf("c") + 1 + "");

					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		chckbxBuffered.setBounds(36, 126, 126, 23);
		/**
		 * 
		 * boutton checkbox buffred
		 * 
		 **************************/
		JCheckBox chckbxCipher = new JCheckBox("Cipher");
		chckbxCipher.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == 1) {
						list.add("b");
						orderCipher.setText(list.indexOf("b") + 1 + "");

					} else {
						orderCipher.setText("");
						list.remove(list.indexOf("b"));
						if (list.indexOf("a") + 1 != 0)
							orderBuffered.setText(list.indexOf("a") + 1 + "");
						if (list.indexOf("c") + 1 != 0)
							orderGZIP.setText(list.indexOf("c") + 1 + "");
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}

		});
		chckbxCipher.setBounds(36, 160, 126, 23);
		/**
		 * 
		 * boutton checkbox GZIP
		 * 
		 ***********************/
		JCheckBox chckbxGzip = new JCheckBox("GZIP");
		chckbxGzip.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == 1) {
						System.out.println("chckbxGzip is checked");
						list.add("c");

						orderGZIP.setText(list.indexOf("c") + 1 + "");

					} else {
						System.out.println("chckbxGzip is unchecked");
						orderGZIP.setText("");
						list.remove(list.indexOf("c"));
						if (list.indexOf("a") + 1 != 0)
							orderBuffered.setText(list.indexOf("a") + 1 + "");
						if (list.indexOf("b") + 1 != 0)
							orderCipher.setText(list.indexOf("b") + 1 + "");
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		});
		chckbxGzip.setBounds(36, 193, 126, 23);
		/***********************************************/
		orderBuffered = new JTextField();
		orderBuffered.setBackground(SystemColor.control);
		orderBuffered.setDisabledTextColor(Color.BLUE);
		orderBuffered.setEnabled(false);
		orderBuffered.setBounds(190, 130, 43, 19);
		orderBuffered.setColumns(10);

		orderCipher = new JTextField();
		orderCipher.setDisabledTextColor(Color.BLUE);
		orderCipher.setBackground(SystemColor.control);
		orderCipher.setEnabled(false);
		orderCipher.setBounds(190, 162, 43, 19);
		orderCipher.setColumns(10);

		orderGZIP = new JTextField();
		orderGZIP.setDisabledTextColor(Color.BLUE);
		orderGZIP.setBackground(SystemColor.control);
		orderGZIP.setEnabled(false);
		orderGZIP.setBounds(190, 193, 43, 19);
		orderGZIP.setColumns(10);
		/***********************************************/

		/**
		 * 
		 * encrypt
		 * 
		 ********************/
		JButton btnEncrypt = new JButton("Encrypt");
		File img_encrypt = new File("pictures/encrypt.png");
		btnEncrypt.setIcon(new ImageIcon(img_encrypt.toString()));

		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*
					 * si il n'y a pas de fichier chargé le programme affiche un message d'erreur
					 */

					if (!filename.isEmpty()) {
						/*
						 * si la list est vide,le programme indique a l'utisateur d'ajouter un ordre
						 */
						if (list.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Select an order", "Where is the order !", 1);
							return;
						}

						CipherAES cipherAES = new CipherAES();
						GZIP gzipClass = new GZIP();
						BuffredFile buffredFile = new BuffredFile();

						/***
						 * si l'ordre d'encrypt contient GZIP PUIS CIPHER, affichage du message d'erreur
						 ***/
						if (((list.indexOf("c") == 0) && (list.indexOf("b")) == 1)
								|| ((list.indexOf("c") == 1) && (list.indexOf("b") == 2))) {
							textArea_2.setText("Error in the ordre GZIP ... CIPHER \n");
							return;
						}
						/***
						 * si l'ordre d'encrypt contient GZIP PUIS BUFFRED, affichage du message d'erreur
						 ***/
						if (((list.indexOf("c") == 0) && (list.indexOf("a")) == 1)
								|| ((list.indexOf("c") == 1) && (list.indexOf("a") == 2))) {
							textArea_2.setText("Error in the ordre GZIP ... BUFFRED \n");
							return;
						}

						/**
						 * encrypt
						 */
						long starttime = System.currentTimeMillis();

						list.forEach(v -> {

							if (v.equals("a")) {
								buffredFile.encrypteBuffred(filename);
							} else if (v.equals("b")) {
								cipherAES.encrypt(filename);

							} else if (v.equals("c")) {
								gzipClass.compressGzipFile(filename);
								/*
								 * suprimer le fichier originale
								 * 
								 */
								Path path = Paths.get(filename);
								try {
									Files.delete(path);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								filename += ".gz";
							}

						});
						long starttime2 = System.currentTimeMillis();

						filename = "";
						/**
						 * timeMillis pour calculer le temp pris dans chaque operation de cryptage
						 */
						long timeMillis = starttime2 - starttime;

						JOptionPane.showMessageDialog(null,
								"Operation was succeed, Time taken is : " + timeMillis + " ms");
						textArea_2.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Excuse me, you must choose a file", "To encrypt", 2);
						return;

					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(null, "Excuse me, you must choose a file", "To encrypt", 3);

				}

			}
		});
		/******************************************************/
		btnEncrypt.setBounds(36, 447, 97, 25);

		JLabel lblMessagesDerreur = new JLabel("Messages :");
		lblMessagesDerreur.setBounds(36, 478, 134, 15);

		JLabel lblEcrireDansUn = new JLabel("Decrypt file");
		lblEcrireDansUn.setFont(new Font("Arial Unicode MS", Font.BOLD, 12));
		lblEcrireDansUn.setBounds(367, 12, 82, 28);
		/******************************************************/

		/***************************/
		/******* PARTI A DROITE ********/
		/***************************/

		JButton btnChoosefile_2 = new JButton("Choose file");
		File folder_win_2 = new File("pictures/Folder-Windows.png");

		btnChoosefile_2.setIcon(new ImageIcon(folder_win_2.toString()));
		btnChoosefile_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser;
				try {
					chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					file_2 = chooser.getSelectedFile();
					filename_2 = file_2.getAbsolutePath();
					System.out.println(filename_2);
					textField_2.setText(filename_2);
				} catch (Exception ex) {

					System.out.println(ex.getMessage());
				}

			}
		});
		/***************************************************/
		btnChoosefile_2.setBounds(367, 38, 288, 25);

		JLabel label_1 = new JLabel("Order:");
		label_1.setBounds(515, 95, 44, 29);

		JLabel label_2 = new JLabel("Filtres:");
		label_2.setBounds(367, 95, 46, 29);

		/***************************************************/
		/**
		 * 
		 * boutton checkbox Buffered
		 * 
		 ***********************/
		JCheckBox chckbxBuffered_2 = new JCheckBox("Buffered");
		chckbxBuffered_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				try {
					if (e.getStateChange() == 1) {

						list_2.add("a");
						orderBuffered_2.setText(list_2.indexOf("a") + 1 + "");
					} else {
						orderBuffered_2.setText("");
						list_2.remove(list_2.indexOf("a"));
						if (list_2.indexOf("b") + 1 != 0)
							orderCipher_2.setText(list_2.indexOf("b") + 1 + "");
						if (list_2.indexOf("c") + 1 != 0)
							orderGZIP_2.setText(list_2.indexOf("c") + 1 + "");

					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});

		chckbxBuffered_2.setBounds(367, 132, 82, 23);
		/**
		 * 
		 * boutton checkbox Cipher
		 * 
		 ***********************/
		JCheckBox chckbxCipher_2 = new JCheckBox("Cipher");
		chckbxCipher_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				try {
					if (e.getStateChange() == 1) {
						list_2.add("b");

						orderCipher_2.setText(list_2.indexOf("b") + 1 + "");

					} else {
						orderCipher_2.setText("");
						list_2.remove(list_2.indexOf("b"));
						if (list_2.indexOf("a") + 1 != 0)
							orderBuffered_2.setText(list_2.indexOf("a") + 1 + "");
						if (list_2.indexOf("c") + 1 != 0)
							orderGZIP_2.setText(list_2.indexOf("c") + 1 + "");
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		});
		chckbxCipher_2.setBounds(367, 166, 69, 23);
		/**
		 * 
		 * boutton checkbox GZIP
		 * 
		 ***********************/
		JCheckBox chckbxGzip_2 = new JCheckBox("GZIP");
		chckbxGzip_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				try {
					if (e.getStateChange() == 1) {
						list_2.add("c");
						orderGZIP_2.setText(list_2.indexOf("c") + 1 + "");
					} else {
						orderGZIP_2.setText("");
						list_2.remove(list_2.indexOf("c"));
						if (list_2.indexOf("a") + 1 != 0)
							orderBuffered_2.setText(list_2.indexOf("a") + 1 + "");
						if (list_2.indexOf("b") + 1 != 0)
							orderCipher_2.setText(list_2.indexOf("b") + 1 + "");
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		});
		/***************************************************/
		chckbxGzip_2.setBounds(367, 193, 55, 23);

		orderGZIP_2 = new JTextField();
		orderGZIP_2.setBackground(SystemColor.control);
		orderGZIP_2.setDisabledTextColor(new Color(220, 20, 60));
		orderGZIP_2.setEnabled(false);
		orderGZIP_2.setBounds(516, 194, 43, 19);
		orderGZIP_2.setColumns(10);

		orderCipher_2 = new JTextField();
		orderCipher_2.setBackground(SystemColor.control);
		orderCipher_2.setDisabledTextColor(new Color(220, 20, 60));
		orderCipher_2.setEnabled(false);
		orderCipher_2.setBounds(515, 167, 43, 19);
		orderCipher_2.setColumns(10);

		orderBuffered_2 = new JTextField();
		orderBuffered_2.setBackground(SystemColor.control);
		orderBuffered_2.setDisabledTextColor(new Color(220, 20, 60));
		orderBuffered_2.setEnabled(false);
		orderBuffered_2.setBounds(515, 136, 43, 19);
		orderBuffered_2.setColumns(10);
		frmJavaFile.getContentPane().setLayout(null);
		frmJavaFile.getContentPane().add(lblEcrireDansUn);
		frmJavaFile.getContentPane().add(btnChoosefile_2);
		frmJavaFile.getContentPane().add(label_1);
		frmJavaFile.getContentPane().add(label_2);
		frmJavaFile.getContentPane().add(chckbxBuffered_2);
		frmJavaFile.getContentPane().add(chckbxCipher_2);
		frmJavaFile.getContentPane().add(chckbxGzip_2);
		frmJavaFile.getContentPane().add(orderGZIP_2);
		frmJavaFile.getContentPane().add(orderCipher_2);
		frmJavaFile.getContentPane().add(orderBuffered_2);
		frmJavaFile.getContentPane().add(lblNewLabel);
		frmJavaFile.getContentPane().add(btnChoosefile);
		frmJavaFile.getContentPane().add(lblFiltres);
		frmJavaFile.getContentPane().add(lblOrder);
		frmJavaFile.getContentPane().add(chckbxBuffered);
		frmJavaFile.getContentPane().add(orderBuffered);
		frmJavaFile.getContentPane().add(chckbxCipher);
		frmJavaFile.getContentPane().add(orderCipher);
		frmJavaFile.getContentPane().add(chckbxGzip);
		frmJavaFile.getContentPane().add(orderGZIP);
		frmJavaFile.getContentPane().add(lblMessagesDerreur);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 234, 295, 201);
		frmJavaFile.getContentPane().add(scrollPane);

		txtrOriginalText = new JTextArea();
		txtrOriginalText.setEnabled(false);
		txtrOriginalText.setBackground(Color.WHITE);
		txtrOriginalText.setWrapStyleWord(true);
		txtrOriginalText.setText("Original Text\r\n ");
		txtrOriginalText.setDisabledTextColor(Color.BLUE);
		scrollPane.setViewportView(txtrOriginalText);
		frmJavaFile.getContentPane().add(btnEncrypt);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(367, 234, 288, 201);
		frmJavaFile.getContentPane().add(scrollPane_1);

		txtrDecrptedtext = new JTextArea();
		txtrDecrptedtext.setText("DecrptedText\r\n ");
		txtrDecrptedtext.setDisabledTextColor(Color.BLUE);
		txtrDecrptedtext.setForeground(Color.BLACK);
		txtrDecrptedtext.setEnabled(false);
		scrollPane_1.setViewportView(txtrDecrptedtext);

		JButton btnDecrypt = new JButton("Decrypt");
		File img_decrypt = new File("pictures/decrypt.png");
		btnDecrypt.setIcon(new ImageIcon(img_decrypt.toString()));

		/***************************************************/

		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!filename_2.isEmpty()) {

						if (list_2.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Select an order", "Where is the order !", 1);
							return;
						}

						ReadFileIntextArea readFileIntextArea = new ReadFileIntextArea();

						CipherAES cipherAES = new CipherAES();
						GZIP gzipClass = new GZIP();
						BuffredFile buffredFile = new BuffredFile();
						long starttime = System.currentTimeMillis();
						list_2.forEach(v -> {
							System.out.println("------------------------------");
							System.out.println("Item : " + list_2.indexOf(v) + " Count : " + v);
							if (v.equals("a")) {
								buffredFile.decrypteBuffred(filename_2);
							} else if (v.equals("b")) {
								cipherAES.decrypt(filename_2);
							} else if (v.equals("c")) {
								gzipClass.decompressGzipFile(filename_2);
								/**
								 * supprimer le fichier originale
								 */

								Path path = Paths.get(filename_2);
								try {
									Files.delete(path);
								} catch (IOException e1) {
									System.out.println(e1.getMessage());
								}

								/***
								 * extension d'un fichier
								 */
								filename_2 = filename_2.replace(".gz", "");

							}

						});
						readFileIntextArea.openFileInTextArea(filename_2, txtrDecrptedtext);
						filename_2 = "";

						long starttime2 = System.currentTimeMillis();

						/**
						 * timeMillis pour calculer le temp pris dans chaque operation de cryptage
						 */
						long timeMillis = starttime2 - starttime;

						/***************
						 ** afficher le contenue d'un fichier apres le decrypt
						 ***********/

						JOptionPane.showMessageDialog(null,
								"Operation was succeed, Temp Taken is " + timeMillis + " ms");

					} else {

						JOptionPane.showMessageDialog(null, "Excuse me, you must choose a file", "To decrypt", 2);
						return;
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(null, "Excuse me, you must choose a file", "To decrypt", 3);

				}

			}

		});
		/********************************************************/
		btnDecrypt.setBounds(367, 447, 114, 25);
		frmJavaFile.getContentPane().add(btnDecrypt);

		JLabel lblMessagesDerreur_1 = new JLabel("Messages:");
		lblMessagesDerreur_1.setBounds(367, 478, 74, 15);
		frmJavaFile.getContentPane().add(lblMessagesDerreur_1);

		JButton help = new JButton("");

		/***************
		 ** Bouton Help
		 ***********/
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * appel du class myhelp
				 */
				new MyHelp();

			}
		});
		/**********************************************************/
		/**
		 * create icon for help button
		 */
		File img_help = new File("pictures/help.png");
		help.setIcon(new ImageIcon(img_help.toString()));
		help.setBounds(657, 3, 18, 19);
		frmJavaFile.getContentPane().add(help);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(370, 500, 285, 97);
		frmJavaFile.getContentPane().add(scrollPane_3);

		textArea_4 = new JTextArea();
		textArea_4.setDisabledTextColor(Color.RED);
		textArea_4.setEnabled(false);
		scrollPane_3.setViewportView(textArea_4);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(346, 3, 9, 594);
		frmJavaFile.getContentPane().add(separator_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(new Color(248, 248, 255));
		scrollPane_2.setBounds(36, 501, 295, 94);
		frmJavaFile.getContentPane().add(scrollPane_2);

		textArea_2 = new JTextArea();
		textArea_2.setDisabledTextColor(Color.RED);
		textArea_2.setEnabled(false);
		scrollPane_2.setViewportView(textArea_2);

		JLabel lblPath = new JLabel("Path :");
		lblPath.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 12));
		lblPath.setBounds(36, 69, 46, 16);
		frmJavaFile.getContentPane().add(lblPath);

		JLabel label = new JLabel("Path :");
		label.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 12));
		label.setBounds(367, 69, 44, 16);
		frmJavaFile.getContentPane().add(label);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(SystemColor.control);
		textField_1.setDisabledTextColor(new Color(0, 128, 0));
		textField_1.setSelectedTextColor(Color.BLUE);
		textField_1.setBounds(82, 66, 249, 20);
		frmJavaFile.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setSelectedTextColor(Color.BLUE);
		textField_2.setDisabledTextColor(new Color(0, 128, 0));
		textField_2.setEditable(false);
		textField_2.setBackground(SystemColor.control);
		textField_2.setColumns(10);
		textField_2.setBounds(413, 66, 242, 20);
		frmJavaFile.getContentPane().add(textField_2);

		JLabel lblHelp = new JLabel("Help:");
		lblHelp.setBounds(620, 3, 32, 16);
		frmJavaFile.getContentPane().add(lblHelp);

		JButton btnClear = new JButton("Clear");
		File file_clear = new File("pictures/clear-icon.png");
		/**********************************************************/
		/***************
		 ** Bouton Clear a gauche
		 ***********/
		btnClear.setIcon(new ImageIcon(file_clear.toString()));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				filename = "";
				txtrOriginalText.setText("");
				textArea_2.setText("");
				textField_1.setText("");
			}
		});
		/***********************************************************/
		btnClear.setBounds(245, 208, 86, 26);
		frmJavaFile.getContentPane().add(btnClear);
		/***********************************************************/

		JButton btnClear_2 = new JButton("Clear");
		File file_clear_2 = new File("pictures/clear-icon.png");
		btnClear_2.setIcon(new ImageIcon(file_clear_2.toString()));
		/***************
		 ** Bouton Clear a droite
		 ***********/
		btnClear_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				filename_2 = "";
				txtrDecrptedtext.setText("");
				textField_2.setText("");
				textArea_4.setText("");

			}
		});
		/***********************************************************/
		btnClear_2.setBounds(571, 208, 84, 26);
		frmJavaFile.getContentPane().add(btnClear_2);
		/***********************************************************/

	}
}
