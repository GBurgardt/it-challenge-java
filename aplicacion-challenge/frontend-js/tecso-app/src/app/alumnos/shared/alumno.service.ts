import * as crypto from 'crypto-js';
import { Injectable } from "@angular/core";
import { AuthService } from 'src/app/shared/auth.service';

import { map, catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { Alumno } from './alumno.model';
import { InscripcionCarrera } from 'src/app/shared/inscripcion-carrera.model';
import { InscripcionCurso } from 'src/app/shared/inscripcion-curso.model';

@Injectable()
export class AlumnoService {
    constructor(
        private authService: AuthService
    ) { }

    /**
     * Obtiene alumnos y mapea respuesta, y captura error
     */
    getAlumnos = () => this.authService.getAlumnos()
        .pipe(
            map(
                (resp: any) => resp.control && resp.control.codigo === 'OK' ?
                    resp.arraydatos.map(
                        alum => new Alumno(alum)
                    ) : []
            ),
            catchError(
                val => of(val)
            )
        )

    /**
     * Obtiene un alumno por su id y mappea respuesta
     */
    getAlumnoById = (idAlumno) => this.authService.getAlumnoById(idAlumno).toPromise()
        .then(
            (resp: any) => resp.control && resp.control.codigo === 'OK' ?
                new Alumno({
                    identificador: idAlumno,
                    ...resp.datos
                }) : null
        )


    /**
     * Llama a authService para persistir un alumno en db. Retorna el observable como promesa
     */
    crearAlumno = (alumno: Alumno, clave) => this.authService
        .postAlumno(
            alumno,
            crypto.MD5(clave).toString()
        )
        .toPromise();

    /**
     * Llama a authService para editar un alumno en db. Retorna el observable como promesa
     */
    editarAlumno = (alumno: Alumno) => this.authService.putAlumno(alumno).toPromise();

    /**
     * Obtiene inscripciones carreras by alumno
     */
    getInscripcionesCarrerasByIdAlumno = (idAlumno) => this.authService.getInscripcionesCarrerasByIdAlumno(idAlumno)
        .pipe(
            map(
                (resp: any) => resp.control && resp.control.codigo === 'OK' ?
                    resp.arraydatos.map(
                        alum => new InscripcionCarrera(alum)
                    ) : []
            ),
            catchError(
                val => of(val)
            )
        )

    /**
     * Obtiene inscripciones cursos by alumno
     */
    getInscripcionesCursosByIdAlumno = (idAlumno) => this.authService.getInscripcionesCursosByIdAlumno(idAlumno)
        .pipe(
            map(
                (resp: any) => resp.control && resp.control.codigo === 'OK' ?
                    resp.arraydatos.map(
                        alum => new InscripcionCurso(alum)
                    ) : []
            ),
            catchError(
                val => of(val)
            )
        )
}
