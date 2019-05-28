--- EJERCICIO 8 -  COMPLEJIDAD BAJA: 
-- si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un único campo* string de 200 caracteres.
-- Determine sobre que tabla seria mas conveniente persistir esta información y realizar la modificación de estructuras correspondientes.

/*
Considerando que solo se persiste la dirección, basta con crear un varchar(200) 'direccion' en la tabla 'Persona'. 
Un approach interesante sería persistir país, provincia y ciudad, creando las respectivas tablas Pais, Provincia, Ciudad. 
Relacionando Persona con Ciudad, Ciudad con Provincia y Provincia con País.
Abajo dejo la query necesaria para la solución solicitada: crear un campo 'direccion' en tabla 'Persona'.
*/

ALTER TABLE persona 
ADD direccion VARCHAR(200)