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
public class EstadoHorariosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idEstadoHorarios")
    private int idEstadoHorarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHorarios")
    private int idHorarios;

    public EstadoHorariosPK() {
    }

    public EstadoHorariosPK(int idEstadoHorarios, int idHorarios) {
        this.idEstadoHorarios = idEstadoHorarios;
        this.idHorarios = idHorarios;
    }

    public int getIdEstadoHorarios() {
        return idEstadoHorarios;
    }

    public void setIdEstadoHorarios(int idEstadoHorarios) {
        this.idEstadoHorarios = idEstadoHorarios;
    }

    public int getIdHorarios() {
        return idHorarios;
    }

    public void setIdHorarios(int idHorarios) {
        this.idHorarios = idHorarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEstadoHorarios;
        hash += (int) idHorarios;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoHorariosPK)) {
            return false;
        }
        EstadoHorariosPK other = (EstadoHorariosPK) object;
        if (this.idEstadoHorarios != other.idEstadoHorarios) {
            return false;
        }
        if (this.idHorarios != other.idHorarios) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.EstadoHorariosPK[ idEstadoHorarios=" + idEstadoHorarios + ", idHorarios=" + idHorarios + " ]";
    }
    
}
