/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.Collection;

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
import javax.validation.constraints.Size;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "responsable_fournisseur")
@NamedQueries({
    @NamedQuery(name = "ResponsableFournisseur.findAll", query = "SELECT r FROM ResponsableFournisseur r")})
public class ResponsableFournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code", nullable = false)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_responsable", nullable = false, length = 50)
    private String nomResponsable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_param_fonction_responsable_societe_code", nullable = false)
    private int fkParamFonctionResponsableSocieteCode;
    @JoinColumn(name = "fk_fournisseur_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Fournisseur fkFournisseurCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsableFournisseur")
    private Collection<ContacteResponsableFournisseur> contacteResponsableFournisseurCollection;

    public ResponsableFournisseur() {
    }

    public ResponsableFournisseur(Integer code) {
        this.code = code;
    }

    public ResponsableFournisseur(Integer code, String nomResponsable, int fkParamFonctionResponsableSocieteCode) {
        this.code = code;
        this.nomResponsable = nomResponsable;
        this.fkParamFonctionResponsableSocieteCode = fkParamFonctionResponsableSocieteCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public int getFkParamFonctionResponsableSocieteCode() {
        return fkParamFonctionResponsableSocieteCode;
    }

    public void setFkParamFonctionResponsableSocieteCode(int fkParamFonctionResponsableSocieteCode) {
        this.fkParamFonctionResponsableSocieteCode = fkParamFonctionResponsableSocieteCode;
    }

    public Fournisseur getFkFournisseurCode() {
        return fkFournisseurCode;
    }

    public void setFkFournisseurCode(Fournisseur fkFournisseurCode) {
        this.fkFournisseurCode = fkFournisseurCode;
    }

    public Collection<ContacteResponsableFournisseur> getContacteResponsableFournisseurCollection() {
        return contacteResponsableFournisseurCollection;
    }

    public void setContacteResponsableFournisseurCollection(Collection<ContacteResponsableFournisseur> contacteResponsableFournisseurCollection) {
        this.contacteResponsableFournisseurCollection = contacteResponsableFournisseurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsableFournisseur)) {
            return false;
        }
        ResponsableFournisseur other = (ResponsableFournisseur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.ResponsableFournisseur[ code=" + code + " ]";
    }

}
