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

    // TODO: Ver si hace falta sobreescribir más métodos (en principio con los métodos actuales es suficiente)

    public MapaValoresUnicos<V,K> inverso()  {
        MapaValoresUnicos<V,K> mapaInverso = new MapaValoresUnicos<>();
        for (Entry<V,K> entry : this.tablaInversa.entrySet()) {
            mapaInverso.put(entry.getKey(), entry.getValue());
        }

        return mapaInverso;
    }

    public V forcePut (K key, V value) {
        // TODO: Implementar
        return null;
    }
}
