/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Embeddable
public class TemasClasePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTema")
    private int idTema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClase")
    private int idClase;

    public TemasClasePK() {
    }

    public TemasClasePK(int idTema, int idClase) {
        this.idTema = idTema;
        this.idClase = idClase;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTema;
        hash += (int) idClase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemasClasePK)) {
            return false;
        }
        TemasClasePK other = (TemasClasePK) object;
        if (this.idTema != other.idTema) {
            return false;
        }
        if (this.idClase != other.idClase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.TemasClasePK[ idTema=" + idTema + ", idClase=" + idClase + " ]";
    }
    
}
