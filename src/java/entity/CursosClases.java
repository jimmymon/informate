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
@Table(name = "cursosclases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursosClases.findAll", query = "SELECT c FROM CursosClases c"),
    @NamedQuery(name = "CursosClases.findByIdCursosClases", query = "SELECT c FROM CursosClases c WHERE c.cursosClasesPK.idCursosClases = :idCursosClases"),
    @NamedQuery(name = "CursosClases.findByIdCursos", query = "SELECT c FROM CursosClases c WHERE c.cursosClasesPK.idCursos = :idCursos"),
    @NamedQuery(name = "CursosClases.findByIdClase", query = "SELECT c FROM CursosClases c WHERE c.cursosClasesPK.idClase = :idClase")})
public class CursosClases implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursosClasesPK cursosClasesPK;
    @JoinColumn(name = "idCursos", referencedColumnName = "idCursos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cursos cursos;
    @JoinColumn(name = "idClase", referencedColumnName = "idClase", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;

    public CursosClases() {
    }

    public CursosClases(CursosClasesPK cursosClasesPK) {
        this.cursosClasesPK = cursosClasesPK;
    }

    public CursosClases(int idCursosClases, int idCursos, int idClase) {
        this.cursosClasesPK = new CursosClasesPK(idCursosClases, idCursos, idClase);
    }

    public CursosClasesPK getCursosClasesPK() {
        return cursosClasesPK;
    }

    public void setCursosClasesPK(CursosClasesPK cursosClasesPK) {
        this.cursosClasesPK = cursosClasesPK;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursosClasesPK != null ? cursosClasesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursosClases)) {
            return false;
        }
        CursosClases other = (CursosClases) object;
        if ((this.cursosClasesPK == null && other.cursosClasesPK != null) || (this.cursosClasesPK != null && !this.cursosClasesPK.equals(other.cursosClasesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.CursosClases[ cursosClasesPK=" + cursosClasesPK + " ]";
    }
    
}
