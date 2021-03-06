/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author germanburgardt
 */
@Entity
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByIdentificador", query = "SELECT a FROM Alumno a WHERE a.identificador = :identificador"),
    @NamedQuery(name = "Alumno.findByLegajo", query = "SELECT a FROM Alumno a WHERE a.legajo = :legajo"),
    @NamedQuery(name = "Alumno.findByClave", query = "SELECT a FROM Alumno a WHERE a.clave = :clave")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identificador")
    private Integer identificador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "legajo")
    private int legajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "clave")
    private String clave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private Collection<InscripcionesCurso> inscripcionesCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private Collection<Acceso> accesoCollection;
    @JoinColumn(name = "idpersona", referencedColumnName = "identificador")
    @OneToOne
    private Persona idpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private Collection<InscripcionesCarrera> inscripcionesCarreraCollection;

    public Alumno() {
    }

    public Alumno(Integer identificador) {
        this.identificador = identificador;
    }

    public Alumno(Integer identificador, int legajo, String clave) {
        this.identificador = identificador;
        this.legajo = legajo;
        this.clave = clave;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @XmlTransient
    public Collection<InscripcionesCurso> getInscripcionesCursoCollection() {
        return inscripcionesCursoCollection;
    }

    public void setInscripcionesCursoCollection(Collection<InscripcionesCurso> inscripcionesCursoCollection) {
        this.inscripcionesCursoCollection = inscripcionesCursoCollection;
    }

    @XmlTransient
    public Collection<Acceso> getAccesoCollection() {
        return accesoCollection;
    }

    public void setAccesoCollection(Collection<Acceso> accesoCollection) {
        this.accesoCollection = accesoCollection;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
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
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Alumno[ identificador=" + identificador + " ]";
    }
    
}
