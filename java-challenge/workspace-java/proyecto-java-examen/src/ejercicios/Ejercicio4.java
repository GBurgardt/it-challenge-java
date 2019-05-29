package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio4 {

	// listas de ejemplo, pueden variarse su contenido, 
	static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
	static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9};

	/**	 
	 * Para ejecutar el método main se debe hacer boton derecho sobre la clase
	 * "Run As --> Java Application" 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("**** inicializando datos ****");
		
		List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
		List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));
	
		System.out.println("**** inicializacion exitosa ****");

		// EJERCICIO 4.1: explicar salidas y sugerir mejoras
		informacion(lista1, 10);
		
		// EJERCICIO 4.2: corregir el metodo
		List<Integer> union = unionListas(lista1, lista2);
		System.out.println("union: " + union.toString());
		
		// // EJERCICIO 4.3: implementar
		List<Integer> interseccion = interseccionListas(lista1, lista2);
		System.out.println("interseccion: " + interseccion.toString());
		
		// // EJERCICIO 4.4: implementar
		List<Integer> orden1 = ordenaListaAscendente(lista1);
		System.out.println("orden asc: " + orden1);
		
		// // EJERCICIO 4.5: implementar
		List<Integer> orden2 = ordenaListaDescendente(lista2);
		System.out.println("orden desc: " + orden2);

		// // EJERCICIO 4.6: implementar
		boolean b = tienenMismoContenido(lista1, lista2);
		System.out.println("mismo contenido: " + b);
		
	}

	private static void informacion(List<Integer> lista1, Integer numero) {
		// TODO: explicar salidas de los system out y sugerir alguna mejora a la implementacion

		// MEJORAS: Todas las operaciones realizadas se pueden mejorar aplicando un enfoque mas funcional (evitar bucles, condicionales para evitar side-efects)
		// Por otro lado, al usar streams es necesario considerar antes el tema performance. Si manejamos arrays de muchísimos elementos, quizás el enfoque con streams
		// no sea el mas adecuado. Pero este no es el caso, así que usamos streams por todas sus ventajas.
		// *Se deja comentado el código viejo y descomentado el código nuevo/mejorado
		
		// int pares = 0;
		// for (Integer n: lista1) {
		// 	if (n % 2 == 0) {
		// 		pares = pares + 1;
		// 	}
		// }

		// MEJORA: Se puede usar un reduce e ir contando de acuerdo a una condición
		// Nos centramos en el QUE, en vez del COMO. Evitamos side-efects
		int pares = lista1.stream()
			.reduce(
				0,
				(acum, n) -> n % 2 == 0 ? acum + 1 : acum
			);

		
		// Se muestra la CANTIDAD de números pares de lista1
		System.out.println("... " + pares);
		
		// List<Integer> impares = new ArrayList<Integer>();
		// for (Integer n: lista1) {
		// 	if (n % 2 != 0) {
		// 		impares.add(n);
		// 	}
		// }

		// MEJORA: Se vuelve a aplicar un enfoque mas funcional, donde nos centramos en el QUE antes del COMO.
		// Si filtra dando una condición, y se toma el resultado como una lista
		List<Integer> impares = lista1.stream()
			.filter(n -> n % 2 != 0)
			.collect(Collectors.toList());
		
		// Se muestran los números impares de lista1 (se crea otra List para impares y a través de un bucle se van filtrando de lista1 y añadiendo en la nueva lista)
		System.out.println("... " + impares.toString());
		

		// int p = lista1.size() / 2;
		// MEJORA: Acá se hace una mejora con respecto a la legibilidad. Los nombres de variables tienen que decirnos algo. Acá no nos decía nada
		// Así que se cambia el nombre de variable
		int halfSize = lista1.size() / 2;
		
		// Acá la salida es 2 porque se muestra el índice del elemento de lista1 que es igual al tamaño de lista1 partido en 2. 
		// Es decir, el tamaño de lista1 es 10. Partido en dos, es 5. Y si se busca en lista1 el número 5 está en el índice 2. Por eso la salida es 2
		System.out.println("..." + lista1.indexOf(halfSize));

		// int c = 0;
		// for (Integer n: lista1) {
		// 	if (n > numero) {
		// 		c = c + 1;
		// 	}
		// }
		
		// // En el bucle se arriba se cuentan todos los números mayores que número (numero se recibe en los parámetros de la función, en este caso es 10).
		// if (c > lista1.size() / 2) {
		// 	// En este condicional se chequea que la cant de números mayor a 10 (al parámetro numero en realidad) sea más que la mitad de los items de lista1
		// 	System.out.println("...");
		// } else if (c > 0) {
		// 	// Si no es mayor que la mitad de los items de lista1, se chequea que haya más de 0 números mayor a 10 (a número)
		// 	System.out.println("...");
		// } else {
		// 	// La única manera de que termine en este bloque condicional es que c sea igual a cero
		// 	System.out.println("...");
		// }

		// MEJORA: Al igual que arriba, se toma un enfoque funcional. 
		// Se aplica reduce dado una condición, dando como resultado la cantidad de elementos de lista1 que cumplen tal condición.
		// También se cambia el nombre de la variable a uno mas representativo
		int cantGreaterNumber = lista1.stream()
			.reduce(
				0,
				(acum, n) -> n > numero ? acum + 1 : acum
			);

		// MEJORA: Primeramente se reutiliza la variable halfSize definida mas arriba. 
		// También se reemplaca c por cantGreaterNumber y por último se muestra unos mensajes mas informativos.
		if (cantGreaterNumber > halfSize) {
			System.out.println("La cantidad de números mayor a "+numero+" son más de la mitad de la lista1");
		} else  if(cantGreaterNumber > 0) {
			System.out.println("La cantidad de números mayor a "+numero+" son más que 0 pero menos que la mitad de la lista1");
		} else {
			System.out.println("La cantidad de números mayor a "+numero+" son 0");
		}
		
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos de ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO: corregir el metodo para que funcione correctamente 
		
		// Se estaba intentando agregar elemenetos a un array (union) que todavía no estaba instanciado. Instanciando la variable con un ArrayList vació compila correctamente
		List<Integer> union = new ArrayList<Integer>();
		
		// El problema que surge acá es que lista1 puede tener elementos repetidos. Al agregarla completa a la unión, se están agregnado tambien los elementos repetidos
		// Y en una unión NO hay elementos repetidos.
		// Una mejor solución es usar un HashSet que NO tienen elementos repetidos.
		// union.addAll(lista1);
		
		// for (Integer m: lista2) {
		// 	if (!union.contains(m)) {
		// 		union.add(m);
		// 	}
		// }
		
		// return union;

		Set<Integer> set = new HashSet<Integer>();

        set.addAll(lista1);
        set.addAll(lista2);

        return new ArrayList<Integer>(set);

		// Dejo comentada una solución con streams. Aunque por performance se prefiere HashSet
		// return Stream.concat(lista1.stream(), lista2.stream())
		// 	.distinct()
		// 	.collect(Collectors.toList());

	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
		List<Integer> interseccion = new ArrayList<Integer>();
		
		for (Integer m: lista2) {
			if (!interseccion.contains(m) && lista1.contains(m)) {
				interseccion.add(m);
			}
		}
		
		return interseccion;

		// Dejo acá abajo comentada una solución mas simple con streams. Como se dice arriba, antes de implementarla siempre considerar tema performance.
		// return lista1.stream()
		// 	.filter(lista2::contains)
		// 	.collect(Collectors.toList());
	}

	/***
	 * @param lista1
	 * 
	 * retornar la lista recibida, ordenada en forma ascendente
	 * 
	 */
	private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {
		// Creo una nueva lista para no mutar la original
		List<Integer> listaOrdenada = new ArrayList<Integer>();
		listaOrdenada.addAll(lista1);

		// La ordeno ascendente
		listaOrdenada.sort(Comparator.naturalOrder());

		return listaOrdenada;
	}

	/***
	 * @param lista2
	 * 
	 * retornar la lista recibida, ordenada en forma descendente
	 * 
	 */
	private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {
		// Creo una nueva lista para no mutar la original
		List<Integer> listaOrdenada = new ArrayList<Integer>();
		listaOrdenada.addAll(lista2);

		// La ordeno ascendente
		listaOrdenada.sort(Comparator.reverseOrder());

		return listaOrdenada;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * devuelve true si contienen los mismos elementos
	 * NO se considera valido que esten en diferente orden
	 * NO se considera valido que la cantidad de repeticiones de los elementos sea diferente
	 * 
	 */
	private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
		
		// Lo primero que chequeamos es que tengan la misma cant de elementos. Si no tienen la misma cant, entonces lo contienen los mismos elementos
		if (lista1.size() != lista2.size()) {
			return false;
		}

		// Hacemos un bucle de lista1.size() ciclos y vamos comparando guiándonos por el índice
		for (int i = 0; i < lista1.size(); i++) {
			// El elemento de lista1 en índice i debe ser igual al elemento en lista2 en índice i. Si en algún caso esto no se cumple, las listas no contienen los mismos elementos por lo que retorno false
			if (lista1.get(i) != lista2.get(i)) {
				return false;
			}

		}

		return true;

	}

}
