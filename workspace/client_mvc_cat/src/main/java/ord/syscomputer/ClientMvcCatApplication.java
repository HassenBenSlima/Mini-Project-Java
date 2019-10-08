package ord.syscomputer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ord.syscomputer.dao.CategorieRepository;
import ord.syscomputer.dao.ClientRepository;
import ord.syscomputer.dao.EtudiantRepository;
import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.entities.Categorie;
import ord.syscomputer.entities.Client;
import ord.syscomputer.entities.Etudiant;
import ord.syscomputer.entities.Produit;

@SpringBootApplication
public class ClientMvcCatApplication  implements CommandLineRunner{
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClientMvcCatApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
	/*	produitRepository.save(new Produit("HP 678", 900, 6,new Categorie(1L)));
		produitRepository.save(new Produit("Sumsung Galaxy", 905, 7,new Categorie(1L)));
		produitRepository.save(new Produit("Xerox", 5600, 6,new Categorie(2L)));
		produitRepository.save(new Produit("Sony", 5600, 6,new Categorie(2L)));
		
		categorieRepository.save(new Categorie("Philips"));
		categorieRepository.save(new Categorie("TOTO"));
	
		Categorie cat=categorieRepository.findOne(1L);
		List<Produit>prod=categorieRepository.getListProduit(1L);
		
		for (Produit produit : prod) {
			System.out.println(produit.getPrix());
		}
		
		
		System.out.println("123");
*/
		/*
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.
		save(new Etudiant("safouane","safouane",df.parse("1983-11-12") ));
		
		etudiantRepository.
		save(new Etudiant("rifaat","rifaat",df.parse("1983-11-12") ));
		etudiantRepository.
		save(new Etudiant("sara","sara",df.parse("1983-11-12") ));
		etudiantRepository.
		save(new Etudiant("hamza","hamza",df.parse("1983-11-12") ));
		etudiantRepository.
		save(new Etudiant("driss","driss",df.parse("1983-11-12") ));
		
		List<Etudiant> etds=etudiantRepository.findAll();
		etds.forEach(e->System.out.println(e.getNom()));
		*/

	
	
	
	/*
		clientRepository.
		save(new Client("hassen", "mahdia", "hassen@gmail.com","20014411"));
		
		clientRepository.
		save(new Client("mahdi", "mahdia", "hassen@gmail.com","20014411"));
		
		clientRepository.
		save(new Client("mohamed", "mahdia", "hassen@gmail.com","20014411"));
		
		clientRepository.
		save(new Client("fares", "mahdia", "hassen@gmail.com","20014411"));
		
		clientRepository.
		save(new Client("farou9", "mahdia", "hassen@gmail.com","20014411"));
		
		clientRepository.
		save(new Client("Csys", "mahdia", "hassen@gmail.com","20014411"));
		
		List<Client> clts=clientRepository.findAll();
		clts.forEach(e->System.out.println(e.getNomClient()));

	*/
	
	
	
	
	
	}
}
