package org.sid.web;

import java.util.List;
import javax.validation.Valid;
import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	
	/*
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String acceuil (Model model,@RequestParam(name="page")int p){
		/*List<Produit> produits=produitRepository.findAll();
		model.addAttribute("prods", produits);*/
/*		Page<Produit> pageProduits=produitRepository.findAll(new PageRequest(p, 2));
		model.addAttribute("pageProduit", pageProduits);*/
		//page courante
	/*	model.addAttribute("pageCourante", p);
		int [] pages =new int [pageProduits.getTotalPages()];
		//remplissage du tableau
		for (int i =0; i<pages.length;i++)
		{
			pages[i]=i;
		}
		model.addAttribute("pages", pages);
		return "Produits";
	}
	*/
	
	
	@RequestMapping(value="/chercher",method=RequestMethod.GET)
	public String acceuil (Model model,
			@RequestParam(name="mc",defaultValue="")String motCle,
			@RequestParam(name="page",defaultValue="0")int page){
		Page<Produit> pageProduits=produitRepository.chercherProduits("%"+motCle+"%", 
		new PageRequest(page, 2));
		model.addAttribute("pageProduit", pageProduits);
		model.addAttribute("pageCourante", page);
		model.addAttribute("mc", motCle);
		int [] pages =new int [pageProduits.getTotalPages()];
		for (int i =0; i<pages.length;i++)
		{
			pages[i]=i;
		}
		model.addAttribute("pages", pages);
		return "Produits";
	}
	

	@RequestMapping(value="/form")
	public String formProduit(Model model){
		model.addAttribute("produit", new Produit());
		return "formProduit";
	}
	
	@RequestMapping(value="/saveProduit" ,method=RequestMethod.POST)
	public String save(Model model,@Valid Produit p ,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "formProduit";
		}
		
		produitRepository.save(p);
		model.addAttribute("produit", p);
		return "confirmation";
	}
	
	
}
