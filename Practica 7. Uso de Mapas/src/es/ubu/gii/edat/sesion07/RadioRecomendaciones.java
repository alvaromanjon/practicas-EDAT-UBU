package es.ubu.gii.edat.sesion07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RadioRecomendaciones {
    private HashMap<String, ArrayList<String>> listaRecomendaciones;

    RadioRecomendaciones() {
        this.listaRecomendaciones = new HashMap<String, ArrayList<String>>();
    }

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

    private int elementosNoNulos(String[] array) {
        int elementos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                elementos++;
            }
        }
        return elementos;
    }
}
