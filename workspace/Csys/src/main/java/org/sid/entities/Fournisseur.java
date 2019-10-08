/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author K555L
 */
@Entity
@Table(name = "fournisseur")
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_fournisseur")
    private Integer codeFournisseur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "des_fournisseur")
    private String desFournisseur;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fournisseur")
    private List<Commande> listCommande;

    public void setListCommande(List<Commande> listCommande) {
        this.listCommande = listCommande;
    }

    public List<Commande> getlistCommande() {
        return listCommande;
    }

    public Fournisseur() {
    }

    public Fournisseur(Integer codeFournisseur) {
        this.codeFournisseur = codeFournisseur;
    }


    public Integer getCodeFournisseur() {
        return codeFournisseur;
    }

    public void setCodeFournisseur(Integer codeFournisseur) {
        this.codeFournisseur = codeFournisseur;
    }

    public String getDesFournisseur() {
        return desFournisseur;
    }

    public void setDesFournisseur(String desFournisseur) {
        this.desFournisseur = desFournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeFournisseur != null ? codeFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.codeFournisseur == null && other.codeFournisseur != null) || (this.codeFournisseur != null && !this.codeFournisseur.equals(other.codeFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.myproject.domain.Fournisseur[ codeFournisseur=" + codeFournisseur + " ]";
    }
    
}
