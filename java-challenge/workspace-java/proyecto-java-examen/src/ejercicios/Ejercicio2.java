package ejercicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * A. Crear una clase Persona con los siguientes campos (con sus respectivos
 * getters, setters y constructor)
 * 
 * TipoDocumento - enum (dni/libretacivica) NroDocumento - Integer Nombre -
 * String Apellido - String FechaNacimiento - Date
 * 
 * B. En el método main de la clase "Ejercicio2" crear una nueva instancia de la
 * clase persona y settearle valores reales con tus datos
 * 
 * 
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en
 * consola (crear método main e imprimir valores)
 * 
 * @author examen
 *
 */
public class Ejercicio2 {

	/**
	 * 
	 */
	public Ejercicio2() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Persona german = new Persona(
				TipoDocumento.DNI,
				38262505,
				"German",
				"Burgardt",
				dateFormat.parse("1994-11-04")
			);
			
			System.out.println(german.getTipoDocumento());
			System.out.println(german.getNroDocumento());
			System.out.println(german.getNombre());
			System.out.println(german.getApellido());
			System.out.println(german.getFechaNacimiento());

			
		} catch (ParseException e) {
			// Handlde ParseException
			System.out.println(e);
		}

		

	}

}
