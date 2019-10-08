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
import com.fss.ml.entities.Employe;
import com.fss.ml.metier.MoulinOliveMetier;
import com.fss.ml.model.BonAchatForm;
import com.fss.ml.model.EmployerForm;

@Controller
@RequestMapping(value="/moulinEmployer")
public class EmployerController {
	   
	@Autowired
		private MoulinOliveMetier metier;
		
	
	@RequestMapping(value="/indexe")
	public String indexe(Model model){
		model.addAttribute("employe",new Employe());
	    model.addAttribute("employes",metier.listEmploye());
	    return"Employes";
	}
	
	@RequestMapping(value="/saveEmploye")
	public String saveEmploye(@Valid Employe e , BindingResult bindingResult,
			Model model	,@RequestParam String action) throws IOException{
		 
		if(bindingResult.hasErrors()){
			model.addAttribute("Employes",metier.listEmploye());	
			return ("Employes");
		}

		if (action=="Save")
		{metier.ajouterEmploye(e);
		}else{   
			
		    metier.modifierEmploye(e);		
		}
		
		model.addAttribute("employe",new Employe());
	    model.addAttribute("employes",metier.listEmploye());
	    
	    return"Employes";
	}
	
	@RequestMapping(value="/employerlist")
	public String indexlist(Model model){
		
	    model.addAttribute("employes",metier.listEmploye());
	    return"ListEmployer";
	}
	
//	@RequestMapping(value="/employerRechercher")
//	public String indexsearch(Model model ,@RequestParam Long cinEmp){
//		
//		Employe e= metier.getEmploye(cinEmp);
//	    model.addAttribute("em",e);
//	    
//	    return"ListEmployer";
//	}
//	
	
	@RequestMapping(value="/suppEmploye")
	public String suppe(Model model, long cinEmp){
		metier.supprimerEmploye(cinEmp);
		model.addAttribute("employe",new Employe());
	    model.addAttribute("employes",metier.listEmploye());
	    return"Employes";
	}

	@RequestMapping(value="/editEmploye")
	public String edite(Model model, long cinEmp){
	    Employe e = metier.getEmploye(cinEmp);
	    model.addAttribute("employe",e);
	    model.addAttribute("employes",metier.listEmploye());
        return"Employes";
	    }
	
	public ModelAndView resolveException(HttpServletRequest request, 
            HttpServletResponse response, Object arg2,Exception ex) {

ModelAndView mv = new ModelAndView();
mv.addObject("employe", new Employe());
mv.addObject("employes",metier.listEmploye());
mv.addObject("exception",ex.getMessage());
mv.setViewName("Employes");
return mv;
}
	
/********************Affichage*******************/
	
	@RequestMapping(value="/indexemploye")
	public String indexemp( Model model){

	    model.addAttribute("emplo",new EmployerForm());

		return "ListEmployer";
	}
	
	@RequestMapping(value="/emplRechercher")
	public String indexsearch(Model model ,EmployerForm E,BindingResult bindingResult ){
		
		if(bindingResult.hasErrors()){
		    model.addAttribute("ep",E);
		    model.addAttribute("emplo",new EmployerForm());

			return "ListEmployer";
		}		
		
		try {
			Employe empl=  metier.getEmploye(E.getCinEmp());
			if(empl !=null)
			{
			E.setEmploy(empl);
			}
			
			} catch (Exception e) {
			E.setException(e.getMessage());	
		}
	    
	    model.addAttribute("ep",E);
	    model.addAttribute("emplo",new EmployerForm());
	    return"ListEmployer";
	}
	
	//pagination
	@RequestMapping(value="/ALLEmp")
    public String charger( EmployerForm E,
    		BindingResult bindingResult ,Model model){
		
		if(bindingResult.hasErrors()){
			return "ListEmployer";
		}
		
		chargerEmpl(E);
		
		model.addAttribute("ep",E);
	    model.addAttribute("emplo",new EmployerForm());
	    
		return "ListEmployer";
	}
	
	
	
	public void chargerEmpl(EmployerForm ep){
		try {

			int pos=ep.getNbLigne()*ep.getPage();
			
			List<Employe> Lemp=metier.consulterEmploye(pos,ep.getNbLigne());
		
			ep.setEmpll(Lemp);
			
			long nbR=metier.getNombreEmployer();
			ep.setNombrePages((int)(nbR/ep.getNbLigne()+1));
			
		} catch (Exception e) {
		ep.setException(e.getMessage());	
		}
}
	
	
	
}
