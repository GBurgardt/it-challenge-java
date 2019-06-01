import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { InscripcionCarrera } from '../shared/inscripcion-carrera.model';
import { EstadoAcademicoService } from '../shared/estado-academico.service';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'estado-academico',
    templateUrl: './estado-academico.component.html',
    styleUrls: ['./estado-academico.component.scss']
})
export class EstadoAcademicoComponent {

    carreras: Observable<InscripcionCarrera>;

    constructor(
        private estadoAcademicoService: EstadoAcademicoService,
        private route: ActivatedRoute
    ) {
        this.route.params.subscribe(params =>
            this.carreras = this.estadoAcademicoService.getInscripcionesCarrerasByIdAlumno(params.idAlumno)
        );
    }
}
