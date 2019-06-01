package modelos;

import entidades.Carrera;
import java.util.Date;

public class CarreraResponse implements Payload {
    private Integer identificador;
    private String nombre;
    private String descripcion;
    private Date fechaDesde;
    private Date fechaHasta;
    
    public CarreraResponse(Carrera carrera) {
        this.identificador = carrera.getIdentificador();
        this.nombre = carrera.getNombre();
        this.descripcion = carrera.getDescripcion();
        this.fechaDesde = carrera.getFechadesde();
        this.fechaHasta = carrera.getFechahasta();
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

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    
    
    
    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
