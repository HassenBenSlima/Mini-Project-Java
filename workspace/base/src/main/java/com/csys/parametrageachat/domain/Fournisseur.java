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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
 * @author Lenovo
 */
@Entity
@Table(name = "fournisseur")
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f")})
public class Fournisseur implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fournisseur")
    private Collection<ArticleFournisseur> articleFournisseurCollection;

    @Column(name = "fk_region_code")
    private Integer fkRegionCode;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code", nullable = false, length = 10)
    private String code;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "actif", nullable = false)
    private boolean actif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_param_mode_reglement_code", nullable = false)
    private int fkParamModeReglementCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delai_paiement", nullable = false)
    private int delaiPaiement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delai_livraison", nullable = false)
    private int delaiLivraison;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "memo", nullable = false, length = 100)
    private String memo;

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "code_impot", nullable = false, length = 50)
    private String codeImpot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "registre_commercial", nullable = false, length = 50)
    private String registreCommercial;

    @JoinTable(name = "fournisseur_categorie_depot", joinColumns = {
        @JoinColumn(name = "fk_fournisseur_code", referencedColumnName = "code")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_categorie_depot_code", referencedColumnName = "code")})
    @ManyToMany(cascade = CascadeType.MERGE)
    private Collection<CategorieDepot> categorieDepotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkFournisseurCode", orphanRemoval = true)
    private Collection<ResponsableFournisseur> responsableFournisseurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fournisseur", orphanRemoval = true)
    private Collection<ContacteFournisseur> contacteFournisseurCollection;
    @JoinColumn(name = "fk_categorie_fournisseur", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private CategorieFournisseur fkCategorieFournisseur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fournisseur", orphanRemoval = true)
    private Collection<PieceJointeFournisseur> pieceJointeFournisseurCollection;

    public Collection<PieceJointeFournisseur> getPieceJointeFournisseurCollection() {
        return pieceJointeFournisseurCollection;
    }

    public void setPieceJointeFournisseurCollection(Collection<PieceJointeFournisseur> pieceJointeFournisseurCollection) {
        this.pieceJointeFournisseurCollection = pieceJointeFournisseurCollection;
    }

    public Fournisseur() {
    }

    public Fournisseur(String code) {
        this.code = code;
    }

    public Fournisseur(String code, String designation, String designationSec, boolean actif,
            int fkParamModeReglementCode, int delaiPaiement, int delaiLivraison, String memo,
            String userCreate, Date dateCreate) {
        this.code = code;
        this.designation = designation;
        this.designationSec = designationSec;
        this.actif = actif;
        this.fkParamModeReglementCode = fkParamModeReglementCode;
        this.delaiPaiement = delaiPaiement;
        this.delaiLivraison = delaiLivraison;
        this.memo = memo;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
    }

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

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public int getFkParamModeReglementCode() {
        return fkParamModeReglementCode;
    }

    public void setFkParamModeReglementCode(int fkParamModeReglementCode) {
        this.fkParamModeReglementCode = fkParamModeReglementCode;
    }

    public int getDelaiPaiement() {
        return delaiPaiement;
    }

    public void setDelaiPaiement(int delaiPaiement) {
        this.delaiPaiement = delaiPaiement;
    }

    public int getDelaiLivraison() {
        return delaiLivraison;
    }

    public void setDelaiLivraison(int delaiLivraison) {
        this.delaiLivraison = delaiLivraison;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public String getCodeImpot() {
        return codeImpot;
    }

    public void setCodeImpot(String codeImpot) {
        this.codeImpot = codeImpot;
    }

    public String getRegistreCommercial() {
        return registreCommercial;
    }

    public void setRegistreCommercial(String registreCommercial) {
        this.registreCommercial = registreCommercial;
    }

    public Collection<CategorieDepot> getCategorieDepotCollection() {
        return categorieDepotCollection;
    }

    public void setCategorieDepotCollection(Collection<CategorieDepot> categorieDepotCollection) {
        this.categorieDepotCollection = categorieDepotCollection;
    }

    public Collection<ResponsableFournisseur> getResponsableFournisseurCollection() {
        return responsableFournisseurCollection;
    }

    public void setResponsableFournisseurCollection(
            Collection<ResponsableFournisseur> responsableFournisseurCollection) {
        this.responsableFournisseurCollection = responsableFournisseurCollection;
    }

    public Collection<ContacteFournisseur> getContacteFournisseurCollection() {
        return contacteFournisseurCollection;
    }

    public void setContacteFournisseurCollection(Collection<ContacteFournisseur> contacteFournisseurCollection) {
        this.contacteFournisseurCollection = contacteFournisseurCollection;
    }

    public CategorieFournisseur getFkCategorieFournisseur() {
        return fkCategorieFournisseur;
    }

    public void setFkCategorieFournisseur(CategorieFournisseur fkCategorieFournisseur) {
        this.fkCategorieFournisseur = fkCategorieFournisseur;
    }

    public int getFkRegionCode() {
        return fkRegionCode;
    }

    public void setFkRegionCode(int fkRegionCode) {
        this.fkRegionCode = fkRegionCode;
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
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.Fournisseur[ code=" + code + " ]";
    }

    public Collection<ArticleFournisseur> getArticleFournisseurCollection() {
        return articleFournisseurCollection;
    }

    public void setArticleFournisseurCollection(Collection<ArticleFournisseur> articleFournisseurCollection) {
        this.articleFournisseurCollection = articleFournisseurCollection;
    }

}
