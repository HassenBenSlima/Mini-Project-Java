/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "depot")
public class Depot implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depot")
    private Collection<ArticleDepotPrix> articleDepotPrixCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ouvrenouvex")
    private boolean ouvrenouvex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valoriser")
    private boolean valoriser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VldCge1")
    private Character vldCge1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VldCge2")
    private Character vldCge2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Stup")
    private boolean stup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AControler")
    private boolean aControler;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Orthopedie")
    private boolean orthopedie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DepotFrs")
    private boolean depotFrs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CodFrs")
    private String codFrs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "UserOuv")
    private String userOuv;
    @Column(name = "DateHeureOuv")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureOuv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Inventaire_AvecSCANPAL")
    private boolean inventaireAvecSCANPAL;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Methode_Traitement_de_Stock")
    private String methodeTraitementdeStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BT_Du_Par_DatePer")
    private boolean bTDuParDatePer;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "designation_sec")
    private String designationSec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code_saisi")
    private String codeSaisi;
    @JsonBackReference
    @JoinColumn(name = "fk_departement_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Departement fkDepartementCode;

    @OneToMany(mappedBy = "depot", cascade = CascadeType.ALL)
    private Collection<NatureDepot> natureDepot;

	@Basic(optional = false)
	@JoinColumn(name = "Maquette", referencedColumnName = "code")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Maquette maquette;


	public Maquette getMaquette() {
		return maquette;
	}

	public void setMaquette(Maquette maquette) {
		this.maquette = maquette;
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

    public boolean getOuvrenouvex() {
        return ouvrenouvex;
    }

    public void setOuvrenouvex(boolean ouvrenouvex) {
        this.ouvrenouvex = ouvrenouvex;
    }

    public boolean getValoriser() {
        return valoriser;
    }

    public void setValoriser(boolean valoriser) {
        this.valoriser = valoriser;
    }

    public Character getVldCge1() {
        return vldCge1;
    }

    public void setVldCge1(Character vldCge1) {
        this.vldCge1 = vldCge1;
    }

    public Character getVldCge2() {
        return vldCge2;
    }

    public void setVldCge2(Character vldCge2) {
        this.vldCge2 = vldCge2;
    }

    public boolean getStup() {
        return stup;
    }

    public void setStup(boolean stup) {
        this.stup = stup;
    }

    public boolean getAControler() {
        return aControler;
    }

    public void setAControler(boolean aControler) {
        this.aControler = aControler;
    }

    public boolean getOrthopedie() {
        return orthopedie;
    }

    public void setOrthopedie(boolean orthopedie) {
        this.orthopedie = orthopedie;
    }

    public boolean getDepotFrs() {
        return depotFrs;
    }

    public void setDepotFrs(boolean depotFrs) {
        this.depotFrs = depotFrs;
    }

    public String getCodFrs() {
        return codFrs;
    }

    public void setCodFrs(String codFrs) {
        this.codFrs = codFrs;
    }

    public String getUserOuv() {
        return userOuv;
    }

    public void setUserOuv(String userOuv) {
        this.userOuv = userOuv;
    }

    public Date getDateHeureOuv() {
        return dateHeureOuv;
    }

    public void setDateHeureOuv(Date dateHeureOuv) {
        this.dateHeureOuv = dateHeureOuv;
    }

    public boolean getInventaireAvecSCANPAL() {
        return inventaireAvecSCANPAL;
    }

    public void setInventaireAvecSCANPAL(boolean inventaireAvecSCANPAL) {
        this.inventaireAvecSCANPAL = inventaireAvecSCANPAL;
    }

    public String getMethodeTraitementdeStock() {
        return methodeTraitementdeStock;
    }

    public void setMethodeTraitementdeStock(String methodeTraitementdeStock) {
        this.methodeTraitementdeStock = methodeTraitementdeStock;
    }

    public boolean getBTDuParDatePer() {
        return bTDuParDatePer;
    }

    public void setBTDuParDatePer(boolean bTDuParDatePer) {
        this.bTDuParDatePer = bTDuParDatePer;
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

    public String getDesignationSec() {
        return designationSec;
    }

    public void setDesignationSec(String designationSec) {
        this.designationSec = designationSec;
    }

    public String getCodeSaisi() {
        return codeSaisi;
    }

    public void setCodeSaisi(String codeSaisi) {
        this.codeSaisi = codeSaisi;
    }

    public Departement getFkDepartementCode() {
        return fkDepartementCode;
    }

    public void setFkDepartementCode(Departement fkDepartementCode) {
        this.fkDepartementCode = fkDepartementCode;
    }

    public boolean isaControler() {
        return aControler;
    }

    public void setaControler(boolean aControler) {
        this.aControler = aControler;
    }

    public boolean isbTDuParDatePer() {
        return bTDuParDatePer;
    }

    public void setbTDuParDatePer(boolean bTDuParDatePer) {
        this.bTDuParDatePer = bTDuParDatePer;
    }

    public Collection<NatureDepot> getNatureDepot() {
        return natureDepot;
    }

    public void setNatureDepot(Collection<NatureDepot> natureDepot) {
        this.natureDepot = natureDepot;
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
        if (!(object instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.Depot_1[ code=" + code + " ]";
    }

    public Depot() {
    }

    public Collection<ArticleDepotPrix> getArticleDepotPrixCollection() {
        return articleDepotPrixCollection;
    }

    public void setArticleDepotPrixCollection(Collection<ArticleDepotPrix> articleDepotPrixCollection) {
        this.articleDepotPrixCollection = articleDepotPrixCollection;
    }

}
