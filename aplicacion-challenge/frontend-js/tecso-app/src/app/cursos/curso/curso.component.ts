import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CursoService } from '../shared/curso.service';
import { Curso } from '../shared/curso.model';

@Component({
    selector: 'curso',
    templateUrl: './curso.component.html',
    styleUrls: ['./curso.component.scss']
})
export class CursoComponent implements OnInit {

    cursos: Observable<Curso>;

    constructor(
        private cursoService: CursoService
    ) { }

    ngOnInit() {
        this.cursos = this.cursoService.getCursos()
    }


}
