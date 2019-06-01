export class Alumno {
    legajo: number;
    identificador: number;
    tipodoc: string;
    documento: number;
    nombre: string;
    apellido: string;
    fechanac: Date;

    constructor(alumno?: {
        legajo: number;
        identificador: number;
        tipodoc: string;
        documento: number;
        nombre: string;
        apellido: string;
        fechanac: any;
    }) {
        if (alumno) {
            this.legajo = alumno.legajo;
            this.identificador = alumno.identificador;
            this.tipodoc = alumno.tipodoc;
            this.documento = alumno.documento;
            this.nombre = alumno.nombre;
            this.apellido = alumno.apellido;
            this.fechanac = new Date(alumno.fechanac);
        } else {
            this.legajo = null;
            this.identificador = null;
            this.tipodoc = null;
            this.documento = null;
            this.nombre = null;
            this.apellido = null;
            this.fechanac = null
        }
    }

}
