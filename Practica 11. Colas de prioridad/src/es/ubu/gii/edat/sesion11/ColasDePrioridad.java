package es.ubu.gii.edat.sesion11;

import java.util.*;

public class ColasDePrioridad {
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

    public static <E> List<E> mayores(Iterable<E> items, int num, Comparator<E> comparator) {
        PriorityQueue<E> cola = new PriorityQueue<>(comparator);

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
