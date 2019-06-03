import { Injectable } from "@angular/core";
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Alumno } from '../alumnos/shared/alumno.model';
import { UtilsService } from './utils.service';
import { InscripcionCurso } from './inscripcion-curso.model';
import { LocalStorageService } from './local-storage.service';


@Injectable()
export class AuthService {
    constructor(
        private http: HttpClient,
        private utilsService: UtilsService,
        private localStorageService: LocalStorageService
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

    postAlumno = (alumno: Alumno, clave: String) => this.http.post(
        `${environment.WS_URL}/alumnos`,
        {

            nombre: alumno.nombre,
            apellido: alumno.apellido,
            tipoDoc: alumno.tipodoc,
            documento: alumno.documento,
            legajo: alumno.legajo,
            fechaNac: this.utilsService.formatDate(alumno.fechanac),
            clave
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

    /**
     * Retorna un observable con todos los alumnos inscriptos a un curso dado
     */
    getAlumnosInscriptosByIdCurso = (idCurso) => this.http.get(
        `${environment.WS_URL}/cursos/${idCurso}/alumnos-inscriptos`
    )

    /**
     * Retorna un Observable con todos los cursos
     */
    getCursos = () => this.http.get(
        `${environment.WS_URL}/cursos`
    )

    login = (legajo: Number, clave: String) => this.http.post(
        `${environment.WS_URL}/alumnos/login/${legajo}`,
        { clave }
    )

    /**
     * Inscribe el alumno actual logueado al curso dado
     */
    postInscripcionesCurso = (idCurso: Number) =>
        this.http.post(
            `${environment.WS_URL}/inscripciones-curso`,
            { idCurso },
            {
                headers: new HttpHeaders({
                    'Authorization': `Bearer ${this.localStorageService.getObject('token')}`
                })
            }
        )

}
