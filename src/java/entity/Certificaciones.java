/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "certificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificaciones.findAll", query = "SELECT c FROM Certificaciones c"),
    @NamedQuery(name = "Certificaciones.findByIdCertificaciones", query = "SELECT c FROM Certificaciones c WHERE c.certificacionesPK.idCertificaciones = :idCertificaciones"),
    @NamedQuery(name = "Certificaciones.findByNombreCertificado", query = "SELECT c FROM Certificaciones c WHERE c.nombreCertificado = :nombreCertificado"),
    @NamedQuery(name = "Certificaciones.findByIdExamen", query = "SELECT c FROM Certificaciones c WHERE c.certificacionesPK.idExamen = :idExamen")})
public class Certificaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CertificacionesPK certificacionesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreCertificado")
    private String nombreCertificado;
    @JoinColumn(name = "idExamen", referencedColumnName = "idExamen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Examenes examenes;

    public Certificaciones() {
    }

    public Certificaciones(CertificacionesPK certificacionesPK) {
        this.certificacionesPK = certificacionesPK;
    }

    public Certificaciones(CertificacionesPK certificacionesPK, String nombreCertificado) {
        this.certificacionesPK = certificacionesPK;
        this.nombreCertificado = nombreCertificado;
    }

    public Certificaciones(int idCertificaciones, int idExamen) {
        this.certificacionesPK = new CertificacionesPK(idCertificaciones, idExamen);
    }

    public CertificacionesPK getCertificacionesPK() {
        return certificacionesPK;
    }

    public void setCertificacionesPK(CertificacionesPK certificacionesPK) {
        this.certificacionesPK = certificacionesPK;
    }

    public String getNombreCertificado() {
        return nombreCertificado;
    }

    public void setNombreCertificado(String nombreCertificado) {
        this.nombreCertificado = nombreCertificado;
    }

    public Examenes getExamenes() {
        return examenes;
    }

    public void setExamenes(Examenes examenes) {
        this.examenes = examenes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (certificacionesPK != null ? certificacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificaciones)) {
            return false;
        }
        Certificaciones other = (Certificaciones) object;
        if ((this.certificacionesPK == null && other.certificacionesPK != null) || (this.certificacionesPK != null && !this.certificacionesPK.equals(other.certificacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.Certificaciones[ certificacionesPK=" + certificacionesPK + " ]";
    }
    
}
