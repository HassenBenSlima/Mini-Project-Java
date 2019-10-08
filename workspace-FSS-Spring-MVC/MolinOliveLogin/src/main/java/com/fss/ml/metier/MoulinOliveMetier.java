package com.fss.ml.metier;

import java.util.List;

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

public interface MoulinOliveMetier {

	/************Client************/
	public Client ajouterClient(Client c);
	public List<Client> listClient();
	public Client getClient(Long idCli);
	public void supprimerClient(Long idCli);
	public void modifierClient(Client c);
	public List<Client> consulterClient(int position,int nbClient);
    public long getNombreClient();
    public List<Facture>findByCinClF(Long cinClient);
	public List<Reservation>findByCinClR(Long cinClient);
	/************EMPLOYE***********/
	public Employe ajouterEmploye(Employe e);
	public List<Employe> listEmploye();
	public Employe getEmploye(Long idEmp);
	public void supprimerEmploye(Long idEmp);
	public void modifierEmploye(Employe e);
	public List<Employe> consulterEmploye(int position,int nbEmploye);
    public long getNombreEmployer();
	/************Fourmisseur***********/
	public Fournisseur ajouterFournisseur(Fournisseur f);
	public Fournisseur getFournisseur(Long CIN);
	public void supprimerFournisseur( Long CIN);
	public void modifierFournisseur(Fournisseur f);
	public List<FournisseurOlive> listFournisseurO();
	public List<FournisseurMaintenance> listFournisseurM();
	
	public List<FournisseurMaintenance> RnameFournisseurM(String name);
	public List<FournisseurOlive> RnameFournisseurO(String name);
	public List<FournisseurMaintenance> consulterFrnms(int position,int nbFournisseurms);
    public long getNombreFrnms();
    public List<FournisseurOlive> consulterFrnos(int position,int nbFournisseuros);
    public long getNombreFrnos();
    
    
	public List<Maintenance>findByCinFm(Long cinFm);
	public List<BonAchat>findByCinFo(Long cinFm);

   /**************Caisse*************/
	public Caisse ajouterCaisse(Caisse cs);
	public Caisse getCaisse(Long idcs);
	public void AjouterMoney(Long idcs ,double mt);
	public void RetirerMoney(Long idcs ,double mt);
	public List<Caisse> listCaisse();

    /**********Reservation************/
	public Reservation ajouterReservation(Reservation r, Long idCli);
	public List<Reservation> listReservation();
	public Reservation getRsv(Long idRsv);
	public void supprimerRsv(Long idRsv);
	public void modifierRsv(Reservation rsv);
	public List<Reservation> consulterRsvClient(Long cinClient,int position,int nbrevervation);
    public long getNombreRsv(Long cinClient);
    public List<Reservation> RreservationD(String date);
    public List<Reservation> consulterReservation(int position,int nbReservation);
    public long getNombreRsvs();
    
	/***************Stock*******************/
	public Stock ajouterStock(Stock ctr);
	public List<CuveOlives> listCuve();
	public List<Citerne> listCiterne();
	public Stock getStock(String Code);
	public void supprimerStock(String Code);
	public void modifierStock(Stock s);
	public List<Citerne> consulterCiterne(int position,int nbCiterne);
    public long getNombreCiterne();
    public void AjouteHuile(String code ,double qtehuile);
	public void RetirerHuile(String code ,double qteHuile);
    public void viderCuve(String code);
    public void RetirerOlive(String Code,double qteOlive);
    public void AjouterOlive(String Code,double qteOlive);
    
    public List<CuveOlives> consulterCuve(int position,int nbCuve);
    public long getNombreCuve();
    public List<Citerne> RechByName(String CODE);
    public List<CuveOlives> RechCuveByName(String CODE);

    
    /************BonAchat**************/
	public BonAchat ajouterBA(BonAchat ba, Long idcaisse,Long CinFourn);
	public List<BonAchat> listBA();
	public BonAchat getBA(Long idBon);
	public void supprimerBA(Long idBon);
	public void modifierBA(BonAchat B);
	public List<BonAchat> consulterBon(Long CINFo,int position,int nbBon);
    public long getNombreBonAchat(Long CINFo);

/****************Maintenance*******************/

		public Maintenance ajouterMaintenance(Maintenance m, Long idFournm, Long Caisse);
		public List<Maintenance> listMaintenance();
		public Maintenance getMaint(Long idMain);
		public void supprimerMaint(Long idMain);
		public void modifierMaint(Maintenance mtn);
		public List<Maintenance> listMainByName(String name);
	    public List<Maintenance> consulterMaintenance(int position,int nbMaintenance);
	    public long getNombreMain();
	    
		
/***************Facture***********************/		
		public List<Facture> listFacture();
    	public Facture ajouterFacture(Facture f, Long cin, Long cs);
    	public Facture getFacture(Long idFacture);
    	public void supprimerFacture(Long idFacture);
    	public void modifierFacture(Facture f);
    	public List<Facture> consulterFactureClient(Long cinClient,int position,int nbFacture);
        public long getNombreFactr(Long cinClient);
    	


}
