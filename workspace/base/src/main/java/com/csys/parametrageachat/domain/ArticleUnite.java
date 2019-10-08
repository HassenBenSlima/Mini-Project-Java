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
@Table(name = "article_unite")
@NamedQueries({
    @NamedQuery(name = "ArticleUnite.findAll", query = "SELECT a FROM ArticleUnite a")})
public class ArticleUnite implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticleUnitePK articleUnitePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_vente")
    private BigDecimal prixVente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbre_piece")
    private BigDecimal nbrePiece;
    @JoinColumn(name = "fk_article_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    @MapsId(value="fkArticleCode")
    private ArticlePH articlePH;
    @JoinColumn(name = "fk_unite_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Unite unite;

    public ArticleUnite() {
    }

    public ArticleUnite(ArticleUnitePK articleUnitePK) {
        this.articleUnitePK = articleUnitePK;
    }

    public ArticleUnite(ArticleUnitePK articleUnitePK, BigDecimal prixVente, BigDecimal nbrePiece) {
        this.articleUnitePK = articleUnitePK;
        this.prixVente = prixVente;
        this.nbrePiece = nbrePiece;
    }

    public ArticleUnite(int fkArticleCode, int fkUniteCode) {
        this.articleUnitePK = new ArticleUnitePK(fkArticleCode, fkUniteCode);
    }

    public ArticleUnitePK getArticleUnitePK() {
        return articleUnitePK;
    }

    public void setArticleUnitePK(ArticleUnitePK articleUnitePK) {
        this.articleUnitePK = articleUnitePK;
    }

    public BigDecimal getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(BigDecimal prixVente) {
        this.prixVente = prixVente;
    }

    public BigDecimal getNbrePiece() {
        return nbrePiece;
    }

    public void setNbrePiece(BigDecimal nbrePiece) {
        this.nbrePiece = nbrePiece;
    }

    public ArticlePH getArticlePH() {
        return articlePH;
    }

    public void setArticlePH(ArticlePH articlePH) {
        this.articlePH = articlePH;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleUnitePK != null ? articleUnitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleUnite)) {
            return false;
        }
        ArticleUnite other = (ArticleUnite) object;
        if ((this.articleUnitePK == null && other.articleUnitePK != null) || (this.articleUnitePK != null && !this.articleUnitePK.equals(other.articleUnitePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.ArticleUnite[ articleUnitePK=" + articleUnitePK + " ]";
    }
    
}
