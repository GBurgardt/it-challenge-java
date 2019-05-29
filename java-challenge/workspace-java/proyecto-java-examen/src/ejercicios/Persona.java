package ejercicios;

import java.util.Date;

public class Persona {
    private TipoDocumento tipoDocumento;
    private Integer nroDocumento;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;

    public Persona(
        TipoDocumento tipoDocumento,
        Integer nroDocumento,
        String nombre,
        String apellido,
        Date fechaNacimiento
    ){
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNroDocumento(Integer nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Integer getNroDocumento() {
        return nroDocumento;
    }


}
