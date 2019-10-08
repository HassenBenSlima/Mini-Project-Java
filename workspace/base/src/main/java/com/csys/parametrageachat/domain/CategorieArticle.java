/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.google.common.base.Preconditions;

import java.math.BigDecimal;
import javax.persistence.Id;

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "categorie_article")
@NamedQueries({
    @NamedQuery(name = "CategorieArticle.findAll", query = "SELECT c FROM CategorieArticle c")})
public class CategorieArticle extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "affecter")
    private boolean affecter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "prefix")
    private String prefix;
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "suffix")
    private String suffix;
    @Basic(optional = false)
    @Column(name = "marge")
    private BigDecimal marge;

    @JoinColumn(name = "fk_categorie_depot_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private CategorieDepot fkCategorieDepotCode;

    @JoinColumn(name = "fk_categorie_article_code", referencedColumnName = "code")
    @ManyToOne
    private CategorieArticle parent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private Collection<CategorieArticle> children;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieArticleCode")
    private Collection<Article> articleCollection;

    public CategorieArticle() {
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public boolean getAffecter() {
        return affecter;
    }

    public void setAffecter(boolean affecter) {
        this.affecter = affecter;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public BigDecimal getMarge() {
        return marge;
    }

    public void setMarge(BigDecimal marge) {
        this.marge = marge;
    }

    
    public CategorieArticle getParent() {
        return parent;
    }

    public void setParent(CategorieArticle parent) {
        this.parent = parent;
    }

    public Collection<CategorieArticle> getChildren() {
        return children;
    }

    public void setChildren(Collection<CategorieArticle> children) {
        this.children = children;
    }

    public CategorieDepot getFkCategorieDepotCode() {
        return fkCategorieDepotCode;
    }

    public void setFkCategorieDepotCode(CategorieDepot fkCategorieDepotCode) {
        this.fkCategorieDepotCode = fkCategorieDepotCode;
    }

    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

   /* public void addToParent(CategorieArticle parent) {
        Preconditions.checkArgument(parent != null, "error.CategorieArticleParentNull");
        this.parent = parent;
        if (this.parent.children == null) {
            this.parent.children = new ArrayList<CategorieArticle>();
        }
        
        this.parent.children.add(this);
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getCode() != null ? getCode().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof CategorieArticle)) {
            return false;
        }
        CategorieArticle other = (CategorieArticle) object;
        if ((this.getCode() == null && other.getCode() != null)
                || (this.getCode() != null && !this.getCode().equals(other.getCode()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.CategorieArticle[ code=" + getCode() + " ]";
    }

}
