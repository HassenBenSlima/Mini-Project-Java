package ney.opendevup.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ney.opendevup.dao.EtudiantRepository;
import ney.opendevup.entities.Etudiant;

@Controller
@RequestMapping(value="/Etudiant")
public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Value("${dir.images}")//inject une propriété
	private String imageDir;
	
	@RequestMapping(value="/Index")
	public String Index( Model model ,@RequestParam(name="page", defaultValue="0") int p
			,@RequestParam(name="motCle", defaultValue="") String  mc)
	{
		Page<Etudiant> pageEtudiants=etudiantRepository.chercherEtudiants("%"+mc+"%",new PageRequest(p, 5));
		
		int pageCount =	pageEtudiants.getTotalPages();
		int [] pages =new int [pageCount];
		for (int i=0;i<pageCount;i++) pages[i]=i;
		
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("pageEtudiants", pageEtudiants);
		model.addAttribute("motCle", mc);

		return "etudiants";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String formEtudiant(Model model){
		model.addAttribute("etudiant", new Etudiant());
		return "FormEtudiant";
	}
	
	@RequestMapping(value="/SaveEtudiant",method=RequestMethod.POST)
	public String Save(Model model,@Valid Etudiant et,BindingResult bindingResult,
			@RequestParam(name="picture")MultipartFile file) throws Exception{
		if(bindingResult.hasErrors())
			return "FormEtudiant";
	
		
		if(!(file.isEmpty())){
			//enregistrer file dans le systeme de fichier
			et.setPhoto(file.getOriginalFilename());
			etudiantRepository.save(et);
			file.transferTo(new File(imageDir+et.getId()));
			//System.getProperty("user.home") instead imageDir;
		}
			
			model.addAttribute("etudiant",et);
		return "redirect:Index";	
	}
	
	@RequestMapping(value="/getPhoto",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody //envoyer des donnée dans le corp
	public byte[] getPhoto(Long id) throws Exception{
		File f=new File(imageDir+id);
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Long id){
		etudiantRepository.delete(id);
		return "redirect:Index";	
		
	}
	

	@RequestMapping(value="/edit")
	public String edit(Long id,Model model){
		Etudiant et = etudiantRepository.getOne(id);
		model.addAttribute("etudiant",et);
		return "EditEtudiant";		
	}
	
	@RequestMapping(value="/UpdateEtudiant",method=RequestMethod.POST)
	public String update(Model model,@Valid Etudiant et,BindingResult bindingResult,
			@RequestParam(name="picture")MultipartFile file) throws Exception{
		if(bindingResult.hasErrors())
			return "EditEtudiant";
	
		
		if(!(file.isEmpty())){
			//enregistrer file dans le systeme de fichier
			et.setPhoto(file.getOriginalFilename());
			etudiantRepository.save(et);
			file.transferTo(new File(imageDir+et.getId()));
			//System.getProperty("user.home") instead imageDir;
		}
			
			model.addAttribute("etudiant",et);
		return "redirect:Index";	
	}
	
}
