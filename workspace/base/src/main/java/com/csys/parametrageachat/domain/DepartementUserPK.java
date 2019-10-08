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
 * @author Lenovo
 */
@Embeddable
public class DepartementUserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_departement_code")
    private int fkDepartementCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;

    public DepartementUserPK() {
    }

    public DepartementUserPK(int fkDepartementCode, String username) {
        this.fkDepartementCode = fkDepartementCode;
        this.username = username;
    }

    public int getFkDepartementCode() {
        return fkDepartementCode;
    }

    public void setFkDepartementCode(int fkDepartementCode) {
        this.fkDepartementCode = fkDepartementCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkDepartementCode;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartementUserPK)) {
            return false;
        }
        DepartementUserPK other = (DepartementUserPK) object;
        if (this.fkDepartementCode != other.fkDepartementCode) {
            return false;
        }
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.DepartementUserPK[ fkDepartementCode=" + fkDepartementCode + ", username=" + username + " ]";
    }
    
}
