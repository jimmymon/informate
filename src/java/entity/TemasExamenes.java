/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "temasexamenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TemasExamenes.findAll", query = "SELECT t FROM TemasExamenes t"),
    @NamedQuery(name = "TemasExamenes.findByIdTemasExamenes", query = "SELECT t FROM TemasExamenes t WHERE t.temasExamenesPK.idTemasExamenes = :idTemasExamenes"),
    @NamedQuery(name = "TemasExamenes.findByIdExamen", query = "SELECT t FROM TemasExamenes t WHERE t.temasExamenesPK.idExamen = :idExamen"),
    @NamedQuery(name = "TemasExamenes.findByIdTema", query = "SELECT t FROM TemasExamenes t WHERE t.temasExamenesPK.idTema = :idTema")})
public class TemasExamenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TemasExamenesPK temasExamenesPK;
    @JoinColumn(name = "idExamen", referencedColumnName = "idExamen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Examenes examenes;
    @JoinColumn(name = "idTema", referencedColumnName = "idTema", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TemasClase temasClase;

    public TemasExamenes() {
    }

    public TemasExamenes(TemasExamenesPK temasExamenesPK) {
        this.temasExamenesPK = temasExamenesPK;
    }

    public TemasExamenes(int idTemasExamenes, int idExamen, int idTema) {
        this.temasExamenesPK = new TemasExamenesPK(idTemasExamenes, idExamen, idTema);
    }

    public TemasExamenesPK getTemasExamenesPK() {
        return temasExamenesPK;
    }

    public void setTemasExamenesPK(TemasExamenesPK temasExamenesPK) {
        this.temasExamenesPK = temasExamenesPK;
    }

    public Examenes getExamenes() {
        return examenes;
    }

    public void setExamenes(Examenes examenes) {
        this.examenes = examenes;
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
        hash += (temasExamenesPK != null ? temasExamenesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemasExamenes)) {
            return false;
        }
        TemasExamenes other = (TemasExamenes) object;
        if ((this.temasExamenesPK == null && other.temasExamenesPK != null) || (this.temasExamenesPK != null && !this.temasExamenesPK.equals(other.temasExamenesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtity.TemasExamenes[ temasExamenesPK=" + temasExamenesPK + " ]";
    }
    
}
