package es.ubu.gii.edat.pr01;

/**
 * Clase que alberga el código completo para la Práctica 01
 * 
 * @author bbaruque
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
	 * 
	 * @param <E>
	 * @param array
	 * @return
	 */
	public static <E> RespuestaMayoritaria<E> mayoritarioIterativo (E [] array){

		// TODO Completar el metodo iterativo
		return null;
		
	}

	/**
	 * 
	 * @param <E>
	 * @param array
	 * @return
	 */
	public static <E> RespuestaMayoritaria<E> mayoritarioRecursivo (E[] array){
		
		// TODO Completar el metodo recursivo
		return null;

	}
	
	// Es posible emplear métodos auxiliares para la ayuda a la implementación de los métodos obligatorios.
	
}
