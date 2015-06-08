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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v"),
    @NamedQuery(name = "Vehiculos.findByIdVehiculo", query = "SELECT v FROM Vehiculos v WHERE v.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Vehiculos.findByCategoria", query = "SELECT v FROM Vehiculos v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "Vehiculos.findByTipo", query = "SELECT v FROM Vehiculos v WHERE v.tipo = :tipo"),
    @NamedQuery(name = "Vehiculos.findByMarca", query = "SELECT v FROM Vehiculos v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculos.findByFechaVigenciaSoat", query = "SELECT v FROM Vehiculos v WHERE v.fechaVigenciaSoat = :fechaVigenciaSoat"),
    @NamedQuery(name = "Vehiculos.findByFechaVigenciaAseguradora", query = "SELECT v FROM Vehiculos v WHERE v.fechaVigenciaAseguradora = :fechaVigenciaAseguradora")})
public class Vehiculos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idVehiculo")
    private String idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "Tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVigenciaSoat")
    @Temporal(TemporalType.DATE)
    private Date fechaVigenciaSoat;
    @Column(name = "fechaVigenciaAseguradora")
    @Temporal(TemporalType.DATE)
    private Date fechaVigenciaAseguradora;
    @ManyToMany(mappedBy = "vehiculosCollection")
    private Collection<Instructores> instructoresCollection;

    public Vehiculos() {
    }

    public Vehiculos(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculos(String idVehiculo, String categoria, String tipo, String marca, String modelo, Date fechaVigenciaSoat) {
        this.idVehiculo = idVehiculo;
        this.categoria = categoria;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaVigenciaSoat = fechaVigenciaSoat;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFechaVigenciaSoat() {
        return fechaVigenciaSoat;
    }

    public void setFechaVigenciaSoat(Date fechaVigenciaSoat) {
        this.fechaVigenciaSoat = fechaVigenciaSoat;
    }

    public Date getFechaVigenciaAseguradora() {
        return fechaVigenciaAseguradora;
    }

    public void setFechaVigenciaAseguradora(Date fechaVigenciaAseguradora) {
        this.fechaVigenciaAseguradora = fechaVigenciaAseguradora;
    }

    @XmlTransient
    public Collection<Instructores> getInstructoresCollection() {
        return instructoresCollection;
    }

    public void setInstructoresCollection(Collection<Instructores> instructoresCollection) {
        this.instructoresCollection = instructoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.Vehiculos[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
