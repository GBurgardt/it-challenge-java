export class Curso {
    identificador: number;
    nombre: string;
    carrera: string;
    descripcion: string;
    cupoMaximo: number
    profesorResume: string;

    constructor(curso?: {
        identificador: number;
        nombre: string;
        carrera: string;
        descripcion: string;
        cupoMaximo: number
        profesorResume: string;
    }) {
        if (curso) {
            this.identificador = curso.identificador;
            this.nombre = curso.nombre;
            this.carrera = curso.carrera;
            this.descripcion = curso.descripcion;
            this.cupoMaximo = curso.cupoMaximo
            this.profesorResume = curso.profesorResume;
        } else {
            this.identificador = null;
            this.nombre = null;
            this.carrera = null;
            this.descripcion = null;
            this.cupoMaximo = null
            this.profesorResume = null;
        }
    }

}
