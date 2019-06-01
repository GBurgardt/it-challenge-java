package servicios;

import com.google.gson.JsonObject;
import entidades.Alumno;
import entidades.Persona;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.AlumnoResponse;
import modelos.AppCodigo;
import modelos.Payload;
import modelos.ServicioResponse;
import persistencia.AlumnoFacade;
import persistencia.PersonaFacade;
import utils.Utils;

@Stateless
@Path("estado-academico")
public class EstadoAcademicoRest {
    @Inject AlumnoFacade alumnoFacade;
    @Inject PersonaFacade personaFacade;
    
    /*
    Estado academico de un alum dado
        inscripciones actuales a carreras y cursos (los dos get),  
        estado de cursos anteriores , 
        promedio general por carrera tomando los cursos ya aprobados)
    */
    @GET
    @Path("/{idAlumno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEstadoAcademico(
        @Context HttpServletRequest request,
        @PathParam("idAlumno") Integer idAlumno
    ) {
        ServicioResponse respuesta = new ServicioResponse();
        try {
            
            // Busco el alumno por id
            Alumno alumno = alumnoFacade.find(idAlumno);

            // Me fijo que exista
            if (alumno == null) {
                respuesta.setControl(AppCodigo.ERROR, "No existe un alumno con ese id");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }
            
            
            alumno.getInscripcionesCarreraCollection();
            alumno.getInscripcionesCursoCollection();
            
            // Creo la respuesta
            respuesta.setDatos(new AlumnoResponse(alumno));
            respuesta.setControl(AppCodigo.OK, "Alumno encontrado");

            // La mando
            return Response.status(Response.Status.OK).entity(respuesta.toJson()).build();
            
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(Response.Status.UNAUTHORIZED).entity(e).build();
        }
        

    }
    
    
}
