package es.ubu.gii.edat.pr04;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Set;

// Tanto las claves como los valores deben ser únicos; sin embargo, como en las tablas hash se permiten valores
// nulos, se permite que haya una clave nula, y un valor nulo, pero no más de uno de cada uno.

public class MapaValoresUnicos<K,V> extends AbstractMap<K,V> {

    private final HashMap<K,V> tablaDirecta;
    private final HashMap<V,K> tablaInversa;

    public MapaValoresUnicos() {
        this.tablaDirecta = new HashMap<>();
        this.tablaInversa = new HashMap<>();
    }

    @Override
    public V put(K key, V value) {
        if (this.tablaInversa.containsKey(value)) {
            throw new IllegalArgumentException("El valor ya tiene una clave");
        }
        V elemento = this.tablaDirecta.put(key, value);
        this.tablaInversa.put(value, key);

        return elemento;
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
