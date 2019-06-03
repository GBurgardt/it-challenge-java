export class InscripcionCurso {
    identificador: number;
    fechainscripcion: Date;
    curso: string;
    notaFinal: number;
    carrera: string;

    constructor(inscripcionCurso?: {
        identificador: number;
        fechainscripcion: any;
        curso: string;
        notaFinal: number;
        carrera: string;
    }) {
        if (inscripcionCurso) {
            this.identificador = inscripcionCurso.identificador;
            this.fechainscripcion = new Date(inscripcionCurso.fechainscripcion);
            this.curso = inscripcionCurso.curso;
            this.notaFinal = inscripcionCurso.notaFinal;
            this.carrera = inscripcionCurso.carrera;
        } else {
            this.identificador = null;
            this.fechainscripcion = null;
            this.curso = null;
            this.notaFinal = null;
            this.carrera = null;
        }
    }

}
