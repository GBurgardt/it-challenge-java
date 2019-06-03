package modelos;

import entidades.Persona;
import java.util.Date;

public class PersonaResponse implements Payload {
    protected Integer identificador;
    private String tipodoc;
    private long documento;
    private String nombre;
    private String apellido;
    private Date fechanac;
    
    public PersonaResponse(Persona persona) {
        this.identificador = persona.getIdentificador();
        this.tipodoc = persona.getTipodoc();
        this.documento = persona.getDocumento();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.fechanac = persona.getFechanac();
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }
    
    
    
    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
