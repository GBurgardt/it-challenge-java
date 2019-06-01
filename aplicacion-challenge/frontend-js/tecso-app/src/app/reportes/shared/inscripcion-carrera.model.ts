export class InscripcionCarrera {
    identificador: number;
    fechainscripcion: Date;
    carrera: string

    constructor(inscripcionCarrera?: {
        identificador: number;
        fechainscripcion: any;
        carrera: string
    }) {
        if (inscripcionCarrera) {
            this.identificador = inscripcionCarrera.identificador;
            this.fechainscripcion = new Date(inscripcionCarrera.fechainscripcion);
            this.carrera = inscripcionCarrera.carrera
        } else {
            this.identificador = null;
            this.fechainscripcion = null;
            this.carrera = null
        }
    }

}
