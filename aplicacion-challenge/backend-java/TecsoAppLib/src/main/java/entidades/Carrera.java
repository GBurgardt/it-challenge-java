/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
 * @author germanburgardt
 */
@Entity
@Table(name = "carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c"),
    @NamedQuery(name = "Carrera.findByIdentificador", query = "SELECT c FROM Carrera c WHERE c.identificador = :identificador"),
    @NamedQuery(name = "Carrera.findByNombre", query = "SELECT c FROM Carrera c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Carrera.findByDescripcion", query = "SELECT c FROM Carrera c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Carrera.findByFechadesde", query = "SELECT c FROM Carrera c WHERE c.fechadesde = :fechadesde"),
    @NamedQuery(name = "Carrera.findByFechahasta", query = "SELECT c FROM Carrera c WHERE c.fechahasta = :fechahasta")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificador")
    private Integer identificador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechadesde")
    @Temporal(TemporalType.DATE)
    private Date fechadesde;
    @Column(name = "fechahasta")
    @Temporal(TemporalType.DATE)
    private Date fechahasta;
    @OneToMany(mappedBy = "idcarrera")
    private Collection<Curso> cursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcarrera")
    private Collection<InscripcionesCarrera> inscripcionesCarreraCollection;

    public Carrera() {
    }

    public Carrera(Integer identificador) {
        this.identificador = identificador;
    }

    public Carrera(Integer identificador, String nombre, Date fechadesde) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.fechadesde = fechadesde;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechadesde() {
        return fechadesde;
    }

    public void setFechadesde(Date fechadesde) {
        this.fechadesde = fechadesde;
    }

    public Date getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(Date fechahasta) {
        this.fechahasta = fechahasta;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @XmlTransient
    public Collection<InscripcionesCarrera> getInscripcionesCarreraCollection() {
        return inscripcionesCarreraCollection;
    }

    public void setInscripcionesCarreraCollection(Collection<InscripcionesCarrera> inscripcionesCarreraCollection) {
        this.inscripcionesCarreraCollection = inscripcionesCarreraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Carrera[ identificador=" + identificador + " ]";
    }
    
}
