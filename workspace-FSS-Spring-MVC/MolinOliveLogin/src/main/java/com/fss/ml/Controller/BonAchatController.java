package com.fss.ml.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.fss.ml.entities.BonAchat;
import com.fss.ml.entities.Client;
import com.fss.ml.entities.CuveOlives;
import com.fss.ml.entities.Facture;
import com.fss.ml.entities.FournisseurOlive;
import com.fss.ml.metier.MoulinOliveMetier;
import com.fss.ml.model.BonAchatForm;
import com.fss.ml.model.FactureForm;

@Controller
@RequestMapping(value="/moulinBonAchat")
public class BonAchatController {

	
	@Autowired
	private MoulinOliveMetier metier;
	
	
	@RequestMapping(value="/indexba")
	public String indexba(Model model){
		
		model.addAttribute("ba",new BonAchat());
	    model.addAttribute("frns",metier.listFournisseurO());
	    model.addAttribute("cv",metier.listCuve());
	    model.addAttribute("bas",metier.listBA());
	    model.addAttribute("css", metier.listCaisse());

	    return"BonAchats";
	}
	@RequestMapping(value="/saveBA")
	public String saveba( @Valid BonAchat b ,  BindingResult bindingResult ,
			Model model) throws IOException{
		
		   if(bindingResult.hasErrors()){
			   model.addAttribute("bas",metier.listBA());
			    model.addAttribute("frns",metier.listFournisseurO());
			    model.addAttribute("cv",metier.listCuve());
			    model.addAttribute("css", metier.listCaisse());
			    return"BonAchats";
			        }
			
			//System.out.println(action);
			
        //         if (action=="Ajouter") {
                	 System.out.println("************************************************");	
						
						metier.ajouterBA(b, b.getCaisse().getIdCaisse(),b.getFournisseuro().getCinFourn());
						metier.AjouterOlive(b.getStocko().getCodeStock(), b.getQuantiteOL());

			System.out.println(b.getQuantiteOL()+"+++"+b.getStocko().getCodeStock());	
		
			//	} else {
				//	metier.modifierBA(b);
				//}	
    
		model.addAttribute("ba",new BonAchat());
	    model.addAttribute("bas",metier.listBA());
	    model.addAttribute("frns",metier.listFournisseurO());
	    model.addAttribute("cv",metier.listCuve());
	    model.addAttribute("css", metier.listCaisse());
	    return"BonAchats";
	    }
	
	
	@RequestMapping(value="/suppBA")
	public String suppba(Model model,Long idBA){
		metier.supprimerBA(idBA);
		model.addAttribute("ba",new BonAchat());
	    model.addAttribute("bas",metier.listBA());
	    model.addAttribute("frns",metier.listFournisseurO());
	    model.addAttribute("cv",metier.listCuve());
	    model.addAttribute("css", metier.listCaisse());

	    return"BonAchats";
	}	    
	
	
	@RequestMapping(value="/modifierBA")
	public String mdifierba( BonAchat b , BindingResult bindingResult ,
			Model model, @RequestParam String action) throws IOException{
		 
		
		if(bindingResult.hasErrors()){
			model.addAttribute("ba",new BonAchat());
		    model.addAttribute("bas",metier.listBA());
		    model.addAttribute("frns",metier.listFournisseurO());
		    model.addAttribute("cv",metier.listCuve());
		    model.addAttribute("css", metier.listCaisse());
		    return"ModifierBonAchat";
		    }
		
			System.out.println(action);
			
            	 System.out.println("************************************************");	
						
					
			System.out.println(b.getQuantiteOL()+"+++"+b.getStocko().getCodeStock());	
		
			
				metier.modifierBA(b);
			
			
			metier.AjouterOlive(b.getStocko().getCodeStock(), b.getQuantiteOL());
			metier.RetirerMoney(b.getCaisse().getIdCaisse(), b.getMontantAchat());	    
		    	
				
    
		model.addAttribute("ba",new BonAchat());
	    model.addAttribute("bas",metier.listBA());
	    model.addAttribute("frns",metier.listFournisseurO());
	    model.addAttribute("cv",metier.listCuve());
	    model.addAttribute("css", metier.listCaisse());
	    return"ModifierBonAchat";
	    }	
	
	
	
	@RequestMapping(value="/editBA")
	public String editba(Model model, Long idBA){
		
	    BonAchat B = metier.getBA(idBA);
	    metier.AjouterMoney(B.getCaisse().getIdCaisse(), B.getMontantAchat());	    
	    metier.RetirerOlive(B.getStocko().getCodeStock(), B.getQuantiteOL());
	    model.addAttribute("ba",B);
	    model.addAttribute("bas",metier.listBA());
	    model.addAttribute("frns",metier.listFournisseurO());
	    model.addAttribute("css", metier.listCaisse());
	    model.addAttribute("cv",metier.listCuve());
	    
	    return"ModifierBonAchat";	    
	    }
	
/***********************Facture pour chaque Client****************************/
	
	@RequestMapping(value="/indexfrnsbonachat")
	public String indexrsvc( Model model){

		model.addAttribute("factcl", new BonAchatForm());

		return "BonAchatFrns";
	}
	
	@RequestMapping(value="/chargerBon")
    public String charger( BonAchatForm fc,
    		BindingResult bindingResult ,Model model){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("factcl",fc);
			return "BonAchatFrns";
		}
		chargerBon(fc);
		
		model.addAttribute("factcl",fc);
		return "BonAchatFrns";
	}
	
	
	
	public void chargerBon(BonAchatForm bon){
		try {
			FournisseurOlive fo= (FournisseurOlive) metier.getFournisseur(bon.getCinFourn());
			bon.setFro(fo);
			int pos=bon.getNbLigne()*bon.getPage();
			List<BonAchat> bons=metier.consulterBon(bon.getCinFourn(),pos,bon.getNbLigne());
			bon.setListbons(bons);
			
			long nbB=metier.getNombreBonAchat(bon.getCinFourn());
			bon.setNombrePages((int)(nbB/bon.getNbLigne()+1));
			
		} catch (Exception e) {
		bon.setException(e.getMessage());	
		}
}
	


}