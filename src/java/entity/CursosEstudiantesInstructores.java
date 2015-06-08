/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cursosestudiantesinstructores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursosEstudiantesInstructores.findAll", query = "SELECT c FROM CursosEstudiantesInstructores c"),
    @NamedQuery(name = "CursosEstudiantesInstructores.findByIdCursosEstudiantesInstructores", query = "SELECT c FROM CursosEstudiantesInstructores c WHERE c.cursosEstudiantesInstructoresPK.idCursosEstudiantesInstructores = :idCursosEstudiantesInstructores"),
    @NamedQuery(name = "CursosEstudiantesInstructores.findByIdEstudiante", query = "SELECT c FROM CursosEstudiantesInstructores c WHERE c.cursosEstudiantesInstructoresPK.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "CursosEstudiantesInstructores.findByIdInstructor", query = "SELECT c FROM CursosEstudiantesInstructores c WHERE c.cursosEstudiantesInstructoresPK.idInstructor = :idInstructor"),
    @NamedQuery(name = "CursosEstudiantesInstructores.findByIdCursos", query = "SELECT c FROM CursosEstudiantesInstructores c WHERE c.cursosEstudiantesInstructoresPK.idCursos = :idCursos")})
public class CursosEstudiantesInstructores implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursosEstudiantesInstructoresPK cursosEstudiantesInstructoresPK;
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;
    @JoinColumn(name = "idInstructor", referencedColumnName = "idInstructor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Instructores instructores;
    @JoinColumn(name = "idCursos", referencedColumnName = "idCursos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cursos cursos;

    public CursosEstudiantesInstructores() {
    }

    public CursosEstudiantesInstructores(CursosEstudiantesInstructoresPK cursosEstudiantesInstructoresPK) {
        this.cursosEstudiantesInstructoresPK = cursosEstudiantesInstructoresPK;
    }

    public CursosEstudiantesInstructores(int idCursosEstudiantesInstructores, long idEstudiante, long idInstructor, int idCursos) {
        this.cursosEstudiantesInstructoresPK = new CursosEstudiantesInstructoresPK(idCursosEstudiantesInstructores, idEstudiante, idInstructor, idCursos);
    }

    public CursosEstudiantesInstructoresPK getCursosEstudiantesInstructoresPK() {
        return cursosEstudiantesInstructoresPK;
    }

    public void setCursosEstudiantesInstructoresPK(CursosEstudiantesInstructoresPK cursosEstudiantesInstructoresPK) {
        this.cursosEstudiantesInstructoresPK = cursosEstudiantesInstructoresPK;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Instructores getInstructores() {
        return instructores;
    }

    public void setInstructores(Instructores instructores) {
        this.instructores = instructores;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursosEstudiantesInstructoresPK != null ? cursosEstudiantesInstructoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosEstudiantesInstructores)) {
            return false;
        }
        CursosEstudiantesInstructores other = (CursosEstudiantesInstructores) object;
        if ((this.cursosEstudiantesInstructoresPK == null && other.cursosEstudiantesInstructoresPK != null) || (this.cursosEstudiantesInstructoresPK != null && !this.cursosEstudiantesInstructoresPK.equals(other.cursosEstudiantesInstructoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.CursosEstudiantesInstructores[ cursosEstudiantesInstructoresPK=" + cursosEstudiantesInstructoresPK + " ]";
    }
    
}
