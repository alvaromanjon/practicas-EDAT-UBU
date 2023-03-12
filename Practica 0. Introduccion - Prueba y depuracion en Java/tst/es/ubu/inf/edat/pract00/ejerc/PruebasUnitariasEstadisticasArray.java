package es.ubu.inf.edat.pract00.ejerc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PruebasUnitariasEstadisticasArray {

	/**
	 * Permite probar la clase de EstaditicasArray cuando el vector contiene un
	 * numero impar de elementos
	 */
	@Test
	public void pruebaPares(){
		
		int arrayPrueba[] = {3,6,2,8,12,57,9,25};

		EstadisticasArray estadisticas = new EstadisticasArray();
		
		estadisticas.rellenaVector(arrayPrueba);
		
		System.out.println("-- Prueba Pares --");
		System.out.println("Media Aritmetica: "+estadisticas.mediaAritmetica());
		assertEquals (15.25, estadisticas.mediaAritmetica(), 0);
		
		System.out.println("Media Geometica: "+estadisticas.mediaGeometrica());
		assertEquals (9.03, estadisticas.mediaGeometrica(), 0.01);
		
		// TODO - Probar el metodo que calcula la Mediana
		
		// TODO - Probar el metodo que calcula la Varianza
		
	}

	/**
	 * Permite probar la clase de EstaditicasArray cuando el vector contiene un
	 * numero impar de elementos
	 */
	@Test
	public void pruebaImpares(){
		
		int arrayPrueba[] = {5,9,43,78,21,14,28};

		EstadisticasArray estadisticas = new EstadisticasArray();
		
		estadisticas.rellenaVector(arrayPrueba);
		
		System.out.println("-- Prueba Impares --");
		System.out.println("Media Aritmetica: "+estadisticas.mediaAritmetica());
		assertEquals (28.28, estadisticas.mediaAritmetica(), 0.01 );
		
		System.out.println("Media Geometica: "+estadisticas.mediaGeometrica());
		assertEquals (19.91, estadisticas.mediaGeometrica(), 0.01);

		// TODO - Probar el metodo que calcula la Mediana
		
		// TODO - Probar el metodo que calcula la Varianza
		
	
	}

}
