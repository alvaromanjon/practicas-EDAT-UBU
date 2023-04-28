package es.ubu.gii.edat.pr04;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Set;

/**
 * Clase que implementa un mapa en el que tanto las claves como los valores son únicos.
 *
 * @param <K> Clase de la clave
 * @param <V> Clase del valor
 * @author Álvaro Manjón Vara
 */
public class MapaValoresUnicos<K,V> extends AbstractMap<K,V> {

    private final HashMap<K,V> tablaDirecta;
    private final HashMap<V,K> tablaInversa;

    /**
     * Constructor de la clase MapaValoresUnicos. Inicializa las tablas directa e inversa.
     */
    public MapaValoresUnicos() {
        this.tablaDirecta = new HashMap<>();
        this.tablaInversa = new HashMap<>();
    }

    /**
     * Constructor de la clase MapaValoresUnicos. Inicializa las tablas directa e inversa a partir de los
     * mapas que se pasan como parámetro.
     *
     * @param tablaDirecta - tabla directa
     * @param tablaInversa - tabla inversa
     */
    public MapaValoresUnicos(HashMap<K,V> tablaDirecta, HashMap<V,K> tablaInversa) {
        this.tablaDirecta = tablaDirecta;
        this.tablaInversa = tablaInversa;
    }

    /**
     * Método que permite insertar un valor en el mapa, de tal manera que tanto la clave como el valor sean
     * únicos, y ambas tablas hash se mantengan sincronizadas.
     * Si se intenta asignar una clave a un valor ya existente, se lanza una excepción de tipo
     * IllegalArgumentException.
     * Si se intenta asignar un valor a una clave ya existente, se elimina la entrada anterior.
     *
     * @param key  - clave
     * @param value - valor
     * @return valor antiguo asociado a la clave
     */
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

    /**
     * Método que permite borrar un valor del mapa a partir de la clave, de tal manera que ambas
     * tablas hash se mantengan sincronizadas.
     *
     * @param key - clave
     * @return valor eliminado y asociado a la clave
     */
    public V remove(Object key) {
        V valorAntiguo = this.tablaDirecta.remove(key);
        this.tablaInversa.remove(valorAntiguo);

        return valorAntiguo;
    }

    /**
     * Método que devuelve un Set con las entradas del mapa.
     *
     * @return Set con las entradas del mapa
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.tablaDirecta.entrySet();
    }

    /**
     * Método que devuelve un objeto de la clase MapaValoresUnicos, que es el inverso del mapa actual.
     * El objeto invertido tiene como claves los valores del mapa actual, y como valores las claves del mapa
     * actual. Si se realiza un cambio en el objeto invertido, también se hará en el mapa actual.
     *
     * @return objeto de la clase MapaValoresUnicos inverso
     */
    public MapaValoresUnicos<V,K> inverso()  {
        return new MapaValoresUnicos<>(this.tablaInversa, this.tablaDirecta);
    }

    /**
     * Método que permite insertar un valor en el mapa, como el método put(), pero en caso de que se intente
     * asignar una clave a un valor ya existente, se elimina la entrada anterior y no devuelve una excepción.
     *
     * @param key - clave
     * @param value - valor
     * @return valor antiguo asociado a la clave
     */
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
