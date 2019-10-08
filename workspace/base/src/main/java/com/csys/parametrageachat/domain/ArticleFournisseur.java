/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

 

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "article_fournisseur")
@NamedQueries({
    @NamedQuery(name = "ArticleFournisseur.findAll", query = "SELECT a FROM ArticleFournisseur a")})
public class ArticleFournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticleFournisseurPK articleFournisseurPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_achat")
    private BigDecimal prixAchat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_prix_achat")
    private BigDecimal maxPrixAchat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_prix_achat")
    private BigDecimal minPrixAchat;
    @MapsId(value="fkArticleCode")
    @JoinColumn(name = "fk_article_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "fk_fournisseur_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Fournisseur fournisseur;

   

    public ArticleFournisseurPK getArticleFournisseurPK() {
        return articleFournisseurPK;
    }

    public void setArticleFournisseurPK(ArticleFournisseurPK articleFournisseurPK) {
        this.articleFournisseurPK = articleFournisseurPK;
    }

    public BigDecimal getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(BigDecimal prixAchat) {
        this.prixAchat = prixAchat;
    }

    public BigDecimal getMaxPrixAchat() {
        return maxPrixAchat;
    }

    public void setMaxPrixAchat(BigDecimal maxPrixAchat) {
        this.maxPrixAchat = maxPrixAchat;
    }

    public BigDecimal getMinPrixAchat() {
        return minPrixAchat;
    }

    public void setMinPrixAchat(BigDecimal minPrixAchat) {
        this.minPrixAchat = minPrixAchat;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

  
    
}
