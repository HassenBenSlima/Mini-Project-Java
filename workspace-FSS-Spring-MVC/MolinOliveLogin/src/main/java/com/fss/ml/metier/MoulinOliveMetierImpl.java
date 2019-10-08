package com.fss.ml.metier;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.fss.ml.Dao.MoulinOliveDao;
import com.fss.ml.entities.BonAchat;
import com.fss.ml.entities.Caisse;
import com.fss.ml.entities.Citerne;
import com.fss.ml.entities.Client;
import com.fss.ml.entities.CuveOlives;
import com.fss.ml.entities.Employe;
import com.fss.ml.entities.Facture;
import com.fss.ml.entities.Fournisseur;
import com.fss.ml.entities.FournisseurMaintenance;
import com.fss.ml.entities.FournisseurOlive;
import com.fss.ml.entities.Maintenance;
import com.fss.ml.entities.Reservation;
import com.fss.ml.entities.Stock;


@Transactional
public class MoulinOliveMetierImpl implements MoulinOliveMetier {
    
	MoulinOliveDao dao;
	
	public void setDao(MoulinOliveDao dao) {
		this.dao = dao;
	}

	@Override
	public Client ajouterClient(Client c) {
		// TODO Auto-generated method stub
		return dao.ajouterClient(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return dao.listClient();
	}
	
	
	@Override
	public Client getClient(Long idCli) {
		// TODO Auto-generated method stub
		return dao.getClient(idCli);
	}

	@Override
	public void supprimerClient(Long idCli) {
		
		dao.supprimerClient(idCli);
	}

	@Override
	public void modifierClient(Client c) {
	dao.modifierClient(c);
		
	}
	
	
	@Override
	public List<Client> consulterClient(int position, int nbClient) {
		// TODO Auto-generated method stub
		return dao.consulterClient(position, nbClient);
	}

	@Override
	public long getNombreClient() {
		// TODO Auto-generated method stub
		return dao.getNombreClient();
	}
	
	@Override
	public List<Facture> findByCinClF(Long cinClient) {
		// TODO Auto-generated method stub
		return dao.findByCinClF(cinClient);
	}

	@Override
	public List<Reservation> findByCinClR(Long cinClient) {
		// TODO Auto-generated method stub
		return dao.findByCinClR(cinClient);
	}


/*************EMPLOYE*****************/
	@Override
	public Employe ajouterEmploye(Employe e) {

    	return dao.ajouterEmploye(e);
	}

	@Override
	public List<Employe> listEmploye() {
		return dao.listEmploye();
	}

	@Override
	public Employe getEmploye(Long idEmp) {
		return dao.getEmploye(idEmp);
	}

	@Override
	public void supprimerEmploye(Long idEmp) {

		dao.supprimerEmploye(idEmp);
	}

	@Override
	public void modifierEmploye(Employe e) {
		dao.modifierEmploye(e);
	}
	
	@Override
	public List<Employe> consulterEmploye(int position, int nbEmploye) {
		// TODO Auto-generated method stub
		return dao.consulterEmploye(position, nbEmploye);
	}

	@Override
	public long getNombreEmployer() {
		// TODO Auto-generated method stub
		return dao.getNombreEmployer();
	}
/*******************Fournisseur***********************/
	@Override
	public Fournisseur ajouterFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		return dao.ajouterFournisseur(f);
	}

	@Override
	public Fournisseur getFournisseur(Long CIN) {
		// TODO Auto-generated method stub
		return dao.getFournisseur(CIN);
	}

	@Override
	public void supprimerFournisseur(Long CIN) {
		dao.supprimerFournisseur(CIN);
	}

	@Override
	public void modifierFournisseur(Fournisseur f) {
		dao.modifierFournisseur(f);
		
	}

	@Override
	public List<FournisseurOlive> listFournisseurO() {
		// TODO Auto-generated method stub
		return dao.listFournisseurO();
	}

	@Override
	public List<FournisseurMaintenance> listFournisseurM() {
		// TODO Auto-generated method stub
		return dao.listFournisseurM();
	}

	
	@Override
	public List<FournisseurMaintenance> RnameFournisseurM(String name) {
		// TODO Auto-generated method stub
		return dao.RnameFournisseurM(name);
	}

	@Override
	public List<FournisseurOlive> RnameFournisseurO(String name) {
		// TODO Auto-generated method stub
		return dao.RnameFournisseurO(name);
	}

	@Override
	public List<FournisseurMaintenance> consulterFrnms(int position, int nbFournisseurms) {
		// TODO Auto-generated method stub
		return dao.consulterFrnms(position, nbFournisseurms);
	}

	@Override
	public long getNombreFrnms() {
		// TODO Auto-generated method stub
		return dao.getNombreFrnms();
	}

	@Override
	public List<FournisseurOlive> consulterFrnos(int position, int nbFournisseuros) {
		// TODO Auto-generated method stub
		return dao.consulterFrnos(position, nbFournisseuros);
	}

	@Override
	public long getNombreFrnos() {
		// TODO Auto-generated method stub
		return dao.getNombreFrnos();
	}

	@Override
	public List<Maintenance>findByCinFm(Long cinFm){
		// TODO Auto-generated method stub
		return dao.findByCinFm(cinFm);
	}

	@Override
	public List<BonAchat> findByCinFo(Long cinFm) {
		// TODO Auto-generated method stub
		return dao.findByCinFo(cinFm);
	}

	
	
	/*************************Caisse************************/

	@Override
	public Caisse ajouterCaisse(Caisse cs) {
		
		return dao.ajouterCaisse(cs);
	}

	@Override
	public void AjouterMoney(Long idcs, double mt) {
		Caisse ss=dao.getCaisse(idcs);
		ss.setSolde(ss.getSolde()+mt);
	}

	@Override
	public void RetirerMoney(Long idcs, double mt) {
			Caisse ss=dao.getCaisse(idcs);
			ss.setSolde(ss.getSolde()-mt);
		}

	@Override
	public Caisse getCaisse(Long idcs) {
		return dao.getCaisse(idcs);
	}
	@Override
	public List<Caisse> listCaisse() {
		// TODO Auto-generated method stub
		return dao.listCaisse();
	}
	/**************************Reservation*****************************/

	@Override
	public Reservation ajouterReservation(Reservation r, Long idCli) {
		// TODO Auto-generated method stub
		return dao.ajouterReservation(r, idCli);
	}

	@Override
	public List<Reservation> listReservation() {
		// TODO Auto-generated method stub
		return dao.listReservation();
	}

	@Override
	public Reservation getRsv(Long idRsv) {
		// TODO Auto-generated method stub
		return dao.getRsv(idRsv);
	}

	@Override
	public void supprimerRsv(Long idRsv) {
		dao.supprimerRsv(idRsv);
		
	}

	@Override
	public void modifierRsv(Reservation rsv) {
		dao.modifierRsv(rsv);
	}
	
	@Override
	public List<Reservation> consulterRsvClient(Long cinClient, int position, int nbrevervation) {
		// TODO Auto-generated method stub
		return dao.consulterRsvClient(cinClient, position, nbrevervation);
	}

	@Override
	public long getNombreRsv(Long cinClient) {
		// TODO Auto-generated method stub
		return dao.getNombreRsv(cinClient);
	}
	@Override
	public List<Reservation> RreservationD(String date) {
		// TODO Auto-generated method stub
		return dao.RreservationD(date);
	}

	@Override
	public List<Reservation> consulterReservation(int position, int nbReservation) {
		// TODO Auto-generated method stub
		return dao.consulterReservation(position, nbReservation);
	}

	@Override
	public long getNombreRsvs() {
		// TODO Auto-generated method stub
		return dao.getNombreRsvs();
	}


/********************************Stock******************************/

	@Override
	public Stock ajouterStock(Stock ctr) {
		// TODO Auto-generated method stub
		return dao.ajouterStock(ctr);
	}

	@Override
	public List<CuveOlives> listCuve() {
		// TODO Auto-generated method stub
		return dao.listCuve();
	}

	@Override
	public List<Citerne> listCiterne() {
		// TODO Auto-generated method stub
		return dao.listCiterne();
	}

	@Override
	public Stock getStock(String Code) {
		// TODO Auto-generated method stub
		return dao.getStock(Code);
	}

	@Override
	public void supprimerStock(String Code) {
		dao.supprimerStock(Code);
	}
	

	@Override
	public void modifierStock(Stock s) {
	dao.modifierStock(s);
		
	}
	@Override
	public List<Citerne> consulterCiterne(int position, int nbCiterne) {
		// TODO Auto-generated method stub
		return dao.consulterCiterne(position, nbCiterne);
	}

	@Override
	public long getNombreCiterne() {
		// TODO Auto-generated method stub
		return dao.getNombreCiterne();
	}

	@Override
	public void AjouteHuile(String code, double qtehuile) {
		Citerne ct = (Citerne) dao.getStock(code);
		ct.setQuantiteHuile(ct.getQuantiteHuile()+qtehuile);
		
	}

	@Override
	public void RetirerHuile(String code, double qteHuile) {
		Citerne ct = (Citerne) dao.getStock(code);
		ct.setQuantiteHuile(ct.getQuantiteHuile()-qteHuile);
		}

	@Override
	public void viderCuve(String code) {
		CuveOlives cuv=(CuveOlives) dao.getStock(code);
		cuv.setQuantiteactOL(0);
	}

	@Override
	public void RetirerOlive(String Code, double qteOlive) {
		CuveOlives cuv=(CuveOlives) dao.getStock(Code);
		cuv.setQuantiteactOL(cuv.getQuantiteactOL()-qteOlive);
	}

	@Override
	public void AjouterOlive(String Code, double qteOlive) {
		CuveOlives cuv=(CuveOlives) dao.getStock(Code);
		cuv.setQuantiteactOL(cuv.getQuantiteactOL()+qteOlive);
	}

	@Override
	public List<CuveOlives> consulterCuve(int position, int nbCuve) {
		// TODO Auto-generated method stub
		return dao.consulterCuve(position, nbCuve);
	}

	@Override
	public long getNombreCuve() {
		// TODO Auto-generated method stub
		return dao.getNombreCuve();
	}

	@Override
	public List<Citerne> RechByName(String CODE) {
		// TODO Auto-generated method stub
		return dao.RechByName(CODE);
	}
	
	@Override
	public List<CuveOlives> RechCuveByName(String CODE) {
		// TODO Auto-generated method stub
		return dao.RechCuveByName(CODE);
	}


/*******************BonAchat*************************/

	@Override
	public BonAchat ajouterBA(BonAchat ba, Long idcaisse, Long CinFourn) {
		// TODO Auto-generated method stub
		return dao.ajouterBA(ba, idcaisse, CinFourn);
	}
	@Override
	public List<BonAchat> listBA() {
		// TODO Auto-generated method stub
		return dao.listBA();
	}

	@Override
	public BonAchat getBA(Long idBon) {
		// TODO Auto-generated method stub
		return dao.getBA(idBon);
	}

	@Override
	public void supprimerBA(Long idBon) {
		dao.supprimerBA(idBon);
	}

	@Override
	public void modifierBA(BonAchat B) {
	dao.modifierBA(B);
	}
	@Override
	public List<BonAchat> consulterBon(Long CINFo, int position, int nbBon) {
		// TODO Auto-generated method stub
		return dao.consulterBon(CINFo, position, nbBon);
	}

	@Override
	public long getNombreBonAchat(Long CINFo) {
		// TODO Auto-generated method stub
		return dao.getNombreBonAchat(CINFo);
	}
	
	
	
	/*****************************Maintenance***********************/

@Override
public Maintenance ajouterMaintenance(Maintenance m, Long idFournm, Long Caisse) {
	// TODO Auto-generated method stub
	return dao.ajouterMaintenance(m, idFournm, Caisse);
}

@Override
public List<Maintenance> listMaintenance() {
	// TODO Auto-generated method stub
	return dao.listMaintenance();
}

@Override
public Maintenance getMaint(Long idMain) {
	// TODO Auto-generated method stub
	return dao.getMaint(idMain);
}

@Override
public void supprimerMaint(Long idMain) {
	dao.supprimerMaint(idMain);
}

@Override
public void modifierMaint(Maintenance mtn) {
	dao.modifierMaint(mtn);
}

@Override
public List<Maintenance> listMainByName(String name) {
	// TODO Auto-generated method stub
	return dao.listMainByName(name);
}

@Override
public List<Maintenance> consulterMaintenance(int position, int nbMaintenance) {
	// TODO Auto-generated method stub
	return dao.consulterMaintenance(position, nbMaintenance);
}

@Override
public long getNombreMain() {
	// TODO Auto-generated method stub
	return dao.getNombreMain();
}


/*********************Facture*************************/

@Override
public List<Facture> listFacture() {
	// TODO Auto-generated method stub
	return dao.listFacture();
}

@Override
public Facture ajouterFacture(Facture f, Long cin, Long cs) {
	// TODO Auto-generated method stub
	return dao.ajouterFacture(f, cin, cs);
}

@Override
public Facture getFacture(Long idFacture) {
	// TODO Auto-generated method stub
	return dao.getFacture(idFacture);
}

@Override
public void supprimerFacture(Long idFacture) {
	// TODO Auto-generated method stub
	dao.supprimerFacture(idFacture);
}

@Override
public void modifierFacture(Facture f) {
	// TODO Auto-generated method stub
	dao.modifierFacture(f);
}

@Override
public List<Facture> consulterFactureClient(Long cinClient, int position, int nbFacture) {
	// TODO Auto-generated method stub
	return dao.consulterFactureClient(cinClient, position, nbFacture);
}

@Override
public long getNombreFactr(Long cinClient) {
	// TODO Auto-generated method stub
	return dao.getNombreFactr(cinClient);
}
/**********************************************/














	
}
