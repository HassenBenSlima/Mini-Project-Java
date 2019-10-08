package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.LaboratoireRepository;
import org.sid.entities.Laboratoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LaboratoireController {
	@Autowired
	private LaboratoireRepository laboratoireRepository;
	
	
	
	@RequestMapping(value="/chercherLab",method=RequestMethod.GET)
	public String acceuil (Model model,
			@RequestParam(name="mc",defaultValue="")String motCle,
			@RequestParam(name="page",defaultValue="0")int page){
		Page<Laboratoire> pagelab=laboratoireRepository.chercherLabo("%"+motCle+"%", 
		new PageRequest(page, 2));
		
		model.addAttribute("pagelab", pagelab);
		model.addAttribute("pageCourante", page);
		model.addAttribute("mc", motCle);
		int [] pages =new int [pagelab.getTotalPages()];
		for (int i =0; i<pages.length;i++)
		{
			pages[i]=i;
		}
		model.addAttribute("pages", pages);
		return "Laboratoire";
	}

	
	@RequestMapping(value="/formLab")
	public String formProduit(Model model){
		model.addAttribute("laboratoire", new Laboratoire());
		return "formLaboratoire";
	}
	
	
	@RequestMapping(value="/saveLaboratoire" ,method=RequestMethod.POST)
	public String save(Model model,@Valid Laboratoire l ,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "formLaboratoire";
		}
		
		laboratoireRepository.save(l);
		model.addAttribute("laboratoire", l);
		return "confirmeLab";
	}
	
	
}
