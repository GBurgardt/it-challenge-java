package servicios;

import com.google.gson.JsonObject;
import entidades.Acceso;
import entidades.Alumno;
import entidades.Curso;
import entidades.InscripcionesCurso;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.AppCodigo;
import modelos.ServicioResponse;
import persistencia.AccesoFacade;
import persistencia.CursoFacade;
import persistencia.InscripcionesCursoFacade;
import utils.Utils;

@Stateless
@Path("inscripciones-curso")
public class InscripcionesCursoRest {
    @Inject InscripcionesCursoFacade inscripcionesCursoFacade;
    @Inject CursoFacade cursoFacade;
    @Inject AccesoFacade accesoFacade;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setInscripcionCurso(@Context HttpServletRequest request) {
        ServicioResponse respuesta = new ServicioResponse();
        try {
            // Obtengo el header de autorización
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            
            // Extraigo el token
            Integer beginIndex = "Bearer".length();
            String token = authorizationHeader
                .substring(beginIndex).trim();

            // Valido el token
            Acceso acceso = accesoFacade.findByToken(token);
            
            // Valido el Acceso
            if(acceso == null) {
                respuesta.setControl(AppCodigo.ERROR, "Error, token invalido");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }
            
            // Busco el alumno del acceso
            Alumno alumno = acceso.getIdalumno();
            
            // Obtengo el body de la request
            JsonObject jsonBody = Utils.getJsonObjectFromRequest(request);
            
            // Obtengo los atributos del body
            Integer idCurso = (Integer) Utils.getKeyFromJsonObject("idCurso", jsonBody, "Integer");

            // Busco el curso
            Curso curso = cursoFacade.find(idCurso);
            
            // Valido que exista
            if(curso == null) {
                respuesta.setControl(AppCodigo.ERROR, "Error, el curso no existe");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }
            
            // Valido que el alumno NO esté inscripto en el curso
            boolean yaEstaInscripto = alumno.getInscripcionesCursoCollection().stream()
                .anyMatch(c -> c.getIdcurso().getIdentificador().equals(curso.getIdentificador()));
            
            if (yaEstaInscripto) {
                respuesta.setControl(AppCodigo.ERROR, "Ya estas inscripto a ese curso");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }
            
            InscripcionesCurso inscripcion = new InscripcionesCurso();
            inscripcion.setFechainscripcion(new Date());
            inscripcion.setIdcurso(curso);
            inscripcion.setIdalumno(alumno);
                
            boolean transaccion = inscripcionesCursoFacade.setInscripcionNueva(inscripcion);
            
            if(!transaccion) {
                respuesta.setControl(AppCodigo.ERROR, "No se pudo crear la inscripcion");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }

            respuesta.setControl(AppCodigo.OK, "Inscripción creada con exito");
            return Response.status(Response.Status.CREATED).entity(respuesta.toJson()).build();
        } catch (Exception ex) { 
            respuesta.setControl(AppCodigo.ERROR, ex.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta.toJson()).build();
        }
    }    
    
    
}
