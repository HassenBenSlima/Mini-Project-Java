package org.isie.web;

import org.isie.dao.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaxeController {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@RequestMapping(value="/entreprise",method=RequestMethod.GET)
	public String index(){
		
		
		
		
		return"entreprises";
	}




}
