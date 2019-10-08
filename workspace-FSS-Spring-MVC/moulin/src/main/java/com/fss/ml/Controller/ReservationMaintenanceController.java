package com.fss.ml.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fss.ml.entities.Client;
import com.fss.ml.entities.FournisseurMaintenance;
import com.fss.ml.entities.FournisseurOlive;
import com.fss.ml.entities.Maintenance;
import com.fss.ml.entities.Reservation;
import com.fss.ml.metier.MoulinOliveMetier;
import com.fss.ml.model.FournMainForm;
import com.fss.ml.model.FournOliveForm;
import com.fss.ml.model.MaintenanceForm;
import com.fss.ml.model.ReseservationClForm;

    @Controller
	@RequestMapping(value="/moulin/moulinOlive")
	public  class ReservationMaintenanceController   {

       @Autowired
		private MoulinOliveMetier metier;
		
      
				
	
      /*****************************RESERVATION*****************************/
		
	
		@RequestMapping(value="/indexr")
		public String indexr(Model model){
			model.addAttribute("reservation",new Reservation());
		    model.addAttribute("reservations",metier.listReservation());
		    model.addAttribute("clients",metier.listClient());
		    return"Reservation";
		}
		
		@RequestMapping(value="/saveRsv")
		public String saveProd(@Valid Reservation r, BindingResult bindingResult,Model model
				,@RequestParam String action) throws IOException{
			 
			if(bindingResult.hasErrors()){
				  model.addAttribute("reservations",metier.listReservation());
				  model.addAttribute("clients",metier.listClient());
				  
				return ("Reservation");
			}
			
			if (action=="Ajouter"){
			metier.ajouterReservation(r, r.getClient().getCinClient());
			}else{
			metier.modifierRsv(r);
			}
			
		
			model.addAttribute("error","Enregister");
			model.addAttribute("reservation",new Reservation());
		    model.addAttribute("reservations",metier.listReservation());
		    model.addAttribute("clients",metier.listClient());
		    
		    return"Reservation";
		}
		
	
		
		@RequestMapping(value="/suppRsv")
		public String suppr(Model model, long idRsv){
			metier.supprimerRsv(idRsv);
			model.addAttribute("reservation",new Reservation());
		    model.addAttribute("reservations",metier.listReservation());
		    model.addAttribute("clients",metier.listClient());
		    return"Reservation";
		}

		@RequestMapping(value="/editRsv")
		public String editr(Model model, long idRsv){
		    Reservation r = metier.getRsv(idRsv);
		    model.addAttribute("reservation",r);
		    model.addAttribute("reservations",metier.listReservation());
		    model.addAttribute("clients",metier.listClient());
		    return"Reservation";
		    }
		
		/*************************Affichage reservations du Client******************************/
		@RequestMapping(value="/indexrsvc")
	    public String indexrsvc( Model model){
		model.addAttribute("rsvcl", new ReseservationClForm());
		return "ListRsvCl";
		}
		
		@RequestMapping(value="/chargerClient")
	    public String charger( ReseservationClForm rc,
	    		BindingResult bindingResult ,Model model){
			
			if(bindingResult.hasErrors()){
				return "ListRsvCl";
			}
			chargerClient(rc);
			model.addAttribute("rsvcl",rc);
			return "ListRsvCl";
		}
		
		
		
		public void chargerClient(ReseservationClForm rc){
			try {
				Client cp = metier.getClient(rc.getCinClient());		
				rc.setClient(cp);
				
				int pos=rc.getNbLigne()*rc.getPage();
				
				List<Reservation> rsvs=metier.consulterRsvClient(rc.getCinClient(),pos,rc.getNbLigne());
			
				rc.setReservations(rsvs);
				long nbR=metier.getNombreRsv(rc.getCinClient());
				rc.setNombrePages((int)(nbR/rc.getNbLigne()+1));
				
			} catch (Exception e) {
			rc.setException(e.getMessage());	
			}
	}

		/************************************Affciahge Reservation by date list ************************************/
	
	
		
		@RequestMapping(value="/folRechercher")
		public String indexsearchFO(Model model ,ReseservationClForm E,BindingResult bindingResult ){
			
			if(bindingResult.hasErrors()){
				model.addAttribute("epff",metier.RreservationD(E.getDateRsv()));
			    model.addAttribute("frol",new ReseservationClForm());
			   
				return "ListRsv";
			}		
            E.setRsvByDat(metier.RreservationD(E.getDateRsv()));
			System.out.println("******************************");
            System.out.println(E.getDateRsv());
            
			model.addAttribute("epff",metier.RreservationD(E.getDateRsv()));
		    model.addAttribute("frol",new ReseservationClForm());
		    return"ListRsv";
		}
		
		//pagination
		@RequestMapping(value="/ALLR")
	    public String chargerrsvs( ReseservationClForm E,
	    		BindingResult bindingResult ,Model model){
			
			if(bindingResult.hasErrors()){
				return "ListRsv";
			}
			
			chargerRrv(E);
			
			model.addAttribute("ep",E);
		    model.addAttribute("frol",new ReseservationClForm());
			return "ListRsv";
		}
		
		
		
		public void chargerRrv(ReseservationClForm ep){
			try {

				int pos=ep.getNbLigne()*ep.getPage();
				
				List<Reservation> list=metier.consulterReservation(pos,ep.getNbLigne());
				ep.setListRsv(list);
				
				long nbrv=metier.getNombreRsvs();
				System.out.println(nbrv);
				ep.setNombrePages((int)(nbrv/ep.getNbLigne()+1));
				System.out.println((nbrv/ep.getNbLigne()+1));
			} catch (Exception e) {
			ep.setException(e.getMessage());	
			}
	}		
		
		
		
		/*****************************Maintenance*****************************/
		
		
		@RequestMapping(value="/indexmta")
		public String indexmt(Model model){
			model.addAttribute("maint",new Maintenance());
		    model.addAttribute("maints",metier.listMaintenance());
		    model.addAttribute("frnms",metier.listFournisseurM());
		    model.addAttribute("css",metier.listCaisse());
		    return"Maintenance";
		}
		
		@RequestMapping(value="/saveMain",method = RequestMethod.POST)
		
		public String saveMain(@Valid Maintenance mt, BindingResult bindingResult,Model model
				) throws IOException{
			 
			if (bindingResult.hasErrors()){
				  model.addAttribute("maint",new Maintenance());
				  model.addAttribute("maints",metier.listMaintenance());
				  model.addAttribute("frnms",metier.listFournisseurM());
				  model.addAttribute("css",metier.listCaisse());
				  model.addAttribute("error","ERREUR !!");
				return "Maintenance";
			}
			
			
				metier.ajouterMaintenance(mt,mt.getFournisseurm().getCinFourn(),mt.getCaissem().getIdCaisse());
                
			
			model.addAttribute("maint",new Maintenance());
		    model.addAttribute("maints",metier.listMaintenance());
		    model.addAttribute("frnms",metier.listFournisseurM());
		    model.addAttribute("css",metier.listCaisse());
		    return"Maintenance";
		}
		
		
	
	
		
		@RequestMapping(value="/suppMain")
		public String suppm(Model model, long idMain){
			metier.supprimerMaint(idMain);
			model.addAttribute("maint",new Maintenance());
		    model.addAttribute("maints",metier.listMaintenance());
		    model.addAttribute("frnms",metier.listFournisseurM());
		    model.addAttribute("css",metier.listCaisse());
		    return"Maintenance";
		    }

		@RequestMapping(value="/modifierMain")
		public String modifierMain(@Valid Maintenance mt, BindingResult bindingResult,Model model
				,@RequestParam String action) throws IOException{
			 
			if(bindingResult.hasErrors()){
				model.addAttribute("maint",new Maintenance());

				  model.addAttribute("maints",metier.listMaintenance());
				  model.addAttribute("frnms",metier.listFournisseurM());
				  model.addAttribute("css",metier.listCaisse());
				  model.addAttribute("error","ERREUR !!");
				return ("ModifierMain");
			}
					
			if(nouvelp.get(nouvelp.size()-1)-mt.getPrixMain()>=0){
				metier.modifierMaint(mt);
			    metier.RetirerMoney(mt.getCaissem().getIdCaisse(),mt.getPrixMain());
			    System.out.println("hassen temchi meriguela");
				model.addAttribute("error","Enregister");
			}else{
				metier.modifierMaint(mt);
			    metier.RetirerMoney(mt.getCaissem().getIdCaisse(),prixenc.get(prixenc.size()-1));
			    System.out.println("hassen ta93ad kima kenete");
				model.addAttribute("error","la solde est insuffisant");

			}
			model.addAttribute("maint",new Maintenance());
		    model.addAttribute("maints",metier.listMaintenance());
		    model.addAttribute("frnms",metier.listFournisseurM());
		    model.addAttribute("css",metier.listCaisse());
		    return"ModifierMain";
		}
		
		ArrayList<Double>encienp=new ArrayList<Double>();
		ArrayList<Double>nouvelp=new ArrayList<Double>();
		ArrayList<Double>prixenc=new ArrayList<Double>();
		@RequestMapping(value="/editMain")
		public String editm(Model model, long idMain){
		    
			Maintenance M = metier.getMaint(idMain);
			System.out.println(M.getCaissem().getSolde()+" encien solde caisse");
		    encienp.add(M.getCaissem().getSolde());
		    System.out.println(encienp.get(encienp.size()-1)+" encien solde caisse dans la liste");
		prixenc.add(M.getPrixMain());
		System.out.println(prixenc.get(prixenc.size()-1)+" encien prix  dans la liste");
		metier.AjouterMoney(M.getCaissem().getIdCaisse(),M.getPrixMain());
				System.out.println(M.getCaissem().getSolde()+M.getPrixMain()+"  solde caisse apres click");
			    nouvelp.add(M.getCaissem().getSolde()+M.getPrixMain());
				System.out.println(nouvelp.get(nouvelp.size()-1)+"  nouvelle solde caisse apres click list");
		    model.addAttribute("maint",M);
		    model.addAttribute("maints",metier.listMaintenance());
		    model.addAttribute("frnms",metier.listFournisseurM());
		    model.addAttribute("css",metier.listCaisse());
		    return "ModifierMain";
		    }

/********************Affichage Maintenance*******************/
		
		
		@RequestMapping(value="/mainRechercher")
		public String indexsearchFO(Model model ,MaintenanceForm E,BindingResult bindingResult ){
			
			if(bindingResult.hasErrors()){
				model.addAttribute("epff",metier.listMainByName(E.getNameFourn()));
			    model.addAttribute("mainPF",new MaintenanceForm());
				return "ListFrnsO";
			}		
            E.setMainByName(metier.listMainByName(E.getNameFourn()));
			System.out.println("******************************");
            System.out.println(E.getNameFourn());
            
			model.addAttribute("epff",metier.listMainByName(E.getNameFourn()));
		    model.addAttribute("mainPF",new MaintenanceForm());
		    return"ListMain";
		}
		
		//pagination
		@RequestMapping(value="/ALLMain")
	    public String charger( MaintenanceForm E,
	    		BindingResult bindingResult ,Model model){
			
			if(bindingResult.hasErrors()){
			
				model.addAttribute("ep",E);
			    model.addAttribute("mainPF",new MaintenanceForm());
			   
				return "ListMain";
			}
			
			chargerMain(E);
			
			model.addAttribute("ep",E);
		    model.addAttribute("mainPF",new MaintenanceForm());
		    
			return "ListMain";
		}
		
		
		
		public void chargerMain(MaintenanceForm man){
			try {

				int pos=man.getNbLigne()*man.getPage();
				
				List<Maintenance> LM=metier.consulterMaintenance(pos,man.getNbLigne());
			
				man.setListmaints(LM);
				
				long nbMain=metier.getNombreMain();
				man.setNombrePages((int)(nbMain/man.getNbLigne()+1));
				
			} catch (Exception e) {
				man.setException(e.getMessage());	
			}
	}
		

	

	}