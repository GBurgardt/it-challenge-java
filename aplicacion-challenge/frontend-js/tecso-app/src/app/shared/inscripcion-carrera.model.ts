export class InscripcionCarrera {
    identificador: number;
    fechainscripcion: Date;
    carrera: string
    promedio: number;

    constructor(inscripcionCarrera?: {
        identificador: number;
        fechainscripcion: any;
        carrera: string;
        promedio: number;
    }) {
        if (inscripcionCarrera) {
            this.identificador = inscripcionCarrera.identificador;
            this.fechainscripcion = new Date(inscripcionCarrera.fechainscripcion);
            this.carrera = inscripcionCarrera.carrera
            this.promedio = inscripcionCarrera.promedio;
        } else {
            this.identificador = null;
            this.fechainscripcion = null;
            this.carrera = null;
            this.promedio = null;
        }
    }

}
