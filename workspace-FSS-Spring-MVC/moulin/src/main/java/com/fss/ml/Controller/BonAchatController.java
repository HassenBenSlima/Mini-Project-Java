package com.fss.ml.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.fss.ml.entities.BonAchat;
import com.fss.ml.entities.Client;
import com.fss.ml.entities.CuveOlives;
import com.fss.ml.entities.Facture;
import com.fss.ml.entities.FournisseurOlive;
import com.fss.ml.entities.Stock;
import com.fss.ml.metier.MoulinOliveMetier;
import com.fss.ml.model.BonAchatForm;
import com.fss.ml.model.FactureForm;

@Controller
@RequestMapping(value="/moulin/moulinBonAchat")
public class BonAchatController implements HandlerExceptionResolver{

	
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
	public String saveba(  BonAchat b ,  BindingResult bindingResult ,
			Model model) throws IOException{
		
		if(bindingResult.hasErrors()){
			model.addAttribute("ba",new BonAchat());
		    model.addAttribute("bas",metier.listBA());
		    model.addAttribute("frns",metier.listFournisseurO());
		    model.addAttribute("cv",metier.listCuve());
		    model.addAttribute("css", metier.listCaisse());
		    model.addAttribute("error", "ERREUR !!");

		    return"BonAchats";
		    }
			
		CuveOlives ck= (CuveOlives) metier.getStock(b.getStocko().getCodeStock());
		//System.out.println(action);
			
		System.out.println(ck.getCapacite()+"----capacité");
//			if(ck.getCapacite()<=((b.getQuantiteOL())+(ck.getQuantiteactOL()))){
				
			        	 System.out.println("************************************************");	
							
							metier.ajouterBA(b, b.getCaisse().getIdCaisse(),b.getFournisseuro().getCinFourn()
									,b.getStocko().getCodeStock());
							//metier.AjouterOlive(b.getStocko().getCodeStock(), b.getQuantiteOL());

				System.out.println(b.getQuantiteOL()+"+++"+b.getStocko().getCodeStock());	
			    
	//		}

		//	if(ck.getCapacite()>(b.getQuantiteOL()+ck.getQuantiteactOL())){
			//	model.addAttribute("error2","la quantité ajouter est superieur a la capacité de cuve");
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
	
	
	@RequestMapping(value="/modifierBA", method = RequestMethod.POST)
	public String mdifierba(  @Valid BonAchat b , BindingResult bindingResult ,
			Model model) throws IOException{
	
		if(bindingResult.hasErrors()){
			model.addAttribute("ba",new BonAchat());
		    model.addAttribute("bas",metier.listBA());
		    model.addAttribute("frns",metier.listFournisseurO());
		    model.addAttribute("cv",metier.listCuve());
		    model.addAttribute("css", metier.listCaisse());
		    model.addAttribute("error", "ERREUR !!");

		    return"ModifierBonAchat";
		    }
		
			
            System.out.println("************************************************");	
						
			System.out.println(b.getQuantiteOL()+"+++"+b.getStocko().getCodeStock());	
			
			if(qts.get(qts.size()-2).equals(qts.get(qts.size()-1))){
			
		    System.out.println("flous no9sote kahaw ya hassen");
					    
		    //metier.RetirerMoney(b.getCaisse().getIdCaisse(), b.getMontantAchat());	
			
			if(nouvelp.get(nouvelp.size()-1)-b.getMontantAchat()>=0){
			metier.RetirerMoney(b.getCaisse().getIdCaisse(), b.getMontantAchat());			
			System.out.println("1");
			model.addAttribute("error", "Enregistrer");
			}else{
				metier.RetirerMoney(b.getCaisse().getIdCaisse(), prixenc.get(prixenc.size()-1));
				System.out.println("2");
				model.addAttribute("error", "la solde est insuffisant");
			}
		
		    
		    
		    
		    metier.modifierBA(b);
		
			}else if((qts.get(qts.size()-2)>qts.get(qts.size()-1))) {
				
					//if(codestk.get(codestk.size()-1).equals(b.getStocko().getCodeStock())){
					metier.AjouterOlive(b.getStocko().getCodeStock(), b.getQuantiteOL());
					System.out.println("seulement ajouter olive");
					//}else if(codestk.get(codestk.size()-1)!=(b.getStocko().getCodeStock())) {
					//	metier.AjouterOlive(codestk.get(codestk.size()-1), qtencien.get(qtencien.size()-1));
			//			metier.AjouterOlive(b.getStocko().getCodeStock(), b.getQuantiteOL());
				//		System.out.println(" ajouter olive dans le nouvelle cuve et retirer de l'encien ");
					//}
			
					if(nouvelp.get(nouvelp.size()-1)-b.getMontantAchat()>=0){
						metier.RetirerMoney(b.getCaisse().getIdCaisse(), b.getMontantAchat());			
						System.out.println("3");
						model.addAttribute("error", "Enregistrer");
					}else{
						metier.RetirerMoney(b.getCaisse().getIdCaisse(), prixenc.get(prixenc.size()-1));
						System.out.println("4");
						model.addAttribute("error", "la solde est insuffisant");
					}
					
			//metier.RetirerMoney(b.getCaisse().getIdCaisse(), b.getMontantAchat());	
			metier.modifierBA(b);
			System.out.println("stock ietbedel w caiise tetbedel");
				
		    }
			
//			if(nouvelp.get(nouvelp.size()-1)-b.getMontantAchat()<0){
//				
//			    metier.RetirerMoney(b.getCaisse().getIdCaisse(),prixenc.get(prixenc.size()-1));
//				metier.AjouterOlive(codestk.get(codestk.size()-1), qtencien.get(qtencien.size()-1));
//			    System.out.println("hassen 7ala 3adia");
//
//			}
				
				
		    
		model.addAttribute("ba",new BonAchat());
	    model.addAttribute("bas",metier.listBA());
	    model.addAttribute("frns",metier.listFournisseurO());
	    model.addAttribute("cv",metier.listCuve());
	    model.addAttribute("css", metier.listCaisse());
	    return"ModifierBonAchat";
	    }	
	
	ArrayList<Double>encienp=new ArrayList<Double>();
	ArrayList<Double>nouvelp=new ArrayList<Double>();
	ArrayList<Double>prixenc=new ArrayList<Double>();
	
	ArrayList<Double>qts=new ArrayList<Double>();
	ArrayList<String>codestk=new ArrayList<String>();
	ArrayList<Double>qtencien=new ArrayList<Double>();

	@RequestMapping(value="/editBA")
	public String editba(Model model, Long idBA){
		
	    BonAchat B = metier.getBA(idBA);
	    qtencien.add(B.getQuantiteOL());
	    System.out.println(qtencien.get(qtencien.size()-1)+" encien quantité  du stock");
	    
	    
	    codestk.add(B.getStocko().getCodeStock());
	    System.out.println(codestk.get(codestk.size()-1)+" encien code du stock");
	    System.out.println(B.getCaisse().getSolde()+" encien solde caisse");
	    encienp.add(B.getCaisse().getSolde());
	  
	    System.out.println(encienp.get(encienp.size()-1)+" encien solde caisse dans la liste");
	  	prixenc.add(B.getMontantAchat());
		System.out.println(prixenc.get(prixenc.size()-1)+" encien prix  dans la liste");
	    CuveOlives cuv=(CuveOlives) metier.getStock(B.getStocko().getCodeStock());
	   
	    
	    
	    qts.add(cuv.getQuantiteactOL());
	   
	    System.out.println(qts.get(qts.size()-1)+" encien Stock");
	    
	    
	    metier.AjouterMoney(B.getCaisse().getIdCaisse(), B.getMontantAchat());	    
	    System.out.println(B.getCaisse().getSolde()+B.getMontantAchat()+"  solde caisse apres click");
	    nouvelp.add(B.getCaisse().getSolde()+B.getMontantAchat());
		System.out.println(nouvelp.get(nouvelp.size()-1)+"  nouvelle solde caisse apres click list");
	    
	    
	    
	    metier.RetirerOlive(B.getStocko().getCodeStock(), B.getQuantiteOL());
	    
	    if(cuv.getQuantiteactOL()-B.getQuantiteOL()>=0){
	    	    qts.add(cuv.getQuantiteactOL()-B.getQuantiteOL());
	    System.out.println(qts.get(qts.size()-1)+" nouvel Stock moins");
	   
	    
	    }else{
	    		    	qts.add(cuv.getQuantiteactOL());
		    System.out.println(qts.get(qts.size()-1)+" nouvel Stock la meme");
		    
		        
	    }
	    
	    System.out.println(qts.get(qts.size()-2)+" encien Stock"+"/"+qts.get(qts.size()-1)+" nouvel Stock");
	   
	    
	    
	    
	    
	    model.addAttribute("ba",B);
	    model.addAttribute("bas",metier.listBA());
	    model.addAttribute("frns",metier.listFournisseurO());
	    model.addAttribute("css", metier.listCaisse());
	    model.addAttribute("cv",metier.listCuve());
	    return"ModifierBonAchat";	    
	    }
	
	public ModelAndView resolveException(HttpServletRequest request, 
            HttpServletResponse response, Object arg2,Exception ex) {

ModelAndView mv = new ModelAndView();
mv.addObject("ba", new BonAchat());
mv.addObject("bas",metier.listBA());
mv.addObject("frns",metier.listFournisseurO());
mv.addObject("css", metier.listCaisse());
mv.addObject("cv",metier.listCuve());

mv.addObject("exception",ex.getMessage());
mv.setViewName("BonAchats");
return mv;
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