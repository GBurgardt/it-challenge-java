--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
--ordenado por legajo descendiente

select legajo, persona.nombre as nombre, apellido, carrera.nombre as nombreCarrera, inscripCarre.fechainscripcion as fechaInscripcionCarrera
from alumno
inner join persona 
    on persona.identificador = idpersona
inner join inscripciones_carrera as inscripCarre
    on inscripCarre.idalumno = alumno.identificador
inner join carrera
    on carrera.identificador = inscripCarre.idcarrera
order by legajo desc
