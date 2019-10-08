package com.csys.parametrageachat.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EC")
public class ArticleEC extends Article {

    @Column(name = "pmp")
    private BigDecimal pmp;

    public BigDecimal getPmp() {
        return pmp;
    }

    public void setPmp(BigDecimal pmp) {
        this.pmp = pmp;
    }

}
