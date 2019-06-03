import { Component, OnInit } from '@angular/core';
import { Alumno } from '../shared/alumno.model';
import { AlumnoService } from '../shared/alumno.service';
import { Router } from '@angular/router';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
    selector: 'nuevo-alumno',
    templateUrl: './nuevo-alumno.component.html',
    styleUrls: ['./nuevo-alumno.component.scss']
})
export class NuevoAlumnoComponent {

    alumno: Alumno = new Alumno();
    clave: String;

    constructor(
        private alumnoService: AlumnoService,
        private utilsService: UtilsService,
        private router: Router
    ) { }


    onClickCrear = () => {
        this.alumnoService.crearAlumno(this.alumno, this.clave)
            .then((resp: any) => {
                alert(`${resp.control.codigo}\n${resp.control.descripcion}`);
                this.router.navigate(['/home/alumnos/']);
            })
            .catch(err => {
                this.utilsService.showError(err);
            })
    }

}
