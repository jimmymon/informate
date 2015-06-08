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
public class CursosEstudiantesInstructoresPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idCursosEstudiantesInstructores")
    private int idCursosEstudiantesInstructores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstudiante")
    private long idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInstructor")
    private long idInstructor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCursos")
    private int idCursos;

    public CursosEstudiantesInstructoresPK() {
    }

    public CursosEstudiantesInstructoresPK(int idCursosEstudiantesInstructores, long idEstudiante, long idInstructor, int idCursos) {
        this.idCursosEstudiantesInstructores = idCursosEstudiantesInstructores;
        this.idEstudiante = idEstudiante;
        this.idInstructor = idInstructor;
        this.idCursos = idCursos;
    }

    public int getIdCursosEstudiantesInstructores() {
        return idCursosEstudiantesInstructores;
    }

    public void setIdCursosEstudiantesInstructores(int idCursosEstudiantesInstructores) {
        this.idCursosEstudiantesInstructores = idCursosEstudiantesInstructores;
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public long getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(long idInstructor) {
        this.idInstructor = idInstructor;
    }

    public int getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCursosEstudiantesInstructores;
        hash += (int) idEstudiante;
        hash += (int) idInstructor;
        hash += (int) idCursos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosEstudiantesInstructoresPK)) {
            return false;
        }
        CursosEstudiantesInstructoresPK other = (CursosEstudiantesInstructoresPK) object;
        if (this.idCursosEstudiantesInstructores != other.idCursosEstudiantesInstructores) {
            return false;
        }
        if (this.idEstudiante != other.idEstudiante) {
            return false;
        }
        if (this.idInstructor != other.idInstructor) {
            return false;
        }
        if (this.idCursos != other.idCursos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.CursosEstudiantesInstructoresPK[ idCursosEstudiantesInstructores=" + idCursosEstudiantesInstructores + ", idEstudiante=" + idEstudiante + ", idInstructor=" + idInstructor + ", idCursos=" + idCursos + " ]";
    }
    
}
