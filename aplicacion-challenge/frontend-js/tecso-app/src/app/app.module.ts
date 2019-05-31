import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthService } from './shared/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { AlumnoService } from './alumnos/shared/alumno.service';
import { AlumnoComponent } from './alumnos/alumno/alumno.component';

@NgModule({
    declarations: [
        AppComponent,
        AlumnoComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule
    ],
    providers: [
        AuthService,
        AlumnoService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
