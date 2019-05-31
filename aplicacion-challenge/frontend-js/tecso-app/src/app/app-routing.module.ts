import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlumnoComponent } from './alumnos/alumno/alumno.component';

const routes: Routes = [
    {
        path: 'alumnos',
        component: AlumnoComponent
    },
    {
        path: '',
        redirectTo: '/alumnos',
        pathMatch: 'full'
    },
    {
        path: '**',
        component: AlumnoComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
