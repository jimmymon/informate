/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "examenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examenes.findAll", query = "SELECT e FROM Examenes e"),
    @NamedQuery(name = "Examenes.findByIdExamen", query = "SELECT e FROM Examenes e WHERE e.idExamen = :idExamen"),
    @NamedQuery(name = "Examenes.findByFechaExamen", query = "SELECT e FROM Examenes e WHERE e.fechaExamen = :fechaExamen"),
    @NamedQuery(name = "Examenes.findByAprobovacion", query = "SELECT e FROM Examenes e WHERE e.aprobovacion = :aprobovacion")})
public class Examenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idExamen")
    private Integer idExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaExamen")
    @Temporal(TemporalType.DATE)
    private Date fechaExamen;
    @Size(max = 3)
    @Column(name = "Aprobovacion")
    private String aprobovacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examenes")
    private Collection<Certificaciones> certificacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examenes")
    private Collection<TemasExamenes> temasExamenesCollection;

    public Examenes() {
    }

    public Examenes(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public Examenes(Integer idExamen, Date fechaExamen) {
        this.idExamen = idExamen;
        this.fechaExamen = fechaExamen;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getAprobovacion() {
        return aprobovacion;
    }

    public void setAprobovacion(String aprobovacion) {
        this.aprobovacion = aprobovacion;
    }

    @XmlTransient
    public Collection<Certificaciones> getCertificacionesCollection() {
        return certificacionesCollection;
    }

    public void setCertificacionesCollection(Collection<Certificaciones> certificacionesCollection) {
        this.certificacionesCollection = certificacionesCollection;
    }

    @XmlTransient
    public Collection<TemasExamenes> getTemasExamenesCollection() {
        return temasExamenesCollection;
    }

    public void setTemasExamenesCollection(Collection<TemasExamenes> temasExamenesCollection) {
        this.temasExamenesCollection = temasExamenesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamen != null ? idExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examenes)) {
            return false;
        }
        Examenes other = (Examenes) object;
        if ((this.idExamen == null && other.idExamen != null) || (this.idExamen != null && !this.idExamen.equals(other.idExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.Examenes[ idExamen=" + idExamen + " ]";
    }
    
}
