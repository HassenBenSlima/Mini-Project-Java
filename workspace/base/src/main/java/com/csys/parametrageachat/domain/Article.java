/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.FetchType;

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "article")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")})
public class Article extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "code_saisi",updatable = false)
    private String codeSaisi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_min")
    private int stockMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_max")
    private int stockMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regeneration")
    private boolean regeneration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockable")
    private boolean stockable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "perissable")
    private boolean perissable;

    @Basic(optional = false)
    @NotNull
    @Column(name = "quantite")
    private int quantite;
   
    @Column(name = "prix_achat")
    private BigDecimal prixAchat;
    @Column(name = "prix_max_saisi")
    private BigDecimal prixMaxSaisi;
    @JoinColumn(name = "fk_unite_code", referencedColumnName = "code")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Unite uniteCode;
    @JoinColumn(name = "fk_brand_code", referencedColumnName = "code")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Brand brandCode;
    @JoinColumn(name = "fk_generic_code", referencedColumnName = "code")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Generic genericCode;
    @JoinColumn(name = "fk_tva_codeA", referencedColumnName = "code")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Tva tvaCodeA;
    @JoinColumn(name = "fk_tva_codeV", referencedColumnName = "code")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Tva tvaCodeV;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article", orphanRemoval = true)
    private Collection<ArticleFournisseur> articleFournisseurCollection;
    @JoinColumn(name = "fk_categorie_article_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private CategorieArticle categorieArticleCode;

//	public Article() {
//  }
//
//  public Article(Integer code) {
//      this.code = code;
//  }
//
//  public Article(Integer code, String codeSaisi, String designation, String designationAr, int stockMin, int stockMax, boolean regeneration, boolean stockable, boolean périssable, boolean actif, int fkUniteCode, int quantite) {
//      this.code = code;
//      this.codeSaisi = codeSaisi;
//      this.designation = designation;
//      this.designationAr = designationAr;
//      this.stockMin = stockMin;
//      this.stockMax = stockMax;
//      this.regeneration = regeneration;
//      this.stockable = stockable;
//      this.périssable = périssable;
//      this.actif = actif;
//      this.fkUniteCode = fkUniteCode;
//      this.quantite = quantite;
//  }
  

    public BigDecimal getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(BigDecimal prixAchat) {
        this.prixAchat = prixAchat;
    }

    public BigDecimal getPrixMaxSaisi() {
        return prixMaxSaisi;
    }

    public void setPrixMaxSaisi(BigDecimal prixMaxSaisi) {
        this.prixMaxSaisi = prixMaxSaisi;
    }

    public Collection<ArticleFournisseur> getArticleFournisseurCollection() {
        return articleFournisseurCollection;
    }

    public void setArticleFournisseurCollection(Collection<ArticleFournisseur> articleFournisseurCollection) {
        this.articleFournisseurCollection = articleFournisseurCollection;
    }

    public String getCodeSaisi() {
        return codeSaisi;
    }

    public void setCodeSaisi(String codeSaisi) {
        this.codeSaisi = codeSaisi;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public int getStockMax() {
        return stockMax;
    }

    public void setStockMax(int stockMax) {
        this.stockMax = stockMax;
    }

    public boolean getRegeneration() {
        return regeneration;
    }

    public void setRegeneration(boolean regeneration) {
        this.regeneration = regeneration;
    }

    public boolean getStockable() {
        return stockable;
    }

    public void setStockable(boolean stockable) {
        this.stockable = stockable;
    }

    public boolean getPerissable() {
        return perissable;
    }

    public void setPerissable(boolean perissable) {
        this.perissable = perissable;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Unite getUniteCode() {
        return uniteCode;
    }

    public void setUniteCode(Unite uniteCode) {
        this.uniteCode = uniteCode;
    }

    public Brand getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(Brand brandCode) {
        this.brandCode = brandCode;
    }

    public Generic getGenericCode() {
        return genericCode;
    }

    public void setGenericCode(Generic genericCode) {
        this.genericCode = genericCode;
    }

    public Tva getTvaCodeA() {
        return tvaCodeA;
    }

    public void setTvaCodeA(Tva tvaCodeA) {
        this.tvaCodeA = tvaCodeA;
    }

    public Tva getTvaCodeV() {
        return tvaCodeV;
    }

    public void setTvaCodeV(Tva tvaCodeV) {
        this.tvaCodeV = tvaCodeV;
    }

    public CategorieArticle getCategorieArticleCode() {
        return categorieArticleCode;
    }

    public void setCategorieArticleCode(CategorieArticle categorieArticleCode) {
        this.categorieArticleCode = categorieArticleCode;
    }

}
