--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.

select tipodoc, documento, nombre, apellido, legajo
from alumno
inner join persona 
    on persona.identificador = idpersona
