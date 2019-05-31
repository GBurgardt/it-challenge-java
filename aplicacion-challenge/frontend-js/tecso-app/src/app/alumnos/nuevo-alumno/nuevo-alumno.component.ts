import { Component, OnInit } from '@angular/core';
import { Alumno } from '../shared/alumno.model';
import { AlumnoService } from '../shared/alumno.service';

@Component({
    selector: 'nuevo-alumno',
    templateUrl: './nuevo-alumno.component.html',
    styleUrls: ['./nuevo-alumno.component.scss']
})
export class NuevoAlumnoComponent implements OnInit {

    alumno: Alumno;

    constructor(
        private alumnoService: AlumnoService
    ) { }

    ngOnInit() {
        // this.alumnos = this.alumnoService.getAlumnos();
    }


}
