package modelos;

import entidades.InscripcionesCurso;
import java.util.Date;

public class InscripcionCursoResponse implements Payload {
    private Integer identificador;
    private Date fechainscripcion;
    private String curso;
    private Integer notaFinal;
    private String carrera;
    
    public InscripcionCursoResponse(InscripcionesCurso inscrip) {
        this.identificador = inscrip.getIdentificador();
        this.fechainscripcion = inscrip.getFechainscripcion();
        this.curso = inscrip.getIdcurso().getNombre();
        this.notaFinal = inscrip.getNotafinal();
        this.carrera = inscrip.getIdcurso().getIdcarrera().getNombre();
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Integer notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    
    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
