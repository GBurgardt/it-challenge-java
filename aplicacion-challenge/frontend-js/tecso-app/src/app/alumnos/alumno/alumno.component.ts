import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Alumno } from '../shared/alumno.model';
import { AlumnoService } from '../shared/alumno.service';

@Component({
    selector: 'alumno',
    templateUrl: './alumno.component.html',
    styleUrls: ['./alumno.component.scss']
})
export class AlumnoComponent implements OnInit {

    alumnos: Observable<Alumno>;

    constructor(
        private alumnoService: AlumnoService
    ) { }

    ngOnInit() {
        this.alumnos = this.alumnoService.getAlumnos();
    }


}