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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "temasclase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TemasClase.findAll", query = "SELECT t FROM TemasClase t"),
    @NamedQuery(name = "TemasClase.findByIdTema", query = "SELECT t FROM TemasClase t WHERE t.temasClasePK.idTema = :idTema"),
    @NamedQuery(name = "TemasClase.findByTemaClase", query = "SELECT t FROM TemasClase t WHERE t.temaClase = :temaClase"),
    @NamedQuery(name = "TemasClase.findByIdClase", query = "SELECT t FROM TemasClase t WHERE t.temasClasePK.idClase = :idClase"),
    @NamedQuery(name = "TemasClase.findByAsistenciaExtudiantes", query = "SELECT t FROM TemasClase t WHERE t.asistenciaExtudiantes = :asistenciaExtudiantes"),
    @NamedQuery(name = "TemasClase.findByNota", query = "SELECT t FROM TemasClase t WHERE t.nota = :nota")})
public class TemasClase implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TemasClasePK temasClasePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "temaClase")
    private String temaClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "asistenciaExtudiantes")
    private String asistenciaExtudiantes;
    @Column(name = "nota")
    private Integer nota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "temasClase")
    private Collection<EstadoTemasClase> estadoTemasClaseCollection;
    @JoinColumn(name = "idClase", referencedColumnName = "idClase", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "temasClase")
    private Collection<TemasExamenes> temasExamenesCollection;

    public TemasClase() {
    }

    public TemasClase(TemasClasePK temasClasePK) {
        this.temasClasePK = temasClasePK;
    }

    public TemasClase(TemasClasePK temasClasePK, String temaClase, String asistenciaExtudiantes) {
        this.temasClasePK = temasClasePK;
        this.temaClase = temaClase;
        this.asistenciaExtudiantes = asistenciaExtudiantes;
    }

    public TemasClase(int idTema, int idClase) {
        this.temasClasePK = new TemasClasePK(idTema, idClase);
    }

    public TemasClasePK getTemasClasePK() {
        return temasClasePK;
    }

    public void setTemasClasePK(TemasClasePK temasClasePK) {
        this.temasClasePK = temasClasePK;
    }

    public String getTemaClase() {
        return temaClase;
    }

    public void setTemaClase(String temaClase) {
        this.temaClase = temaClase;
    }

    public String getAsistenciaExtudiantes() {
        return asistenciaExtudiantes;
    }

    public void setAsistenciaExtudiantes(String asistenciaExtudiantes) {
        this.asistenciaExtudiantes = asistenciaExtudiantes;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @XmlTransient
    public Collection<EstadoTemasClase> getEstadoTemasClaseCollection() {
        return estadoTemasClaseCollection;
    }

    public void setEstadoTemasClaseCollection(Collection<EstadoTemasClase> estadoTemasClaseCollection) {
        this.estadoTemasClaseCollection = estadoTemasClaseCollection;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
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
        hash += (temasClasePK != null ? temasClasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemasClase)) {
            return false;
        }
        TemasClase other = (TemasClase) object;
        if ((this.temasClasePK == null && other.temasClasePK != null) || (this.temasClasePK != null && !this.temasClasePK.equals(other.temasClasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.TemasClase[ temasClasePK=" + temasClasePK + " ]";
    }
    
}
