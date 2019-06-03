import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/shared/auth.service';
import { map, catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { Alumno } from 'src/app/alumnos/shared/alumno.model';
import { Curso } from './curso.model';

@Injectable()
export class CursoService {

    constructor(private authService: AuthService) { }


    /**
     * Obtiene cursos y mapea respuesta, y captura error
     */
    getCursos = () => this.authService.getCursos()
        .pipe(
            map(
                (resp: any) => resp.control && resp.control.codigo === 'OK' ?
                    resp.arraydatos.map(
                        alum => new Curso(alum)
                    ) : []
            ),
            catchError(
                val => of(val)
            )
        )

    /**
     * Obtiene alumnos inscriptos dado un curso
     */
    getAlumnosInscriptos = (idCurso) => this.authService.getAlumnosInscriptosByIdCurso(idCurso)
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

}
