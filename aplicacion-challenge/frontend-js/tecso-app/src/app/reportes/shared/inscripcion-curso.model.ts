export class InscripcionCurso {
    identificador: number;
    fechainscripcion: Date;
    curso: string

    constructor(inscripcionCurso?: {
        identificador: number;
        fechainscripcion: any;
        curso: string
    }) {
        if (inscripcionCurso) {
            this.identificador = inscripcionCurso.identificador;
            this.fechainscripcion = new Date(inscripcionCurso.fechainscripcion);
            this.curso = inscripcionCurso.curso
        } else {
            this.identificador = null;
            this.fechainscripcion = null;
            this.curso = null
        }
    }

}
