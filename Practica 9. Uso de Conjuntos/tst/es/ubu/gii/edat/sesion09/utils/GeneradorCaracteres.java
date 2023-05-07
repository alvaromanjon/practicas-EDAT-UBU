package es.ubu.gii.edat.sesion09.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeneradorCaracteres {

	/**
	 * Contenido alfabético en inglés
	 */
	static Character[] abecedario = 
		{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	/**
	 * 
	 * @param tamano
	 * @return
	 */
	public static List<Character> listaAleatoria (int tamano){
		
		char[] aleatorio = arrayAleatorio(tamano);
		List<Character> aleatoria = new ArrayList<Character>(tamano);		
		
		for(int i=0; i<tamano; i++){
			aleatoria.add(aleatorio[i]);
		}
		
		return aleatoria;
		
	}
	
	/**
	 * 
	 * @param tamano
	 * @param min
	 * @param max
	 * @return
	 */
	public static List<Character> listaAleatoriaEntre (int tamano, char min, char max){
		
		List<Character> lista = Arrays.asList(abecedario);
		List<Character> respuesta = new ArrayList<Character>();
		
		int posMin = lista.indexOf(min);
		int posMax = lista.indexOf(max);
		
		int rango = posMax - posMin;
		for(int i=0; i < Math.floor(tamano/rango); i++)
			respuesta.addAll(lista.subList(posMin, posMax+1));
		respuesta.addAll(lista.subList(posMin, tamano%rango));
		Collections.shuffle(respuesta);
		
		return respuesta.subList(0, tamano);
		
	}
	
	/**
	 * 
	 * @param tamano
	 * @return
	 */
	public static List<Character> listaAleatoriaUnicos (int tamano){
		
		if(tamano > abecedario.length)
			throw new IllegalArgumentException(); 
		
		List<Character> lista = Arrays.asList(abecedario);
		
		List<Character> respuesta = new ArrayList<Character>();
		
		Collections.shuffle(lista);
		
		respuesta.addAll(lista.subList(0, tamano-1));

		return respuesta; 
		
	}

	/**
	 * 
	 * @param tamano
	 * @return
	 */
	public static char[] arrayAleatorio (int tamano){
		
		char[] aleatorio = new char[tamano];
		
		for(int i=0; i<tamano; i++){
			int indice = (int) Math.round(Math.random()*(abecedario.length-1));
			aleatorio[i] = abecedario[indice];
		}

		return aleatorio;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Character caracterAleatorio(){
		
		int indice = (int) Math.round(Math.random()*(abecedario.length-1));
		return abecedario[indice];
		
	}
	
}
