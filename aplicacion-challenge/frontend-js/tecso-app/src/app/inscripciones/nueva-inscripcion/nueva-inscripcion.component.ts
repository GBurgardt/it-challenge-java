import { Component } from '@angular/core';
import { Curso } from 'src/app/cursos/shared/curso.model';
import { Observable } from 'rxjs';
import { CursoService } from 'src/app/cursos/shared/curso.service';
import { InscripcionService } from '../shared/inscripcion.service';
import { Router } from '@angular/router';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
    selector: 'nueva-inscripcion',
    templateUrl: './nueva-inscripcion.component.html',
    styleUrls: ['./nueva-inscripcion.component.scss']
})
export class NuevaInscripcionComponent {

    curso: Curso;
    cursos: Observable<Curso>;

    constructor(
        private cursoService: CursoService,
        private inscripcionService: InscripcionService,
        private router: Router,
        private utilsService: UtilsService
    ) { }

    ngOnInit() {
        this.cursos = this.cursoService.getCursos();
    }

    onClickConfirmar = () => this.inscripcionService.inscripcionCurso(this.curso.identificador)
        .then((resp: any) => {
            alert(`${resp.control.codigo}\n${resp.control.descripcion}`);
            this.router.navigate(['/home/alumnos/']);
        })
        .catch(err => {
            this.utilsService.showError(err);
        })

}
