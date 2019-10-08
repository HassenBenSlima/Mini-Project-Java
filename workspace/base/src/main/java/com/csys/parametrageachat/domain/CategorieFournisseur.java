/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "categorie_fournisseur")
public class CategorieFournisseur implements Serializable {

    @Column(name = "actif")
    private Boolean actif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCategorieFournisseur")
    private Collection<Fournisseur> fournisseurCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code", nullable = false)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "designation", nullable = false, length = 50)
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "designation_sec", nullable = false, length = 50)
    private String designationSec;
    @Size(max = 5)
    @Column(name = "prefix", length = 5)
    private String prefix;
    @Column(name = "suffix")
    private String suffix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_create", nullable = false, length = 50)
    private String userCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    public CategorieFournisseur() {
    }

    public CategorieFournisseur(Integer code) {
        this.code = code;
    }

    public CategorieFournisseur(Integer code, String designation, String designationSec, String userCreate,
            Date dateCreate) {
        this.code = code;
        this.designation = designation;
        this.designationSec = designationSec;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignationSec() {
        return designationSec;
    }

    public void setDesignationSec(String designationSec) {
        this.designationSec = designationSec;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof CategorieFournisseur)) {
            return false;
        }
        CategorieFournisseur other = (CategorieFournisseur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.CategorieFournisseur[ code=" + code + " ]";
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Collection<Fournisseur> getFournisseurCollection() {
        return fournisseurCollection;
    }

    public void setFournisseurCollection(Collection<Fournisseur> fournisseurCollection) {
        this.fournisseurCollection = fournisseurCollection;
    }

}
