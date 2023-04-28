package es.ubu.gii.edat.pr04;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import es.ubu.gii.edat.pr04.MapaValoresUnicos;
//import es.ubu.gii.edat.pr04.v3.*;


/**
 * Version para jUnit4. 
 * Para darselo a los alumnos para que realicen sus pruebas.
 * 
 * @author bbaruque
 *
 */


public class MapaValoresUnicosTest{

	protected MapaValoresUnicos<Integer,Character> mapaVU;
	protected MapaValoresUnicos<Character,Integer> mapaVUInv;
	
	@Before
	public void setUp() throws Exception {
		mapaVU = new MapaValoresUnicos<Integer,Character>(); 
		mapaVUInv = null;
	}

	@After
	public void tearDown() throws Exception {
		mapaVU.clear();
//		mapaVUInv.clear();
	}

	@Test
	public void testInsertarSinRepetidos() {
		
		assertNull(mapaVU.put(1,'a'));
		assertNull(mapaVU.put(2,'b'));
		assertNull(mapaVU.put(3,'c'));
		
		assertEquals(3,mapaVU.size());
		
		assertNull(mapaVU.put(5, 'd'));
		
		assertEquals(4,mapaVU.size());
		
	}

	@Test
	public void testInsertarClaveRepetida() {
		
		testInsertarSinRepetidos();

		assertEquals((Character)'d', mapaVU.put(5, 'e'));
		
		assertEquals(4,mapaVU.size());
		assertTrue(mapaVU.containsKey(5));
		assertTrue(mapaVU.containsValue('e'));
		assertFalse(mapaVU.containsValue('d'));
		
	}

	
	@Test	
	public void testInsertarValorRepetido() {
		
		testInsertarSinRepetidos();
		
		try{
			mapaVU.put(6, 'd');
		}catch(IllegalArgumentException iae){
			System.err.println("Excepcion correctamente lanzada");
			return;
		}
		
		fail();
		
	}
	
	@Test
	public void testForzarInsercionSinSobreescritura() {
		
		testInsertarSinRepetidos();
		assertNull(mapaVU.forcePut(6, 'f'));
		
		assertEquals(5,mapaVU.size());
		assertTrue(mapaVU.containsKey(6));
		assertTrue(mapaVU.containsValue('f'));
		
		assertEquals((Character)'f', mapaVU.get(6));
		
	}

	@Test
	public void testForzarInsercionSobreescritura() {
		
		testInsertarSinRepetidos();
		assertEquals((Character)'b', mapaVU.forcePut(2, 'a'));
		
		assertEquals(3,mapaVU.size());
		assertTrue(mapaVU.containsKey(2));
		assertTrue(mapaVU.containsValue('a'));
		
		assertFalse(mapaVU.containsValue('b'));
		assertFalse(mapaVU.containsKey(1));
		
		assertEquals((Character)'a', mapaVU.get(2));
		
	}
	
	@Test
	public void testEliminarContenido() {
		
		Character valorE;
		testInsertarSinRepetidos();
		
		valorE = mapaVU.remove(2);
		assertEquals((Character)'b', valorE);
		assertFalse(mapaVU.containsKey(2));
		assertFalse(mapaVU.containsValue('b'));
		assertEquals(3, mapaVU.size());
		
		valorE = mapaVU.remove(2);
		assertEquals(null, valorE);
		assertEquals(3, mapaVU.size());
		
	}
	
	@Test
	public void testKeySet() {
		
		Set<Integer> clavesControl = new HashSet<Integer>();
		clavesControl.addAll(Arrays.asList(1,2,3,5));
		
		testInsertarSinRepetidos();
		
		Set<Integer> claves = mapaVU.keySet();
		assertEquals(clavesControl.size(),claves.size());
		assertEquals(clavesControl,claves);
		
	}
	
	@Test
	public void testValues() {
		
		Set<Character> valoresControl = new HashSet<Character>();
		valoresControl.addAll(Arrays.asList('a','b','c','d'));
		
		testInsertarSinRepetidos();
		
		Collection<Character> claves = mapaVU.values();
		assertEquals(valoresControl.size(),claves.size());
		assertTrue(valoresControl.containsAll(claves));
	}

	@Test	
	public void testConsultaInverso(){
		
		testInsertarSinRepetidos();
		mapaVUInv = mapaVU.inverso();
		
		assertEquals(4, mapaVUInv.size());
		
		assertTrue(mapaVUInv.containsKey('a'));
		assertFalse(mapaVUInv.containsKey(1));
		assertTrue(mapaVUInv.containsValue(2));
		assertFalse(mapaVUInv.containsValue('b'));
		
		assertEquals((Integer) 3, mapaVUInv.get('c'));
		assertEquals((Integer) 5, mapaVUInv.get('d'));
		
	}
	
	@Test	
	public void testInsercionInverso(){
		
		testInsertarSinRepetidos();
		mapaVUInv = mapaVU.inverso();

		assertEquals(4, mapaVU.size());
		assertEquals(4, mapaVUInv.size());
		
		assertEquals(null, mapaVUInv.put('g', 8));

		assertEquals(5, mapaVU.size());
		assertEquals(5, mapaVUInv.size());

		assertTrue(mapaVU.containsKey(8));
		assertTrue(mapaVU.containsValue('g'));
		
	}

	@Test	
	public void testForzarInsercionInverso(){
		
		testInsertarSinRepetidos();
		mapaVUInv = mapaVU.inverso();

		assertEquals(null, mapaVUInv.forcePut('f', 6));

		assertEquals(5,mapaVU.size());
		assertEquals(5,mapaVUInv.size());

		assertTrue(mapaVU.containsKey(6));
		assertTrue(mapaVU.containsValue('f'));
		assertTrue(mapaVUInv.containsKey('f'));
		assertTrue(mapaVUInv.containsValue(6));
		
		assertEquals((Character)'f', mapaVU.get(6));
		assertEquals((Integer)6, mapaVUInv.get('f'));

	}
	
}
