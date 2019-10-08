package ney.opendevup.web;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ney.opendevup.dao.AffectationMaterielRepository;
import ney.opendevup.dao.GensRepository;
import ney.opendevup.dao.MaterielRepository;
import ney.opendevup.entities.AffectationMateriel;
import ney.opendevup.entities.Gens;
import ney.opendevup.entities.Impriment;
import ney.opendevup.entities.Materiel;
import ney.opendevup.entities.PC;

@Controller
public class AffectationMaterielController {

	@Autowired
	private MaterielRepository materielRepository;
	@Autowired
	private GensRepository gensRepository;
	@Autowired
	private AffectationMaterielRepository affectationMtrlRepository;
	
	@RequestMapping(value="/formAffecationM",method=RequestMethod.GET)
	public String FormAffectationMateriel(Model model){
		model.addAttribute("allgens",gensRepository.findAll());
		model.addAttribute("allMateriel", materielRepository.findAll());
		return "AffectationMateriel";
	}


	@RequestMapping(value="/AffectationMtrl",method=RequestMethod.GET)
	public  String Save(Model model,
			@RequestParam(name="dateM") String date,
			@RequestParam(name="listeGens") ArrayList<Gens> listeGens,
			@RequestParam(name="liste") ArrayList<Materiel> liste ) throws Exception  {
		
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.parse(date));	
		
		liste.forEach(l->System.out.println(l.getReference()));
		listeGens.forEach(l->System.out.println(l.getCin()));
		
		for (Gens g :listeGens){
		Gens gen= gensRepository.findOne(g.getCin());
		System.out.println("----------------------");	
		System.out.println(g.getCin());	
		System.out.println("----------------------");	
			
		for (Materiel m :liste){
			
			Materiel mt=materielRepository.findOne(m.getReference());
			
			
			System.out.println("----------------------");	
			System.out.println(mt.getReference());	
			System.out.println("----------------------");	
			if (m instanceof PC){	
			affectationMtrlRepository.save(
			new AffectationMateriel(df.parse(date), new Gens(gen.getCin()), new PC(mt.getReference())));
			}
			
			if (m instanceof Impriment){	
				affectationMtrlRepository.save(
				new AffectationMateriel(df.parse(date), new Gens(gen.getCin()), new Impriment(mt.getReference())));
				}
				
			
			
		}
		
		}
		
		
		//	model.addAttribute("etudiant",et);
		model.addAttribute("allgens",gensRepository.findAll());
		model.addAttribute("allMateriel", materielRepository.findAll());
	return "AffectationMateriel";	
}
	
}