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
public class EstadoTemasClasePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idEstadoTemasClase")
    private int idEstadoTemasClase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTemasClase")
    private int idTemasClase;

    public EstadoTemasClasePK() {
    }

    public EstadoTemasClasePK(int idEstadoTemasClase, int idTemasClase) {
        this.idEstadoTemasClase = idEstadoTemasClase;
        this.idTemasClase = idTemasClase;
    }

    public int getIdEstadoTemasClase() {
        return idEstadoTemasClase;
    }

    public void setIdEstadoTemasClase(int idEstadoTemasClase) {
        this.idEstadoTemasClase = idEstadoTemasClase;
    }

    public int getIdTemasClase() {
        return idTemasClase;
    }

    public void setIdTemasClase(int idTemasClase) {
        this.idTemasClase = idTemasClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEstadoTemasClase;
        hash += (int) idTemasClase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoTemasClasePK)) {
            return false;
        }
        EstadoTemasClasePK other = (EstadoTemasClasePK) object;
        if (this.idEstadoTemasClase != other.idEstadoTemasClase) {
            return false;
        }
        if (this.idTemasClase != other.idTemasClase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.EstadoTemasClasePK[ idEstadoTemasClase=" + idEstadoTemasClase + ", idTemasClase=" + idTemasClase + " ]";
    }
    
}
