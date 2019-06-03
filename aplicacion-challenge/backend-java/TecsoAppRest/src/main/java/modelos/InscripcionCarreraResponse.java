package modelos;

import entidades.InscripcionesCarrera;
import java.util.Date;

public class InscripcionCarreraResponse implements Payload {
    private Integer identificador;
    private Date fechainscripcion;
    private String carrera;
    private Integer promedio;
    
    public InscripcionCarreraResponse(InscripcionesCarrera inscrip) {
        this.identificador = inscrip.getIdentificador();
        this.carrera = inscrip.getIdcarrera().getNombre();
        this.fechainscripcion = inscrip.getFechainscripcion();
        
//        this.promedio = inscrip.getIdalumno().getInscripcionesCursoCollection()
//            .stream()
//            .filter(i -> i.getIdcurso().getIdcarrera().getIdentificador().equals(inscrip.getIdcarrera().getIdentificador()))
//            .filter(i -> i.getNotafinal() != null)
//            .map(i -> i.getNotafinal())
//            .reduce(
//                0,
//                (acum, nota) -> acum + nota
//            );
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getPromedio() {
        return promedio;
    }

    public void setPromedio(Integer promedio) {
        this.promedio = promedio;
    }

    
    
    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
