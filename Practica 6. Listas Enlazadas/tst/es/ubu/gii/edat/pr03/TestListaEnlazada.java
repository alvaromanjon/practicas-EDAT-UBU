/**
 * Programa que prueba la clase {@code ListaEnlazada}.
 * 
 * Al ejecutarse con las aserciones habilitadas (opción -ea o -enableassertions
 * de la máquina virtual), no debería saltar ninguna.
 */

package es.ubu.gii.edat.pr03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import junit.framework.JUnit4TestAdapter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.ubu.gii.edat.pr03.ListaEnlazada;

public class TestListaEnlazada {

	ListaEnlazada<Integer> lEnlazada = null;
	List<Integer> control = null;
	private static int puntos = 0;


	@Before
	public void runBeforeEveryTest() {
		lEnlazada = new ListaEnlazada<Integer>();
		control = new ArrayList<Integer>(5);
	}

	@After
	public void runAfterEveryTest() {
		lEnlazada.clear();
		control.clear();
	} 

	@org.junit.AfterClass
	public static void puntuacion(){
		System.out.println("Puntuacion: "+puntos);
	}
	
	/**
	 * Método para comprobar que la insercion de elementos individuales
	 * tiene como resultado una lista correctamente creada.
	 * Debería ser igual que una lista creada con un array. 
	 */
	@Test
	public void insertaElementos(){

		lEnlazada.add(5); control.add(5);  
		lEnlazada.add(3); control.add(3);
		lEnlazada.add(8); control.add(8);
		lEnlazada.add(10); control.add(10);
		lEnlazada.add(5); control.add(5);

		System.out.println(lEnlazada.toString());

		assertEquals("No se han insertado correctamente", control, lEnlazada);

		puntos = puntos + 3;

	}

	@Test
	public void recuperaElementos(){

		lEnlazada.add(5); control.add(5);  
		lEnlazada.add(3); control.add(3);
		lEnlazada.add(8); control.add(8);
		lEnlazada.add(10); control.add(10);
		lEnlazada.add(5); control.add(5);

		assertEquals("No se han insertado correctamente", control, lEnlazada);

		assertEquals("No se han recuperado correctamente",control.get(0),lEnlazada.get(0));
		assertEquals("No se han recuperado correctamente",control.get(4),lEnlazada.get(4));
		assertEquals("No se han recuperado correctamente",control.get(2),lEnlazada.get(2));

		puntos = puntos + 2;

	}


	/**
	 * Método que permite comprobar si se insertan correctamente elementos en una posición dada,
	 * distinta de la posición final. Solo se necesita comprobar en caso de querer comprobar el
	 * trabajo que se propone como opcional.
	 */


	/**
	 * Metodo para comprobar que insertando una colección ya generada anteriormente, 
	 * el resultado es una lista equivalente.
	 */
	@Test
	public void insertaUnaLista(){

		List<Integer> auxiliar = Arrays.asList(1,5,10,2,7,5,3,9);

		lEnlazada.addAll(auxiliar);

		System.out.println(lEnlazada.toString());

		assertEquals("No se ha insertado correctamente una sublista dentro de otra", auxiliar, lEnlazada);

		puntos = puntos + 1;

	}

	/**
	 * Metodo para comprobar el borrado de elementos en funcion de la posicion que ocupan.
	 * Tras realizarlo, debe contener el mismo listado de elementos sin el que se acaba de eliminar.
	 */
	@Test
	public void borraElementosIndice(){

		ListaEnlazada<Character> lEnlazada = new ListaEnlazada<Character>();
		List<Character> control = new ArrayList<Character>(5);

		lEnlazada.add('b'); control.add('b');    
		lEnlazada.add('d'); control.add('d');
		lEnlazada.add('a'); control.add('a');
		lEnlazada.add('z'); control.add('z');
		lEnlazada.add('i'); control.add('i');

		System.out.println(lEnlazada.toString());

		// First element
		lEnlazada.remove(0); control.remove(0);
		assertEquals ("Al borrar el primer elemento, el tamaño no se actualiza correctamente", control.size(), lEnlazada.size());
		assertEquals ("Al borrar el primer elemento, la lista no se actualiza correctamente", control, lEnlazada);

		System.out.println(lEnlazada.toString());

		// Last element
		lEnlazada.remove(3); control.remove(3);
		assertEquals ("Al borrar el ultimo elemento, el tamaño no se actualiza correctamente", control.size(), lEnlazada.size());
		assertEquals ("Al borrar el ultimo elemento, la lista no se actualiza correctamente", control, lEnlazada);

		System.out.println(lEnlazada.toString());

		// Center element
		lEnlazada.remove(1); control.remove(1);
		assertEquals ("Al borrar el ultimo elemento, el tamaño no se actualiza correctamente", control.size(), lEnlazada.size());
		assertEquals ("Al borrar el ultimo elemento, la lista no se actualiza correctamente", control, lEnlazada);

		System.out.println(lEnlazada.toString());

		puntos = puntos + 3;

	}

	@Test
	public void vaciaCabeza(){

		ListaEnlazada<Character> lEnlazada = new ListaEnlazada<Character>();
		List<Character> control = new ArrayList<Character>(5);

		lEnlazada.add('b'); control.add('b');    
		lEnlazada.add('d'); control.add('d');
		lEnlazada.add('a'); control.add('a');
		lEnlazada.add('z'); control.add('z');
		lEnlazada.add('i'); control.add('i');

		while(!lEnlazada.isEmpty()){
			Character e = lEnlazada.remove(0);
			Character c = control.remove(0);
			assertEquals ("No se recupera el primer elemento correctamente al borrarlo", c, e);
			assertEquals ("No se borra el primer elemento correctamente", control, lEnlazada);
		}

		puntos = puntos + 2;

	}

	/**
	 * Método que permite comprobar si se realizan los recorridos de forma correcta. 
	 * Se comprueba tanto la iteracion ascendente como la descendente
	 */
	@Test
	public void recorridos(){

		ListaEnlazada<Integer> lEnlazada = new ListaEnlazada<Integer>();
		List<Integer> control = new ArrayList<Integer>(5);
		int cont = 0;		

		lEnlazada.add(5); control.add(5);  
		lEnlazada.add(3); control.add(3);
		lEnlazada.add(8); control.add(8);
		lEnlazada.add(10); control.add(10);
		lEnlazada.add(5); control.add(5);

		ListIterator<Integer> it = lEnlazada.listIterator();
		ListIterator<Integer> itC = control.listIterator();

		while (it.hasNext()){
			cont ++;
			Integer c = itC.next();
			Integer le = it.next();
			assertEquals ("No se realiza el recorrido hacia adelante correctamente", c, le);
		}

		assertEquals (5, cont);

		while (it.hasPrevious()){
			cont --;
			Integer c = itC.previous();
			Integer le = it.previous();
			assertEquals ("No se realiza el recorrido hacia atras correctamente", c, le);
		}

		assertEquals (0, cont);

		puntos = puntos + 3;

	}

	@Test
	(expected=IndexOutOfBoundsException.class)
	public void recuperarVacia(){
		assertTrue(lEnlazada.isEmpty());
		lEnlazada.get(0);
		fail ("No se lanza la excepcion correspondiente al realizar accesos no validos");

		puntos = puntos + 1;

	}

	@Test
	(expected=IndexOutOfBoundsException.class)
	public void borrarVacia(){
		assertTrue(lEnlazada.isEmpty());
		lEnlazada.remove(0);
		fail ("No se lanza la excepcion correspondiente al realizar accesos no validos");

		puntos = puntos + 1;

	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(TestListaEnlazada.class);
	} 

	@Test
	public void insertaElementosPosicion(){

		for (int i=0; i<5; i++){
			lEnlazada.add(i); control.add(i);
		}

		lEnlazada.add(2, 5); control.add(2, 5);  
		lEnlazada.add(0, 3); control.add(0, 3);
		lEnlazada.add(4, 8); control.add(4, 8);
		lEnlazada.add(1, 10); control.add(1, 10);
		lEnlazada.add(3, 5); control.add(3, 5);

		System.out.println(lEnlazada.toString());

		assertEquals("No se han insertado correctamente en la posicion solicitada", control, lEnlazada);

	}	

	@Test
	(expected=IndexOutOfBoundsException.class)
	public void insertarFueraRango(){
		assertTrue(lEnlazada.isEmpty());
		lEnlazada.add(25,25);
		fail ("No se lanza la excepcion correspondiente al realizar accesos no validos");
	}

	@Test
	public void borraElementosContenido(){

		ListaEnlazada<Character> lEnlazada = new ListaEnlazada<Character>();
		List<Character> control = new ArrayList<Character>(5);

		lEnlazada.add('b'); control.add('b');    
		lEnlazada.add('d'); control.add('d');
		lEnlazada.add('a'); control.add('a');
		lEnlazada.add('z'); control.add('z');
		lEnlazada.add('i'); control.add('i');

		System.out.println(lEnlazada.toString());

		// First element
		lEnlazada.remove((Character)'b'); control.remove((Character)'b');
		assertEquals ("Al borrar el primer elemento, el tamaño no se actualiza correctamente", control.size(), lEnlazada.size());
		assertEquals ("Al borrar el primer elemento, la lista no se actualiza correctamente", control, lEnlazada);

		System.out.println(lEnlazada.toString());

		// Last element
		lEnlazada.remove((Character)'i'); control.remove((Character)'i');
		assertEquals ("Al borrar el ultimo elemento, el tamaño no se actualiza correctamente", control.size(), lEnlazada.size());
		assertEquals ("Al borrar el ultimo elemento, la lista no se actualiza correctamente", control, lEnlazada);

		System.out.println(lEnlazada.toString());

		// Center element
		lEnlazada.remove((Character)'a'); control.remove((Character)'a');
		assertEquals ("Al borrar el ultimo elemento, el tamaño no se actualiza correctamente", control.size(), lEnlazada.size());
		assertEquals ("Al borrar el ultimo elemento, la lista no se actualiza correctamente", control, lEnlazada);

		System.out.println(lEnlazada.toString());

		// Non-Included Element

		lEnlazada.remove((Character)'j'); control.remove((Character)'j');
		assertEquals ("Al borrar un elemento no contenido, el tamaño no se actualiza correctamente", control.size(), lEnlazada.size());
		assertEquals ("Al borrar un elemento no contenido, la lista no se actualiza correctamente", control, lEnlazada);

		System.out.println(lEnlazada.toString());

		puntos = puntos + 3;

	}

}
