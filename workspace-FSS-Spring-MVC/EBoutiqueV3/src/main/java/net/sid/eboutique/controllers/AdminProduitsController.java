package net.sid.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sid.eboutique.entities.Categorie;
import net.sid.eboutique.entities.Produit;
import net.sid.eboutique.metier.IAdminProduitsMetier;

@Controller
@RequestMapping(value="/adminProd")
public class AdminProduitsController {

	@Autowired
	private IAdminProduitsMetier metier;
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("produit",new Produit());
	    model.addAttribute("produits",metier.listproduits());
	    model.addAttribute("categories",metier.listCategories());
	    return"produits";
	}
	
	@RequestMapping(value="/saveProd")
	public String saveProd(@Valid Produit p, BindingResult bindingResult,
			Model model,MultipartFile file	) throws IOException{
		 //file pour upload
		if(bindingResult.hasErrors()){
			model.addAttribute("categories",metier.listCategories());
			model.addAttribute("produits",metier.listproduits());
			
			return ("produits");
		}
		//ou on va stocker la photo
//s'ilya upload
		if((!file.isEmpty())){	
		// j enregistre la photo je conné le path le chemin
		//on va affciher dans un fichier pour enregistrer dans un fichier on va ecrire
		// trasferto(chemin) pour prendre le chemin(ou je stock la photo) (exple:dans le profite utilisateur)/le nom du fichier
		String Path=System.getProperty("java.io.tmpdir");//exemple de chemin
		p.setPhoto(file.getOriginalFilename());
		/****enregistrement***/
		Long idP=null;
		if(p.getIdProduit()==null)
		{
			//apres je coné l'id photo
			idP=metier.ajouterProduit(p, p.getCategorie().getIdcategorie());
			}
		else{
		metier.modifierProduit(p);
		idP=p.getIdProduit();
		 }/*********/
		// je veut le transferer vers ce chemin avec new file
		// on va donner le idproduit de sur le nom du photo il faut ajouter le produit avant de donner le idproduit au nom de photo
		file.transferTo(new File(Path+"/"+"PROD_"+idP+"_"+file.getOriginalFilename()));
		
		//dans la base de donné je veut stocker lechemin ou est ce que l'enregistrer
		} else{
			
			if(p.getIdProduit()==null)
			metier.ajouterProduit(p, p.getCategorie().getIdcategorie());
			else metier.modifierProduit(p);
			
		}
		
		model.addAttribute("produit",new Produit());
	    model.addAttribute("produits",metier.listproduits());
	    model.addAttribute("categories",metier.listCategories());
	    
	    return"produits";
	}
	
	@RequestMapping(value="/photoProd",produces=MediaType.IMAGE_JPEG_VALUE)// je veut indique que l'image jpg 
	@ResponseBody  
	public byte[] photoCat( long idProd) throws IOException{	
		Produit p=metier.getProduit(idProd);
		File f= new File(System.getProperty("java.io.tmpdir")+"/PROD_"+idProd+"_"+p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));   // pour affciher une image a prtir de la base de donnée 
	} 
	
	@RequestMapping(value="/suppProd")
	public String supp(Model model, long idProd){
		metier.supprimerProduit(idProd);
		model.addAttribute("produit",new Produit());
	    model.addAttribute("produits",metier.listproduits());
	    model.addAttribute("categories",metier.listCategories());
	    return"produits";
	}

	@RequestMapping(value="/editProd")
	public String edit(Model model, long idProd){
	    Produit p = metier.getProduit(idProd);
		model.addAttribute("produit",p);
	    model.addAttribute("produits",metier.listproduits());
	    model.addAttribute("categories",metier.listCategories());
	    return"produits";
	    }
	
}
