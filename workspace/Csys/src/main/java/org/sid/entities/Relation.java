/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author K555L
 */
@Entity
@Table(name = "relation")
@NamedQueries({
    @NamedQuery(name = "Relation.findAll", query = "SELECT r FROM Relation r")})
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelationPK relationPK;
    @Size(max = 10)
    @Column(name = "qte_commande")
    private String qteCommande;
    @JoinColumn(name = "code_art", referencedColumnName = "code_art", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @MapsId("codeArt")
    private Article article;
    @JsonBackReference
    @JoinColumn(name = "code_commande", referencedColumnName = "code_commande", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @MapsId("codeCommande")
    private Commande commande;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Relation() {
    }

    public Relation(RelationPK relationPK) {
        this.relationPK = relationPK;
    }

    public Relation(int codeArt, int codeCommande) {
        this.relationPK = new RelationPK(codeArt, codeCommande);
    }

    public RelationPK getRelationPK() {
        return relationPK;
    }

    public void setRelationPK(RelationPK relationPK) {
        this.relationPK = relationPK;
    }

    public String getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(String qteCommande) {
        this.qteCommande = qteCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relationPK != null ? relationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relation)) {
            return false;
        }
        Relation other = (Relation) object;
        if ((this.relationPK == null && other.relationPK != null) || (this.relationPK != null && !this.relationPK.equals(other.relationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.myproject.domain.Relation[ relationPK=" + relationPK + " ]";
    }

   

}
