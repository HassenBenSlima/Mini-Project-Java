package net.sid.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import net.sid.eboutique.entities.Categorie;
import net.sid.eboutique.metier.IAdminCategoriesMetier;
               // implementé une interface pour la gestion des exceptions HandlerExceptionResolver qui va obligé moi de redefinir une methode 
@Controller
@RequestMapping(value="/adminCat")//c est a dire on suppose que tous les lien pour allez vers gestion commance par adminCat--et facilté le travalle pour spring sucurité
// @SessionAttributes("editedCat")
public class AdminCategoriesController implements HandlerExceptionResolver {
//appeler couche metier via l'interface IAdmineCategoriesMetier
	
	@Autowired //on va demander a spring de recherche au moment de demarrage de rechercher un objet aui implement cette interface et l'associer  
	private IAdminCategoriesMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("categorie",new Categorie());//c'est pour la saisir d'une categorie
		//on meme temp j'ai besion d'affciher toute les categories
		model.addAttribute("categories",metier.listCategories());
		return"categories";//le nom de la page
	}
	
	@RequestMapping(value="/saveCat")//@Valid POUR INDIQUE QUE LA VALIDATION DE LA CATEGORIE doit etre faite
	public String saveCat(@Valid Categorie c, BindingResult bindingResult,
			Model model,MultipartFile file	) throws IOException{
		 
		if(bindingResult.hasErrors()){
			model.addAttribute("categories",metier.listCategories());
			 return ("categories");
		}
		
		if((!file.isEmpty())){
			//pour verifier c'st un vrai image// je veut lire l'image apartir de file.getIntputStream
			BufferedImage bi=ImageIO.read(file.getInputStream());//j'ai recuper la photo dans la base de doonner//c'est la photo qu'on va telecharger; lire la photo avec image intput,output
		
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());//il nya pas dans la formulaire ,on va recupérer le nom de la photo dans file.getOriginalFilename 
		} 
		
		// pour tester le modier et l'ajout // pour ne pas ajouter une nouvelle produit lors de la clic sur save
		if(c.getIdcategorie()!=null ){
			/**************/
			//if(model.asMap().get("editedCat")!=null){//on va prendere la photo qui existe dans la model  
				//Categorie cat=(Categorie) model.asMap().get("editedCat");// on va prend tous les attribut de la sessionAtribute
				//c.setPhoto(cat.getPhoto());// on va prend seulement la photo
			//}
			//-charger la photo pour reste lors de l'editer -s'il est null la categorie on va la rechercher a partir de la metier
		/******/
		if(file.isEmpty()){
		Categorie cat = metier.getCategorie(c.getIdcategorie());
		
		c.setPhoto(cat.getPhoto());
		}
		/****/
		metier.modifierCategorie(c);
		}
		else {// on va ajouter
		metier.ajouterCategorie(c);//ajouter categorie
		}
		model.addAttribute("categorie",new Categorie());//c'est pour la saisir d'une categorie
		//on meme temp j'ai besion d'affciher toute les categories
		model.addAttribute("categories",metier.listCategories());
		return"categories";//le nom de la page
	}
	
	  // on utilise produces pour indique que ce ne return pas  une text , je veut indique de comme quoi c'est une image jpg  
	@RequestMapping(value="/photoCat",produces=MediaType.IMAGE_JPEG_VALUE)// je veut indique que l'image jpg 
	@ResponseBody //la reponce il va etre envoyer dans le core de la reponce  http 
	public byte[] photoCat( long idCat) throws IOException{
		
		Categorie c=metier.getCategorie(idCat);
		// je recupere la photo c'est tableau de byte apres il va le  metre dans un stream et apres il va envoyer a celui qui a demandé
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));   // pour affciher une image a prtir de la base de donnée 
		// on va utilisé la class (ToByteArray)= lire les données a partir d' un straeme (new ByeteArrayIntStream(c.getphoto)
	} 
	
	@RequestMapping(value="/suppCat")
	public String supp(Model model, long idCat){
		
	metier.supprimerCategrorie(idCat);
		model.addAttribute("categorie",new Categorie());//c'est pour la saisir d'une categorie
		//on meme temp j'ai besion d'affciher toute les categories
		model.addAttribute("categories",metier.listCategories());
		return"categories";//le nom de la page
	}
	
	@RequestMapping(value="/editCat")
	public String edit(Model model, long idCat){
		Categorie c =metier.getCategorie(idCat);
		// (sa pour reload image dans la formulaire pour ne perte pas l'image lors de la modification)quant j ai edite une categorie je veut placerdans la session
        //model.addAttribute("editedCat", c); ca pour  l'utilisation de la sessionAttribut
		model.addAttribute("categorie",c);//c'est pour la saisir d'une categorie
		//on meme temp j'ai besion d'affciher toute les categories
		model.addAttribute("categories",metier.listCategories());
		return"categories";//le nom de la page
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, 
			                             HttpServletResponse response, Object arg2,Exception ex) {
     
		//senario: il ya l'exception generer il revient a la vue il trouve que dans la model vous ituliser un formulaire
		ModelAndView mv = new ModelAndView();
		//pour ajouter  ala vue il fuat ajouter un attribut
		mv.addObject("categorie", new Categorie());
		mv.addObject("categories",metier.listCategories());
        mv.addObject("exception",ex.getMessage());
        mv.setViewName("categories");
		return mv;
	}
	 

	
}
