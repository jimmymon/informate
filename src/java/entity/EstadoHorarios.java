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
@Table(name = "estadohorarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoHorarios.findAll", query = "SELECT e FROM EstadoHorarios e"),
    @NamedQuery(name = "EstadoHorarios.findByIdEstadoHorarios", query = "SELECT e FROM EstadoHorarios e WHERE e.estadoHorariosPK.idEstadoHorarios = :idEstadoHorarios"),
    @NamedQuery(name = "EstadoHorarios.findByEstado", query = "SELECT e FROM EstadoHorarios e WHERE e.estado = :estado"),
    @NamedQuery(name = "EstadoHorarios.findByDescripcionEstado", query = "SELECT e FROM EstadoHorarios e WHERE e.descripcionEstado = :descripcionEstado"),
    @NamedQuery(name = "EstadoHorarios.findByIdHorarios", query = "SELECT e FROM EstadoHorarios e WHERE e.estadoHorariosPK.idHorarios = :idHorarios")})
public class EstadoHorarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadoHorariosPK estadoHorariosPK;
    @Size(max = 11)
    @Column(name = "estado")
    private String estado;
    @Size(max = 60)
    @Column(name = "descripcionEstado")
    private String descripcionEstado;
    @JoinColumn(name = "idHorarios", referencedColumnName = "idHorarios", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Horarios horarios;

    public EstadoHorarios() {
    }

    public EstadoHorarios(EstadoHorariosPK estadoHorariosPK) {
        this.estadoHorariosPK = estadoHorariosPK;
    }

    public EstadoHorarios(int idEstadoHorarios, int idHorarios) {
        this.estadoHorariosPK = new EstadoHorariosPK(idEstadoHorarios, idHorarios);
    }

    public EstadoHorariosPK getEstadoHorariosPK() {
        return estadoHorariosPK;
    }

    public void setEstadoHorariosPK(EstadoHorariosPK estadoHorariosPK) {
        this.estadoHorariosPK = estadoHorariosPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public Horarios getHorarios() {
        return horarios;
    }

    public void setHorarios(Horarios horarios) {
        this.horarios = horarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoHorariosPK != null ? estadoHorariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoHorarios)) {
            return false;
        }
        EstadoHorarios other = (EstadoHorarios) object;
        if ((this.estadoHorariosPK == null && other.estadoHorariosPK != null) || (this.estadoHorariosPK != null && !this.estadoHorariosPK.equals(other.estadoHorariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.EstadoHorarios[ estadoHorariosPK=" + estadoHorariosPK + " ]";
    }
    
}
