import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { LocalStorageService } from 'src/app/shared/local-storage.service';

@Injectable()
export class AuthGuardService implements CanActivate {

    constructor(
        private localStorageService: LocalStorageService,
        private router: Router
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

        const token = this.localStorageService.getObject('token');

        // Si no hay token, lo mando al login
        if (token) {
            // Ok
            return true;
        } else {
            // Lo mando a login
            this.router.navigate(['/home/login/']);
            return false;
        }

    }
}
