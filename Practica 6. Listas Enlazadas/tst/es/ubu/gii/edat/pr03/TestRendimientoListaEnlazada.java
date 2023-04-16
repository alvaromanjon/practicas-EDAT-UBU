package es.ubu.gii.edat.pr03;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import es.ubu.gii.edat.pr03.ListaEnlazada;

public class TestRendimientoListaEnlazada {

	private int maxSize = 10000;
	private List<Long> l = null;
	ListaEnlazada<Long> listaEnlazada = null;

	private void before(int Max){
		listaEnlazada = new ListaEnlazada<Long>();
		l = listaAleatoria(Max); 
	}

	private void after(){
		l.clear();
		listaEnlazada.clear();
	}

	/**
	 * Comprueba el rendimiento al ir insertando un mayor numero de elementos en la 
	 * ListaEnlazada 
	 */

	private void testAddAll(int Max) {

		Long inicio = new Long(0);
		Long fin = new Long(0);

		System.out.print("Insercion, ");

		inicio = System.nanoTime();
		listaEnlazada.addAll(l);
		fin = System.nanoTime();

		assertEquals(l, listaEnlazada);

		System.out.print(Max+", "+(fin-inicio)+"\n");

	} // testAddAll


	private void testRemoveAll(int Max) {

		Long inicio = new Long(0);
		Long fin = new Long(0);

		System.out.print("Borrado, ");

		listaEnlazada.addAll(l);
		List<Long> borrar = listaAleatoria(Max);

		inicio = System.nanoTime();
		for (int i=0; i<borrar.size(); i++){
			assertEquals(l.remove(borrar.get(i)),
					listaEnlazada.remove(borrar.get(i)));
		}
		fin = System.nanoTime();

		assertEquals(l.size(), listaEnlazada.size());
		assertEquals(l, listaEnlazada);

		System.out.println(Max+", "+(fin-inicio)+"\n");

	}

	private void testRecorridos(){

	}

	/**
	 * Permite generar un listado de numeros enteros aleatorios (repetidos)
	 * El rango es [0, num Elementos de la lista]
	 * 
	 * @param Max numero de elementos de la lista
	 * @return
	 */
	private List<Long> listaAleatoria(int Max){

		List<Long> l = new LinkedList<Long>();

		for (int j=0; j<Max; j++)
			l.add(Math.round(Math.random()*Max));

		return l;

	} // listaAleatoria

	@Test
	public void ejecutaTests(){

		for (int i=0; i<= 10; i++){
			
			int Max = (maxSize/10)*i;

			before(Max); testAddAll(Max); after();
			before(Max); testRemoveAll(Max); after();
		}
	}

} // TestRendimientoListaEnlazada
