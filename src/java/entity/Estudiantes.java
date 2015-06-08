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
@Table(name = "estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByIdEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Estudiantes.findByTipoSangre", query = "SELECT e FROM Estudiantes e WHERE e.tipoSangre = :tipoSangre"),
    @NamedQuery(name = "Estudiantes.findByNombreContacto", query = "SELECT e FROM Estudiantes e WHERE e.nombreContacto = :nombreContacto"),
    @NamedQuery(name = "Estudiantes.findByTelefonoContacto", query = "SELECT e FROM Estudiantes e WHERE e.telefonoContacto = :telefonoContacto"),
    @NamedQuery(name = "Estudiantes.findByParentezco", query = "SELECT e FROM Estudiantes e WHERE e.parentezco = :parentezco")})
public class Estudiantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstudiante")
    private Long idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipoSangre")
    private String tipoSangre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreContacto")
    private String nombreContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefonoContacto")
    private String telefonoContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "parentezco")
    private String parentezco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Collection<CursosEstudiantesInstructores> cursosEstudiantesInstructoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Collection<Usuarios> usuariosCollection;

    public Estudiantes() {
    }

    public Estudiantes(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiantes(Long idEstudiante, String tipoSangre, String nombreContacto, String telefonoContacto, String parentezco) {
        this.idEstudiante = idEstudiante;
        this.tipoSangre = tipoSangre;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.parentezco = parentezco;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getParentezco() {
        return parentezco;
    }

    public void setParentezco(String parentezco) {
        this.parentezco = parentezco;
    }

    @XmlTransient
    public Collection<CursosEstudiantesInstructores> getCursosEstudiantesInstructoresCollection() {
        return cursosEstudiantesInstructoresCollection;
    }

    public void setCursosEstudiantesInstructoresCollection(Collection<CursosEstudiantesInstructores> cursosEstudiantesInstructoresCollection) {
        this.cursosEstudiantesInstructoresCollection = cursosEstudiantesInstructoresCollection;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.Estudiantes[ idEstudiante=" + idEstudiante + " ]";
    }
    
}
