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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "tva")
@NamedQueries({
    @NamedQuery(name = "Tva.findAll", query = "SELECT t FROM Tva t")})
public class Tva implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tvaCodeA")
    private Collection<Article> articleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tvaCodeV")
    private Collection<Article> articleCollection1;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur")
    private BigDecimal valeur;

    public Tva() {
    }

    public Tva(Integer code) {
        this.code = code;
    }

    public Tva(Integer code, BigDecimal valeur) {
        this.code = code;
        this.valeur = valeur;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
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
        if (!(object instanceof Tva)) {
            return false;
        }
        Tva other = (Tva) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.Tva[ code=" + code + " ]";
    }

    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    public Collection<Article> getArticleCollection1() {
        return articleCollection1;
    }

    public void setArticleCollection1(Collection<Article> articleCollection1) {
        this.articleCollection1 = articleCollection1;
    }

}
