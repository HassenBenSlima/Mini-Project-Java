/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "unite")
@NamedQueries({
    @NamedQuery(name = "Unite.findAll", query = "SELECT u FROM Unite u")})
public class Unite extends BaseEntity implements Serializable {

    @OneToMany(mappedBy = "uniteCode")
    private List<Article> articleCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unite")
    private Collection<ArticleUnite> articleUniteCollection;

    private static final long serialVersionUID = 1L;

    public Collection<ArticleUnite> getArticleUniteCollection() {
        return articleUniteCollection;
    }

    public void setArticleUniteCollection(Collection<ArticleUnite> articleUniteCollection) {
        this.articleUniteCollection = articleUniteCollection;
    }

    public List<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(List<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

}
