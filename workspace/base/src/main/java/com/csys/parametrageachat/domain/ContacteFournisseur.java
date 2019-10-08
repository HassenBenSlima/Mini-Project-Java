/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "contacte_fournisseur")
@NamedQueries({
    @NamedQuery(name = "ContacteFournisseur.findAll", query = "SELECT c FROM ContacteFournisseur c")})
public class ContacteFournisseur implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "contacteFournisseur1")
    private ContacteFournisseur contacteFournisseur;
    @JoinColumns({
        @JoinColumn(name = "fk_fournisseur_code", referencedColumnName = "fk_fournisseur_code", insertable = false, updatable = false)
        , @JoinColumn(name = "fk_type_contacte_code", referencedColumnName = "fk_type_contacte_code", insertable = false, updatable = false)
        , @JoinColumn(name = "valeur", referencedColumnName = "valeur", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private ContacteFournisseur contacteFournisseur1;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContacteFournisseurPK contacteFournisseurPK;
    @MapsId("fkFournisseurCode")
    @JoinColumn(name = "fk_fournisseur_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fournisseur fournisseur;

    public ContacteFournisseur() {
    }

    public ContacteFournisseur(ContacteFournisseurPK contacteFournisseurPK) {
        this.contacteFournisseurPK = contacteFournisseurPK;
    }

    public ContacteFournisseur(String fkFournisseurCode, int fkTypeContacteCode, String valeur) {
        this.contacteFournisseurPK = new ContacteFournisseurPK(fkFournisseurCode, fkTypeContacteCode, valeur);
    }

    public ContacteFournisseurPK getContacteFournisseurPK() {
        return contacteFournisseurPK;
    }

    public void setContacteFournisseurPK(ContacteFournisseurPK contacteFournisseurPK) {
        this.contacteFournisseurPK = contacteFournisseurPK;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contacteFournisseurPK != null ? contacteFournisseurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContacteFournisseur)) {
            return false;
        }
        ContacteFournisseur other = (ContacteFournisseur) object;
        if ((this.contacteFournisseurPK == null && other.contacteFournisseurPK != null) || (this.contacteFournisseurPK != null && !this.contacteFournisseurPK.equals(other.contacteFournisseurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.ContacteFournisseur[ contacteFournisseurPK=" + contacteFournisseurPK + " ]";
    }

    public ContacteFournisseur getContacteFournisseur() {
        return contacteFournisseur;
    }

    public void setContacteFournisseur(ContacteFournisseur contacteFournisseur) {
        this.contacteFournisseur = contacteFournisseur;
    }

    public ContacteFournisseur getContacteFournisseur1() {
        return contacteFournisseur1;
    }

    public void setContacteFournisseur1(ContacteFournisseur contacteFournisseur1) {
        this.contacteFournisseur1 = contacteFournisseur1;
    }

}
