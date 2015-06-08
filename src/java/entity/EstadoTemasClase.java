/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "estadotemasclase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoTemasClase.findAll", query = "SELECT e FROM EstadoTemasClase e"),
    @NamedQuery(name = "EstadoTemasClase.findByIdEstadoTemasClase", query = "SELECT e FROM EstadoTemasClase e WHERE e.estadoTemasClasePK.idEstadoTemasClase = :idEstadoTemasClase"),
    @NamedQuery(name = "EstadoTemasClase.findByEstadoTemaClase", query = "SELECT e FROM EstadoTemasClase e WHERE e.estadoTemaClase = :estadoTemaClase"),
    @NamedQuery(name = "EstadoTemasClase.findByIdTemasClase", query = "SELECT e FROM EstadoTemasClase e WHERE e.estadoTemasClasePK.idTemasClase = :idTemasClase")})
public class EstadoTemasClase implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadoTemasClasePK estadoTemasClasePK;
    @Size(max = 9)
    @Column(name = "estadoTemaClase")
    private String estadoTemaClase;
    @JoinColumn(name = "idTemasClase", referencedColumnName = "idTema", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TemasClase temasClase;

    public EstadoTemasClase() {
    }

    public EstadoTemasClase(EstadoTemasClasePK estadoTemasClasePK) {
        this.estadoTemasClasePK = estadoTemasClasePK;
    }

    public EstadoTemasClase(int idEstadoTemasClase, int idTemasClase) {
        this.estadoTemasClasePK = new EstadoTemasClasePK(idEstadoTemasClase, idTemasClase);
    }

    public EstadoTemasClasePK getEstadoTemasClasePK() {
        return estadoTemasClasePK;
    }

    public void setEstadoTemasClasePK(EstadoTemasClasePK estadoTemasClasePK) {
        this.estadoTemasClasePK = estadoTemasClasePK;
    }

    public String getEstadoTemaClase() {
        return estadoTemaClase;
    }

    public void setEstadoTemaClase(String estadoTemaClase) {
        this.estadoTemaClase = estadoTemaClase;
    }

    public TemasClase getTemasClase() {
        return temasClase;
    }

    public void setTemasClase(TemasClase temasClase) {
        this.temasClase = temasClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoTemasClasePK != null ? estadoTemasClasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoTemasClase)) {
            return false;
        }
        EstadoTemasClase other = (EstadoTemasClase) object;
        if ((this.estadoTemasClasePK == null && other.estadoTemasClasePK != null) || (this.estadoTemasClasePK != null && !this.estadoTemasClasePK.equals(other.estadoTemasClasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.EstadoTemasClase[ estadoTemasClasePK=" + estadoTemasClasePK + " ]";
    }
    
}
