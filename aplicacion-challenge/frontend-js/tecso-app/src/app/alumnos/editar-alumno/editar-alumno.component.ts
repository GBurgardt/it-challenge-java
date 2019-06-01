import { Component, OnInit } from '@angular/core';
import { Alumno } from '../shared/alumno.model';
import { AlumnoService } from '../shared/alumno.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
    selector: 'editar-alumno',
    templateUrl: './editar-alumno.component.html',
    styleUrls: ['./editar-alumno.component.scss']
})
export class EditarAlumnoComponent {

    alumno: Alumno = new Alumno();

    constructor(
        private alumnoService: AlumnoService,
        private router: Router,
        private route: ActivatedRoute,
        private utilsService: UtilsService
    ) {
        this.route.params.subscribe(params =>
            this.alumnoService.getAlumnoById(params.idAlumno)
                .then(
                    alumno => this.alumno = alumno
                )
                .catch(
                    err => {
                        // Muestro error
                        this.utilsService.showError(err);
                        // Lo mando nuevamente a alumnos
                        this.router.navigate(['/home/alumnos/']);
                    }
                )
        );
    }


    /**
     * Llama a alumnosService que maneja la edición del alumno
     */
    onClickConfirmar = () =>
        this.alumnoService.editarAlumno(this.alumno)
            .then((resp: any) => {
                alert(`${resp.control.codigo}\n${resp.control.descripcion}`);
                this.router.navigate(['/home/alumnos/']);
            })
            .catch(err => {
                // Muestro error
                this.utilsService.showError(err);
                // Lo mando nuevamente a alumnos
                this.router.navigate(['/home/alumnos/']);
            })
}
