package es.ubu.gii.edat.pr01;

import static org.junit.Assert.*;

import org.junit.Test;

import es.ubu.gii.edat.pr01.ElementoMayoritario;
import es.ubu.gii.edat.pr01.ElementoMayoritario.RespuestaMayoritaria;

public class ElementoMayoritario_Test {

	@Test
	public void testElementoMayoritario_iterativo_int() {
		Integer [] vector1 = {3,3,4,2,4,4,2,4,4};
		Integer [] vector2 = {3,3,4,2,4,4,2,4};

		RespuestaMayoritaria<Integer> m1 = new RespuestaMayoritaria<Integer> (4,5); 
		RespuestaMayoritaria<Integer> m2 = new RespuestaMayoritaria<Integer> (null,0);
				
		RespuestaMayoritaria<Integer> r1 = ElementoMayoritario.mayoritarioIterativo(vector1);
		RespuestaMayoritaria<Integer> r2 = ElementoMayoritario.mayoritarioIterativo(vector2);
		
		assertEquals(m1.getElemento(),r1.getElemento());
		assertEquals(m1.getFrecuencia(),r1.getFrecuencia());
		assertEquals(m2.getElemento(),r2.getElemento());
		assertEquals(m2.getFrecuencia(),r2.getFrecuencia());
	}

	@Test
	public void testElementoMayoritario_recursivo_int() {
		Integer [] vector1 = {3,3,4,2,4,4,2,4,4};
		Integer [] vector2 = {3,3,4,2,4,4,2,4};

		RespuestaMayoritaria<Integer> m1 = new RespuestaMayoritaria<Integer> (4,5); 
		RespuestaMayoritaria<Integer> m2 = new RespuestaMayoritaria<Integer> (null,0);
				
		RespuestaMayoritaria<Integer> r1 = ElementoMayoritario.mayoritarioRecursivo(vector1);
		RespuestaMayoritaria<Integer> r2 = ElementoMayoritario.mayoritarioRecursivo(vector2);
		
		assertEquals(m1.getElemento(),r1.getElemento());
		assertEquals(m1.getFrecuencia(),r1.getFrecuencia());
		assertEquals(m2.getElemento(),r2.getElemento());
		assertEquals(m2.getFrecuencia(),r2.getFrecuencia());
	}
	
	@Test
	public void testElementoMayoritario_iterativo_char() {
		Character [] vector1 = {'a','a','b','a','a','a','a','b','c'};
		Character [] vector2 = {'b','b','a','a','c','c','d'};

		RespuestaMayoritaria<Character> m1 = new RespuestaMayoritaria<Character> ('a',6); 
		RespuestaMayoritaria<Character> m2 = new RespuestaMayoritaria<Character> (null,0);
				
		RespuestaMayoritaria<Character> r1 = ElementoMayoritario.mayoritarioIterativo(vector1);
		RespuestaMayoritaria<Character> r2 = ElementoMayoritario.mayoritarioIterativo(vector2);
		
		assertEquals(m1.getElemento(),r1.getElemento());
		assertEquals(m1.getFrecuencia(),r1.getFrecuencia());
		assertEquals(m2.getElemento(),r2.getElemento());
		assertEquals(m2.getFrecuencia(),r2.getFrecuencia());
	}

	@Test
	public void testElementoMayoritario_recursivo_char() {
		Character [] vector1 = {'a','a','b','a','a','a','a','b','c'};
		Character [] vector2 = {'b','b','a','a','c','c','d'};

		RespuestaMayoritaria<Character> m1 = new RespuestaMayoritaria<Character> ('a',6); 
		RespuestaMayoritaria<Character> m2 = new RespuestaMayoritaria<Character> (null,0);
				
		RespuestaMayoritaria<Character> r1 = ElementoMayoritario.mayoritarioRecursivo(vector1);
		RespuestaMayoritaria<Character> r2 = ElementoMayoritario.mayoritarioRecursivo(vector2);
		
		assertEquals(m1.getElemento(),r1.getElemento());
		assertEquals(m1.getFrecuencia(),r1.getFrecuencia());
		assertEquals(m2.getElemento(),r2.getElemento());
		assertEquals(m2.getFrecuencia(),r2.getFrecuencia());
	}

	
}
