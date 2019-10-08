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
import javax.validation.constraints.Size;

/**
 *
 * @author Farouk
 */
@Embeddable
public class ArticleFournisseurPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_article_code")
    private Integer fkArticleCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fk_fournisseur_code")
    private String fkFournisseurCode;

    public ArticleFournisseurPK() {
    }

    
    public Integer getFkArticleCode() {
        return fkArticleCode;
    }

    public void setFkArticleCode(Integer fkArticleCode) {
        this.fkArticleCode = fkArticleCode;
    }

    public String getFkFournisseurCode() {
        return fkFournisseurCode;
    }

    public void setFkFournisseurCode(String fkFournisseurCode) {
        this.fkFournisseurCode = fkFournisseurCode;
    }
    
}
