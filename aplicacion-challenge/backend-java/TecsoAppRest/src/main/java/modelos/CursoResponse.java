package modelos;

import entidades.Curso;

public class CursoResponse implements Payload {
    private int identificador;
    private String nombre;
    private String carrera;
    private String descripcion;
    private int cupoMaximo;
    private String profesorResume;
    
    public CursoResponse(Curso curso) {
        this.identificador = curso.getIdentificador();
        this.nombre = curso.getNombre();
        this.carrera = curso.getIdcarrera().getNombre();
        this.descripcion = curso.getDescripcion();
        this.cupoMaximo = curso.getCupomaximo();
        this.profesorResume = curso.getIdProfesor().getIdpersona().getNombre() + " " + curso.getIdProfesor().getIdpersona().getApellido() + " (Legajo: " + curso.getIdProfesor().getLegajo() + ")";
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getProfesor() {
        return profesorResume;
    }

    public void setProfesor(String profesor) {
        this.profesorResume = profesor;
    }
    
    
    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
