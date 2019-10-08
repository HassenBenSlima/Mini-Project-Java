package iit.ens.projetTest;


import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstPan   extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPan window = new FirstPan();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstPan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		ReadFile rf = new ReadFile();
		rf.setVisible(false);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnEncript = new JButton("READ");
		btnEncript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				rf.setVisible(true);
		     	frame.setVisible(false);
			}
		});
		
		
		btnEncript.setBounds(50, 94, 89, 70);
		frame.getContentPane().add(btnEncript);
		WriteFile wf = new WriteFile();
		wf.setVisible(false);
		JButton btnDecript = new JButton("WRITE");
		btnDecript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				wf.setVisible(true);
		     	frame.setVisible(false);
			}
		});
		
		
		btnDecript.setBounds(283, 94, 89, 70);
		frame.getContentPane().add(btnDecript);
	}
}
