/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "generic")
@NamedEntityGraph(name = "GenericWithMarks",
        attributeNodes = @NamedAttributeNode("genericBaremeAppelOffreCollection"))
public class Generic extends BaseEntity implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genericCode")
    private Collection<Article> articleCollection;
    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "fk_categorie_depot_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private CategorieDepot fkCategorieDepotCode;

    @OneToMany(mappedBy = "generic", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<GenericBaremeAppelOffre> genericBaremeAppelOffreCollection;

    public Generic() {
    }

    public CategorieDepot getFkCategorieDepotCode() {
        return fkCategorieDepotCode;
    }

    public void setFkCategorieDepotCode(CategorieDepot fkCategorieDepotCode) {
        this.fkCategorieDepotCode = fkCategorieDepotCode;
    }

    public Collection<GenericBaremeAppelOffre> getGenericBaremeAppelOffreCollection() {
        return genericBaremeAppelOffreCollection;
    }

    public void setGenericBaremeAppelOffreCollection(Collection<GenericBaremeAppelOffre> genericBaremeAppelOffreCollection) {
        this.genericBaremeAppelOffreCollection = genericBaremeAppelOffreCollection;
    }

    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }
}
