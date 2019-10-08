/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "forme")
@NamedQueries({
    @NamedQuery(name = "Forme.findAll", query = "SELECT f FROM Forme f")})
public class Forme extends BaseEntity implements Serializable {

    
    @OneToMany(mappedBy = "fkFormeCode")
    private Collection<ArticlePH> articleCollection;

    private static final long serialVersionUID = 1L;

    public Forme() {
    }

    public Collection<ArticlePH> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<ArticlePH> articleCollection) {
        this.articleCollection = articleCollection;
    }

 
    

}
