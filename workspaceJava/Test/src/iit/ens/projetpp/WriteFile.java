//package iit.ens.projetpp;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileWriter;
//import java.io.Writer;
//
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
////
//public class WriteFile extends JFrame {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private String FILEPATH;
//	private JPanel contentPane;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_3;
//	private JTextField textField_4;
//	private static ReadFile frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frame = new ReadFile();
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
//	public WriteFile() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 301, 500);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JLabel lblNewLabel = new JLabel("Write in file");
//		lblNewLabel.setBounds(112, 11, 72, 14);
//		contentPane.add(lblNewLabel);
//
//		JButton btnChouseFile = new JButton("choose file ");
//		btnChouseFile.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				final JFrame frame = new JFrame("Open File Example");
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frame.getContentPane().setLayout(new BorderLayout());
//				JFileChooser chooser = new JFileChooser();
//				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//				if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
//
//					FILEPATH = chooser.getSelectedFile().toString();
//					// System.out.println(chooser.getSelectedFile().toString());
//
//				}
//			}
//		});
//		btnChouseFile.setBounds(68, 35, 140, 30);
//		contentPane.add(btnChouseFile);
//
//		JCheckBox chckbxNewCheckBox = new JCheckBox("Buffered");
//		chckbxNewCheckBox.setBounds(46, 100, 97, 23);
//		contentPane.add(chckbxNewCheckBox);
//
//		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Cipher");
//		chckbxNewCheckBox_1.setBounds(46, 141, 97, 23);
//		contentPane.add(chckbxNewCheckBox_1);
//
//		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Gzip");
//		chckbxNewCheckBox_2.setBounds(46, 184, 97, 23);
//		contentPane.add(chckbxNewCheckBox_2);
//
//		textField = new JTextField();
//		textField.setText("1");
//		textField.setBounds(214, 101, 20, 20);
//		contentPane.add(textField);
//		textField.setColumns(10);
//
//		textField_1 = new JTextField();
//		textField_1.setText("2");
//		textField_1.setColumns(10);
//		textField_1.setBounds(214, 142, 20, 20);
//		contentPane.add(textField_1);
//
//		textField_2 = new JTextField();
//		textField_2.setText("3");
//		textField_2.setColumns(10);
//		textField_2.setBounds(214, 185, 20, 20);
//		contentPane.add(textField_2);
//
//		JLabel lblFilters = new JLabel("filters");
//		lblFilters.setBounds(58, 79, 46, 14);
//		contentPane.add(lblFilters);
//
//		JLabel lblOrder = new JLabel("order :");
//		lblOrder.setBounds(199, 76, 46, 14);
//		contentPane.add(lblOrder);
//
//		textField_3 = new JTextField();
//		textField_3.setBounds(10, 232, 265, 94);
//		contentPane.add(textField_3);
//		textField_3.setColumns(10);
//
//		JButton btnNewButton = new JButton("save");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				String string = textField_3.getText();
//				System.out.println(FILEPATH);
//				String s = FILEPATH + "filtredFile.txt";
//				try {
//					Writer w = new FileWriter(s);
//					w.write(string);
//					w.close();
//				} catch (Exception ex) {
//					ex.printStackTrace();
//				}
//
//				Boolean b1, b2, b3, nb1, nb2, nb3;
//				b1 = (textField.getText().length() == 1 && chckbxNewCheckBox.isSelected()
//						&& textField.getText().matches("[0-9]+"));
//				
//				b2 = textField_1.getText().length() == 1 && chckbxNewCheckBox_1.isSelected()
//						&& textField_1.getText().matches("[0-9]+");
//				
//				b3 = textField_2.getText().length() == 1 && chckbxNewCheckBox_2.isSelected()
//						&& textField_2.getText().matches("[0-9]+");
//				
//				nb1 = !chckbxNewCheckBox.isSelected();
//				nb2 = !chckbxNewCheckBox_1.isSelected();
//				nb3 = !chckbxNewCheckBox_2.isSelected();
//
//				if (b1 || nb1) {
//					if (b2 || nb2) {
//						if (b3 || nb3) {
//
//							if (b1 & !b2 & !b3) {
//								new Buff(s).bufferedwriter();
//							} else if (!b1 & b2 & !b3) {
//								new CipherSample(s).encrypt();
//							} else if (!b1 & !b2 & b3) {
//								new GZIPExample(s).compressGzipFile();
//							
//							} else if (b1 & b2 & !b3) {
//
//								if (Integer.valueOf(textField.getText()) < Integer.valueOf(textField_1.getText())) {
//									new Buff(s).bufferedwriter();
//									new CipherSample(s).encrypt();
//								} else if (Integer.valueOf(textField.getText()) > Integer
//										.valueOf(textField_1.getText())) {
//									new CipherSample(s).encrypt();
//									new Buff(s).bufferedwriter();
//								} else {
//									textField_4.setText(" error same order");
//								}
//
//							} else if (b1 & !b2 & b3) {
//
//								if (Integer.valueOf(textField.getText()) < Integer.valueOf(textField_2.getText())) {
//									new Buff(s).bufferedwriter();
//									new GZIPExample(s).compressGzipFile();
//								} else if (Integer.valueOf(textField.getText()) > Integer
//										.valueOf(textField_2.getText())) {
//									new GZIPExample(s).compressGzipFile();
//									new Buff(s + ".gz").bufferedwriter();
//								} else {
//									textField_4.setText(" error same order");
//								}
//
//							} else if (!b1 & b2 & b3) {
//
//								if (Integer.valueOf(textField_1.getText()) < Integer.valueOf(textField_2.getText())) {
//									new CipherSample(s).encrypt();
//									new GZIPExample(s).compressGzipFile();
//								} else if (Integer.valueOf(textField_1.getText()) > Integer
//										.valueOf(textField_2.getText())) {
//									new GZIPExample(s).compressGzipFile();
//									new CipherSample(s + ".gz").encrypt();
//								} else {
//									textField_4.setText(" error same order");
//								}
//
//							} else if (b1 & b2 & b3) {
//
//								if (Integer.valueOf(textField.getText()) < Integer.valueOf(textField_1.getText())
//										&& Integer.valueOf(textField_1.getText()) < Integer
//												.valueOf(textField_2.getText())) {
//									new Buff(s).bufferedwriter();
//									new CipherSample(s).encrypt();
//									new GZIPExample(s).compressGzipFile();
//									// new File(s).delete();
//								} else if (Integer.valueOf(textField.getText()) > Integer.valueOf(textField_1.getText())
//										&& Integer.valueOf(textField_1.getText()) > Integer
//												.valueOf(textField_2.getText())) {
//									new GZIPExample(s).compressGzipFile();
//									new CipherSample(s + ".gz").encrypt();
//									new Buff(s + ".gz").bufferedwriter();
//
//								} else if (Integer.valueOf(textField_1.getText()) < Integer.valueOf(textField.getText())
//										&& Integer.valueOf(textField.getText()) < Integer
//												.valueOf(textField_2.getText())) {
//									new CipherSample(s).encrypt();
//									new Buff(s).bufferedwriter();
//									new GZIPExample(s).compressGzipFile();
//								} else if (Integer.valueOf(textField_1.getText()) > Integer.valueOf(textField.getText())
//										&& Integer.valueOf(textField.getText()) > Integer
//												.valueOf(textField_2.getText())) {
//									new GZIPExample(s).compressGzipFile();
//									new Buff(s + ".gz").bufferedwriter();
//									new CipherSample(s + ".gz").encrypt();
//
//								} else if (Integer.valueOf(textField.getText()) < Integer.valueOf(textField_2.getText())
//										&& Integer.valueOf(textField_2.getText()) < Integer
//												.valueOf(textField_1.getText())) {
//									new Buff(s).bufferedwriter();
//									new GZIPExample(s).compressGzipFile();
//									new CipherSample(s + ".gz").encrypt();
//
//								} else if (Integer.valueOf(textField.getText()) > Integer.valueOf(textField_2.getText())
//										&& Integer.valueOf(textField_2.getText()) > Integer
//												.valueOf(textField_1.getText())) {
//									new CipherSample(s).encrypt();
//									new GZIPExample(s).compressGzipFile();
//									new Buff(s + ".gz").bufferedwriter();
//								} else {
//									textField_4.setText(" error same order");
//								}
//
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
//		btnNewButton.setBounds(95, 337, 89, 23);
//		contentPane.add(btnNewButton);
//
//		textField_4 = new JTextField();
//		textField_4.setBounds(10, 396, 265, 54);
//		contentPane.add(textField_4);
//		textField_4.setColumns(10);
//
//		JButton button = new JButton("<");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				FirstPan f1 = new FirstPan();
//				// f1.setVisible(true);
//				frame.setVisible(false);
//
//			}
//		});
//		button.setBounds(0, 0, 46, 23);
//		contentPane.add(button);
//		// contentPane.setVisible(true);
//	}
//}
