package es.ubu.gii.edat.pr03;

import java.util.AbstractList;
import java.util.Iterator;

public class ListaEnlazada<E> extends AbstractList<E> {
    private NodoInterno<E> posicion;
    private int numElementos;

    public ListaEnlazada() {
        posicion = null;
        numElementos = 0;
    }

    private class NodoInterno<E> {
        private E elemento;
        private NodoInterno<E> siguiente;

        public NodoInterno(E elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }

        public E getElemento() {
            return elemento;
        }

        public void setElemento(E elemento) {
            this.elemento = elemento;
        }

        public NodoInterno<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoInterno<E> siguiente) {
            this.siguiente = siguiente;
        }
    }

    @Override
    public boolean add(E e) {
        // TODO: Implementar
        return false;
    }

    @Override
    public E remove(int index) {
        // TODO: Implementar
        return null;
    }

    @Override
    public E get(int index) {
        // TODO: implementar
        return null;
    }

    @Override
    public int size() {
        // TODO: Implementar
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO: Implementar
        return null;
    }

    @Override
    public void clear() {
        // TODO: Implementar
    }
}
