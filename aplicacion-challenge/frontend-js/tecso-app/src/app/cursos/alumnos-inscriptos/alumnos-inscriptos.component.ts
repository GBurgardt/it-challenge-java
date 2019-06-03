import { Component } from '@angular/core';
import { Observable } from 'rxjs';

import { ActivatedRoute } from '@angular/router';
import { Alumno } from 'src/app/alumnos/shared/alumno.model';
import { CursoService } from '../shared/curso.service';

@Component({
    selector: 'alumnos-inscriptos',
    templateUrl: './alumnos-inscriptos.component.html',
    styleUrls: ['./alumnos-inscriptos.component.scss']
})
export class AlumnoInscriptosComponent {

    alumnosInscriptos: Observable<Alumno>;

    constructor(
        private cursoService: CursoService,
        private route: ActivatedRoute
    ) {
        this.route.params
            .subscribe(params => {
                this.alumnosInscriptos = this.cursoService.getAlumnosInscriptos(params.idCurso)
            });
    }


}
