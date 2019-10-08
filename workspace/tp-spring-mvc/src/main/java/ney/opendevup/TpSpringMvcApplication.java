package ney.opendevup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ney.opendevup.dao.EtudiantRepository;
import ney.opendevup.entities.Etudiant;

@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
		
		ApplicationContext ctx =SpringApplication.run(TpSpringMvcApplication.class, args);//inversion de controlle
		EtudiantRepository etudiantRepository=ctx.getBean(EtudiantRepository.class);
		
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
	 	etudiantRepository.save(new Etudiant("Ahmed", df.parse("1988-11-10"),
	 								"ahmed@gmail.com", "ahmed.jpg"));
	 	etudiantRepository.save(new Etudiant("Mohamed", df.parse("1988-11-10"),
					"mohamed@gmail.com", "mohamed.jpg"));
	 	etudiantRepository.save(new Etudiant("ibrahim", df.parse("1988-11-10"),
					"ibrahim@gmail.com", "ibrahim.jpg"));
	 	
	 	Page<Etudiant> etds= etudiantRepository.findAll( new PageRequest(0, 5));
	 	
	 	etds.forEach(e->System.out.println(e.getNom()));
	 	
	 	System.out.println("-----------------------");
	 	
	 	Page<Etudiant> etd= etudiantRepository.chercherEtudiants("%med%", new PageRequest(0, 5));
	 	
	 	etd.forEach(e->System.out.println(e.getEmail()));
	 	
	 	
	 	
	 	
	 	
	 	

		
	}
}
