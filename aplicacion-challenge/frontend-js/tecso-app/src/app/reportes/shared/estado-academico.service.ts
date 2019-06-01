import { Injectable } from "@angular/core";
import { AuthService } from 'src/app/shared/auth.service';
import { map, catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { InscripcionCarrera } from './inscripcion-carrera.model';

@Injectable()
export class EstadoAcademicoService {

    constructor(
        private authService: AuthService
    ) {}

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

}
