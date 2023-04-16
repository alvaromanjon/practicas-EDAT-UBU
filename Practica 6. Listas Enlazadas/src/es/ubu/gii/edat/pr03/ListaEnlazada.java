package es.ubu.gii.edat.pr03;

import java.util.AbstractList;
import java.util.Iterator;

public class ListaEnlazada<E> extends AbstractList<E> {
    private NodoInterno<E> inicial;
    private int numElementos;

    public ListaEnlazada() {
        inicial = null;
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
        NodoInterno<E> nuevoNodo = new NodoInterno<E>(e);
        if (inicial == null) {
            inicial = nuevoNodo;
        } else {
            NodoInterno<E> anteriorNodo = inicial;
            while (anteriorNodo.getSiguiente() != null) {
                anteriorNodo = anteriorNodo.getSiguiente();
            }
            anteriorNodo.setSiguiente(nuevoNodo);
        }
        this.numElementos++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index == numElementos) {
            this.add(element);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E remove(int index) {
        // TODO: Implementar
        return null;
    }

    @Override
    public E get(int index) {
        // TODO: Implementar
        return null;
    }

    @Override
    public int size() {
        return numElementos;
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
