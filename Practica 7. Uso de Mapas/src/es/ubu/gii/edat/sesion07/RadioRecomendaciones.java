package es.ubu.gii.edat.sesion07;

import java.util.*;

/**
 * Clase que contiene una lista de canciones, así como las relaciones entre las distintas canciones. Se
 * puede generar una playlist a partir de una canción inicial, así como obtener las canciones que no
 * tienen recomendaciones.
 *
 * @author Álvaro Manjón Vara
 */
public class RadioRecomendaciones {
    private HashMap<String, ArrayList<String>> listaRecomendaciones;

    /**
     * Constructor de la clase RadioRecomendaciones. Inicializa la lista de recomendaciones vacía.
     */
    RadioRecomendaciones() {
        this.listaRecomendaciones = new HashMap<String, ArrayList<String>>();
    }

    /**
     * Método que inserta las canciones y sus recomendaciones. El array de cadenas de texto contiene las
     * canciones y sus recomendaciones en el siguiente formato:
     * String[] temas = { "|", "Tema0", "Tema1","Tema2",
     * "|", "Tema1", "Tema3","Tema5","Tema12",
     * "|", "Tema2", "Tema4", "|", "Tema3", "Tema4","Tema2","Tema8","Tema1", "|", "Tema4", "Tema1","Tema2",
     * "|", "Tema5", "Tema4","Tema2","Tema0","Tema9", "|"}
     * donde cada separador "|" indica el inicio de un nuevo elemento. El primer elemento es el tema
     * principal, y los siguientes son las recomendaciones de dicho tema.
     *
     * @param recomendaciones - array de cadenas de texto que contiene las canciones y sus recomendaciones
     * @return número de canciones que se han insertado en la lista de recomendaciones
     */
    public int insertaRecomendaciones(String[] recomendaciones) {
        int canciones = 0;
        boolean nuevoElemento = false;
        String clave = "";

        for (int i = 0; i < recomendaciones.length; i++) {
            if (recomendaciones[i].equals("|")) {
                nuevoElemento = true;
                continue;
            }
            if (nuevoElemento) {
                canciones++;
                clave = recomendaciones[i];
                this.listaRecomendaciones.put(clave, new ArrayList<String>());
                nuevoElemento = false;
            } else {
                this.listaRecomendaciones.get(clave).add(recomendaciones[i]);
            }
        }

        return canciones;
    }

    /**
     * Método que genera una playlist a partir de una canción inicial y un número de temas.
     * La playlist se genera de la siguiente forma:
     * 1. Se añade la canción inicial a la playlist.
     * 2. Se añaden las recomendaciones de la canción inicial a la playlist.
     * 3. Si todavía quedan canciones por añadir a la playlist, se añaden las recomendaciones de la
     * siguiente canción de la lista después de la canción inicial.
     * 4. Se repite el paso 3 hasta que se hayan añadido todas las canciones a la playlist.
     * La playlist no va a contener canciones duplicadas.
     *
     * @param inicial - canción inicial de la playlist
     * @param numTemas - número de temas de la playlist
     * @return playlist generada
     */
    public String[] generaPlaylist(String inicial, int numTemas) {
        String[] playlist = new String[numTemas];
        ArrayList<String> temasRecomendados = new ArrayList<String>();

        playlist[0] = inicial;
        for (int i = 0; elementosNoNulos(playlist) < numTemas; i++) {
            temasRecomendados = this.listaRecomendaciones.get(playlist[i]);
            for (int j = 0; elementosNoNulos(playlist) < numTemas && j < temasRecomendados.size(); j++) {
                if (Arrays.asList(playlist).contains(temasRecomendados.get(j))) {
                    continue;
                } else {
                    playlist[i + j + 1] = temasRecomendados.get(j);
                }
            }
        }

        return playlist;
    }

    /**
     * Método interno que devuelve el número de elementos no nulos de un array de cadenas de texto.
     *
     * @param array - array de cadenas de texto
     * @return número de elementos no nulos del array
     */
    private int elementosNoNulos(String[] array) {
        int elementos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                elementos++;
            }
        }
        return elementos;
    }

    /**
     * Método que devuelve las canciones que no son recomendación de ninguna otra canción.
     *
     * @return canciones que no son recomendación de ninguna otra canción
     */
    public String[] noRecomendadas() {
        ArrayList<String> temasNoRecomendados = new ArrayList<String>();
        ArrayList<String> todosLosTemas = new ArrayList<String>();

        for (ArrayList<String> temas : this.listaRecomendaciones.values()) {
            todosLosTemas.addAll(temas);
        }

        for (String tema : this.listaRecomendaciones.keySet()) {
            if (todosLosTemas.contains(tema)) {
                continue;
            } else {
                temasNoRecomendados.add(tema);
            }
        }

        return temasNoRecomendados.toArray(new String[temasNoRecomendados.size()]);
    }
}
