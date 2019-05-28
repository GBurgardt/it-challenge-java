--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo máximo por curso

select 
    carrera.nombre as nombreCarrera,
    curso.nombre as nombreCurso,
    count(*) as cantInscriptos,
    curso.cupomaximo as cupoMaximo
from alumno
inner join inscripciones_curso as inscripCurso
    on inscripCurso.idalumno = alumno.identificador
inner join curso
    on inscripCurso.idcurso = curso.identificador
inner join carrera
    on curso.idcarrera = carrera.identificador
group by carrera.nombre, curso.nombre, curso.cupomaximo
