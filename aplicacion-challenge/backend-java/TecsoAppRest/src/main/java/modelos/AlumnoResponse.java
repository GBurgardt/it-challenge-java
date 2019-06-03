package modelos;

import entidades.Alumno;

public class AlumnoResponse extends PersonaResponse implements Payload {
    private int legajo;
    
    public AlumnoResponse(Alumno alum) {
        super(alum.getIdpersona());
        this.legajo = alum.getLegajo();
        this.identificador = alum.getIdentificador();
    }
    
    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
