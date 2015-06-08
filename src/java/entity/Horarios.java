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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h"),
    @NamedQuery(name = "Horarios.findByIdHorarios", query = "SELECT h FROM Horarios h WHERE h.horariosPK.idHorarios = :idHorarios"),
    @NamedQuery(name = "Horarios.findByFechaClase", query = "SELECT h FROM Horarios h WHERE h.fechaClase = :fechaClase"),
    @NamedQuery(name = "Horarios.findByHoraInicial", query = "SELECT h FROM Horarios h WHERE h.horaInicial = :horaInicial"),
    @NamedQuery(name = "Horarios.findByHoraFinal", query = "SELECT h FROM Horarios h WHERE h.horaFinal = :horaFinal"),
    @NamedQuery(name = "Horarios.findByIdClase", query = "SELECT h FROM Horarios h WHERE h.horariosPK.idClase = :idClase")})
public class Horarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorariosPK horariosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaClase")
    @Temporal(TemporalType.DATE)
    private Date fechaClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "horaInicial")
    private String horaInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "horaFinal")
    private String horaFinal;
    @JoinColumn(name = "idClase", referencedColumnName = "idClase", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarios")
    private Collection<EstadoHorarios> estadoHorariosCollection;

    public Horarios() {
    }

    public Horarios(HorariosPK horariosPK) {
        this.horariosPK = horariosPK;
    }

    public Horarios(HorariosPK horariosPK, Date fechaClase, String horaInicial, String horaFinal) {
        this.horariosPK = horariosPK;
        this.fechaClase = fechaClase;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    public Horarios(int idHorarios, int idClase) {
        this.horariosPK = new HorariosPK(idHorarios, idClase);
    }

    public HorariosPK getHorariosPK() {
        return horariosPK;
    }

    public void setHorariosPK(HorariosPK horariosPK) {
        this.horariosPK = horariosPK;
    }

    public Date getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
    }

    @XmlTransient
    public Collection<EstadoHorarios> getEstadoHorariosCollection() {
        return estadoHorariosCollection;
    }

    public void setEstadoHorariosCollection(Collection<EstadoHorarios> estadoHorariosCollection) {
        this.estadoHorariosCollection = estadoHorariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horariosPK != null ? horariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.horariosPK == null && other.horariosPK != null) || (this.horariosPK != null && !this.horariosPK.equals(other.horariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.Horarios[ horariosPK=" + horariosPK + " ]";
    }
    
}
