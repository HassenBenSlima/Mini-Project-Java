package ney.opendevup.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import ney.opendevup.dao.MaterielRepository;
import ney.opendevup.entities.Materiel;
import ney.opendevup.entities.PC;

@Controller
public class PCcontroller  implements HandlerExceptionResolver{

	@Autowired
	private MaterielRepository materielRepository;
	
	@RequestMapping(value="/formPC",method=RequestMethod.GET)
	public String formEtudiant(Model model){
		model.addAttribute("pc", new PC());
		return "AjouterPC";
	}
	
	@RequestMapping(value="/SavePC",method=RequestMethod.POST)
	public String Save(Model model,@Valid @ModelAttribute("pc")PC pc,
			BindingResult bindingResult){

		
		Materiel impr=materielRepository.findOne(pc.getReference());
		
		if(bindingResult.hasErrors()){
					if (impr!=null)
					model.addAttribute("ext","Exist");
					model.addAttribute("pc",pc);
					return "AjouterPC";
					}
		
		materielRepository.save(pc);
	
			model.addAttribute("pc",pc);
			return "AjouterPC";
	
		}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("pc", new PC());
        mv.addObject("e",ex.getMessage());
        mv.addObject("ext","Exist");

        mv.setViewName("AjouterPC");
		return mv;		
	}

}

