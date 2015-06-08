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
public class HorariosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idHorarios")
    private int idHorarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClase")
    private int idClase;

    public HorariosPK() {
    }

    public HorariosPK(int idHorarios, int idClase) {
        this.idHorarios = idHorarios;
        this.idClase = idClase;
    }

    public int getIdHorarios() {
        return idHorarios;
    }

    public void setIdHorarios(int idHorarios) {
        this.idHorarios = idHorarios;
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
        hash += (int) idHorarios;
        hash += (int) idClase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorariosPK)) {
            return false;
        }
        HorariosPK other = (HorariosPK) object;
        if (this.idHorarios != other.idHorarios) {
            return false;
        }
        if (this.idClase != other.idClase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.HorariosPK[ idHorarios=" + idHorarios + ", idClase=" + idClase + " ]";
    }
    
}
