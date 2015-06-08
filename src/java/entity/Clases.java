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
@Table(name = "clases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clases.findAll", query = "SELECT c FROM Clases c"),
    @NamedQuery(name = "Clases.findByIdClase", query = "SELECT c FROM Clases c WHERE c.idClase = :idClase"),
    @NamedQuery(name = "Clases.findByTipoClase", query = "SELECT c FROM Clases c WHERE c.tipoClase = :tipoClase"),
    @NamedQuery(name = "Clases.findByDescripcionLugar", query = "SELECT c FROM Clases c WHERE c.descripcionLugar = :descripcionLugar")})
public class Clases implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClase")
    private Integer idClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tipoClase")
    private String tipoClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DescripcionLugar")
    private String descripcionLugar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases")
    private Collection<CursosClases> cursosClasesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases")
    private Collection<Horarios> horariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases")
    private Collection<TemasClase> temasClaseCollection;

    public Clases() {
    }

    public Clases(Integer idClase) {
        this.idClase = idClase;
    }

    public Clases(Integer idClase, String tipoClase, String descripcionLugar) {
        this.idClase = idClase;
        this.tipoClase = tipoClase;
        this.descripcionLugar = descripcionLugar;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }

    public String getDescripcionLugar() {
        return descripcionLugar;
    }

    public void setDescripcionLugar(String descripcionLugar) {
        this.descripcionLugar = descripcionLugar;
    }

    @XmlTransient
    public Collection<CursosClases> getCursosClasesCollection() {
        return cursosClasesCollection;
    }

    public void setCursosClasesCollection(Collection<CursosClases> cursosClasesCollection) {
        this.cursosClasesCollection = cursosClasesCollection;
    }

    @XmlTransient
    public Collection<Horarios> getHorariosCollection() {
        return horariosCollection;
    }

    public void setHorariosCollection(Collection<Horarios> horariosCollection) {
        this.horariosCollection = horariosCollection;
    }

    @XmlTransient
    public Collection<TemasClase> getTemasClaseCollection() {
        return temasClaseCollection;
    }

    public void setTemasClaseCollection(Collection<TemasClase> temasClaseCollection) {
        this.temasClaseCollection = temasClaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClase != null ? idClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clases)) {
            return false;
        }
        Clases other = (Clases) object;
        if ((this.idClase == null && other.idClase != null) || (this.idClase != null && !this.idClase.equals(other.idClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.Clases[ idClase=" + idClase + " ]";
    }
    
}
