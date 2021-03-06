package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "inscripciones_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InscripcionesCurso.findAll", query = "SELECT i FROM InscripcionesCurso i"),
    @NamedQuery(name = "InscripcionesCurso.findByIdentificador", query = "SELECT i FROM InscripcionesCurso i WHERE i.identificador = :identificador"),
    @NamedQuery(name = "InscripcionesCurso.findByFechainscripcion", query = "SELECT i FROM InscripcionesCurso i WHERE i.fechainscripcion = :fechainscripcion"),
    @NamedQuery(name = "InscripcionesCurso.findByNotafinal", query = "SELECT i FROM InscripcionesCurso i WHERE i.notafinal = :notafinal")})
public class InscripcionesCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identificador")
    private Integer identificador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechainscripcion;
    @Column(name = "notafinal")
    private Integer notafinal;
    @JoinColumn(name = "idalumno", referencedColumnName = "identificador")
    @ManyToOne(optional = false)
    private Alumno idalumno;
    @JoinColumn(name = "idcurso", referencedColumnName = "identificador")
    @ManyToOne(optional = false)
    private Curso idcurso;

    public InscripcionesCurso() {
    }

    public InscripcionesCurso(Integer identificador) {
        this.identificador = identificador;
    }

    public InscripcionesCurso(Integer identificador, Date fechainscripcion) {
        this.identificador = identificador;
        this.fechainscripcion = fechainscripcion;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public Integer getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(Integer notafinal) {
        this.notafinal = notafinal;
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
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
        if (!(object instanceof InscripcionesCurso)) {
            return false;
        }
        InscripcionesCurso other = (InscripcionesCurso) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.InscripcionesCurso[ identificador=" + identificador + " ]";
    }
    
}
