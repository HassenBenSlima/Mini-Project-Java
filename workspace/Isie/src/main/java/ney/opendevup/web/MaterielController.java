package ney.opendevup.web;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import ney.opendevup.dao.MaterielRepository;
import ney.opendevup.entities.Impriment;
import ney.opendevup.entities.Materiel;

@Controller
public class MaterielController  implements HandlerExceptionResolver{

	@Autowired
	private MaterielRepository materielRepository;
	
	@RequestMapping(value="/formImprimente",method=RequestMethod.GET)
	public String formEtudiant(Model model){
		model.addAttribute("imprimente", new Impriment());
		return "AjouterImp";
	}
	
	@RequestMapping(value="/SaveImprimente",method=RequestMethod.POST)
	public String Save(Model model,@Valid @ModelAttribute("imprimente")Impriment imprimente,
			BindingResult bindingResult){

		
		Materiel impr=materielRepository.findOne(imprimente.getReference());
		
		if(bindingResult.hasErrors()){
					if (impr!=null)
					model.addAttribute("ext","Exist");
					model.addAttribute("imprimente",imprimente);
					return "AjouterImp";
					}
		
		materielRepository.save(imprimente);
	
			model.addAttribute("imprimente",imprimente);
			return "AjouterImp";
	
		}
	
	@ExceptionHandler(EntityExistsException.class)
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("imprimente", new Impriment());
        mv.addObject("e",ex.getMessage());
        mv.addObject("ext","Exist");

        mv.setViewName("AjouterImp");
		return mv;		
	}

}

