package com.fss.ml.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.mapping.Value;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fss.ml.entities.BonAchat;
import com.fss.ml.entities.Client;
import com.fss.ml.entities.Employe;
import com.fss.ml.entities.FournisseurMaintenance;
import com.fss.ml.entities.FournisseurOlive;
import com.fss.ml.entities.Maintenance;
import com.fss.ml.metier.MoulinOliveMetier;
import com.fss.ml.model.EmployerForm;
import com.fss.ml.model.FournMainForm;
import com.fss.ml.model.FournOliveForm;

@Controller
@RequestMapping(value="/moulin/moulinFrns")
public class FournisseursController {
	 @Autowired
	 private MoulinOliveMetier metier;

       
	 @ExceptionHandler
	 public String HandlerNullValueInNestedPathException (Exception e){
		System.out.println("exception by "+e);
		 return "Valid";
		 
	 }
	/******************FournisseurMaintenance********************/
    
	 
    
	 //fournisseur de Maintenance
		@RequestMapping(value="/indexfm")
		public String indexfo(Model model){
			model.addAttribute("frnm",new FournisseurMaintenance());
		    model.addAttribute("frnms",metier.listFournisseurM());
		    return"FournisseursM";
		}
		
//		@RequestMapping(value="/frnsmlist")
//		public String indexlistm(Model model){
//			
//		    model.addAttribute("frnms",metier.listFournisseurM());
//		    return"ListFrnsM";
//		}
//		
//		@RequestMapping(value="/frnsMRechercher")
//		public String indexsearchM(Model model ,@RequestParam Long cinFourn){
//			
//			FournisseurMaintenance m= (FournisseurMaintenance) metier.getFournisseur(cinFourn);
//		    model.addAttribute("frm",m);
//		    return"ListFrnsM";
//		}
		
		@RequestMapping(value="/saveFrnM")
		public String saveEmploye(FournisseurMaintenance fm , BindingResult bindingResult,
				Model model	,@RequestParam String action) throws IOException{
			
			if(bindingResult.hasErrors()){
				model.addAttribute("frnm",new FournisseurMaintenance());
				model.addAttribute("frnms",metier.listFournisseurM());	
				model.addAttribute("error","ERREUR!!");
				return "FournisseursM";
			}
			
			if (action=="Ajouter")
			{metier.ajouterFournisseur(fm);
			}else{   
				
			    metier.modifierFournisseur(fm);		
			}
			model.addAttribute("error","Enregister");
			model.addAttribute("frnm",new FournisseurMaintenance());
		    model.addAttribute("frnms",metier.listFournisseurM());
		    return"FournisseursM";
		}
		
		
		@RequestMapping(value="/suppFrnsM")
		public String suppf(Model model, long CINFM){
			
			List<Maintenance>LM= metier.findByCinFm(CINFM);
			
			for(int i=0;i<LM.size();i++){		
				metier.supprimerMaint(LM.get(i).getIdMain());
			}
			
			metier.supprimerFournisseur(CINFM);
			model.addAttribute("frnm",new FournisseurMaintenance());
		    model.addAttribute("frnms",metier.listFournisseurM());
		    return"FournisseursM";
		}

		@RequestMapping(value="/editfrns")
		public String editf(Model model, long CINFM){
		    FournisseurMaintenance F = (FournisseurMaintenance) metier.getFournisseur(CINFM);
		 
		    model.addAttribute("frnm",F);
		    model.addAttribute("frnms",metier.listFournisseurM());
		    return"FournisseursM";
		    }				
		


		/********************Affichage Fournisseur Maintenance*******************/
		
		@RequestMapping(value="/indexfrnsmain")
		public String indexemp( Model model){

		    model.addAttribute("frm",new FournMainForm());

			return "ListFrnsM";
		}
		
		@RequestMapping(value="/foRechercher")
		public String indexsearch(Model model ,FournMainForm E,BindingResult bindingResult ){
			
			if(bindingResult.hasErrors()){
				return "ListFrnsM";
			}		
            E.setListfrounByname(metier.RnameFournisseurM(E.getNomFourn()));
			System.out.println("******************************");
            System.out.println(E.getNomFourn());
            
			model.addAttribute("epff",metier.RnameFournisseurM(E.getNomFourn()));
		    model.addAttribute("frm",new FournMainForm());
		    return"ListFrnsM";
		}
		
		//pagination
		@RequestMapping(value="/ALLFO")
	    public String charger( FournMainForm E,
	    		BindingResult bindingResult ,Model model){
			
			if(bindingResult.hasErrors()){
				model.addAttribute("ep",E);
			    model.addAttribute("frm",new FournMainForm());
				return "ListFrnsM";
			}
			
			chargerFrnsM(E);
			
			model.addAttribute("ep",E);
		    model.addAttribute("frm",new FournMainForm());
		    
			return "ListFrnsM";
		}
		
		
		
		public void chargerFrnsM(FournMainForm ep){
			try {

				int pos=ep.getNbLigne()*ep.getPage();
				
				List<FournisseurMaintenance> Lemp=metier.consulterFrnms(pos,ep.getNbLigne());
			
				ep.setListFournMain(Lemp);
				
				long nbR=metier.getNombreFrnms();
				ep.setNombrePages((int)(nbR/ep.getNbLigne()+1));
				
			} catch (Exception e) {
			ep.setException(e.getMessage());	
			}
	}
		
	
/***************************FournisseurOlive***********************************/
		
		@RequestMapping(value="/indexfo")
		public String indexfm(Model model){
			model.addAttribute("frno",new FournisseurOlive());
		    model.addAttribute("frnos",metier.listFournisseurO());
		    return"FournisseursO";
		}

		@RequestMapping(value="/frnsolist")
		public String indexlisto(Model model){
			
		    model.addAttribute("frnos",metier.listFournisseurO());
		    return"ListFrnsO";
		}
		
		@RequestMapping(value="/frnsORechercher")
		public String indexsearchO(Model model ,@RequestParam Long cinFourn){
			
			FournisseurOlive oo=  (FournisseurOlive) metier.getFournisseur(cinFourn);
		    model.addAttribute("fro",oo);
		    return"ListFrnsO";
		}
		
		
		
		@RequestMapping(value="/saveFrnO")
		public String saveEmploye(@Valid FournisseurOlive fo , BindingResult bindingResult,
				Model model	,@RequestParam String action) throws IOException{
			
			if(bindingResult.hasErrors()){
				model.addAttribute("error","ERREUR!!");
				model.addAttribute("frno",new FournisseurOlive());
				model.addAttribute("frnos",metier.listFournisseurM());	
				return ("FournisseursO");
			}

			if (action=="Ajouter")
			{metier.ajouterFournisseur(fo);
			}else{   
				
			    metier.modifierFournisseur(fo);		
			}
			model.addAttribute("error","Enregister");
			model.addAttribute("frno",new FournisseurOlive());
		    model.addAttribute("frnos",metier.listFournisseurO());
		    return"FournisseursO";
		}
		
		
		@RequestMapping(value="/suppFrnsO")
		public String suppfm(Model model, long CINFO){
			
            List<BonAchat>LB= metier.findByCinFo(CINFO);
            
			for(int i=0;i<LB.size();i++){		
				metier.supprimerBA(LB.get(i).getIdBA());
			}
			
			metier.supprimerFournisseur(CINFO);
			
			model.addAttribute("frno",new FournisseurOlive());
		    model.addAttribute("frnos",metier.listFournisseurO());
		    return"FournisseursO";
		}

		@RequestMapping(value="/editfrnsO")
		public String editfm(Model model, long CINFO){
		    FournisseurOlive F =  (FournisseurOlive) metier.getFournisseur(CINFO);
		 
			model.addAttribute("frno",F);
		    model.addAttribute("frnos",metier.listFournisseurO());
		    return"FournisseursO";
		    }

/********************Affichage Fournisseur Olive*******************/
		
		@RequestMapping(value="/indexfrnsolive")
		public String indexeol( Model model){

		    model.addAttribute("frol",new FournOliveForm());

			return "ListFrnsO";
		}
		
		@RequestMapping(value="/folRechercher")
		public String indexsearchFO(Model model ,FournOliveForm E,BindingResult bindingResult ){
			
			if(bindingResult.hasErrors()){
			
				model.addAttribute("epff",metier.RnameFournisseurO(E.getNomFourn()));
			    model.addAttribute("frol",new FournOliveForm());
			    
				return "ListFrnsO";
			}		
            E.setListFournObyname(metier.RnameFournisseurO(E.getNomFourn()));
			System.out.println("******************************");
            System.out.println(E.getNomFourn());
            
			model.addAttribute("epff",metier.RnameFournisseurO(E.getNomFourn()));
		    model.addAttribute("frol",new FournOliveForm());
		    return"ListFrnsO";
		}
		
		//pagination
		@RequestMapping(value="/ALLFOL")
	    public String charger( FournOliveForm E,
	    		BindingResult bindingResult ,Model model){
			
			if(bindingResult.hasErrors()){
				model.addAttribute("ep",E);
			    model.addAttribute("frol",new FournOliveForm());
			    
				return "ListFrnsO";
			}
			
			chargerFrnsO(E);
			
			model.addAttribute("ep",E);
		    model.addAttribute("frol",new FournOliveForm());
		    
			return "ListFrnsO";
		}
		
		
		
		public void chargerFrnsO(FournOliveForm ep){
			try {

				int pos=ep.getNbLigne()*ep.getPage();
				
				List<FournisseurOlive> Lfo=metier.consulterFrnos(pos,ep.getNbLigne());
			
				ep.setListFournOlive(Lfo);
				
				long nbfo=metier.getNombreFrnos();
				ep.setNombrePages((int)(nbfo/ep.getNbLigne()+1));
				
			} catch (Exception e) {
			ep.setException(e.getMessage());	
			}
	}
	
}
