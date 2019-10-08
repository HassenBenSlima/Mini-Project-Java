/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author K555L
 */
@Entity
@Table(name = "Article")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")})
public class Article implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<Relation> relationList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_art")
    private Integer codeArt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "des_art")
    private String desArt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_art")
    private float prixArt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_min_art")
    private int stockMinArt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qte_dispo")
    private int qteDispo;
    
    public Article() {
    }

    public Article(Integer codeArt) {
        this.codeArt = codeArt;
    }

    public Article(Integer codeArt, String desArt, float prixArt, int stockMinArt, int qteDispo) {
        this.codeArt = codeArt;
        this.desArt = desArt;
        this.prixArt = prixArt;
        this.stockMinArt = stockMinArt;
        this.qteDispo = qteDispo;
    }

    public Integer getCodeArt() {
        return codeArt;
    }

    public void setCodeArt(Integer codeArt) {
        this.codeArt = codeArt;
    }

    public String getDesArt() {
        return desArt;
    }

    public void setDesArt(String desArt) {
        this.desArt = desArt;
    }

    public float getPrixArt() {
        return prixArt;
    }

    public void setPrixArt(float prixArt) {
        this.prixArt = prixArt;
    }

    public int getStockMinArt() {
        return stockMinArt;
    }

    public void setStockMinArt(int stockMinArt) {
        this.stockMinArt = stockMinArt;
    }

    public int getQteDispo() {
        return qteDispo;
    }

    public void setQteDispo(int qteDispo) {
        this.qteDispo = qteDispo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeArt != null ? codeArt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.codeArt == null && other.codeArt != null) || (this.codeArt != null && !this.codeArt.equals(other.codeArt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.myproject.domain.Article[ codeArt=" + codeArt + " ]";
    }

    public List<Relation> getRelationList() {
        return relationList;
    }

    public void setRelationList(List<Relation> relationList) {
        this.relationList = relationList;
    }
    
}
