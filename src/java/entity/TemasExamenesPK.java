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
public class TemasExamenesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTemasExamenes")
    private int idTemasExamenes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idExamen")
    private int idExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTema")
    private int idTema;

    public TemasExamenesPK() {
    }

    public TemasExamenesPK(int idTemasExamenes, int idExamen, int idTema) {
        this.idTemasExamenes = idTemasExamenes;
        this.idExamen = idExamen;
        this.idTema = idTema;
    }

    public int getIdTemasExamenes() {
        return idTemasExamenes;
    }

    public void setIdTemasExamenes(int idTemasExamenes) {
        this.idTemasExamenes = idTemasExamenes;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTemasExamenes;
        hash += (int) idExamen;
        hash += (int) idTema;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemasExamenesPK)) {
            return false;
        }
        TemasExamenesPK other = (TemasExamenesPK) object;
        if (this.idTemasExamenes != other.idTemasExamenes) {
            return false;
        }
        if (this.idExamen != other.idExamen) {
            return false;
        }
        if (this.idTema != other.idTema) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.TemasExamenesPK[ idTemasExamenes=" + idTemasExamenes + ", idExamen=" + idExamen + ", idTema=" + idTema + " ]";
    }
    
}
