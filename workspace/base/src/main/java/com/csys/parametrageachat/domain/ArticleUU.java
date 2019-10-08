package com.csys.parametrageachat.domain;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("UU")
public class ArticleUU extends Article {

    @Column(name = "prix_vente_fixe")
    private BigDecimal prixVenteFixe;
    @Column(name = "prix_fixe")
    private Boolean prixFixe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleUU",orphanRemoval=true)
    private Collection<ArticleDepotPrix> articleDepotPrixCollection;

 
    public BigDecimal getPrixVenteFixe() {
        return prixVenteFixe;
    }

    public void setPrixVenteFixe(BigDecimal prixVenteFixe) {
        this.prixVenteFixe = prixVenteFixe;
    }

    public Boolean getPrixFixe() {
        return prixFixe;
    }

    public void setPrixFixe(Boolean prixFixe) {
        this.prixFixe = prixFixe;
    }

    public Collection<ArticleDepotPrix> getArticleDepotPrixCollection() {
        return articleDepotPrixCollection;
    }

    public void setArticleDepotPrixCollection(Collection<ArticleDepotPrix> articleDepotPrixCollection) {
        this.articleDepotPrixCollection = articleDepotPrixCollection;
    }
}
