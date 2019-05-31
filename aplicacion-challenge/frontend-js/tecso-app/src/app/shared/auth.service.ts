import { Injectable } from "@angular/core";
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class AuthService {
    constructor(
        private http: HttpClient
    ) { }

    /**
     * Retorna un Observable con todos los alumnos
     */
    getAlumnos = () => this.http.get(
        `${environment.WS_URL}/alumnos`
    )
}
