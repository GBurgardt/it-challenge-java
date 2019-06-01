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
                activo: currentRoute === '/home/alumnos'
            },
            // {
            //     descripcion: 'estado academico',
            //     url: '/home/estado-academico',
            //     activo: currentRoute === '/home/estado-academico'
            // },
            {
                descripcion: 'cursos',
                url: '/home/cursos',
                activo: currentRoute === '/home/cursos'
            },
            {
                descripcion: 'inscripcion curso',
                url: '/home/inscripcion',
                activo: currentRoute === '/home/inscripcion'
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
