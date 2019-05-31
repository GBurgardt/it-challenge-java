import { Injectable } from "@angular/core";
import { AuthService } from 'src/app/shared/auth.service';

import { map } from 'rxjs/operators';

@Injectable()
export class AlumnoService {
    constructor(
        private authService: AuthService
    ) { }

    getAlumnos = () => this.authService.getAlumnos()
        .pipe(
            map(
                (resp: any) => resp.arraydatos
            )
        )
        // .toPromise()
        // .then(
        //     (resp: any) => resp.arraydatos
        // )
}
