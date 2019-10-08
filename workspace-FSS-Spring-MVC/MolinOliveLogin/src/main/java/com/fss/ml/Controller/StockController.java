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
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fss.ml.entities.Citerne;
import com.fss.ml.entities.CuveOlives;
import com.fss.ml.metier.MoulinOliveMetier;
import com.fss.ml.model.CiterneForm;
import com.fss.ml.model.CuveForm;


@Controller
@RequestMapping(value="/moulinStock")
public class StockController implements HandlerExceptionResolver{
	
	@Autowired
	private MoulinOliveMetier metier;
	
	@RequestMapping(value="/indexc")
	public String index(Model model){
		model.addAttribute("citerne",new Citerne());
	    model.addAttribute("citernes",metier.listCiterne());
	    return"Citernes";
	}
	@RequestMapping(value="/saveCiterne")
	public String saveCiterne(@Valid Citerne ctr , BindingResult bindingResult,
			Model model, @RequestParam String action) throws IOException{
		 
		if(bindingResult.hasErrors()){
			  model.addAttribute("citernes",metier.listCiterne());
			    return"Citernes";
    }
   
		if(action=="Save")
		{
		    metier.ajouterStock(ctr);
		}else{
			
			metier.modifierStock(ctr);
					
			 }
	  
		model.addAttribute("citerne",new Citerne());
	    model.addAttribute("citernes",metier.listCiterne());
	    return"Citernes";
	    }
	
	
	@RequestMapping(value="/suppCiterne")
	public String supp(Model model, String code){
		metier.supprimerStock(code);
		model.addAttribute("citerne",new Citerne());
	    model.addAttribute("citernes",metier.listCiterne());
	    return"Citernes";
	}

	@RequestMapping(value="/editCiterne")
	public String edit(Model model, String code){
	    Citerne c = (Citerne) metier.getStock(code);
	    model.addAttribute("citerne",c);
	    model.addAttribute("citernes",metier.listCiterne());
	    return"Citernes";	    
	    }

    		
	public ModelAndView resolveException(HttpServletRequest request, 
			                             HttpServletResponse response, Object arg2,Exception ex) {
     
		ModelAndView mv = new ModelAndView();
		mv.addObject("citerne", new Citerne());
		mv.addObject("citernes",metier.listCiterne());
        mv.addObject("exception",ex.getMessage());
        mv.setViewName("Citernes");
		return mv;
	}
	/********************Affichage*******************/
	
	@RequestMapping(value="/citerneRechercher")
	public String indexsearch(Model model ,CiterneForm C,BindingResult bindingResult ){
		
		if(bindingResult.hasErrors()){
			return "ListCiternes";
		}		
		List<Citerne> lc =metier.RechByName(C.getCodeStock());
		C.setCiterneByName(lc);
	    model.addAttribute("cit",metier.RechByName(C.getCodeStock()));
	    
	    model.addAttribute("ctrn",new CiterneForm());
	    return"ListCiternes";
	}
	
	//pagination
	@RequestMapping(value="/ALLCiterne")
    public String charger( CiterneForm ct,
    		BindingResult bindingResult ,Model model){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("citern",ct);
			model.addAttribute("ctrn",new CiterneForm());
			return "ListCiternes";
		}
		
		chargerCieterne(ct);
		model.addAttribute("citern",ct);
		model.addAttribute("ctrn",new CiterneForm());
		return "ListCiternes";
	}
	
	
	
	public void chargerCieterne(CiterneForm ct){
		try {

			int pos=ct.getNbLigne()*ct.getPage();
			
			List<Citerne> cts=metier.consulterCiterne(pos,ct.getNbLigne());
		
			ct.setCtrns(cts);
			long nbC=metier.getNombreCiterne();
			ct.setNombrePages((int)(nbC/ct.getNbLigne()+1));
			
		} catch (Exception e) {
			
		ct.setException(e.getMessage());	
		}
}
	/***************************Cuve*************************************/
	
	@RequestMapping(value="/indexv")
	public String indexcv(Model model){
		model.addAttribute("cuve",new CuveOlives());
	    model.addAttribute("cuves",metier.listCuve());
	    return"Cuves";
	}
	
	@RequestMapping(value="/saveCuve")
	public String saveCiterne(@Valid CuveOlives ctr , BindingResult bindingResult,
			Model model, @RequestParam String action) throws IOException{
		 
		if(bindingResult.hasErrors()){
			  model.addAttribute("cuves",metier.listCiterne());
			    return"Cuves";
    }
   
		try {
			if(action=="Save")
			{
			    metier.ajouterStock(ctr);
			}else{
				
				metier.modifierStock(ctr);
						
				 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("cuve",new CuveOlives());
	    model.addAttribute("cuves",metier.listCuve());
	    return"Cuves";
	    }
	
	
	@RequestMapping(value="/suppCuve")
	public String suppcv(Model model, String code){
		metier.supprimerStock(code);
		model.addAttribute("cuve",new CuveOlives());
	    model.addAttribute("cuves",metier.listCuve());
	    return"Cuves";
	}

	@RequestMapping(value="/editCuve")
	public String editcv(Model model, String code){
	    CuveOlives v = (CuveOlives) metier.getStock(code);
	    model.addAttribute("cuve",v);
	    model.addAttribute("cuves",metier.listCuve());
	    return"Cuves";	    
	    }
	
	public ModelAndView resolveExceptione(HttpServletRequest request, 
            HttpServletResponse response, Object arg2,Exception ex) {

    ModelAndView mv = new ModelAndView();
    mv.addObject("cuve", new CuveOlives());
    mv.addObject("cuves",metier.listCuve());
    mv.addObject("exception",ex.getMessage());
    mv.setViewName("Cuves");
    return mv;
}

	/********************Affichage*******************/
	
	@RequestMapping(value="/cuveRechercher")
	public String indexsearchc(Model model ,CuveForm C,BindingResult bindingResult ){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("cv",metier.RechCuveByName(C.getCodeStock()));
		    model.addAttribute("cuver",new CuveForm());
		    
			return "ListCuve";
		}		
		
		List<CuveOlives>lcuve=metier.RechCuveByName(C.getCodeStock());
		C.setRechCuveByName(lcuve);
		
		
	    model.addAttribute("cv",lcuve);
	    model.addAttribute("cuver",new CuveForm());
	    return"ListCuve";
	}
	
	//pagination
	@RequestMapping(value="/ALLCuve")
    public String chargerc( CuveForm ct,
    		BindingResult bindingResult ,Model model){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("cve",ct);
			model.addAttribute("cuver",new CuveForm());

			return "ListCuve";
		}
		
		chargerCuve(ct);
		model.addAttribute("cve",ct);
		model.addAttribute("cuver",new CuveForm());
	
		return "ListCuve";
	}
	
	
	
	public void chargerCuve(CuveForm ct){
		try {

			int pos=ct.getNbLigne()*ct.getPage();
			
			List<CuveOlives> cts=metier.consulterCuve(pos,ct.getNbLigne());
		
			ct.setListcuve(cts);
			long nbR=metier.getNombreCuve();
			ct.setNombrePages((int)(nbR/ct.getNbLigne()+1));
			
		} catch (Exception e) {
		ct.setException(e.getMessage());	
		}
}
	
	
	/*******************************************Gerer Stock*********************************************************/



//Citerne





	@RequestMapping(value="/indexhuile")
	public String indexajthuile(Model model){
		model.addAttribute("citrne",new CiterneForm());
	    model.addAttribute("Lcs",metier.listCiterne());
	    model.addAttribute("cuv",new CuveForm());
	    model.addAttribute("Lcuves",metier.listCuve());
	    model.addAttribute("cuves",new CuveForm());
	    return"gererStock";
	}




	@RequestMapping(value="/AjouterHuile")
	public String AjouterHuile(@Valid CiterneForm ctr , BindingResult bindingResult,
			Model model) throws IOException{
		 
		if(bindingResult.hasErrors()){
		    model.addAttribute("Lcs",metier.listCiterne());
		    model.addAttribute("Lcuves",metier.listCuve());
		    return"gererStock";
		}
   	   
		metier.AjouteHuile(ctr.getCodeStock(), ctr.getQuantiterAjtHuile());
		
		model.addAttribute("citrne",new CiterneForm());
	    model.addAttribute("Lcs",metier.listCiterne());
	    model.addAttribute("cuv",new CuveForm());
	    model.addAttribute("Lcuves",metier.listCuve());
	    model.addAttribute("cuves",new CuveForm());
	    return"gererStock";
	}


	@RequestMapping(value="/RetirerOlive")
	public String RetirerOlive(@Valid CuveForm cv , BindingResult bindingResult,
			Model model) throws IOException{
		 
		if(bindingResult.hasErrors()){
		    model.addAttribute("Lcs",metier.listCiterne());
		    model.addAttribute("Lcuves",metier.listCuve());
		    return"gererStock";
		}
   	   metier.RetirerOlive(cv.getCodeStock(), cv.getQuantiterRtrOlive());
   	   
		model.addAttribute("citrne",new CiterneForm());
	    model.addAttribute("Lcs",metier.listCiterne());
	    model.addAttribute("cuv",new CuveForm());
	    model.addAttribute("Lcuves",metier.listCuve());
	    model.addAttribute("cuves",new CuveForm());
	    return"gererStock";
	}



	@RequestMapping(value="/viderCuve")
	public String ViderCuve(@Valid CuveForm cv , BindingResult bindingResult,
			Model model) throws IOException{
		 
		if(bindingResult.hasErrors()){
		    model.addAttribute("Lcs",metier.listCiterne());
		    model.addAttribute("Lcuves",metier.listCuve());
		    return"gererStock";
		}
   	   
		metier.viderCuve(cv.getCodeStock());
		
		model.addAttribute("citrne",new CiterneForm());
	    model.addAttribute("Lcs",metier.listCiterne());
	    model.addAttribute("cuv",new CuveForm());
	    model.addAttribute("Lcuves",metier.listCuve());
	    model.addAttribute("cuves",new CuveForm());
	    return"gererStock";
	}







}
