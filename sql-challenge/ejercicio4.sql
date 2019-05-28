--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo

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
    having count(*) > curso.cupomaximo
