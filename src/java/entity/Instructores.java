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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "instructores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructores.findAll", query = "SELECT i FROM Instructores i"),
    @NamedQuery(name = "Instructores.findByIdInstructor", query = "SELECT i FROM Instructores i WHERE i.idInstructor = :idInstructor"),
    @NamedQuery(name = "Instructores.findByEstadoCivil", query = "SELECT i FROM Instructores i WHERE i.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Instructores.findByNivelAcademico", query = "SELECT i FROM Instructores i WHERE i.nivelAcademico = :nivelAcademico"),
    @NamedQuery(name = "Instructores.findByProfesion", query = "SELECT i FROM Instructores i WHERE i.profesion = :profesion"),
    @NamedQuery(name = "Instructores.findByTipoInstructor", query = "SELECT i FROM Instructores i WHERE i.tipoInstructor = :tipoInstructor")})
public class Instructores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInstructor")
    private Long idInstructor;
    @Size(max = 11)
    @Column(name = "estadoCivil")
    private String estadoCivil;
    @Size(max = 11)
    @Column(name = "nivelAcademico")
    private String nivelAcademico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "profesion")
    private String profesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "tipoInstructor")
    private String tipoInstructor;
    @JoinTable(name = "instructoresvehiculos", joinColumns = {
        @JoinColumn(name = "IdInstructor", referencedColumnName = "idInstructor")}, inverseJoinColumns = {
        @JoinColumn(name = "IdVehiculo", referencedColumnName = "idVehiculo")})
    @ManyToMany
    private Collection<Vehiculos> vehiculosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructores")
    private Collection<CursosEstudiantesInstructores> cursosEstudiantesInstructoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructores")
    private Collection<Usuarios> usuariosCollection;

    public Instructores() {
    }

    public Instructores(Long idInstructor) {
        this.idInstructor = idInstructor;
    }

    public Instructores(Long idInstructor, String profesion, String tipoInstructor) {
        this.idInstructor = idInstructor;
        this.profesion = profesion;
        this.tipoInstructor = tipoInstructor;
    }

    public Long getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Long idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTipoInstructor() {
        return tipoInstructor;
    }

    public void setTipoInstructor(String tipoInstructor) {
        this.tipoInstructor = tipoInstructor;
    }

    @XmlTransient
    public Collection<Vehiculos> getVehiculosCollection() {
        return vehiculosCollection;
    }

    public void setVehiculosCollection(Collection<Vehiculos> vehiculosCollection) {
        this.vehiculosCollection = vehiculosCollection;
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
        hash += (idInstructor != null ? idInstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructores)) {
            return false;
        }
        Instructores other = (Instructores) object;
        if ((this.idInstructor == null && other.idInstructor != null) || (this.idInstructor != null && !this.idInstructor.equals(other.idInstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.Instructores[ idInstructor=" + idInstructor + " ]";
    }
    
}
