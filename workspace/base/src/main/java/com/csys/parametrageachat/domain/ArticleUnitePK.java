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
public class ArticleUnitePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_article_code")
    private Integer fkArticleCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_unite_code")
    private Integer fkUniteCode;

    public ArticleUnitePK() {
    }

    public ArticleUnitePK(Integer fkArticleCode, Integer fkUniteCode) {
        this.fkArticleCode = fkArticleCode;
        this.fkUniteCode = fkUniteCode;
    }

    public Integer getFkArticleCode() {
        return fkArticleCode;
    }

    public void setFkArticleCode(Integer fkArticleCode) {
        this.fkArticleCode = fkArticleCode;
    }

    public Integer getFkUniteCode() {
        return fkUniteCode;
    }

    public void setFkUniteCode(Integer fkUniteCode) {
        this.fkUniteCode = fkUniteCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkArticleCode;
        hash += (int) fkUniteCode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleUnitePK)) {
            return false;
        }
        ArticleUnitePK other = (ArticleUnitePK) object;
        if (this.fkArticleCode != other.fkArticleCode) {
            return false;
        }
        if (this.fkUniteCode != other.fkUniteCode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.ArticleUnitePK[ fkArticleCode=" + fkArticleCode + ", fkUniteCode=" + fkUniteCode + " ]";
    }
    
}
