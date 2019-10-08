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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "bareme_appel_offre")
@NamedQueries({
    @NamedQuery(name = "BaremeAppelOffre.findAll", query = "SELECT b FROM BaremeAppelOffre b")})
public class BaremeAppelOffre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "designation_sec")
    private String designationSec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actif")
    private boolean actif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_create")
    private String userCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baremeAppelOffre")
    private Collection<GenericBaremeAppelOffre> genericBaremeAppelOffreCollection;

    public BaremeAppelOffre() {
    }

    public BaremeAppelOffre(Integer code) {
        this.code = code;
    }

    public BaremeAppelOffre(Integer code, String designation, String designationSec, boolean actif, String userCreate, Date date) {
        this.code = code;
        this.designation = designation;
        this.designationSec = designationSec;
        this.actif = actif;
        this.userCreate = userCreate;
        this.date = date;
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

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<GenericBaremeAppelOffre> getGenericBaremeAppelOffreCollection() {
        return genericBaremeAppelOffreCollection;
    }

    public void setGenericBaremeAppelOffreCollection(Collection<GenericBaremeAppelOffre> genericBaremeAppelOffreCollection) {
        this.genericBaremeAppelOffreCollection = genericBaremeAppelOffreCollection;
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
        if (!(object instanceof BaremeAppelOffre)) {
            return false;
        }
        BaremeAppelOffre other = (BaremeAppelOffre) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.BaremeAppelOffre[ code=" + code + " ]";
    }

}
