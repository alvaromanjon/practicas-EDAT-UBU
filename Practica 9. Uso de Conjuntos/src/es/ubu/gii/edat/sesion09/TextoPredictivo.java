package es.ubu.gii.edat.sesion09;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Clase que permite almacenar un tesauro de palabras en un deteminado idioma y
 * realizar sugerencias en torno a palabras incompletas o incorrectas a modo de
 * corrector ortográfico automático.
 * 
 * @author bbaruque
 *
 */
public class TextoPredictivo {

	/**
	 * Se necesitará un atributo que permita Se empleará una clase que implemente el
	 * interfaz Set
	 */
	private NavigableSet<String> diccionario = new TreeSet<String>();

	/**
	 * Constructor de la clase. Se inicializa con el conjunto de palabras incluidas
	 * en el diccionario (tesauro) que se podrán emplear como sugerencias.
	 * 
	 * @param tesauro array de palabras que se van a emplear para corregir
	 */
	public TextoPredictivo(String[] tesauro) {
		// TODO A completar por el estudiante
		// TODO To be completed by the students
	}

	/**
	 * Método que permite facilitar un listado de sugerencias dada una cadena de
	 * consulta. Se especifica como parámetro cuantas sugerencias se necesitan
	 * obtener.
	 * 
	 * Suponiendo que se ha establecido un orden alfabético en el tesauro, se
	 * devolverán como sugerencias en el array en el siguiente orden:
	 *
	 * 1. Al inicio del vector las (n/2) palabras anteriores a la cadena buscada
	 * Estas aparecerán en el orden ALFABÉTICO 2. A partir de la posición (n/2) las
	 * palabras posteriores a la de busqueda. Estas aparecerán en el orden
	 * ALFABÉTICO
	 * 
	 * En caso de que se pida un numero IMPAR de palabras, se devolverá 1 menos del
	 * grupo de las ANTERIORES Si no existen suficientes palabras para completar una
	 * de las dos mitades, se rellenará con las palabras que se pueda.
	 * 
	 * Por último en caso de que se soliciten sugerencias para una palabra que ya se
	 * encuentra en el tesauro, solo se devolverá la propia palabra en el array de
	 * búsqueda.
	 * 
	 * @param incompleta     cadena de texto sobre la que se quieren obtener
	 *                       sugerencias
	 * @param numSugerencias cantidad de palabras total que se quiere incluir en las
	 *                       sugerencias
	 * @return array de palabras sugeridas
	 */
	public String[] sugiere(String incompleta, int numSugerencias) {

		// TODO A completar por el estudiante
		// TODO To be completed by the students

	}

	/**
	 * Metodo que permite conocer el tamaño del tesauro almacenado
	 * 
	 * @return numero de palabras DIFERENTES almacenadas en el tesauro
	 */
	public int tamañoDiccionario() {
		// TODO A completar por el estudiante
		// TODO To be completed by the students
	}

}
