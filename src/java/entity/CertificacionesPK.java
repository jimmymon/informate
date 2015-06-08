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
public class CertificacionesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idCertificaciones")
    private int idCertificaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idExamen")
    private int idExamen;

    public CertificacionesPK() {
    }

    public CertificacionesPK(int idCertificaciones, int idExamen) {
        this.idCertificaciones = idCertificaciones;
        this.idExamen = idExamen;
    }

    public int getIdCertificaciones() {
        return idCertificaciones;
    }

    public void setIdCertificaciones(int idCertificaciones) {
        this.idCertificaciones = idCertificaciones;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCertificaciones;
        hash += (int) idExamen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CertificacionesPK)) {
            return false;
        }
        CertificacionesPK other = (CertificacionesPK) object;
        if (this.idCertificaciones != other.idCertificaciones) {
            return false;
        }
        if (this.idExamen != other.idExamen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.CertificacionesPK[ idCertificaciones=" + idCertificaciones + ", idExamen=" + idExamen + " ]";
    }
    
}
