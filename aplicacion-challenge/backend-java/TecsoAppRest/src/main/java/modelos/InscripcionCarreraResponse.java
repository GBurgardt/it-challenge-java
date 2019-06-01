package modelos;

import entidades.InscripcionesCarrera;
import java.util.Date;

public class InscripcionCarreraResponse implements Payload {
    private Integer identificador;
    private Date fechainscripcion;
    private String carrera;
    
    public InscripcionCarreraResponse(InscripcionesCarrera inscrip) {
        this.identificador = inscrip.getIdentificador();
        this.carrera = inscrip.getIdcarrera().getNombre();
        this.fechainscripcion = inscrip.getFechainscripcion();
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

    
    
    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
