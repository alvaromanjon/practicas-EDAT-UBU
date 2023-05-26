/**
 * Programa que prueba los métodos de la clase {@code ColasDePrioridad}.
 * 
 * Al ejecutarse con las aserciones habilitadas (opción -ea o -enableassertions
 * de la máquina virtual), no debería saltar ninguna.
 */

package es.ubu.gii.edat.sesion11;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

/**
 * Clase que prueba los métodos de la clase {@code ColasDePrioridad}.
 * 
 * @author <a href="mailto:jjrodriguez@ubu.es">Juan José Rodríguez Diez</a>
 * 
 */
public class ColasPrioridadTest {

	/**
	 * Función que prueba {@code ColasDePrioridad.mayores}.
	 */
	
	@Test
	public void pruebaMayores() {

		// Obtenemos una lista con los 4 mayores, comprobamos
		List<Integer> mayores = ColasDePrioridad.mayores(
				Arrays.asList(8, 2, 0, 9, 7, 3, 6, 4, 5, 1), 4);
		System.out.println(mayores);
		assertEquals( Arrays.asList(9, 8, 7, 6), mayores);

		// Creamos una lista con los enteros 0...999
		int numEnteros = 1000;
		List<Integer> listaEnteros = new ArrayList<Integer>(numEnteros);
		for (int i = 0; i < numEnteros; i++)
			listaEnteros.add(i);

		// Creamos una lista con los 10 mayores
		int numMayores = 10;
		List<Integer> listaMayores = new ArrayList<Integer>(numEnteros);
		for (int i = 0; i < numMayores; i++)
			listaMayores.add(numEnteros - i - 1);
		System.out.println(listaMayores);

		// Creamos el generador de números aleatorios
		Random random = new Random(0);

		// Hacemos 10 comprobaciones
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(listaEnteros, random); // barajamos la lista
			mayores = ColasDePrioridad.mayores(listaEnteros, numMayores);
			System.out.println(listaEnteros.subList(0, numMayores) + "... -> "
					+ mayores);
			assertEquals(listaMayores,mayores);
		}
	}

	/**
	 * Función que prueba {@code ColasDePrioridad.menores}.
	 */
	@Test
	public void pruebaMenores() {

		// Obtenemos una lista con los 4 Menores, comprobamos
		List<Integer> menores = ColasDePrioridad.menores(
				Arrays.asList(8, 2, 0, 9, 7, 3, 6, 4, 5, 1), 4);
		System.out.println(menores);
		assertEquals (Arrays.asList(0, 1, 2, 3), menores);

		// Creamos una lista con los enteros 0...999
		int numEnteros = 1000;
		List<Integer> listaEnteros = new ArrayList<Integer>(numEnteros);
		for (int i = 0; i < numEnteros; i++)
			listaEnteros.add(i);

		// Creamos una lista con los 10 Menores
		int numMenores = 10;
		List<Integer> listaMenores = new ArrayList<Integer>(numEnteros);
		for (int i = 0; i < numMenores; i++)
			listaMenores.add(i);
		System.out.println(listaMenores);

		// Creamos el generador de números aleatorios
		Random random = new Random(0);

		// Hacemos 10 comprobaciones
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(listaEnteros, random); // barajamos la lista
			menores = ColasDePrioridad.menores(listaEnteros, numMenores);
			System.out.println(listaEnteros.subList(0, numMenores) + "... -> "
					+ menores);
			assertEquals(listaMenores, menores);
		}
	}

	/**
	 * Función que prueba los métodos de {@code ColasDePrioridad} usando (y sin
	 * usar) un comparador. Los elementos son cadenas.
	 */
	@Test
	public void pruebaConComparador() {

		// Comparador de cadenas en función de su longitud, si es la misma se
		// usa el orden habitual
		Comparator<String> comparador = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length())
					return -1;
				if (o1.length() > o2.length())
					return 1;
				return o1.compareTo(o2);
			}
		};

		// Creamos una lista de cadenas: a0, a1, ..., a1000
		int numElementos = 1001;
		List<String> listaCadenas = new ArrayList<String>(numElementos);
		for (int i = 0; i < numElementos; i++) {
			listaCadenas.add("a" + i);
		}

		// Barajamos la lista
		Collections.shuffle(listaCadenas, new Random(0));
		System.out.println(listaCadenas.subList(0, 10) + "..." );

		// Obtenemos los menores con el orden natural, comprobamos
		List<String> seleccionados = ColasDePrioridad.menores(listaCadenas, 10);
		System.out.println(seleccionados);
		assertEquals("[a0, a1, a10, a100, a1000, a101, a102, a103, a104, a105]", seleccionados.toString());

		// Obtenemos los mayores con el orden natural, comprobamos
		seleccionados = ColasDePrioridad.mayores(listaCadenas, 10);
		System.out.println(seleccionados);
		assertEquals("[a999, a998, a997, a996, a995, a994, a993, a992, a991, a990]", seleccionados.toString());

		// Obtenemos los menores con el comparador, comprobamos
		seleccionados = ColasDePrioridad.menores(listaCadenas, 10, comparador);
		System.out.println(seleccionados);
		assertEquals("[a0, a1, a2, a3, a4, a5, a6, a7, a8, a9]", seleccionados.toString());

		// Obtenemos los mayores con el comparador, comprobamos
		seleccionados = ColasDePrioridad.mayores(listaCadenas, 10, comparador);
		System.out.println(seleccionados);
		assertEquals("[a1000, a999, a998, a997, a996, a995, a994, a993, a992, a991]", seleccionados.toString());

	}
	
}
