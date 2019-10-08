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
import ney.opendevup.entities.Flash;
import ney.opendevup.entities.Materiel;

@Controller
public class FlashController  implements HandlerExceptionResolver {

	@Autowired
	private MaterielRepository materielRepository;
	
	@RequestMapping(value="/formFlash",method=RequestMethod.GET)
	public String formEtudiant(Model model){
		model.addAttribute("flash", new Flash());
		return "AjouterFlash";
	}
	
	@RequestMapping(value="/SaveFlash",method=RequestMethod.POST)
	public String Save(Model model,@Valid @ModelAttribute("flash")Flash flash,
			BindingResult bindingResult){

		
		Materiel impr=materielRepository.findOne(flash.getReference());
		
		if(bindingResult.hasErrors()){
					if (impr!=null)
					model.addAttribute("ext","Exist");
					model.addAttribute("flash",flash);
					return "AjouterFlash";
					}
		
		materielRepository.save(flash);
	
			model.addAttribute("flash",flash);
			model.addAttribute("ext","Enregistrer");

			return "AjouterFlash";
	
		}

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("tablette", new Flash());
        mv.addObject("e",ex.getMessage());
        mv.addObject("ext","Exist");

        mv.setViewName("AjouterFlash");
		return null;
	}
	
			

}

