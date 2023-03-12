package es.ubu.gii.edat.pr01;

import es.ubu.gii.edat.pr01.ElementoMayoritario.RespuestaMayoritaria;
import org.junit.Test;
import java.util.Random;

/**
 * Clase que permite comprobar el rendimiento de cada una de las aproximaciones al problema
 * implementadas en la clase ElementoMayoritario, ejecutando 10 iteraciones para cada algoritmo
 * e incrementando el tamaño del vector de prueba en cada iteración, para así poder comprobar
 * el rendimiento y duración de los algoritmos.
 *
 * @author Álvaro Manjón Vara
 */
public class ComplejidadAlgoritmica_Test {

    // Número tope de elementos que va a tener el vector test
    int limiteElementos = 10000;

    // Incremento de elementos que se va a ir añadiendo en cada iteración
    int paso = limiteElementos / 10;

    /**
     * Método que permite generar un vector de tamaño variable con valores aleatorios.
     *
     * @param tam - tamaño del vector que se va a generar
     * @return vector de tamaño tam con valores aleatorios
     */
    private Integer[] vectorAleatorio (int tam){
        Random rd = new Random();
        Integer[] vectorTest = new Integer[tam];

        for (int i = 0; i < tam ; i++) {
            vectorTest[i] = rd.nextInt(7);
        }

        return vectorTest;
    }

    /**
     * Método que permite comprobar el rendimiento del algoritmo iterativo. Se ejecuta 10 veces,
     * incrementando el tamaño del vector de prueba en cada iteración.
     * La salida ha sido formateada de tal forma que puede ser importada a un fichero .csv para
     * poder visualizar mejor los datos y crear gráficos.
     */
    @Test
    public void testElementoMayoritario_iterativo() {
        double inicio, fin;
        Integer[] vectorTest;

        System.out.println("ALGORITMO ITERATIVO");
        System.out.println("Tiempo de ejecución para vectores de distinto tamaño: ");

        for (int i = 1000; i <= limiteElementos; i += paso) {
            vectorTest = vectorAleatorio(i);

            inicio = System.currentTimeMillis();
            RespuestaMayoritaria<Integer> r1 = ElementoMayoritario.mayoritarioIterativo(vectorTest);
            fin = System.currentTimeMillis();

            //System.out.println("Número de elementos: " + i);
            //System.out.println("Tiempo (ms): " + (fin - inicio));
            System.out.println("Num.Elem," + i + ",tiempo(ms)," + (fin - inicio));
        }
    }

    /**
     * Método que permite comprobar el rendimiento del algoritmo recursivo. Se ejecuta 10 veces,
     * incrementando el tamaño del vector de prueba en cada iteración.
     * La salida ha sido formateada de tal forma que puede ser importada a un fichero .csv para
     * poder visualizar mejor los datos y crear gráficos.
     */
    @Test
    public void testElementoMayoritario_recursivo() {
        double inicio, fin;
        Integer[] vectorTest;

        System.out.println("ALGORITMO RECURSIVO");
        System.out.println("Tiempo de ejecución para vectores de distinto tamaño: ");

        for (int i = 1000; i <= limiteElementos; i += paso) {
            vectorTest = vectorAleatorio(i);

            inicio = System.currentTimeMillis();
            RespuestaMayoritaria<Integer> r1 = ElementoMayoritario.mayoritarioRecursivo(vectorTest);
            fin = System.currentTimeMillis();

            //System.out.println("Número de elementos: " + i);
            //System.out.println("Tiempo (ms): " + (fin - inicio));
            System.out.println("Num.Elem," + i + ",tiempo(ms)," + (fin - inicio));
        }
    }
}
