import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlumnoComponent } from './alumnos/alumno/alumno.component';
import { NuevoAlumnoComponent } from './alumnos/nuevo-alumno/nuevo-alumno.component';
import { EditarAlumnoComponent } from './alumnos/editar-alumno/editar-alumno.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './core/home/home.component';
import { EstadoAcademicoComponent } from './reportes/estado-academico/estado-academico.component';

const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent,
        children: [
            {
                path: 'alumnos',
                component: AlumnoComponent
            },
            {
                path: 'alumnos/nuevo',
                component: NuevoAlumnoComponent
            },
            {
                path: 'alumnos/editar/:idAlumno',
                component: EditarAlumnoComponent
            },
            {
                path: 'estado-academico/:idAlumno',
                component: EstadoAcademicoComponent
            }
        ]
    },
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    }

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
