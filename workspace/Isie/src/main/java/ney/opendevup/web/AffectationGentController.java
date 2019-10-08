package ney.opendevup.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import ney.opendevup.dao.EndroidRepository;
import ney.opendevup.dao.GensRepository;
import ney.opendevup.dao.ManicipaliteRepository;
import ney.opendevup.entities.Gens;

@Controller
public class AffectationGentController implements HandlerExceptionResolver {
	
	@Autowired
	private GensRepository gensRepository;
	@Autowired
	private EndroidRepository endroidRepository;
	@Autowired
	private ManicipaliteRepository manicipaliteRepository;
	
	@RequestMapping(value="/affectation",method=RequestMethod.GET)
	public String affectation (Model model,
			@RequestParam(name="listemanicipalite",defaultValue="")Long idmanicipalite){
		
		model.addAttribute("allmanicipalite",manicipaliteRepository.findAll());
		model.addAttribute("allgens",gensRepository.chercherGensByManicipalité(idmanicipalite));
		model.addAttribute("allEndroit",endroidRepository.chercherEndroitByManicipalite(idmanicipalite));
		model.addAttribute("Currentmanicipalit",manicipaliteRepository.findOne(idmanicipalite));
		
		return "AffectationGens";
	}
	
/*	@RequestMapping(value="/ajaxController",method=RequestMethod.GET)
	public @ResponseBody Long SendWithAjax (Model model,
			@RequestParam(name="listemanicipalite",defaultValue="1")Long idmanicipalite) {
		
		System.out.println(idmanicipalite);
		model.addAttribute("allmanicipalite",manicipaliteRepository.findAll());
		model.addAttribute("allgens",gensRepository.chercherGensByManicipalité(idmanicipalite));
		model.addAttribute("allEndroit",endroidRepository.chercherEndroitByManicipalite(idmanicipalite));
		return idmanicipalite;
	}*/
	
	@RequestMapping(value="/SaveAffectation",method=RequestMethod.POST)
	public String SaveAffectation (Model model,	
			@RequestParam(name="dateAff") String date,
			@RequestParam(name="poste") String poste,
			@RequestParam(name="listemanicipalite",defaultValue="1")Long idmanicipalite,
			@RequestParam(name="listeGens")ArrayList<Gens> listeGens,		
			@RequestParam(name="listeEndoit",defaultValue="1")Long idEndoit ) throws Exception{
		
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.parse(date));	
		System.out.println(idmanicipalite);	
		System.out.println(idEndoit);	
		System.out.println(poste);	
		listeGens.forEach(g->System.out.println(g.getCin()));
		
		
		model.addAttribute("allmanicipalite",manicipaliteRepository.findAll());
		model.addAttribute("allgens",gensRepository.chercherGensByManicipalité(idmanicipalite));
		model.addAttribute("allEndroit",endroidRepository.chercherEndroitByManicipalite(idmanicipalite));
		model.addAttribute("Currentmanicipalit",manicipaliteRepository.findOne(idmanicipalite));
		return "AffectationGens";
	}
@ExceptionHandler
@Override
public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, 
		Object arg2, Exception ex) {
	ModelAndView mv = new ModelAndView();
    mv.addObject("e",ex.getMessage());
    mv.addObject("allmanicipalite",manicipaliteRepository.findAll());
    mv.addObject("allgens",gensRepository.chercherGensByManicipalité(1L));
    mv.addObject("allEndroit",endroidRepository.chercherEndroitByManicipalite(1L));
    mv.addObject("Currentmanicipalit",manicipaliteRepository.findOne(1L));
	
    mv.setViewName("AffectationGens");
	return mv;	
	}
	
	
}
