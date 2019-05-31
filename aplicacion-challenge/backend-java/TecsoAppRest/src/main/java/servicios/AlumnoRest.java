package servicios;

import entidades.Alumno;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.AlumnoResponse;
import modelos.AppCodigo;
import modelos.Payload;
import modelos.ServicioResponse;
import persistencia.AlumnoFacade;

@Stateless
@Path("alumnos")
public class AlumnoRest {
    @Inject AlumnoFacade alumnoFacade;
    
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



    
}
