package com.fss.ml.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

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

public class MoulinOliveDaoImpl implements MoulinOliveDao {
    
	@PersistenceContext
	private EntityManager em ;
	
	@Override
	public Client ajouterClient(Client c) {
	      em.persist(c);
		return c;
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<Client> listClient() {
		Query req=em.createQuery("select c from Client c");
		return req.getResultList();
	}



	@Override
	public Client getClient(Long CIN) {
		// TODO Auto-generated method stub
		Client cc =em.find(Client.class, CIN);
		if(cc==null) throw new RuntimeException("Client introuvabe");
		return cc;
	}
	
	@Override
	public void supprimerClient(Long CIN) {
		Client c =em.find(Client.class, CIN);
		em.remove(c);				
	}

	@Override
	public void modifierClient(Client c) {
		em.merge(c);	
	
	}
	
	@Override
	public List<Client> consulterClient(int position, int nbClient) {
		Query req =em.createQuery("select c from Client c");
        req.setFirstResult(position);
        req.setMaxResults(nbClient);
        return req.getResultList();	
}

	@Override
	public long getNombreClient() {
		
		Query req=em.createQuery("select count(c) from Client c");
		return (Long)req.getResultList().get(0); 
	}
	
	@Override
	public List<Facture> findByCinClF(Long cinClient) {
		Query req=em.createQuery("select f from Facture f where f.client.cinClient=:x");
		req.setParameter("x",cinClient); 
		return req.getResultList();
	}

	@Override
	public List<Reservation> findByCinClR(Long cinClient) {
		Query req=em.createQuery("select r from Reservation r where r.client.cinClient=:x");
		req.setParameter("x",cinClient); 
		return req.getResultList();
	}

	@Override
	public List<Client> nameClient(String nameClient) {
		Query req=em.createQuery("select c from Client c where c.nomClient like :x");
		req.setParameter("x", "%"+nameClient+"%"); 
		return req.getResultList();
    }


	/************************Employe*************************/

	@Override
	public Employe ajouterEmploye(Employe e) {
		  em.persist(e);
			return e;
			}

	@Override
	public List<Employe> listEmploye() {
		Query req1=em.createQuery("select e from Employe e");
		return req1.getResultList();
	}
    
	@Override
	public Employe getEmploye(Long idEmp) {
		Employe ee= em.find(Employe.class, idEmp);
		if(ee==null) throw new RuntimeException("Employer introuvabe");
	    return ee;
	}

	@Override
	public void supprimerEmploye(Long idEmp) {
		// TODO Auto-generated method stub
		Employe E =em.find(Employe.class, idEmp);
		em.remove(E);	
	}

	@Override
	public void modifierEmploye( Employe e) {
		// TODO Auto-generated method stub
		
		em.merge(e);
	}
	
	@Override
	public List<Employe> consulterEmploye(int position, int nbEmploye) {
    
   		Query req =em.createQuery("select e from Employe e");
        req.setFirstResult(position);
        req.setMaxResults(nbEmploye);
        return req.getResultList();	
    }

	@Override
	public long getNombreEmployer() {
		Query req=em.createQuery("select count(e) from Employe e");
		return (Long)req.getResultList().get(0); 
		
	}

	
	
	/********************Fournisseur********************/

	@Override
	public Fournisseur ajouterFournisseur(Fournisseur f) {
		em.persist(f);
		return f;
	}

	@Override
	public Fournisseur getFournisseur(Long CIN) {
		// TODO Auto-generated method stub
		 Fournisseur ff=em.find(Fournisseur.class, CIN);
		if(ff==null)throw new RuntimeException("Fournisseur "+CIN+" introuvable!");
		return ff;
	}

	@Override
	public void supprimerFournisseur(Long CIN) {
		Fournisseur f=em.find(Fournisseur.class, CIN);
		em.remove(f);
		
	}

	@Override
	public void modifierFournisseur(Fournisseur f) {
		em.merge(f);
	}

	@Override
	public List<FournisseurOlive> listFournisseurO() {
		Query req1=em.createQuery("select f from FournisseurOlive f");
		return req1.getResultList();
	}
	@Override
	public List<FournisseurMaintenance> listFournisseurM() {
		Query req1=em.createQuery("select f from FournisseurMaintenance f");
		return req1.getResultList();
	}

	
	@Override
	public List<FournisseurMaintenance> RnameFournisseurM(String name) {
		Query req=em.createQuery("select m from FournisseurMaintenance m where m.nomFourn like :x");
		req.setParameter("x","%"+name+"%"); 
		return req.getResultList();
    }

	@Override
	public List<FournisseurOlive> RnameFournisseurO(String name) {
		Query req=em.createQuery("select o from FournisseurOlive o where o.nomFourn like :x");
		req.setParameter("x", "%"+name+"%"); 
		return req.getResultList();
    }

	@Override
	public List<FournisseurMaintenance> consulterFrnms(int position, int nbFournisseurms) {
		Query req=em.createQuery("select m from FournisseurMaintenance m");
    	req.setFirstResult(position);
    	req.setMaxResults(nbFournisseurms);
    	return req.getResultList();	
        }

	@Override
	public long getNombreFrnms() {
		Query req=em.createQuery("select count(m) from FournisseurMaintenance m");
		return (Long)req.getResultList().get(0); 
	}

	@Override
	public List<FournisseurOlive> consulterFrnos(int position, int nbFournisseuros) {
		Query req=em.createQuery("select o from FournisseurOlive o");
    	req.setFirstResult(position);
    	req.setMaxResults(nbFournisseuros);
    	return req.getResultList();	
        }

	@Override
	public long getNombreFrnos() {
		Query req=em.createQuery("select count(o) from FournisseurOlive o");
		return (Long)req.getResultList().get(0); 
	}

	
	@Override
	public List<Maintenance> findByCinFm(Long cinFm ) {
		Query req=em.createQuery("select m from Maintenance m where m.fournisseurm.cinFourn=:x");
		req.setParameter("x",cinFm); 
		return req.getResultList();
	}

	@Override
	public List<BonAchat> findByCinFo(Long cinFm) {
		Query req=em.createQuery("select b from BonAchat b where b.fournisseuro.cinFourn=:x");
		req.setParameter("x",cinFm); 
		return req.getResultList();
	}

	
	/*******************Caisse********************/

	@Override
	public Caisse ajouterCaisse(Caisse cs) {
		em.persist(cs);
		return cs;
	}

    @Override
    public Caisse getCaisse(Long idcs) {
	
	return em.find(Caisse.class, idcs);
	
    }
    @Override
	public List<Caisse> listCaisse() {
		Query req =em.createQuery("select cs from Caisse cs");
		return req.getResultList();
	}

    
/************************Reservation**********************/

    @Override
    public Reservation ajouterReservation(Reservation r, Long idCli) {
	Client cl =getClient(idCli);
	r.setClient(cl);
	em.persist(r);
	return r;
    }

    @Override
    public List<Reservation> listReservation() {
    Query req=em.createQuery("select r from Reservation r order by r.dateRsv asc");
	return req.getResultList();	
    }
    @Override
    public Reservation getRsv(Long idRsv) {
    	// TODO Auto-generated method stub
    	return em.find(Reservation.class, idRsv);
    }

    @Override
    public void supprimerRsv(Long idRsv) {
    	Reservation rv=getRsv(idRsv);
    	em.remove(rv);
    }

    @Override
    public void modifierRsv(Reservation rsv) {
    	em.merge(rsv);
    }
    @Override
	public List<Reservation> consulterRsvClient(Long cinClient, int position, int nbReservation) {
    	
    	Query req=em.createQuery("select r from Reservation r where r.client.cinClient=:x order by r.dateRsv desc");
    	req.setParameter("x", cinClient);
    	req.setFirstResult(position);
    	req.setMaxResults(nbReservation);
    	return req.getResultList();	
        }

           @Override
        	public long getNombreRsv(Long cinClient) {
   
    		Query req=em.createQuery("select count(r) from Reservation r where r.client.cinClient=:x");
    		req.setParameter("x",cinClient); 
    		return (Long)req.getResultList().get(0); 
    		
    	}
           
       	@Override
    	public List<Reservation> RreservationD(String date) {
       		Query req=em.createQuery("select r from Reservation r where r.dateRsv like :x");
    		req.setParameter("x","%"+date+"%"); 
    		return req.getResultList();
        }

    	@Override
    	public List<Reservation> consulterReservation(int position, int nbReservation) {
    		Query req=em.createQuery("select r from Reservation r");
        	req.setFirstResult(position);
        	req.setMaxResults(nbReservation);
        	return req.getResultList();	
            }

    	@Override
    	public long getNombreRsvs() {
    		Query req=em.createQuery("select count(r) from Reservation r");
    		return (Long)req.getResultList().get(0); 
    	}

    
       	
	/******************************Stock********************************/

	@Override
	public Stock ajouterStock(Stock ctr) {
		em.persist(ctr);
		return ctr;
	}

	@Override
	public List<CuveOlives> listCuve() {
		Query req=em.createQuery("select cv from CuveOlives cv");
		return req.getResultList();
		}

	@Override
	public List<Citerne> listCiterne() {
		Query req=em.createQuery("select c from Citerne c");
		return req.getResultList();
		}

	@Override
	public Stock getStock(String Code) {
		// TODO Auto-generated method stub
		return em.find(Stock.class,Code);
	}

	@Override
	public void supprimerStock(String Code) {
		Stock s=getStock(Code);
		em.remove(s);
	}

	@Override
	public void modifierStock(Stock s) {
		em.merge(s);
	}

    @Override
	public List<Citerne> consulterCiterne( int position, int nbCiterne) {
    	
    	Query req=em.createQuery("select c from Citerne c");
    	req.setFirstResult(position);
    	req.setMaxResults(nbCiterne);
    	return req.getResultList();	
        }

           @Override
        	public long getNombreCiterne() {
   
    		Query req=em.createQuery("select count(c) from Citerne c");
    		return (Long)req.getResultList().get(0); 
    		
    	}

           @Override
       	public List<CuveOlives> consulterCuve(int position, int nbCuve) {
        	   Query req=em.createQuery("select c from CuveOlives c");
           	req.setFirstResult(position);
           	req.setMaxResults(nbCuve);
           	return req.getResultList();	
               }

       	@Override
       	public long getNombreCuve() {
       		Query req=em.createQuery("select count(c) from CuveOlives c");
    		return (Long)req.getResultList().get(0); 
    		
    	}

    	@Override
    	public List<CuveOlives> RechCuveByName(String CODE) {
    		Query req=em.createQuery("select c from CuveOlives c where c.codeStock like :x");
    		req.setParameter("x", "%"+CODE+"%"); 
    		return req.getResultList();
        }

    	@Override
    	public List<Citerne> RechByName(String CODE) {
    		Query req=em.createQuery("select c from Citerne c where c.codeStock like :x");
    		req.setParameter("x", "%"+CODE+"%"); 
    		return req.getResultList();
        }

    	
       		
	/*********Facture*******/
    	@Override
    	public List<Facture> listFacture() {
    		Query req =em.createQuery("select f from Facture f order by f.idVente asc");
    		return req.getResultList();
    	}
    	 
    	public Facture ajouterFacture(Facture f, Long cin, Long cs) {
		    Client cc= getClient(cin);
		    f.setClient(cc);
		    Caisse cf= getCaisse(cs);
		    
		    cf.setSolde(cf.getSolde()+f.getMontantf());
		    f.setCaissef(cf);
	        
		    em.persist(f);
    		return f;
    	
    	}


    	@Override
    	public Facture getFacture(Long idFacture) {
    		// TODO Auto-generated method stub
    		return em.find(Facture.class,idFacture);
    	}

    	@Override
    	public void supprimerFacture(Long idFacture) {
    		Facture fctr = getFacture(idFacture);
    		    em.remove(fctr);
    	}

    	@Override
    	public void modifierFacture(Facture f) {
    	em.merge(f);
    		
    	}
    	@Override
    	public List<Facture> consulterFactureClient(Long cinClient, int position, int nbFacture) {
       		Query req=em.createQuery("select f from Facture f where f.client.cinClient=:x");
        	req.setParameter("x", cinClient);
        	req.setFirstResult(position);
        	req.setMaxResults(nbFacture);
        	return req.getResultList();	
            }

    	@Override
    	public long getNombreFactr(Long cinClient) {
    		Query req=em.createQuery("select count(f) from Facture f where f.client.cinClient=:x");
    		req.setParameter("x",cinClient); 
    		return (Long)req.getResultList().get(0); 
    		}
    

    /*****************BonAchat*****************/
    @Override
    public BonAchat ajouterBA(BonAchat ba, Long idcaisse, Long CinFourn,String codestock) {
        Caisse cs= getCaisse(idcaisse);
        CuveOlives c =(CuveOlives) getStock(codestock);
      
        if (cs.getSolde()>=ba.getMontantAchat()&&(c.getCapacite()>=c.getQuantiteactOL()+ba.getQuantiteOL())){
      ba.setStocko(c);  	
        ba.setCaisse(cs);
        c.setQuantiteactOL(c.getQuantiteactOL()+ba.getQuantiteOL());
        FournisseurOlive fro= (FournisseurOlive) getFournisseur(CinFourn);
        ba.setFournisseuro(fro);
        cs.setSolde(cs.getSolde()-ba.getMontantAchat());
        em.persist(ba);
        JOptionPane.showMessageDialog(null, "Enregistrement réussite", "Bon d'achat", 1);
        }else if(cs.getSolde()<ba.getMontantAchat()){
        	
        	JOptionPane.showMessageDialog(null, " la solde est insuffisant");
        
        }else if(c.getCapacite()<c.getQuantiteactOL()+ba.getQuantiteOL()){
        	JOptionPane.showMessageDialog(null, "cette quantité est superieur à la capacité de cet cuve\n s 'il-vous-plaît choisir un autre cuve");
            	
        }else{
        	JOptionPane.showMessageDialog(null, "Vérifier les informations de cet bon d'achat");
            	
        }
        return ba;
        }

	@Override
	public List<BonAchat> listBA() {
	Query req=em.createQuery("select b from BonAchat b");
		return req.getResultList();
	}

	@Override
	public BonAchat getBA(Long idBon) {
		// TODO Auto-generated method stub
		return em.find(BonAchat.class, idBon);
	}

	@Override
	public void supprimerBA(Long idBon) {
		BonAchat bon=getBA(idBon);
		em.remove(bon);
		
	}

	@Override
	public void modifierBA(BonAchat B) {
		
		em.merge(B);
		
	}

	@Override
	public List<BonAchat> consulterBon(Long CINFo,int position, int nbBon) {
		Query req=em.createQuery("select b from BonAchat b where b.fournisseuro.cinFourn=:x");
    	req.setParameter("x", CINFo);
    	req.setFirstResult(position);
    	req.setMaxResults(nbBon);
    	return req.getResultList();	
        }

	@Override
	public long getNombreBonAchat(Long CINFo) {
		Query req=em.createQuery("select count(b) from BonAchat b where b.fournisseuro.cinFourn=:x");
		req.setParameter("x",CINFo); 
		return (Long)req.getResultList().get(0); 
		}

	
	
	
	/***************************Maintenance*****************************/

	@Override
	    public Maintenance ajouterMaintenance(Maintenance m, Long idFournm , Long Caisse) {
		Caisse cs =getCaisse(Caisse);
		if(cs.getSolde()>=m.getPrixMain()){
		FournisseurMaintenance fm=(FournisseurMaintenance) getFournisseur(idFournm);
		m.setFournisseurm(fm);
		
		
		m.setCaissem(cs);
		cs.setSolde(cs.getSolde()-m.getPrixMain());
		em.persist(m);
		 JOptionPane.showMessageDialog(null, "Enregistrement réussite", "Maintenance", 1);
		}else{
			JOptionPane.showMessageDialog(null, " le solde est insuffisant");
		}
		
		return m;
	}

	@Override
	public List<Maintenance> listMaintenance() {
		Query req=em.createQuery("select m from Maintenance m");
		return req.getResultList();
	}

	@Override
	public Maintenance getMaint(Long idMain) {
		// TODO Auto-generated method stub
		return em.find(Maintenance.class, idMain);
	}

	@Override
	public void supprimerMaint(Long idMain) {
		Maintenance mt= getMaint(idMain);
		em.remove(mt);
		
	}

	@Override
	public void modifierMaint(Maintenance mtn) {
		
		em.merge(mtn);	
		
	}

	@Override
	public List<Maintenance> listMainByName(String name) {
		Query req=em.createQuery("select m from Maintenance m where m.fournisseurm.nomFourn like :x");
		req.setParameter("x", "%"+name+"%"); 
		return req.getResultList();
    }

	@Override
	public List<Maintenance> consulterMaintenance(int position, int nbMaintenance) {
		Query req=em.createQuery("select m from Maintenance m");
    	req.setFirstResult(position);
    	req.setMaxResults(nbMaintenance);
    	
    	return req.getResultList();	
        }

	@Override
	public long getNombreMain() {
		Query req=em.createQuery("select count(m) from Maintenance m");
		return (Long)req.getResultList().get(0); 
	}

	/*************************************************/




	


	


	
	
 }

	
