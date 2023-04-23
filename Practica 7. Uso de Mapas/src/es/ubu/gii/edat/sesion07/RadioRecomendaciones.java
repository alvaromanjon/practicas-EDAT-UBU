package es.ubu.gii.edat.sesion07;

import java.util.ArrayList;
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
}
