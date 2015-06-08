/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findByIdCursos", query = "SELECT c FROM Cursos c WHERE c.idCursos = :idCursos"),
    @NamedQuery(name = "Cursos.findByTipoCurso", query = "SELECT c FROM Cursos c WHERE c.tipoCurso = :tipoCurso"),
    @NamedQuery(name = "Cursos.findByValorCurso", query = "SELECT c FROM Cursos c WHERE c.valorCurso = :valorCurso")})
public class Cursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCursos")
    private Integer idCursos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "tipoCurso")
    private String tipoCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorCurso")
    private int valorCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursos")
    private Collection<CursosEstudiantesInstructores> cursosEstudiantesInstructoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursos")
    private Collection<CursosClases> cursosClasesCollection;

    public Cursos() {
    }

    public Cursos(Integer idCursos) {
        this.idCursos = idCursos;
    }

    public Cursos(Integer idCursos, String tipoCurso, int valorCurso) {
        this.idCursos = idCursos;
        this.tipoCurso = tipoCurso;
        this.valorCurso = valorCurso;
    }

    public Integer getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(Integer idCursos) {
        this.idCursos = idCursos;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public int getValorCurso() {
        return valorCurso;
    }

    public void setValorCurso(int valorCurso) {
        this.valorCurso = valorCurso;
    }

    @XmlTransient
    public Collection<CursosEstudiantesInstructores> getCursosEstudiantesInstructoresCollection() {
        return cursosEstudiantesInstructoresCollection;
    }

    public void setCursosEstudiantesInstructoresCollection(Collection<CursosEstudiantesInstructores> cursosEstudiantesInstructoresCollection) {
        this.cursosEstudiantesInstructoresCollection = cursosEstudiantesInstructoresCollection;
    }

    @XmlTransient
    public Collection<CursosClases> getCursosClasesCollection() {
        return cursosClasesCollection;
    }

    public void setCursosClasesCollection(Collection<CursosClases> cursosClasesCollection) {
        this.cursosClasesCollection = cursosClasesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursos != null ? idCursos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.idCursos == null && other.idCursos != null) || (this.idCursos != null && !this.idCursos.equals(other.idCursos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.Cursos[ idCursos=" + idCursos + " ]";
    }
    
}
