import { Injectable } from "@angular/core";
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Alumno } from '../alumnos/shared/alumno.model';
import { UtilsService } from './utils.service';


@Injectable()
export class AuthService {
    constructor(
        private http: HttpClient,
        private utilsService: UtilsService
    ) { }

    /**
     * Retorna un Observable con todos los alumnos
     */
    getAlumnos = () => this.http.get(
        `${environment.WS_URL}/alumnos`
    )

    /**
     * Retorna un Observable con un alumno, buscándolo con su id
     */
    getAlumnoById = (idAlumno) => this.http.get(
        `${environment.WS_URL}/alumnos/${idAlumno}`
    )

    postAlumno = (alumno: Alumno) => this.http.post(
        `${environment.WS_URL}/alumnos`,
        {

            nombre: alumno.nombre,
            apellido: alumno.apellido,
            tipoDoc: alumno.tipodoc,
            documento: alumno.documento,
            legajo: alumno.legajo,
            fechaNac: this.utilsService.formatDate(alumno.fechanac)
        }
    )

    putAlumno = (alumno: Alumno) => this.http.put(
        `${environment.WS_URL}/alumnos`,
        {
            idAlumno: alumno.identificador,
            nombre: alumno.nombre,
            apellido: alumno.apellido,
            tipoDoc: alumno.tipodoc,
            documento: alumno.documento,
            legajo: alumno.legajo,
            fechaNac: this.utilsService.formatDate(alumno.fechanac)
        }
    )

    /**
     * Retorna un observable con todas las inscripciones a carreras de un alumno
     */
    getInscripcionesCarrerasByIdAlumno = (idAlumno) => this.http.get(
        `${environment.WS_URL}/alumnos/${idAlumno}/carreras`
    )

    /**
     * Retorna un observable con todas las inscripciones a cursos de un alumno
     */
    getInscripcionesCursosByIdAlumno = (idAlumno) => this.http.get(
        `${environment.WS_URL}/alumnos/${idAlumno}/cursos`
    )
}
