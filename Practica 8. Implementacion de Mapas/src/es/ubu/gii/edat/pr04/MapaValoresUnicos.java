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

    public MapaValoresUnicos(HashMap<K,V> tablaDirecta, HashMap<V,K> tablaInversa) {
        this.tablaDirecta = tablaDirecta;
        this.tablaInversa = tablaInversa;
    }

    @Override
    public V put(K key, V value) {
        // En caso de asignar una clave a un valor existente
        if (this.tablaInversa.containsKey(value)) {
            throw new IllegalArgumentException("El valor ya tiene una clave");
        }

        V valorAntiguo = this.tablaDirecta.put(key, value);
        this.tablaInversa.put(value, key);

        // En caso de asignar un valor a una clave existente
        if (valorAntiguo != null) {
            this.tablaInversa.remove(valorAntiguo);
        }

        return valorAntiguo;
    }

    public V remove(Object key) {
        V valorAntiguo = this.tablaDirecta.remove(key);
        this.tablaInversa.remove(valorAntiguo);

        return valorAntiguo;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.tablaDirecta.entrySet();
    }

    public MapaValoresUnicos<V,K> inverso()  {
        return new MapaValoresUnicos<>(this.tablaInversa, this.tablaDirecta);
    }

    public V forcePut (K key, V value) {
        // En caso de asignar una clave a un valor existente
        if (this.tablaInversa.containsKey(value)) {
            this.tablaDirecta.remove(this.tablaInversa.get(value));
            this.tablaInversa.remove(value);
        }
        V valorAntiguo = this.tablaDirecta.put(key, value);
        this.tablaInversa.put(value, key);

        // En caso de asignar un valor a una clave existente
        if (valorAntiguo != null) {
            this.tablaInversa.remove(valorAntiguo);
        }

        return valorAntiguo;
    }
}
