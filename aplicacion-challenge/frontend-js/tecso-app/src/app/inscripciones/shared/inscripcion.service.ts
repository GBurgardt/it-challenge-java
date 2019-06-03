import * as crypto from 'crypto-js';
import { Injectable } from "@angular/core";
import { AuthService } from 'src/app/shared/auth.service';
import { LocalStorageService } from 'src/app/shared/local-storage.service';

@Injectable()
export class InscripcionService {

    constructor(
        private authService: AuthService,
        private localStorageService: LocalStorageService
    ) { }

    /**
     * Loguea y guarda token en localStorage
     */
    login = (legajo: Number, clave: String) => this.authService.login(legajo, crypto.MD5(clave).toString())
        .toPromise()
        .then(
            (resp: any) => {
                // Guardo token en localstorage
                this.localStorageService.setObject('token', resp.datos.token)
            }
        )

    /**
     * Inscribe el alumno actual logueado al curso dado
     */
    inscripcionCurso = (idCurso: Number) => this.authService.postInscripcionesCurso(idCurso)
        .toPromise();

}
