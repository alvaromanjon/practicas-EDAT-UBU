package es.ubu.gii.edat.sesion11;

import java.util.*;

/**
 * Clase que implementa métodos para trabajar con colas de prioridad.
 *
 * @author Álvaro Manjón Vara
 */
public class ColasDePrioridad {
    /**
     * Método que devuelve los n elementos mayores de una colección. Va a estar ordenada de
     * mayor a menor.
     * La complejidad algorítmica de este método es O(n log m), donde n va a ser el tamaño del
     * iterable, y m el número de elementos que se quieren obtener. Esto es así porque:
     * - El bucle for tiene complejidad O(n)
     * - Se va a utilizar una cola de prioridad para almacenar los elementos, y la inserción y extracción
     * de elementos en una cola de prioridad tiene complejidad O(log m).
     * - Se va a utilizar un ArrayList para almacenar los elementos, y la ordenación de un ArrayList tiene
     * complejidad O(m log m).
     * Como m <= n, la complejidad algorítmica del método es O(n log m).
     *
     * @param items - colección de elementos
     * @param num   - número de elementos que se quieren obtener
     * @return lista con los n elementos mayores de la colección
     */
    public static <E extends Comparable<E>> List<E> mayores(Iterable<E> items, int num) {
        PriorityQueue<E> cola = new PriorityQueue<>();

        for (E item : items) {
            cola.add(item);
            if (cola.size() > num) {
                cola.poll();
            }
        }

        List<E> resultado = new ArrayList<>(cola);
        resultado.sort(Collections.reverseOrder());
        return resultado;
    }

    /**
     * Método que devuelve los n elementos mayores de una colección. Va a estar ordenada de
     * mayor a menor.
     * La complejidad algorítmica de este método es O(n log m), donde n va a ser el tamaño del
     * iterable, y m el número de elementos que se quieren obtener. Esto es así porque:
     * - El bucle for tiene complejidad O(n)
     * - Se va a utilizar una cola de prioridad para almacenar los elementos, y la inserción y extracción
     * de elementos en una cola de prioridad tiene complejidad O(log m).
     * - Se va a utilizar un ArrayList para almacenar los elementos, y la ordenación de un ArrayList tiene
     * complejidad O(m log m).
     * Como m <= n, la complejidad algorítmica del método es O(n log m).
     *
     * @param items      - colección de elementos
     * @param num        - número de elementos que se quieren obtener
     * @param comparator - comparador que se va a utilizar para ordenar los elementos
     * @return lista con los n elementos mayores de la colección
     */
    public static <E> List<E> mayores(Iterable<E> items, int num, Comparator<E> comparator) {
        PriorityQueue<E> cola = new PriorityQueue<>(comparator);

        for (E item : items) {
            cola.add(item);
            if (cola.size() > num) {
                cola.poll();
            }
        }

        List<E> resultado = new ArrayList<>(cola);
        resultado.sort(Collections.reverseOrder(comparator));
        return resultado;
    }

    /**
     * Método que devuelve los n elementos menores de una colección. Va a estar ordenada de
     * menor a mayor.
     * La complejidad algorítmica de este método es O(n log m), donde n va a ser el tamaño del
     * iterable, y m el número de elementos que se quieren obtener. Esto es así porque:
     * - El bucle for tiene complejidad O(n)
     * - Se va a utilizar una cola de prioridad para almacenar los elementos, y la inserción y extracción
     * de elementos en una cola de prioridad tiene complejidad O(log m).
     * - Se va a utilizar un ArrayList para almacenar los elementos, y la ordenación de un ArrayList tiene
     * complejidad O(m log m).
     * Como m <= n, la complejidad algorítmica del método es O(n log m).
     *
     * @param items - colección de elementos
     * @param num   - número de elementos que se quieren obtener
     * @return lista con los n elementos menores de la colección
     */
    public static <E extends Comparable<E>> List<E> menores(Iterable<E> items, int num) {
        PriorityQueue<E> cola = new PriorityQueue<>(Collections.reverseOrder());

        for (E item : items) {
            cola.add(item);
            if (cola.size() > num) {
                cola.poll();
            }
        }

        List<E> resultado = new ArrayList<>(cola);
        resultado.sort(Comparator.naturalOrder());
        return resultado;
    }

    /**
     * Método que devuelve los n elementos menores de una colección. Va a estar ordenada de
     * menor a mayor.
     * La complejidad algorítmica de este método es O(n log m), donde n va a ser el tamaño del
     * iterable, y m el número de elementos que se quieren obtener. Esto es así porque:
     * - El bucle for tiene complejidad O(n)
     * - Se va a utilizar una cola de prioridad para almacenar los elementos, y la inserción y extracción
     * de elementos en una cola de prioridad tiene complejidad O(log m).
     * - Se va a utilizar un ArrayList para almacenar los elementos, y la ordenación de un ArrayList tiene
     * complejidad O(m log m).
     * Como m <= n, la complejidad algorítmica del método es O(n log m).
     *
     * @param items      - colección de elementos
     * @param num        - número de elementos que se quieren obtener
     * @param comparator - comparador que se va a utilizar para ordenar los elementos
     * @return lista con los n elementos menores de la colección
     */
    public static <E> List<E> menores(Iterable<E> items, int num, Comparator<E> comparator) {
        PriorityQueue<E> cola = new PriorityQueue<>(Collections.reverseOrder(comparator));

        for (E item : items) {
            cola.add(item);
            if (cola.size() > num) {
                cola.poll();
            }
        }

        List<E> resultado = new ArrayList<>(cola);
        resultado.sort(comparator);
        return resultado;
    }
}
