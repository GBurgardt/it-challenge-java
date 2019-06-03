import { Component } from '@angular/core';
import { AuthService } from 'src/app/shared/auth.service';
import { InscripcionService } from '../shared/inscripcion.service';
import { Router } from '@angular/router';
import { UtilsService } from 'src/app/shared/utils.service';

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent {

    legajo: Number;
    clave: String;

    constructor(
        private inscripcionService: InscripcionService,
        private router: Router,
        private utilsService: UtilsService
    ) { }

    onClickLogin = () => this.inscripcionService.login(this.legajo, this.clave)
        .then(
            resp => {
                // Login correcto, lo mando a nueva inscripcion
                this.router.navigate(['/home/nueva-inscripcion/']);
            }
        )
        .catch(
            err => {
                // Muestro error
                this.utilsService.showError(err);
            }
        )


}
