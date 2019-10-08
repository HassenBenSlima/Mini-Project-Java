package com.fss.ml.Controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.fss.ml.metier.MoulinOliveMetier;
import com.fss.ml.model.CaisseForm;
import com.fss.ml.model.CiterneForm;
import com.fss.ml.model.CuveForm;
@Controller
@RequestMapping(value="/moulin/Caisse")
public class CaisseConroller {


	
	@Autowired
	private MoulinOliveMetier metier;





		@RequestMapping(value="/indexcaisse")
		public String indexajthuile(Model model){
			model.addAttribute("caisa",new CaisseForm());
		    model.addAttribute("cs",metier.listCaisse());
		    model.addAttribute("caisr",new CaisseForm());
		    return"gererCaisse";
		}




		@RequestMapping(value="/AjouterArgent")
		public String AjouterHuile(@Valid CaisseForm c , BindingResult bindingResult,
				Model model) throws IOException{
			 
			if(bindingResult.hasErrors()){
				model.addAttribute("caisa",new CaisseForm());
			    model.addAttribute("cs",metier.listCaisse());
			    model.addAttribute("caisr",new CaisseForm());
			    model.addAttribute("error","ERREUR!!");
			    
			    return"gererCaisse";
			}
	   	   
			metier.AjouterMoney(c.getIdCaisse(), c.getMontantAjouter());
			
			model.addAttribute("caisa",new CaisseForm());
		    model.addAttribute("cs",metier.listCaisse());
		    model.addAttribute("caisr",new CaisseForm());
		    model.addAttribute("error","Enregistrer");
		    
		    return"gererCaisse";
		}


		@RequestMapping(value="/RetirerArgent")
		public String RetirerOlive(@Valid CaisseForm c , BindingResult bindingResult,
				Model model) throws IOException{
			 
			if(bindingResult.hasErrors()){
				model.addAttribute("caisa",new CaisseForm());
			    model.addAttribute("cs",metier.listCaisse());
			    model.addAttribute("caisr",new CaisseForm());
			    model.addAttribute("error","ERREUR!!");
			    return"gererCaisse";
			}

			metier.RetirerMoney(c.getIdCaisse(), c.getMontantRetirer());
			 
	   	model.addAttribute("caisa",new CaisseForm());
	    model.addAttribute("cs",metier.listCaisse());
	    model.addAttribute("caisr",new CaisseForm());
	    model.addAttribute("error","l'action est effectuée");
	    
	    return"gererCaisse";
	}
		
		
		
		@RequestMapping(value="/acceuil")
		public String acueil(Model model){
			
		    return"acceuil";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}