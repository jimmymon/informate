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
public class UsuariosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarios")
    private long idUsuarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuarios_idUsuarios")
    private long usuariosidUsuarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estudiantes_idEstudiante")
    private long estudiantesidEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Instructores_idInstructor")
    private long instructoresidInstructor;

    public UsuariosPK() {
    }

    public UsuariosPK(long idUsuarios, long usuariosidUsuarios, long estudiantesidEstudiante, long instructoresidInstructor) {
        this.idUsuarios = idUsuarios;
        this.usuariosidUsuarios = usuariosidUsuarios;
        this.estudiantesidEstudiante = estudiantesidEstudiante;
        this.instructoresidInstructor = instructoresidInstructor;
    }

    public long getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(long idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public long getUsuariosidUsuarios() {
        return usuariosidUsuarios;
    }

    public void setUsuariosidUsuarios(long usuariosidUsuarios) {
        this.usuariosidUsuarios = usuariosidUsuarios;
    }

    public long getEstudiantesidEstudiante() {
        return estudiantesidEstudiante;
    }

    public void setEstudiantesidEstudiante(long estudiantesidEstudiante) {
        this.estudiantesidEstudiante = estudiantesidEstudiante;
    }

    public long getInstructoresidInstructor() {
        return instructoresidInstructor;
    }

    public void setInstructoresidInstructor(long instructoresidInstructor) {
        this.instructoresidInstructor = instructoresidInstructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuarios;
        hash += (int) usuariosidUsuarios;
        hash += (int) estudiantesidEstudiante;
        hash += (int) instructoresidInstructor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosPK)) {
            return false;
        }
        UsuariosPK other = (UsuariosPK) object;
        if (this.idUsuarios != other.idUsuarios) {
            return false;
        }
        if (this.usuariosidUsuarios != other.usuariosidUsuarios) {
            return false;
        }
        if (this.estudiantesidEstudiante != other.estudiantesidEstudiante) {
            return false;
        }
        if (this.instructoresidInstructor != other.instructoresidInstructor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.UsuariosPK[ idUsuarios=" + idUsuarios + ", usuariosidUsuarios=" + usuariosidUsuarios + ", estudiantesidEstudiante=" + estudiantesidEstudiante + ", instructoresidInstructor=" + instructoresidInstructor + " ]";
    }
    
}
