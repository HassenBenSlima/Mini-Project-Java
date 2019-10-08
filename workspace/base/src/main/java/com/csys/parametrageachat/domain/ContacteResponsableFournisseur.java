/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "contacte_responsable_fournisseur")
@NamedQueries({
    @NamedQuery(name = "ContacteResponsableFournisseur.findAll", query = "SELECT c FROM ContacteResponsableFournisseur c")})
public class ContacteResponsableFournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContacteResponsableFournisseurPK contacteResponsableFournisseurPK;
    @MapsId(value = "fkResponsableFournisseurCode")
    @JoinColumn(name = "fk_responsable_fournisseur_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ResponsableFournisseur responsableFournisseur;

    public ContacteResponsableFournisseur() {
    }

    public ContacteResponsableFournisseur(ContacteResponsableFournisseurPK contacteResponsableFournisseurPK) {
        this.contacteResponsableFournisseurPK = contacteResponsableFournisseurPK;
    }

    public ContacteResponsableFournisseur(int fkResponsableFournisseurCode, int fkParamTypeContacteCode, String valeur) {
        this.contacteResponsableFournisseurPK = new ContacteResponsableFournisseurPK(fkResponsableFournisseurCode, fkParamTypeContacteCode, valeur);
    }

    public ContacteResponsableFournisseurPK getContacteResponsableFournisseurPK() {
        return contacteResponsableFournisseurPK;
    }

    public void setContacteResponsableFournisseurPK(ContacteResponsableFournisseurPK contacteResponsableFournisseurPK) {
        this.contacteResponsableFournisseurPK = contacteResponsableFournisseurPK;
    }

    public ResponsableFournisseur getResponsableFournisseur() {
        return responsableFournisseur;
    }

    public void setResponsableFournisseur(ResponsableFournisseur responsableFournisseur) {
        this.responsableFournisseur = responsableFournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contacteResponsableFournisseurPK != null ? contacteResponsableFournisseurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContacteResponsableFournisseur)) {
            return false;
        }
        ContacteResponsableFournisseur other = (ContacteResponsableFournisseur) object;
        if ((this.contacteResponsableFournisseurPK == null && other.contacteResponsableFournisseurPK != null) || (this.contacteResponsableFournisseurPK != null && !this.contacteResponsableFournisseurPK.equals(other.contacteResponsableFournisseurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.ContacteResponsableFournisseur[ contacteResponsableFournisseurPK=" + contacteResponsableFournisseurPK + " ]";
    }

}
