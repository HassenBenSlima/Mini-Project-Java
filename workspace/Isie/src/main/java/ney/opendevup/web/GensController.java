package ney.opendevup.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ney.opendevup.dao.GensRepository;
import ney.opendevup.dao.ManicipaliteRepository;
import ney.opendevup.entities.Gens;

@Controller
public class GensController{
		
		@Autowired
		private GensRepository gensRepository;
		
		@Autowired
		private ManicipaliteRepository manicipaliteRepository;
		
		@Autowired
		private TypeRepository typeRepository;
		
		@RequestMapping(value="/Index")
		public String Index( Model model ,@RequestParam(name="page", defaultValue="0") int p
				,@RequestParam(name="motCle", defaultValue="") String  mc)
		{
			System.out.println(mc+"--------");
			Page<Gens> pageGens=gensRepository.chercherGensByCin("%"+mc+"%",
					new PageRequest(p, 5));
			
			int pageCount =	pageGens.getTotalPages();
			
			int [] pages =new int [pageCount];
			for (int i=0;i<pageCount;i++) pages[i]=i;
			
			model.addAttribute("pages", pages);
			model.addAttribute("pageCourante", p);
			model.addAttribute("pageGens", pageGens);
			model.addAttribute("motCle", mc);
			return "suivieGens";
		}	
		
		@RequestMapping(value="/formgens",method=RequestMethod.GET)
		public String formEtudiant(Model model){
			model.addAttribute("gts", new Gens());
			model.addAttribute("mpt",manicipaliteRepository.findAll());
			model.addAttribute("typs",typeRepository.findAll() );

			return "AjouterGent";
		}
		
		@RequestMapping(value="/Savegent",method=RequestMethod.POST)
		public String Save(Model model,@Valid @ModelAttribute("gts")Gens gts,
				BindingResult bindingResult){

			
			Gens g=gensRepository.findOne(gts.getCin());
			if (g!=null)
			{	model.addAttribute("ext","Existe");
				model.addAttribute("gts",gts);
				model.addAttribute("mpt",manicipaliteRepository.findAll());
				model.addAttribute("typs",typeRepository.findAll() );

				return "AjouterGent";
			}
			System.out.println("1");
			if(bindingResult.hasErrors()){
				System.out.println("2");
			//	model.addAttribute("gts",gts);
				model.addAttribute("mpt",manicipaliteRepository.findAll());
				model.addAttribute("typs",typeRepository.findAll() );

				return "AjouterGent";
						}
			gensRepository.save(gts);
		
				model.addAttribute("gts",gts);
				model.addAttribute("mpt",manicipaliteRepository.findAll());
				model.addAttribute("typs",typeRepository.findAll() );

				model.addAttribute("ext","Enregistrer");
				return "AjouterGent";
		
			}
		
		@RequestMapping(value="/supprimer")
		public String supprimer(Long id){
			gensRepository.delete(id);
			return "redirect:Index";	
			
		}

		@RequestMapping(value="/edit")
		public String edit(Long id,Model model){
			Gens gts = gensRepository.getOne(id);
			model.addAttribute("gts",gts);
			model.addAttribute("mpt",manicipaliteRepository.findAll());
			model.addAttribute("typs",typeRepository.findAll() );
			
			model.addAttribute("c",id);
			return "EditGent";		
		}
		
		@RequestMapping(value="/UpdateGent",method=RequestMethod.POST)
		public String update(Model model,@Valid @ModelAttribute("gts")Gens gts,
				BindingResult bindingResult,
				@RequestParam(name="cinp") Long c){
			System.out.println(c);
			
			Gens g=gensRepository.findOne(gts.getCin());
			

			if(gts.getCin().equals(c) ){
				System.out.println("1");
				
				gensRepository.delete(c);
				gensRepository.save(gts);
				}
			
			if(!(gts.getCin().equals(c)) ){
				System.out.println("2");
				if (g!=null)
				{
					System.out.println("3");
					
				model.addAttribute("ext","Existe");
				model.addAttribute("gts",gts);
				model.addAttribute("mpt",manicipaliteRepository.findAll());
				model.addAttribute("typs",typeRepository.findAll() );
				return "EditGent";
				} 
				gensRepository.delete(c);
				
				gensRepository.save(gts);
			}
			
			System.out.println("4");
			
			if(bindingResult.hasErrors()){
				System.out.println("5");
			//	model.addAttribute("gts",gts);
						return "EditGent";
						}
			
		
				model.addAttribute("gts",gts);
				model.addAttribute("mpt",manicipaliteRepository.findAll());
				model.addAttribute("typs",typeRepository.findAll() );
				model.addAttribute("ext","Enregistrer");
				return "EditGent";
		
			}


		 @ExceptionHandler
		 public String HandlerNullValueInNestedPathException (Exception e,Model model){
			 
			System.out.println("exception by "+e);
			
			model.addAttribute("gts",new Gens());
			model.addAttribute("mpt",manicipaliteRepository.findAll());
			model.addAttribute("typs",typeRepository.findAll() );
 
			return "AjouterGent";
			 
		 }
		
		
		
				}
