import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthService } from './shared/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { AlumnoService } from './alumnos/shared/alumno.service';
import { AlumnoComponent } from './alumnos/alumno/alumno.component';
import { NuevoAlumnoComponent } from './alumnos/nuevo-alumno/nuevo-alumno.component';
import { UtilsService } from './shared/utils.service';
import { EditarAlumnoComponent } from './alumnos/editar-alumno/editar-alumno.component';
import { MenuComponent } from './core/menu/menu.component';
import { HomeComponent } from './core/home/home.component';
import { EstadoAcademicoComponent } from './alumnos/estado-academico/estado-academico.component';
import { AlumnoInscriptosComponent } from './cursos/alumnos-inscriptos/alumnos-inscriptos.component';
import { CursoService } from './cursos/shared/curso.service';
import { CursoComponent } from './cursos/curso/curso.component';
import { LoginComponent } from './inscripciones/login/login.component';
import { InscripcionService } from './inscripciones/shared/inscripcion.service';
import { LocalStorageService } from './shared/local-storage.service';
import { NuevaInscripcionComponent } from './inscripciones/nueva-inscripcion/nueva-inscripcion.component';
import { AuthGuardService } from './inscripciones/shared/auth-guard.service';

@NgModule({
    declarations: [
        AppComponent,
        AlumnoComponent,
        NuevoAlumnoComponent,
        EditarAlumnoComponent,
        MenuComponent,
        HomeComponent,
        EstadoAcademicoComponent,
        AlumnoInscriptosComponent,
        CursoComponent,
        LoginComponent,
        NuevaInscripcionComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
    providers: [
        AuthService,
        AlumnoService,
        UtilsService,
        CursoService,
        InscripcionService,
        LocalStorageService,
        AuthGuardService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
