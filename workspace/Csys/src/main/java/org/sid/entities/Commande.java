/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author K555L
 */
@Entity
@Table(name = "Commande")
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_commande")
    private Integer codeCommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_commade")
    private Date datecommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mont_tot_commane")
    private double montTotCommande;
    
    @JoinColumn(name = "code_fournisseur", referencedColumnName = "code_fournisseur")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Fournisseur fournisseur;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commande")
    @JsonManagedReference
    private List<Relation> relationList;

    public Date getDatecommande() {
        return datecommande;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public List<Relation> getRelationList() {
        return relationList;
    }

    public void setRelationList(List<Relation> relationList) {
        this.relationList = relationList;
    }
    
    public Commande() {
    }

    public Commande(Integer codeCommande) {
        this.codeCommande = codeCommande;
    }

    public Commande(Integer codeCommande, Date datecommande, double montTotCommane) {
        this.codeCommande = codeCommande;
        this.datecommande = datecommande;
        this.montTotCommande = montTotCommane;
    }

    public Integer getCodeCommande() {
        return codeCommande;
    }

    public void setCodeCommande(Integer codeCommande) {
        this.codeCommande = codeCommande;
    }

    public Date getDateCommade() {
        return datecommande;
    }

    public void setDateCommade(Date datecommande) {
        this.datecommande = datecommande;
    }

    public double getMontTotCommane() {
        return montTotCommande;
    }

    public void setMontTotCommande(double montTotCommane) {
        this.montTotCommande = montTotCommane;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeCommande != null ? codeCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.codeCommande == null && other.codeCommande != null) || (this.codeCommande != null && !this.codeCommande.equals(other.codeCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.myproject.domain.Commande[ codeCommande=" + codeCommande + " ]";
    }
    
}
