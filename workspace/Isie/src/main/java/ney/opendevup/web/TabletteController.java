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
import ney.opendevup.entities.Materiel;
import ney.opendevup.entities.Tablette;

@Controller
public class TabletteController implements HandlerExceptionResolver {

	@Autowired
	private MaterielRepository materielRepository;
	
	@RequestMapping(value="/formTablette",method=RequestMethod.GET)
	public String formEtudiant(Model model){
		model.addAttribute("tablette", new Tablette());
		return "AjouterTablette";
	}
	
	@RequestMapping(value="/SaveTablette",method=RequestMethod.POST)
	public String Save(Model model,@Valid @ModelAttribute("tablette")Tablette tablette,
			BindingResult bindingResult){

		
		Materiel impr=materielRepository.findOne(tablette.getReference());
		
		if(bindingResult.hasErrors()){
					if (impr!=null)
					model.addAttribute("ext","Exist");
					model.addAttribute("tablette",tablette);
					return "AjouterTablette";
					}
		
			materielRepository.save(tablette);
	
			model.addAttribute("tablette",tablette);
			model.addAttribute("ext","Enregistrer");

			return "AjouterTablette";
	
		}

	@ExceptionHandler(EntityExistsException.class)
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("tablette", new Tablette());
        mv.addObject("e",ex.getMessage());
        mv.addObject("ext","Exist");

        mv.setViewName("AjouterTablette");
		return mv;		
	}
	


}

