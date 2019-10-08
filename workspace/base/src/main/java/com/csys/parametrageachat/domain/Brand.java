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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Farouk
 */
@Entity
@Table(name = "brand")
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b")})
public class Brand extends BaseEntity implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandCode")
    private Collection<Article> articleCollection;

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "fk_categorie_depot_code", referencedColumnName = "code")

    @ManyToOne
    private CategorieDepot fkCategorieDepotCode;

    public CategorieDepot getFkcategorieDepotCode() {
        return fkCategorieDepotCode;
    }

    public void setFkcategorieDepotCode(CategorieDepot fkCategorieDepotCode) {
        this.fkCategorieDepotCode = fkCategorieDepotCode;
    }

    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

}
