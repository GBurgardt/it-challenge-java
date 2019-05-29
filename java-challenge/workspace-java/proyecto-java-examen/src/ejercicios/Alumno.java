package ejercicios;

import java.util.Date;

public class Alumno extends Persona {
    public Integer legajo;

    public Alumno(
        TipoDocumento tipoDocumento,
        Integer nroDocumento,
        String nombre,
        String apellido,
        Date fechaNacimiento,
        Integer legajo
    ) {
        super(tipoDocumento, nroDocumento, nombre, apellido, fechaNacimiento);
        this.legajo = legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Integer getLegajo() {
        return legajo;
    }


}
