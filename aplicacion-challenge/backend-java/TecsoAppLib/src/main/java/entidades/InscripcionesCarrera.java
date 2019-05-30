/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author germanburgardt
 */
@Entity
@Table(name = "inscripciones_carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InscripcionesCarrera.findAll", query = "SELECT i FROM InscripcionesCarrera i"),
    @NamedQuery(name = "InscripcionesCarrera.findByFechainscripcion", query = "SELECT i FROM InscripcionesCarrera i WHERE i.fechainscripcion = :fechainscripcion"),
    @NamedQuery(name = "InscripcionesCarrera.findById", query = "SELECT i FROM InscripcionesCarrera i WHERE i.id = :id")})
public class InscripcionesCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechainscripcion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "idalumno", referencedColumnName = "identificador")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "idcarrera", referencedColumnName = "identificador")
    @ManyToOne(optional = false)
    private Carrera idcarrera;

    public InscripcionesCarrera() {
    }

    public InscripcionesCarrera(Integer id) {
        this.id = id;
    }

    public InscripcionesCarrera(Integer id, Date fechainscripcion) {
        this.id = id;
        this.fechainscripcion = fechainscripcion;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Carrera getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Carrera idcarrera) {
        this.idcarrera = idcarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionesCarrera)) {
            return false;
        }
        InscripcionesCarrera other = (InscripcionesCarrera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.InscripcionesCarrera[ id=" + id + " ]";
    }
    
}
