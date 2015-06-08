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
public class CursosClasesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCursosClases")
    private int idCursosClases;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCursos")
    private int idCursos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClase")
    private int idClase;

    public CursosClasesPK() {
    }

    public CursosClasesPK(int idCursosClases, int idCursos, int idClase) {
        this.idCursosClases = idCursosClases;
        this.idCursos = idCursos;
        this.idClase = idClase;
    }

    public int getIdCursosClases() {
        return idCursosClases;
    }

    public void setIdCursosClases(int idCursosClases) {
        this.idCursosClases = idCursosClases;
    }

    public int getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
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
        hash += (int) idCursosClases;
        hash += (int) idCursos;
        hash += (int) idClase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosClasesPK)) {
            return false;
        }
        CursosClasesPK other = (CursosClasesPK) object;
        if (this.idCursosClases != other.idCursosClases) {
            return false;
        }
        if (this.idCursos != other.idCursos) {
            return false;
        }
        if (this.idClase != other.idClase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.CursosClasesPK[ idCursosClases=" + idCursosClases + ", idCursos=" + idCursos + ", idClase=" + idClase + " ]";
    }
    
}
