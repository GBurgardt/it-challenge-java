/**
 * 
 */
package ejercicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * A. Crear una clase Alumnno con los siguientes campos (con sus respectivos
 * getters, setters y constructor)
 * 
 * Persona 
 * Legajo - Integer
 * 
 * 
 * @author examen
 *
 */
public class Ejercicio3 {

	/**
	 * 
	 */
	public Ejercicio3() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Alumno testAlumno = new Alumno(
				TipoDocumento.DNI,
				38262505,
				"German",
				"Burgardt",
				dateFormat.parse("1994-11-04"),
				41168
			);
		} catch (ParseException e) {
			// Handlde ParseException
			System.out.println(e);
		}

	}

}
