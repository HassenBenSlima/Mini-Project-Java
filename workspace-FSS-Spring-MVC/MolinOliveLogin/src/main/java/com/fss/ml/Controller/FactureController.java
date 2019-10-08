package com.fss.ml.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fss.ml.entities.Client;
import com.fss.ml.entities.Facture;
import com.fss.ml.entities.Reservation;
import com.fss.ml.entities.Stock;
import com.fss.ml.metier.MoulinOliveMetier;
import com.fss.ml.model.FactureForm;
import com.fss.ml.model.MaintenanceForm;
import com.fss.ml.model.ReseservationClForm;

import java.util.Objects;

import javax.validation.Valid;
@Controller
@RequestMapping(value="/FactureImp")
public class FactureController {
	
	@Autowired
	private MoulinOliveMetier metier;
	
	@RequestMapping(value="/indexfac")
	
	public String indexF(Model model){
	
		model.addAttribute("fac", new Facture());
		model.addAttribute("facs", metier.listFacture());
		model.addAttribute("clients", metier.listClient());
		model.addAttribute("ct", metier.listCiterne());
		model.addAttribute("Css", metier.listCaisse());
	    return"Facture";
	}
	
	@RequestMapping(value="/Savefac")
	public String Savefac(@Valid Facture f,Model model,BindingResult bindingResult 
			) throws IOException{
		
		if(bindingResult.hasErrors()){

			model.addAttribute("facs", metier.listFacture());
			model.addAttribute("clients", metier.listClient());
			model.addAttribute("ct", metier.listCiterne());
			model.addAttribute("Css", metier.listCaisse());	
			return "Facture";
		}
		
	      metier.ajouterFacture(f,f.getClient().getCinClient(), f.getCaissef().getIdCaisse());		
			
               for(int i=0;i<citerns.size();i++){
               //System.out.println("Code de Citerne : "+citerns.get(i));				
              //System.out.println("Quantité acheté : "+Quantites.get(i)+", Code de Citerne : "+citerns.get(i));	
				 
               metier.RetirerHuile(citerns.get(i),Quantites.get(i));
				}
			
			citerns.clear();
			Quantites.clear();	
		    
			
		
	
	
	
	   List<Facture> ImpF =metier.listFacture();	
	    Facture FImp=ImpF.get(ImpF.size()-1);
	
		model.addAttribute("fac", new Facture());
		model.addAttribute("facs", FImp);
		model.addAttribute("clients", metier.listClient());
		model.addAttribute("ct", metier.listCiterne());
		model.addAttribute("Css", metier.listCaisse());
		return"ImpFacture";
		}

	ArrayList<String> citerns = new ArrayList<String>();
	ArrayList<Double> Quantites = new ArrayList<Double>();
	
	@RequestMapping(value="ajaxController",method = {RequestMethod.GET})
	public @ResponseBody void JSCall(@RequestParam(value="variable") String variable,
			@RequestParam(value="variable2") double variable2){

	citerns.add(variable);
	Quantites.add(variable2);
	
//	for(int i=0;i<citerns.size();i++){
////System.out.println("Code de Citerne : "+citerns.get(i));				
//System.out.println("Quantité acheté : "+Quantites.get(i)+", Code de Citerne : "+citerns.get(i));	
//		 
//       metier.RetirerHuile(citerns.get(i),Quantites.get(i));
//		}
	
	System.out.println(variable); //prints only "1" on each link
	System.out.println(variable2);
	}
	
	@RequestMapping(value="/suppFacture")
	public String suppm(Model model, long idfacture){
		
		metier.supprimerFacture(idfacture);
		
		model.addAttribute("factcl", new Facture());
		return"FacturesClient";
		}
	
/***********************Facture pour chaque Client****************************/
	
	@RequestMapping(value="/indexfactClient")
	public String indexrsvc( Model model){

		model.addAttribute("factcl", new FactureForm());

		return "FacturesClient";
	}
	
	@RequestMapping(value="/chargerFacture")
    public String charger( FactureForm fc,
    		BindingResult bindingResult ,Model model){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("factcl",fc);
			return "FacturesClient";
		}
		chargerClient(fc);
		
		model.addAttribute("factcl",fc);
		return "FacturesClient";
	}
	
	
	
	public void chargerClient(FactureForm fc){
		try {
			Client cp = metier.getClient(fc.getCinClient());		
			fc.setClient(cp);
			
			int pos=fc.getNbLigne()*fc.getPage();
			List<Facture> fatrs=metier.consulterFactureClient(fc.getCinClient(),pos,fc.getNbLigne());
			fc.setFactureClient(fatrs);
			
			long nbF=metier.getNombreFactr(fc.getCinClient());
			fc.setNombrePages((int)(nbF/fc.getNbLigne()+1));
			
		} catch (Exception e) {
		fc.setException(e.getMessage());	
		}
}
	
	
}
