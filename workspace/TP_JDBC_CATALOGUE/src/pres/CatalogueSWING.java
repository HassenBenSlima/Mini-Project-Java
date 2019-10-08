package pres;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.MetierCatalogueImpl;
import metier.Produit;

public class CatalogueSWING extends JFrame {

		
	private JLabel jLabelMC=new JLabel("Mot Clé:");
	private JTextField jTextFieldMC=new JTextField(12);
	private JButton jButtonOK=new JButton("OK");
	private JTable jTable;
	private ProduitModel produitModel;
	private MetierCatalogueImpl metier=new MetierCatalogueImpl();
	
	public CatalogueSWING(){//button fermer
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());//sud north, west east
		JPanel jPanelN=new JPanel();
		jPanelN.setLayout(new FlowLayout());//centrer
		jPanelN.add(jLabelMC);
		jPanelN.add(jTextFieldMC);
		jPanelN.add(jButtonOK);
		this.add(jPanelN,BorderLayout.NORTH);
		
		produitModel= new ProduitModel();
		jTable=new JTable(produitModel);
		JScrollPane jScrollPane= new JScrollPane(jTable);
		this.add(jScrollPane, BorderLayout.CENTER);
		
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());//methode de donner la dimension d'ecron
		this.setVisible(true);
		jButtonOK.addActionListener(new ActionListener() {
			//Comme controller
			@Override
			public void actionPerformed(ActionEvent e) {
				String mc =jTextFieldMC.getText();
				List <Produit> prods=metier.getProduitParMC(mc);
				//je recupere la list dans le model
				produitModel.loadData(prods);
				
			}
		}); 
	
	}
	public static void main(String[]args)
	{
		//test
		new CatalogueSWING();
	}
}
