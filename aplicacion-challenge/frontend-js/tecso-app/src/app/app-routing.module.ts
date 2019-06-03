import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AlumnoComponent } from './alumnos/alumno/alumno.component';
import { NuevoAlumnoComponent } from './alumnos/nuevo-alumno/nuevo-alumno.component';
import { EditarAlumnoComponent } from './alumnos/editar-alumno/editar-alumno.component';
import { HomeComponent } from './core/home/home.component';
import { EstadoAcademicoComponent } from './alumnos/estado-academico/estado-academico.component';
import { AlumnoInscriptosComponent } from './cursos/alumnos-inscriptos/alumnos-inscriptos.component';
import { CursoComponent } from './cursos/curso/curso.component';
import { LoginComponent } from './inscripciones/login/login.component';
import { NuevaInscripcionComponent } from './inscripciones/nueva-inscripcion/nueva-inscripcion.component';
import { AuthGuardService } from './inscripciones/shared/auth-guard.service';

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
                path: 'alumnos/:idAlumno',
                component: EditarAlumnoComponent
            },
            {
                path: 'alumnos/:idAlumno/estado-academico',
                component: EstadoAcademicoComponent
            },
            {
                path: 'cursos',
                component: CursoComponent
            },
            {
                path: 'cursos/:idCurso/alumnos-inscriptos',
                component: AlumnoInscriptosComponent
            },
            {
                path: 'login',
                component: LoginComponent
            },
            {
                path: 'nueva-inscripcion',
                component: NuevaInscripcionComponent,
                canActivate: [AuthGuardService]
            }
        ]
    },
    {
        path: '',
        redirectTo: '/home/login',
        pathMatch: 'full'
    },
    {
        path: '**',
        redirectTo: '/home/login'
    }

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
