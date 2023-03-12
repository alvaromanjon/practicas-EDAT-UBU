package es.ubu.gii.edat.pr01;

import java.util.Arrays;

/**
 * Clase que alberga el código completo para la Práctica 01
 * 
 * @author bbaruque
 * @author Álvaro Manjón Vara
 *
 */
public class ElementoMayoritario {

	/**
	 * Para poder devolver dos valores diferentes por parte de un mismo método, se necesita una clase sencilla con dos atributos.
	 * En este caso, la clase RespuestaMayoritaria permite encapsular en el mismo objeto:
	 * - elemento mayoritario encontrado
	 * - el numero de veces que se repite (o frecuencia) como un entero
	 * 
	 * Al devolver la respuesta de cada metodo, se deberán incluir los dos datos encontrados dentro de un objeto de este tipo y
	 * devolverlo como respuesta.
	 *  
	 * @author bbaruque
	 *
	 * @param <E>
	 */
	public static class RespuestaMayoritaria <E>{
		
		private E elemento;
		private int frecuencia;
		
		public RespuestaMayoritaria(E elemento, int frecuencia){
			this.elemento = elemento;
			this.frecuencia = frecuencia;
		}

		public E getElemento() {
			return elemento;
		}

		public int getFrecuencia() {
			return frecuencia;
		}
	}

	/**
	 * Aproximación iterativa en la que se van a recorrer todos los elementos de la lista y
	 * se va a comprobar la frecuencia de cada uno de ellos. Si existe algún elemento cuya frecuencia
	 * sea igual o superior a la mitad del tamaño de la colección + 1, este elemento será el mayoritario.
	 *
	 * @param array - array de elementos en el que se va a buscar el elemento mayoritario
	 * @return objeto de tipo RespuestaMayoritaria con el elemento mayoritario y su frecuencia
	 */
	public static <E> RespuestaMayoritaria<E> mayoritarioIterativo (E [] array) {
		int frecMax = 0;
		E elemMax = null;

		for (E elem : array) {
			for (E elem2 : array) {
				if (elem.equals(elem2)) {
					frecMax++;
				}
			}
			if (frecMax > array.length / 2) {
				elemMax = elem;
				break;
			} else {
				frecMax = 0;
			}
		}

		return new RespuestaMayoritaria<E>(elemMax, frecMax);
	}

	/**
	 * Aproximación recursiva en la que se divide el array en dos partes, y se llama al método recursivamente
	 * para hallar el elemento mayoritario de cada una de las partes, hasta hallar el elemento mayoritario siguiendo
	 * el principio del método mayoritarioIterativo.
	 *
	 * @param array - array de elementos en el que se va a buscar el elemento mayoritario
	 * @return objeto de tipo RespuestaMayoritaria con el elemento mayoritario y su frecuencia
	 */
	public static <E> RespuestaMayoritaria<E> mayoritarioRecursivo (E[] array){
		int frecMax = 0, frecm1 = 0, frecm2 = 0;
		E elemMax = null;

		if (array.length == 1) {
			elemMax = array[0];
			frecMax = 1;
		} else {
			RespuestaMayoritaria<E> m1 = mayoritarioRecursivo(Arrays.copyOfRange(array, 0, (array.length + 1)/2));
			RespuestaMayoritaria<E> m2 = mayoritarioRecursivo(Arrays.copyOfRange(array, (array.length + 1)/2, array.length));

			for (E elem : array) {
				if (elem.equals(m1.getElemento())) {
					frecm1++;
				}
				if (elem.equals(m2.getElemento())) {
					frecm2++;
				}
			}

			if (frecm1 > array.length / 2) {
				elemMax = m1.getElemento();
				frecMax = frecm1;
			} else if (frecm2 > array.length / 2) {
				elemMax = m2.getElemento();
				frecMax = frecm2;
			}
		}

		return new RespuestaMayoritaria<E>(elemMax, frecMax);
	}
}
