package ney.opendevup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ney.opendevup.dao.AffectationMaterielRepository;
import ney.opendevup.dao.EndroidRepository;
import ney.opendevup.dao.GensRepository;
import ney.opendevup.dao.ManicipaliteRepository;
import ney.opendevup.dao.MaterielRepository;
import ney.opendevup.entities.AffectationMateriel;
import ney.opendevup.entities.DateMethod;
import ney.opendevup.entities.Endroit;
import ney.opendevup.entities.Gens;
import ney.opendevup.entities.Manicipalite;
import ney.opendevup.entities.Materiel;
import ney.opendevup.entities.PC;
import ney.opendevup.entities.TypeGent;
import ney.opendevup.web.TypeRepository;

@SpringBootApplication
public class IsieApplication {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx =SpringApplication.run(IsieApplication.class, args);//inversion de controlle
		
		
		
		System.out.println("-----------------------");
		
		TypeRepository typeRepository=ctx.getBean(TypeRepository.class);
		typeRepository.save(new TypeGent("Gens d'inscription"));
		typeRepository.save(new TypeGent("Gens de sensablisation"));
		
		System.out.println("-----------------------");
	 	
		
		GensRepository gensRepository=ctx.getBean(GensRepository.class);
		
		System.out.println("-----------------------");
	 	
		ManicipaliteRepository manicipaliteRepository =ctx.getBean(ManicipaliteRepository.class);
		
		
		manicipaliteRepository.save(new Manicipalite("baladia SAKIA", 10L));
		manicipaliteRepository.save(new Manicipalite("baladia SALTNIA", 10L));
		
		
		
		
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		gensRepository.save(new Gens(11211111L,"Hasssen" , df.parse("1992-04-24"),
	 			18L, 20014411L, "route de mahdia", "hassen@gmail.com", new TypeGent(1L),new Manicipalite(1L)));
	 
		gensRepository.save(new Gens(22311111L,"Ahmed" , df.parse("1992-04-24"),
	 			18L, 20014411L, "route de mahdia", "hassen@gmail.com", new TypeGent(1L),new Manicipalite(1L)));
	 
		gensRepository.save(new Gens(44444444L,"Taha" , df.parse("1992-04-24"),
	 			18L, 20014411L, "route de mahdia", "hassen@gmail.com", new TypeGent(2L),new Manicipalite(2L)));
	 
		gensRepository.save(new Gens(55555555L,"Mohamed" , df.parse("1992-04-24"),
	 			18L, 20014411L, "route de mahdia", "hassen@gmail.com", new TypeGent(2L),new Manicipalite(2L)));
	 
	 	Page<Gens> gn= gensRepository.findAll( new PageRequest(0, 5));
	 	
	 	gn.forEach(g->System.out.println(g.getNom()));
	 	
	 	
	 	
	 	Page<Gens> gns= gensRepository.chercherGensByCin( "%1%", new PageRequest(0, 5));
	 	
	    gns.forEach(g->System.out.println(g.getNom()));
	 	
	    
	    System.out.println("-----------------------");
	 	
		EndroidRepository endroidRepository=ctx.getBean(EndroidRepository.class);
		
		endroidRepository.save(new Endroit("Sakite eddayere", "tres bon",new Manicipalite(1L)));
	
		endroidRepository.save(new Endroit("Sakite ezzite", "bon",new Manicipalite(1L)));
		
		endroidRepository.save(new Endroit("Monoprie", "bon",new Manicipalite(2L)));

		DateMethod d=new DateMethod();
		System.out.println(d.yesterday());
	    
	    System.out.println("-----------------------");
	 	
		MaterielRepository materielRepository=ctx.getBean(MaterielRepository.class);
		
		materielRepository.save(new PC("K555L", "Asus", "bonne etat"));
		materielRepository.save(new PC("REF001", "Dell", "Moyenne"));

	 List<Materiel>mtrls=materielRepository.findAll();
	 
	 mtrls.forEach(m->System.out.println(m.getReference()));
	 
	 System.out.println("-----------------------");
	 	
		AffectationMaterielRepository affectationMtrlRepository=ctx.getBean(AffectationMaterielRepository.class);
		
		//affectationMtrlRepository.save(new AffectationMateriel(df.parse("2017-05-17"), new Gens(55555555L), new PC("K555L")));
	
		 System.out.println("-----------------------");
		 
		List<Gens> gm=gensRepository.chercherGensByManicipalité(1L);
		 gm.forEach(g->System.out.println(g.getNom()));
		 
		 System.out.println("-----------------------");

		 List<Endroit> ed=endroidRepository.chercherEndroitByManicipalite(2L);
		 ed.forEach(e->System.out.println(e.getNom()));
		 
		 System.out.println("-----------------------");

	
	
	}
	
	
	
	
	
	
	
	
}
