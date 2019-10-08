/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Farouk
 */
@Embeddable
public class ArticleDepotPrixPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_depot_code")
    private Integer fkDepotCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_article_code")
    private Integer fkArticleCode;

    
    public int getFkDepotCode() {
        return fkDepotCode;
    }

    public void setFkDepotCode(Integer fkDepotCode) {
        this.fkDepotCode = fkDepotCode;
    }

    public Integer getFkArticleCode() {
        return fkArticleCode;
    }

    public void setFkArticleCode(Integer fkArticleCode) {
        this.fkArticleCode = fkArticleCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkDepotCode;
        hash += (int) fkArticleCode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleDepotPrixPK)) {
            return false;
        }
        ArticleDepotPrixPK other = (ArticleDepotPrixPK) object;
        if (this.fkDepotCode != other.fkDepotCode) {
            return false;
        }
        if (this.fkArticleCode != other.fkArticleCode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.ArticleDepotPrixPK[ fkDepotCode=" + fkDepotCode + ", fkArticleCode=" + fkArticleCode + " ]";
    }
    
}
