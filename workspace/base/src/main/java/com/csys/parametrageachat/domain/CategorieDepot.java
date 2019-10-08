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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "categorie_depot")
@NamedQueries({
    @NamedQuery(name = "CategorieDepot.findAll", query = "SELECT c FROM CategorieDepot c")})
public class CategorieDepot implements Serializable {

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCategorieDepotCode")
    private Collection<Generic> genericCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCategorieDepotCode")
    private Collection<Brand> brandCollection;

    @Id
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "code")
    private String code;
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
    @Size(min = 1, max = 50)
    @Column(name = "user_create")
    private String userCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "can_be_pos")
    private boolean canBePos;
    @Size(max = 50)
    @Column(name = "designation_pos")
    private String designationPos;
    @Size(max = 50)
    @Column(name = "designation_pos_sec")
    private String designationPosSec;

    @ManyToMany(mappedBy = "categorieDepotCollection", cascade = CascadeType.ALL)
    private Collection<Fournisseur> fournisseurCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieDepot")
    private Collection<NatureDepot> natureDepotCollection;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public boolean getCanBePos() {
        return canBePos;
    }

    public void setCanBePos(boolean canBePos) {
        this.canBePos = canBePos;
    }

    public String getDesignationPos() {
        return designationPos;
    }

    public void setDesignationPos(String designationPos) {
        this.designationPos = designationPos;
    }

    public String getDesignationPosSec() {
        return designationPosSec;
    }

    public void setDesignationPosSec(String designationPosSec) {
        this.designationPosSec = designationPosSec;
    }

    public Collection<Fournisseur> getFournisseurCollection() {
        return fournisseurCollection;
    }

    public void setFournisseurCollection(Collection<Fournisseur> fournisseurCollection) {
        this.fournisseurCollection = fournisseurCollection;
    }

    public Collection<NatureDepot> getNatureDepotCollection() {
        return natureDepotCollection;
    }

    public void setNatureDepotCollection(Collection<NatureDepot> natureDepotCollection) {
        this.natureDepotCollection = natureDepotCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getCode() != null ? this.getCode().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieDepot)) {
            return false;
        }
        CategorieDepot other = (CategorieDepot) object;
        if ((this.getCode() == null && other.getCode() != null) || (this.getCode() != null && !this.getCode().equals(other.getCode()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.myapp.domain.CategorieDepot[ code=" + this.getCode() + " ]";
    }

    public CategorieDepot() {
    }

    public Collection<Generic> getGenericCollection() {
        return genericCollection;
    }

    public void setGenericCollection(Collection<Generic> genericCollection) {
        this.genericCollection = genericCollection;
    }

    public Collection<Brand> getBrandCollection() {
        return brandCollection;
    }

    public void setBrandCollection(Collection<Brand> brandCollection) {
        this.brandCollection = brandCollection;
    }

    

}
