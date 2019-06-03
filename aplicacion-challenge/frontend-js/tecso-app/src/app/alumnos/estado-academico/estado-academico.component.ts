import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { InscripcionCarrera } from '../../shared/inscripcion-carrera.model';
import { ActivatedRoute } from '@angular/router';
import { InscripcionCurso } from 'src/app/shared/inscripcion-curso.model';
import { AlumnoService } from '../shared/alumno.service';

@Component({
    selector: 'estado-academico',
    templateUrl: './estado-academico.component.html',
    styleUrls: ['./estado-academico.component.scss']
})
export class EstadoAcademicoComponent {

    carreras: Observable<InscripcionCarrera>;
    cursos: Observable<InscripcionCurso>;

    constructor(
        private alumnoService: AlumnoService,
        private route: ActivatedRoute
    ) {
        this.route.params
            .subscribe(params => {
                this.carreras = this.alumnoService.getInscripcionesCarrerasByIdAlumno(params.idAlumno);
                this.cursos = this.alumnoService.getInscripcionesCursosByIdAlumno(params.idAlumno);
            });
    }
}
