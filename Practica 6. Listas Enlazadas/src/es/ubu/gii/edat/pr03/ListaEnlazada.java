package es.ubu.gii.edat.pr03;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListaEnlazada<E> extends AbstractList<E> {
    private NodoInterno<E> inicial;
    private int numElementos;

    public ListaEnlazada() {
        inicial = null;
        numElementos = 0;
    }

    private static class NodoInterno<E> {
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

    @Override
    public int size() {
        return numElementos;
    }

    public class IteradorListaEnlazada implements ListIterator<E> {
        private NodoInterno<E> nodoPosicion;
        private NodoInterno<E> nodoAnterior;
        private int indicePosicion;

        public IteradorListaEnlazada() {
            nodoPosicion = inicial;
            nodoAnterior = null;
            indicePosicion = 0;
        }

        @Override
        public boolean hasNext() {
            return nodoPosicion != null;
        }

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

        @Override
        public boolean hasPrevious() {
            return nodoAnterior != null;
        }

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

        @Override
        public int nextIndex() {
            return indicePosicion;
        }

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

    @Override
    public void clear() {
        inicial = null;
        numElementos = 0;
    }
}
