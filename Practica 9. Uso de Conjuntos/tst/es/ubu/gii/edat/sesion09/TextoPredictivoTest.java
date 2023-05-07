package es.ubu.gii.edat.sesion09;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TextoPredictivoTest {

	TextoPredictivo predictivo;
	
	String [] diccionario = {"a","ante","bajo","cabe","con","contra","según","sin","sobre","tras"};
	
	@Before
	public void setUp() throws Exception {
		predictivo = new TextoPredictivo(diccionario);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTextoPredictivo() {
		assertEquals(10,predictivo.tamañoDiccionario());
	}

	@Test
	public void testSugiere() {
		
		String [] sugerencias;
		
		sugerencias = predictivo.sugiere("ba", 3);
		assertEquals("ante",sugerencias[0]);
		assertEquals("bajo",sugerencias[1]);
		assertEquals("cabe",sugerencias[2]);
		
		sugerencias = predictivo.sugiere("sob", 3);
		assertEquals("sin",sugerencias[0]);
		assertEquals("sobre",sugerencias[1]);
		assertEquals("tras",sugerencias[2]);
	}
}
