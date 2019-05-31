import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlumnoComponent } from './alumnos/alumno/alumno.component';
import { NuevoAlumnoComponent } from './alumnos/nuevo-alumno/nuevo-alumno.component';

const routes: Routes = [
    {
        path: 'alumnos',
        component: AlumnoComponent
    },
    {
        path: 'alumnos/nuevo',
        component: NuevoAlumnoComponent
    }

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
