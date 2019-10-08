package org.sid.web;

import org.sid.dao.UniterRechercherRepository;
import org.sid.entities.Chercheur;
import org.sid.entities.Laboratoire;
import org.sid.entities.UniteRecherche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UniterRechercheController {
	@Autowired
	private UniterRechercherRepository uniterRechRepository;




	@RequestMapping(value="/chercherUnt",method=RequestMethod.GET)
	public String acceuil (Model model,
			@RequestParam(name="mc",defaultValue="")String motCle,
			@RequestParam(name="page",defaultValue="0")int page){
		Page<UniteRecherche> pageUnt=uniterRechRepository.chercherUniteRecherche("%"+motCle+"%", 
		new PageRequest(page, 2));
		
		model.addAttribute("pageUnt", pageUnt);
		model.addAttribute("pageCourante", page);
		model.addAttribute("mc", motCle);
		int [] pages =new int [pageUnt.getTotalPages()];
		for (int i =0; i<pages.length;i++)
		{
			pages[i]=i;
		}
		model.addAttribute("pages", pages);
		return "UniterRecherche";
	}








}
