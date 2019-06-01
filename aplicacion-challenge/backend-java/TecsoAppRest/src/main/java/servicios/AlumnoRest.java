package servicios;

import com.google.gson.JsonObject;
import entidades.Alumno;
import entidades.Persona;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
import modelos.InscripcionCarreraResponse;
import modelos.InscripcionCursoResponse;
import modelos.Payload;
import modelos.ServicioResponse;
import persistencia.AlumnoFacade;
import persistencia.PersonaFacade;
import utils.Utils;

@Stateless
@Path("alumnos")
public class AlumnoRest {
    @Inject AlumnoFacade alumnoFacade;
    @Inject PersonaFacade personaFacade;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumnos() {
        
        try {
            // Busco todos los alumnos
            List<Alumno> alumnos = alumnoFacade.findAll();

            // Los mappeo a json
            List<Payload> listResp = alumnos.stream()
                .map(a -> new AlumnoResponse(a))
                .collect(Collectors.toList());

            // Creo la respuesta
            ServicioResponse respuesta = new ServicioResponse();
            respuesta.setArraydatos(listResp);
            respuesta.setControl(AppCodigo.OK, "Alumnos");

            // La mando
            return Response.status(Response.Status.OK).entity(respuesta.toJson()).build();
            
        } catch (Exception e) {
            
            return Response.status(Response.Status.UNAUTHORIZED).entity(e).build();
        }
        

    }
    
    @GET
    @Path("/{idAlumno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumnoById(
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
            
            
            // Creo la respuestaas
            respuesta.setDatos(new AlumnoResponse(alumno));
            respuesta.setControl(AppCodigo.OK, "Alumno encontrado");

            // La mando
            return Response.status(Response.Status.OK).entity(respuesta.toJson()).build();
            
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(Response.Status.UNAUTHORIZED).entity(e).build();
        }
        

    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setAlumno(@Context HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ServicioResponse respuesta = new ServicioResponse();
        try {
            // Obtengo el body de la request
            JsonObject jsonBody = Utils.getJsonObjectFromRequest(request);
            
            // Obtengo los atributos del body
            String nombre = (String) Utils.getKeyFromJsonObject("nombre", jsonBody, "String");
            String apellido = (String) Utils.getKeyFromJsonObject("apellido", jsonBody, "String");
            Long documento = (Long) Utils.getKeyFromJsonObject("documento", jsonBody, "Long");
            String tipoDoc = (String) Utils.getKeyFromJsonObject("tipoDoc", jsonBody, "String");
            Integer legajo = (Integer) Utils.getKeyFromJsonObject("legajo", jsonBody, "Integer");
            Date fechaNac = (Date) Utils.getKeyFromJsonObject("fechaNac", jsonBody, "Date");

            // Verifico datos nulos
            if(nombre == null || apellido == null  || documento == null || tipoDoc == null || legajo == null || fechaNac == null) {
                respuesta.setControl(AppCodigo.ERROR, "Error, algun campo esta nulo");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }
            
            boolean transaccion;
            Persona newPersona = new Persona();
            newPersona.setNombre(nombre);
            newPersona.setApellido(apellido);
            newPersona.setTipodoc(tipoDoc);
            newPersona.setDocumento(documento);
            newPersona.setFechanac(fechaNac);
            
            transaccion = personaFacade.setPersonaNueva(newPersona);
            
            Alumno newAlumno = new Alumno();
            newAlumno.setLegajo(legajo);
            newAlumno.setIdpersona(newPersona);
            transaccion = alumnoFacade.setAlumnoNuevo(newAlumno);
           
            
            if(!transaccion) {
                respuesta.setControl(AppCodigo.ERROR, "No se pudo crear el alumno");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }

            respuesta.setControl(AppCodigo.OK, "Alumno creado con exito");
            return Response.status(Response.Status.CREATED).entity(respuesta.toJson()).build();
        } catch (Exception ex) { 
            respuesta.setControl(AppCodigo.ERROR, ex.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta.toJson()).build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editAlumno(@Context HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ServicioResponse respuesta = new ServicioResponse();
        try {
            // Obtengo el body de la request
            JsonObject jsonBody = Utils.getJsonObjectFromRequest(request);
            
            // Obtengo los atributos del body
            Integer idAlumno = (Integer) Utils.getKeyFromJsonObject("idAlumno", jsonBody, "Integer");
            String nombre = (String) Utils.getKeyFromJsonObject("nombre", jsonBody, "String");
            String apellido = (String) Utils.getKeyFromJsonObject("apellido", jsonBody, "String");
            Long documento = (Long) Utils.getKeyFromJsonObject("documento", jsonBody, "Long");
            String tipoDoc = (String) Utils.getKeyFromJsonObject("tipoDoc", jsonBody, "String");
            Integer legajo = (Integer) Utils.getKeyFromJsonObject("legajo", jsonBody, "Integer");
            Date fechaNac = (Date) Utils.getKeyFromJsonObject("fechaNac", jsonBody, "Date");

            // Verifico datos nulos
            if(idAlumno == null || nombre == null || apellido == null  || documento == null || tipoDoc == null || legajo == null || fechaNac == null) {
                respuesta.setControl(AppCodigo.ERROR, "Error, algun campo esta nulo");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }
            
            Alumno editAlumno = alumnoFacade.find(idAlumno);
            
            // Me fijo si existe el alumno
            if(editAlumno == null) {
                respuesta.setControl(AppCodigo.ERROR, "No existe el alumno");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }
            
            boolean transaccion;
            Persona editPersona = editAlumno.getIdpersona();
            editPersona.setNombre(nombre);
            editPersona.setApellido(apellido);
            editPersona.setTipodoc(tipoDoc);
            editPersona.setDocumento(documento);
            editPersona.setFechanac(fechaNac);
            
            transaccion = personaFacade.editPersona(editPersona);
                    
            editAlumno.setLegajo(legajo);
            
            transaccion = alumnoFacade.editAlumno(editAlumno);
            
            if(!transaccion) {
                respuesta.setControl(AppCodigo.ERROR, "No se pudo editar el alumno");
                return Response.status(Response.Status.UNAUTHORIZED).entity(respuesta.toJson()).build();
            }

            respuesta.setControl(AppCodigo.OK, "Alumno editado con exito");
            return Response.status(Response.Status.CREATED).entity(respuesta.toJson()).build();
        } catch (Exception ex) { 
            respuesta.setControl(AppCodigo.ERROR, ex.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta.toJson()).build();
        }
    }


    
    @GET
    @Path("/{idAlumno}/carreras")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarrerasAlumno(
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
            
            // Busco las carreras del alumno y las mappeo
            List<Payload> listResp = alumno.getInscripcionesCarreraCollection().stream()
                .map(a -> new InscripcionCarreraResponse(a))
                .collect(Collectors.toList());

            // Creo la respuesta
            respuesta.setArraydatos(listResp);
            respuesta.setControl(AppCodigo.OK, "Inscripciones alumno");
            
            // La mando
            return Response.status(Response.Status.OK).entity(respuesta.toJson()).build();
            
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(Response.Status.UNAUTHORIZED).entity(e).build();
        }
        

    }
    
    @GET
    @Path("/{idAlumno}/cursos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCursosAlumno(
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
            
            // Busco las inscripciones del alumno y las mappeo
            List<Payload> listResp = alumno.getInscripcionesCursoCollection().stream()
                .map(a -> new InscripcionCursoResponse(a))
                .collect(Collectors.toList());

            // Creo la respuesta
            respuesta.setArraydatos(listResp);
            respuesta.setControl(AppCodigo.OK, "Inscripciones alumno");
            
            // La mando
            return Response.status(Response.Status.OK).entity(respuesta.toJson()).build();
            
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(Response.Status.UNAUTHORIZED).entity(e).build();
        }
        

    }

    
}
