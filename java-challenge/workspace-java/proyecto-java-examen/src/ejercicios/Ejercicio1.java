package ejercicios;
/**
 * Ejercicio: analizar la siguente clase y realizar las correcciones
 * necesarias para que compile  
 * @author examen
 *
 */
public class Ejercicio1 {
	
	  	static int count1;
	    static int count2;  

	    public Ejercicio1() {
	    	count1 = 0;
	    	count2 ++;
	    }

	    public void incrementa1() {
	    	count1++;
	    }

	    public void incrementa2() {
	    	count2++;
	    }

	    public static void incrementa() {
			// Una función static solo puede referenciar campos static
	    	count1++;
	    }

}
