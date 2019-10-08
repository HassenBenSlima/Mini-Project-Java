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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "dci")
@NamedQueries({
    @NamedQuery(name = "Dci.findAll", query = "SELECT d FROM Dci d")})
public class Dci extends BaseEntity implements Serializable {

    @ManyToMany(mappedBy = "dciCollection")
    private Collection<ArticlePH> articleCollection;

    private static final long serialVersionUID = 1L;
    

    public Collection<ArticlePH> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<ArticlePH> articleCollection) {
        this.articleCollection = articleCollection;
    }

}
