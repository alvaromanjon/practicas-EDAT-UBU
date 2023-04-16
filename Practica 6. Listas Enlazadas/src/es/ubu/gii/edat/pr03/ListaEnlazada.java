package es.ubu.gii.edat.pr03;

import java.util.AbstractList;
import java.util.ListIterator;

/**
 * Implementación de una lista enlazada simple, cuyos elementos disponen de un puntero que apunta al
 * siguiente elemento. La lista funciona en un sólo sentido.
 *
 * @author Álvaro Manjón Vara
 *
 * @param <E>
 */
public class ListaEnlazada<E> extends AbstractList<E> {
    private NodoInterno<E> inicial;
    private int numElementos;

    /**
     * Constructor de la clase ListaEnlazada. Inicializa la lista vacía.
     */
    public ListaEnlazada() {
        inicial = null;
        numElementos = 0;
    }

    /**
     * Clase interna que representa un nodo de la lista enlazada. Cada nodo contiene un elemento y un
     * puntero al siguiente nodo.
     *
     * @param <E>
     */
    private static class NodoInterno<E> {
        private E elemento;
        private NodoInterno<E> siguiente;

        /**
         * Constructor de la clase NodoInterno. Inicializa el nodo con el elemento indicado y el
         * puntero al siguiente nodo a null.
         *
         * @param elemento - elemento que se va a almacenar en el nodo
         */
        public NodoInterno(E elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }

        /**
         * Método que devuelve el elemento almacenado en el nodo.
         *
         * @return elemento almacenado en el nodo
         */
        public E getElemento() {
            return elemento;
        }

        /**
         * Método que modifica el elemento almacenado en el nodo.
         *
         * @param elemento - nuevo elemento que se va a almacenar en el nodo
         */
        public void setElemento(E elemento) {
            this.elemento = elemento;
        }

        /**
         * Método que devuelve el puntero al siguiente nodo.
         *
         * @return puntero al siguiente nodo
         */
        public NodoInterno<E> getSiguiente() {
            return siguiente;
        }

        /**
         * Método que modifica el puntero al siguiente nodo.
         *
         * @param siguiente - nuevo puntero al siguiente nodo
         */
        public void setSiguiente(NodoInterno<E> siguiente) {
            this.siguiente = siguiente;
        }
    }

    /**
     * Método que añade un elemento al final de la lista.
     *
     * @param e - elemento que se va a añadir
     * @return true
     */
    @Override
    public boolean add(E e) {
        NodoInterno<E> nuevoNodo = new NodoInterno<E>(e);
        if (this.inicial == null) {
            this.inicial = nuevoNodo;
        } else {
            NodoInterno<E> anteriorNodo = this.inicial;
            while (anteriorNodo.getSiguiente() != null) {
                anteriorNodo = anteriorNodo.getSiguiente();
            }
            anteriorNodo.setSiguiente(nuevoNodo);
        }
        this.numElementos++;
        return true;
    }

    /**
     * Método que añade un elemento en la posición indicada.
     *
     * @param index - posición en la que se va a añadir el elemento
     * @param element - elemento que se va a añadir
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= numElementos) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            NodoInterno<E> nodoContinuacion = this.inicial;
            this.inicial = new NodoInterno<E>(element);
            this.inicial.setSiguiente(nodoContinuacion);
        } else {
            NodoInterno<E> nodoAnterior = this.inicial;
            for (int i = 0; i < index - 1; i++) {
                nodoAnterior = nodoAnterior.getSiguiente();
            }
            NodoInterno<E> nodoContinuacion = nodoAnterior.getSiguiente();
            nodoAnterior.setSiguiente(new NodoInterno<E>(element));
            nodoAnterior.getSiguiente().setSiguiente(nodoContinuacion);
        }
        this.numElementos++;
    }

    /**
     * Método que elimina el elemento de la posición indicada.
     *
     * @param index - posición del elemento que se va a eliminar
     * @return contenido del elemento eliminado
     */
    @Override
    public E remove(int index) {
        E nodoEliminado = null;
        if (index < 0 || index >= numElementos) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            nodoEliminado = this.inicial.getElemento();
            this.inicial = this.inicial.getSiguiente();
        } else {
            NodoInterno<E> nodoAnterior = this.inicial;
            for (int i = 0; i < index - 1; i++) {
                nodoAnterior = nodoAnterior.getSiguiente();
            }
            nodoEliminado = nodoAnterior.getSiguiente().getElemento();
            nodoAnterior.setSiguiente(nodoAnterior.getSiguiente().getSiguiente());
        }

        numElementos--;
        return nodoEliminado;
    }

    /**
     * Método que devuelve el elemento de la posición indicada.
     *
     * @param index - posición del elemento que se va a devolver
     * @return contenido del elemento
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= numElementos) {
            throw new IndexOutOfBoundsException();
        }

        NodoInterno<E> nodoPosicion = this.inicial;
        for (int i = 0; i < index; i++) {
            nodoPosicion = nodoPosicion.getSiguiente();
        }
        return nodoPosicion.getElemento();
    }

    /**
     * Tamaño de la lista.
     *
     * @return tamaño de la lista
     */
    @Override
    public int size() {
        return numElementos;
    }

    /**
     * Método que vacía la lista
     */
    @Override
    public void clear() {
        inicial = null;
        numElementos = 0;
    }

    /**
     * Clase iterador interna que implementa la interfaz ListIterator, para poder iterar por la lista.
     */
    public class IteradorListaEnlazada implements ListIterator<E> {
        private NodoInterno<E> nodoPosicion;
        private NodoInterno<E> nodoAnterior;
        private int indicePosicion;

        /**
         * Constructor de la clase IteradorListaEnlazada.
         */
        public IteradorListaEnlazada() {
            nodoPosicion = inicial;
            nodoAnterior = null;
            indicePosicion = 0;
        }

        /**
         * Método que indica si hay un elemento siguiente.
         *
         * @return true si hay un elemento siguiente, false en caso contrario
         */
        @Override
        public boolean hasNext() {
            return nodoPosicion != null;
        }

        /**
         * Método que devuelve el elemento siguiente.
         *
         * @return elemento siguiente
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            E elemento = nodoPosicion.getElemento();
            nodoAnterior = nodoPosicion;
            nodoPosicion = nodoPosicion.getSiguiente();
            indicePosicion++;
            return elemento;
        }

        /**
         * Método que indica si hay un elemento anterior.
         *
         * @return true si hay un elemento anterior, false en caso contrario
         */
        @Override
        public boolean hasPrevious() {
            return nodoAnterior != null;
        }

        /**
         * Método que devuelve el elemento anterior.
         *
         * @return elemento anterior
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new IndexOutOfBoundsException();
            }
            E elemento = nodoAnterior.getElemento();
            nodoPosicion = nodoAnterior;
            NodoInterno<E> nodoInicial = inicial;
            for (int i = 0; i < indicePosicion - 1; i++) {
                nodoInicial = nodoInicial.getSiguiente();
            }
            nodoAnterior = nodoInicial;
            indicePosicion--;
            return elemento;
        }

        /**
         * Método que devuelve la posición del elemento siguiente.
         *
         * @return posición del elemento siguiente
         */
        @Override
        public int nextIndex() {
            return indicePosicion;
        }

        /**
         * Método que devuelve la posición del elemento anterior.
         *
         * @return posición del elemento anterior
         */
        @Override
        public int previousIndex() {
            return indicePosicion - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();

        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}
