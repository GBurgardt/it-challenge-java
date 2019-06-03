package servicios;

import entidades.Curso;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.AlumnoResponse;
import modelos.AppCodigo;
import modelos.CursoResponse;
import modelos.Payload;
import modelos.ServicioResponse;
import persistencia.CursoFacade;
import persistencia.InscripcionesCursoFacade;

@Stateless
@Path("cursos")
public class CursoRest {
    @Inject CursoFacade cursoFacade;
    @Inject InscripcionesCursoFacade inscripcionesCursoFacade;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCursos() {
        
        try {
            // Busco todos los alumnos
            List<Curso> cursos = cursoFacade.findAll();

            // Los mappeo a json
            List<Payload> listResp = cursos.stream()
                .map(a -> new CursoResponse(a))
                .collect(Collectors.toList());

            // Creo la respuesta
            ServicioResponse respuesta = new ServicioResponse();
            respuesta.setArraydatos(listResp);
            respuesta.setControl(AppCodigo.OK, "Cursos");

            // La mando
            return Response.status(Response.Status.OK).entity(respuesta.toJson()).build();
            
        } catch (Exception e) {
            
            return Response.status(Response.Status.UNAUTHORIZED).entity(e).build();
        }
    }
    
    
    @GET
    @Path("/{idCurso}/alumnos-inscriptos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumnosIncriptos(
        @Context HttpServletRequest request,
        @PathParam("idCurso") Integer idCurso
    ) {
        ServicioResponse respuesta = new ServicioResponse();
        try {
            
            // Busco el curso por id
            Curso curso = cursoFacade.find(idCurso);

            // Me fijo que exista
            if (curso == null) {
                respuesta.setControl(AppCodigo.ERROR, "No existe un curso con ese id");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }
            
            // Busco alumnos inscriptos al curso
            List<Payload> alumnosInscriptos = curso.getInscripcionesCursoCollection()
                .stream()
                .map(a -> new AlumnoResponse(a.getIdalumno()))
                .collect(Collectors.toList());
            
            // Creo la respuesta
            respuesta.setArraydatos(alumnosInscriptos);
            respuesta.setControl(AppCodigo.OK, "Alumnos inscriptos al curso buscado");

            // La mando
            return Response.status(Response.Status.OK).entity(respuesta.toJson()).build();
            
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(Response.Status.UNAUTHORIZED).entity(e).build();
        }
        

    }
    
    
    
}
