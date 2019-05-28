--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual

update inscrip1
set inscrip1.fechainscripcion = GETDATE()
from inscripciones_curso inscrip1
where exists (
    select * from inscripciones_curso as inscrip2
    inner join inscripciones_carrera as inscripCarrera
        on inscripCarrera.idalumno = inscrip2.idalumno
    where inscrip2.fechainscripcion < inscripCarrera.fechainscripcion
        and inscrip1.idalumno = inscrip2.idalumno
        and inscrip1.idcurso = inscrip2.idcurso
)
