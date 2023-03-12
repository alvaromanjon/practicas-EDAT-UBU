package es.ubu.gii.edat.pr01;

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
	 * se va a comprobar la frecuencia de cada uno de ellos.
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
	 * 
	 * @param <E>
	 * @param array
	 * @return
	 */
	public static <E> RespuestaMayoritaria<E> mayoritarioRecursivo (E[] array){
		


		return null;

	}
}
