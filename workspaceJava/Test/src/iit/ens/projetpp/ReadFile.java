//package iit.ens.projetpp;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.awt.event.ActionEvent;
//import javax.swing.JCheckBox;
//import javax.swing.JFileChooser;
//import javax.swing.JTextField;
//
//public class ReadFile extends JFrame {
//	/**
//	 * 
//	 */
//	String er = "";
//	private static final long serialVersionUID = 1L;
//	private String FILEPATH;
//	private JPanel contentPane;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_3;
//	private JTextField textField_4;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReadFile frame = new ReadFile();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public ReadFile() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 300, 500);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JLabel lblNewLabel = new JLabel("Read the file");
//		lblNewLabel.setBounds(100, 11, 61, 14);
//		contentPane.add(lblNewLabel);
//
//		JButton btnChouseFile = new JButton("choose file ");
//		btnChouseFile.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				final JFrame frame = new JFrame("Open File Example");
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frame.getContentPane().setLayout(new BorderLayout());
//				JFileChooser chooser = new JFileChooser();
//				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//				if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
//					FILEPATH = chooser.getSelectedFile().toString();
//					// System.out.println(chooser.getSelectedFile().toString());
//
//				}
//			}
//		});
//		btnChouseFile.setBounds(60, 36, 140, 30);
//		contentPane.add(btnChouseFile);
//
//		JCheckBox chckbxNewCheckBox = new JCheckBox("Buffered");
//		chckbxNewCheckBox.setBounds(38, 101, 97, 23);
//		contentPane.add(chckbxNewCheckBox);
//
//		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Cipher");
//		chckbxNewCheckBox_1.setBounds(38, 142, 97, 23);
//		contentPane.add(chckbxNewCheckBox_1);
//
//		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Gzip");
//		chckbxNewCheckBox_2.setBounds(38, 185, 97, 23);
//		contentPane.add(chckbxNewCheckBox_2);
//
//		textField = new JTextField();
//		textField.setText("1");
//		textField.setBounds(206, 102, 20, 20);
//		contentPane.add(textField);
//		textField.setColumns(10);
//
//		textField_1 = new JTextField();
//		textField_1.setText("2");
//		textField_1.setColumns(10);
//		textField_1.setBounds(206, 143, 20, 20);
//		contentPane.add(textField_1);
//
//		textField_2 = new JTextField();
//		textField_2.setText("3");
//		textField_2.setColumns(10);
//		textField_2.setBounds(206, 186, 20, 20);
//		contentPane.add(textField_2);
//
//		JLabel lblFilters = new JLabel("filters");
//		lblFilters.setBounds(50, 80, 46, 14);
//		contentPane.add(lblFilters);
//
//		JLabel lblOrder = new JLabel("order :");
//		lblOrder.setBounds(191, 77, 46, 14);
//		contentPane.add(lblOrder);
//
//		textField_3 = new JTextField();
//		textField_3.setBounds(10, 232, 264, 94);
//		contentPane.add(textField_3);
//		textField_3.setColumns(10);
//
//		JButton btnNewButton = new JButton("upload");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				String s2 = FILEPATH;
//				if (FILEPATH.toLowerCase().contains(".gz")) {
//					s2 = FILEPATH.replace(".gz", "");
//				}
//
//				String s = FILEPATH;
//
//				Boolean b1, b2, b3, nb1, nb2, nb3;
//				b1 = (textField.getText().length() == 1 && chckbxNewCheckBox.isSelected()
//						&& textField.getText().matches("[0-9]+"));
//				b2 = textField_1.getText().length() == 1 && chckbxNewCheckBox_1.isSelected()
//						&& textField_1.getText().matches("[0-9]+");
//				b3 = textField_2.getText().length() == 1 && chckbxNewCheckBox_2.isSelected()
//						&& textField_2.getText().matches("[0-9]+");
//				nb1 = !chckbxNewCheckBox.isSelected();
//				nb2 = !chckbxNewCheckBox_1.isSelected();
//				nb3 = !chckbxNewCheckBox_2.isSelected();
//
//				if (b1 || nb1) {
//					if (b2 || nb2) {
//						if (b3 || nb3) {
//
//							if (b1 & !b2 & !b3) {
//								er = new Buff(s).bufferedreader();
//							} else if (!b1 & b2 & !b3) {
//								er = new CipherSample(s).decrypt();
//							} else if (!b1 & !b2 & b3) {
//								er = new GZIPExample(s).decompressGzipFile();
//							} else if (b1 & b2 & !b3) {
//
//								if (Integer.valueOf(textField.getText()) < Integer.valueOf(textField_1.getText())) {
//									er = new Buff(s).bufferedreader();
//									er = new CipherSample(s).decrypt();
//								} else if (Integer.valueOf(textField.getText()) > Integer
//										.valueOf(textField_1.getText())) {
//									er = new CipherSample(s).decrypt();
//									er = new Buff(s).bufferedreader();
//								} else {
//									textField_4.setText(" error same order");
//								}
//
//							} else if (b1 & !b2 & b3) {
//
//								if (Integer.valueOf(textField.getText()) < Integer.valueOf(textField_2.getText())) {
//									er = new Buff(s).bufferedreader();
//									er = new GZIPExample(s).decompressGzipFile();
//								} else if (Integer.valueOf(textField.getText()) > Integer
//										.valueOf(textField_2.getText())) {
//									er = new GZIPExample(s).decompressGzipFile();
//									er = new Buff(s2).bufferedreader();
//								} else {
//									textField_4.setText(" error same order");
//								}
//
//							} else if (!b1 & b2 & b3) {
//
//								if (Integer.valueOf(textField_1.getText()) < Integer.valueOf(textField_2.getText())) {
//									er = new CipherSample(s).decrypt();
//									er = new GZIPExample(s).compressGzipFile();
//								} else if (Integer.valueOf(textField_1.getText()) > Integer
//										.valueOf(textField_2.getText())) {
//									er = new GZIPExample(s).decompressGzipFile();
//									er = new CipherSample(s2).decrypt();
//								} else {
//									textField_4.setText(" error same order");
//								}
//
//							} else if (b1 & b2 & b3) {
//
//								if (Integer.valueOf(textField.getText()) < Integer.valueOf(textField_1.getText())
//										&& Integer.valueOf(textField_1.getText()) < Integer
//												.valueOf(textField_2.getText())) {
//									er = new Buff(s).bufferedwriter();
//									er = new CipherSample(s).decrypt();
//									er = new GZIPExample(s).decompressGzipFile();
//									// new File(s).delete();
//								} else if (Integer.valueOf(textField.getText()) > Integer.valueOf(textField_1.getText())
//										&& Integer.valueOf(textField_1.getText()) > Integer
//												.valueOf(textField_2.getText())) {
//									er = new GZIPExample(s).decompressGzipFile();
//									er = new CipherSample(s2).decrypt();
//									er = new Buff(s2).bufferedreader();
//
//								} else if (Integer.valueOf(textField_1.getText()) < Integer.valueOf(textField.getText())
//										&& Integer.valueOf(textField.getText()) < Integer
//												.valueOf(textField_2.getText())) {
//									er = new CipherSample(s).decrypt();
//									er = new Buff(s).bufferedreader();
//									er = new GZIPExample(s).decompressGzipFile();
//								} else if (Integer.valueOf(textField_1.getText()) > Integer.valueOf(textField.getText())
//										&& Integer.valueOf(textField.getText()) > Integer
//												.valueOf(textField_2.getText())) {
//									er = new GZIPExample(s).decompressGzipFile();
//									er = new Buff(s2).bufferedreader();
//									er = new CipherSample(s2).decrypt();
//
//								} else if (Integer.valueOf(textField.getText()) < Integer.valueOf(textField_2.getText())
//										&& Integer.valueOf(textField_2.getText()) < Integer
//												.valueOf(textField_1.getText())) {
//									er = new Buff(s).bufferedreader();
//									er = new GZIPExample(s).decompressGzipFile();
//									er = new CipherSample(s2).decrypt();
//
//								} else if (Integer.valueOf(textField.getText()) > Integer.valueOf(textField_2.getText())
//										&& Integer.valueOf(textField_2.getText()) > Integer
//												.valueOf(textField_1.getText())) {
//									er = new CipherSample(s).decrypt();
//									er = new GZIPExample(s).decompressGzipFile();
//									er = new Buff(s2).bufferedreader();
//								} else {
//									textField_4.setText(" error same order");
//								}
//
//							}
//
//							textField_4.setText(er);
//
//							StringBuffer buf = new StringBuffer();
//							Reader r;
//							try {
//								r = new FileReader(s2);
//
//								int octet = 0;
//								while (octet != -1) {
//									octet = r.read();
//									if (octet == -1)
//										break;
//									buf.append((char) octet);
//									System.out.print((char) (octet));
//								}
//
//								r.close();
//
//								textField_3.setText(buf.toString());
//							} catch (FileNotFoundException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							} catch (IOException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//						} else {
//							textField_4.setText(" error order on Gzip");
//						}
//					} else {
//						textField_4.setText(" error order on Cypher");
//					}
//
//				} else {
//					textField_4.setText(" error order on buffered");
//				}
//
//
//			}
//		});
//		btnNewButton.setBounds(100, 337, 89, 23);
//		contentPane.add(btnNewButton);
//
//		textField_4 = new JTextField();
//		textField_4.setBounds(10, 396, 264, 54);
//		contentPane.add(textField_4);
//		textField_4.setColumns(10);
//
//		JButton button = new JButton("<");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				FirstPan f1 = new FirstPan();
//
//			}
//		});
//		button.setBounds(0, 0, 46, 23);
//		contentPane.add(button);
//	}
//}
