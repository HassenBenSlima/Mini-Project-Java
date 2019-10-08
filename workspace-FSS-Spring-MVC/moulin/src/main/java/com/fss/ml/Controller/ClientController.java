package com.fss.ml.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fss.ml.entities.BonAchat;
import com.fss.ml.entities.Client;
import com.fss.ml.entities.Employe;
import com.fss.ml.entities.Facture;
import com.fss.ml.entities.Reservation;
import com.fss.ml.metier.MoulinOliveMetier;
import com.fss.ml.model.ClientForm;
import com.fss.ml.model.EmployerForm;

@Controller
@RequestMapping(value="/moulin/moulinClient")
public class ClientController {
	@Autowired
	private MoulinOliveMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("client",new Client());
	    model.addAttribute("clients",metier.listClient());
	    return"Clients";
	}
	
	
//	@RequestMapping(value="/clientlist")
//	public String indexlist(Model model){
//		
//	    model.addAttribute("clients",metier.listClient());
//	    return"ListClient";
//	}
//	@RequestMapping(value="/clientRechercher")
//	public String indexsearch(Model model ,@RequestParam Long cinClient){
//		
//		Client c= metier.getClient(cinClient);
//	    model.addAttribute("cl",c);
//	    
//	    return"ListClient";
//	}
	
	
	@RequestMapping(value="/saveClient")
	public String saveClient(@Valid Client c , BindingResult bindingResult,
			Model model, @RequestParam String action) throws IOException{
		 
		if(bindingResult.hasErrors()){
			model.addAttribute("clients",metier.listClient());
			return ("Clients");
		}
   System.out.println(action);
		if(action=="Ajouter")
		{
		    metier.ajouterClient(c);
		}else{
			metier.modifierClient(c);
			}
		 model.addAttribute("error","Enregister");
		model.addAttribute("client",new Client());
	    model.addAttribute("clients",metier.listClient());
	    
	    return"Clients";
	}
	
	
	@RequestMapping(value="/suppClient")
	public String supp(Model model, long CIN){
		
		List<Reservation>LR= metier.findByCinClR(CIN);
        
		for(int i=0;i<LR.size();i++){		
			metier.supprimerRsv(LR.get(i).getIdRsv());
		}
       
		List<Facture>LF= metier.findByCinClF(CIN);
        
		for(int i=0;i<LF.size();i++){		
			metier.supprimerFacture(LF.get(i).getIdVente());
		}

		metier.supprimerClient(CIN);
		model.addAttribute("client",new Client());
	    model.addAttribute("clients",metier.listClient());
	    return"Clients";
	}

	@RequestMapping(value="/editClient")
	public String edit(Model model, long CIN){
	    Client c = metier.getClient(CIN);
		model.addAttribute("client",c);
		model.addAttribute("clients",metier.listClient());
	    return"Clients";
	    }
          
    		
	public ModelAndView resolveException(HttpServletRequest request, 
			                             HttpServletResponse response, Object arg2,Exception ex) {
     
		ModelAndView mv = new ModelAndView();
		mv.addObject("client", new Client());
		mv.addObject("clients",metier.listClient());
        mv.addObject("exception",ex.getMessage());
        mv.setViewName("Clients");
		return mv;
	}


/********************Affichage*******************/



@RequestMapping(value="/clientRechercher")
public String indexsearch(Model model ,ClientForm E,BindingResult bindingResult ){
	
	if(bindingResult.hasErrors()){
		model.addAttribute("ep",E);
	    model.addAttribute("emplo",new ClientForm());
		return "ListClient";
	}		
	
	try {
		Client cltm=  metier.getClient(E.getCinClient());
		if(cltm !=null)
		{
		E.setClt(cltm);
		}
		
		} catch (Exception e) {
		E.setException(e.getMessage());	
	}
    
    model.addAttribute("ep",E);
    model.addAttribute("emplo",new ClientForm());
    return"ListClient";
}

//pagination
@RequestMapping(value="/ALLClient")
public String charger( ClientForm E,
		BindingResult bindingResult ,Model model){
	
	if(bindingResult.hasErrors()){
		model.addAttribute("ep",E);
	    model.addAttribute("emplo",new ClientForm());
		return "ListClient";
	}
	
	chargerClient(E);
	
	model.addAttribute("ep",E);
    model.addAttribute("emplo",new ClientForm());
    
	return "ListClient";
}



public void chargerClient(ClientForm c){
	try {

		int pos=c.getNbLigne()*c.getPage();
		
		List<Client> LC=metier.consulterClient(pos,c.getNbLigne());

		c.setListClient(LC);
		
		long nbC=metier.getNombreClient();
		c.setNombrePages((int)(nbC/c.getNbLigne()+1));
		
	} catch (Exception e) {
	c.setException(e.getMessage());	
	}
}

/***********************Client by name**************************/
@RequestMapping(value="/nameClRechercher")
public String indexsearchFO(Model model ,ClientForm E,BindingResult bindingResult ){
	
	if(bindingResult.hasErrors()){
	
		model.addAttribute("epff",metier.nameClient(E.getNameClient()));
	    model.addAttribute("emplo",new ClientForm());
	    
		return "LNomClient";
	}		
 E.setListClientByName(metier.nameClient(E.getNameClient()));
	System.out.println("******************************");
 System.out.println(E.getNameClient());
 
	model.addAttribute("epff",metier.nameClient(E.getNameClient()));
 model.addAttribute("emplo",new ClientForm());
 return"LNomClient";
}


//pagination
@RequestMapping(value="/ALLnameClient")
public String chargername( ClientForm E,
		BindingResult bindingResult ,Model model){
	
	if(bindingResult.hasErrors()){
		model.addAttribute("ep",E);
	    model.addAttribute("emplo",new ClientForm());
		return "LNomClient";
	}
	
	chargerClient(E);
	
	model.addAttribute("ep",E);
  model.addAttribute("emplo",new ClientForm());
  
	return "LNomClient";
}

}