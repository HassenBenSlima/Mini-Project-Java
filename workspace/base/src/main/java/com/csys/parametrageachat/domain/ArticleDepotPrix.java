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
@Table(name = "article_depot_prix")
@NamedQueries({
    @NamedQuery(name = "ArticleDepotPrix.findAll", query = "SELECT a FROM ArticleDepotPrix a")})
public class ArticleDepotPrix implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticleDepotPrixPK articleDepotPrixPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_vente")
    private BigDecimal prixVente;
    @MapsId(value = "fkArticleCode")
    @JoinColumn(name = "fk_article_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private ArticleUU articleUU;
    @JoinColumn(name = "fk_depot_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Depot depot;

    public ArticleDepotPrix() {
    }

//    public ArticleDepotPrix(ArticleDepotPrixPK articleDepotPrixPK) {
//        this.articleDepotPrixPK = articleDepotPrixPK;
//    }
//
//    public ArticleDepotPrix(ArticleDepotPrixPK articleDepotPrixPK, BigDecimal prixVente) {
//        this.articleDepotPrixPK = articleDepotPrixPK;
//        this.prixVente = prixVente;
//    }
//
//    public ArticleDepotPrix(int fkDepotCode, int fkArticleCode) {
//        this.articleDepotPrixPK = new ArticleDepotPrixPK(fkDepotCode, fkArticleCode);
//    }
    public ArticleDepotPrixPK getArticleDepotPrixPK() {
        return articleDepotPrixPK;
    }

    public void setArticleDepotPrixPK(ArticleDepotPrixPK articleDepotPrixPK) {
        this.articleDepotPrixPK = articleDepotPrixPK;
    }

    public BigDecimal getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(BigDecimal prixVente) {
        this.prixVente = prixVente;
    }

    public ArticleUU getArticle() {
        return articleUU;
    }

    public void setArticle(ArticleUU articleUU) {
        this.articleUU = articleUU;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleDepotPrixPK != null ? articleDepotPrixPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleDepotPrix)) {
            return false;
        }
        ArticleDepotPrix other = (ArticleDepotPrix) object;
        if ((this.articleDepotPrixPK == null && other.articleDepotPrixPK != null) || (this.articleDepotPrixPK != null && !this.articleDepotPrixPK.equals(other.articleDepotPrixPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.ArticleDepotPrix[ articleDepotPrixPK=" + articleDepotPrixPK + " ]";
    }

}
