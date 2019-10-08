/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import com.csys.parametrageachat.domain.ArticlePH;

/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "specialite")
@NamedQueries({
    @NamedQuery(name = "Specialite.findAll", query = "SELECT s FROM Specialite s")})
public class Specialite extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "specialiteCollection")
    private Collection<ArticlePH> articleCollection;

    public Collection<ArticlePH> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<ArticlePH> articleCollection) {
        this.articleCollection = articleCollection;
    }

}
