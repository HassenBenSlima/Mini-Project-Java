package com.csys.parametrageachat.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@DiscriminatorValue("PH")
@NamedEntityGraph(name = "ArticleWithAllNodes",
        attributeNodes
        = @NamedAttributeNode("articleFournisseurCollection")
)
public class ArticlePH extends Article {

    @Size(max = 50)
    @Column(name = "dose")
    private String dose;
    @JoinTable(name = "article_dci", joinColumns = {
        @JoinColumn(name = "fk_article_code", referencedColumnName = "code")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_dci_code", referencedColumnName = "code")})
    @ManyToMany()
    private Collection<Dci> dciCollection;
    @JoinTable(name = "article_specialite", joinColumns = {
        @JoinColumn(name = "fk_article_code", referencedColumnName = "code")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_specialite_code", referencedColumnName = "code")})
    @ManyToMany()
    private Collection<Specialite> specialiteCollection;
    @JoinColumn(name = "fk_forme_code", referencedColumnName = "code")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Forme fkFormeCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articlePH")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ArticleUnite> articleUniteCollection;

//	    public ArticleAutre() {
//			
//		}
    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Collection<Dci> getDciCollection() {
        return dciCollection;
    }

    public void setDciCollection(Collection<Dci> dciCollection) {
        this.dciCollection = dciCollection;
    }

    public Collection<Specialite> getSpecialiteCollection() {
        return specialiteCollection;
    }

    public void setSpecialiteCollection(Collection<Specialite> specialiteCollection) {
        this.specialiteCollection = specialiteCollection;
    }

    public Forme getFkFormeCode() {
        return fkFormeCode;
    }

    public void setFkFormeCode(Forme fkFormeCode) {
        this.fkFormeCode = fkFormeCode;
    }

    public Collection<ArticleUnite> getArticleUniteCollection() {
        return articleUniteCollection;
    }

    public void setArticleUniteCollection(Collection<ArticleUnite> articleUniteCollection) {
        this.articleUniteCollection = articleUniteCollection;
    }

}
