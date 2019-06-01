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
import { EstadoAcademicoComponent } from './reportes/estado-academico/estado-academico.component';
import { EstadoAcademicoService } from './reportes/shared/estado-academico.service';


@NgModule({
    declarations: [
        AppComponent,
        AlumnoComponent,
        NuevoAlumnoComponent,
        EditarAlumnoComponent,
        MenuComponent,
        HomeComponent,
        EstadoAcademicoComponent
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
        EstadoAcademicoService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
