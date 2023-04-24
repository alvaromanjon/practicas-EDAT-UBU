package es.ubu.gii.edat.pr04;

import java.util.AbstractMap;
import java.util.Hashtable;
import java.util.Set;

// Tanto las claves como los valores deben ser únicos; sin embargo, como en las tablas hash se permiten valores
// nulos, se permite que haya una clave nula, y un valor nulo, pero no más de uno de cada uno.

public class MapaValoresUnicos<K,V> extends AbstractMap<K,V> {

    private final Hashtable<K,V> tablaDirecta;
    private final Hashtable<K,V> tablaInversa;

    public MapaValoresUnicos() {
        this.tablaDirecta = new Hashtable<>();
        this.tablaInversa = new Hashtable<>();
    }

    @Override
    public V put(K key, V value) {
        // TODO: Implementar
        return null;
    }

    public V remove(Object key) {
        // TODO: Implementar
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        // TODO: Implementar
        return null;
    }

    // TODO: Ver si hace falta sobreescribir más métodos (en principio con los métodos actuales es suficiente)

    public MapaValoresUnicos<V,K> inverso()  {
        // TODO: Implementar
        return null;
    }

    public V forcePut (K key, V value) {
        // TODO: Implementar
        return null;
    }
}
