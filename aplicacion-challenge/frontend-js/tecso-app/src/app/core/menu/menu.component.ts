import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.scss']
})
export class MenuComponent {
    menus: any[];

    constructor(
        private router: Router
    ) {

        const currentRoute = this.router.url;

        this.menus = [
            {
                descripcion: 'alumnos',
                url: '/home/alumnos',
                activo: currentRoute.includes('/home/alumnos')
            },
            {
                descripcion: 'cursos',
                url: '/home/cursos',
                activo: currentRoute.includes('/home/cursos')
            },
            {
                descripcion: 'inscripcion curso',
                url: '/home/login',
                activo: currentRoute.includes('/home/login')
            }
        ];
    }

    onClickMenu(menuSelec) {
        this.menus = this.menus.map(m => ({
            ...m,
            activo: m === menuSelec
        }));
    }

}
