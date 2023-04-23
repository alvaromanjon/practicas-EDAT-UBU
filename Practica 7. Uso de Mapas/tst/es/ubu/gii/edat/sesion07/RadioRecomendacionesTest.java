package es.ubu.gii.edat.sesion07;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RadioRecomendacionesTest {

	RadioRecomendaciones miRadio;
	
	@Before
	public void setUp() throws Exception {
		miRadio = new RadioRecomendaciones();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertaRecomendaciones() {
		
		String[] recom = { "|", "Pagan Poetry", "Enigma Machine for Alan Turing",
		        "|","Rock the Casbah","London Calling","Calling to you Hart","The Final Countdown",
		        "|","Calling to you Hart", "Total Eclipse From My Heart","The Final Countdown",
		        "|","Mi Carro","Que Viva Espana",
		        "|","The Final Countdown","I Was Made for Loving You Baby",
		        "|"};
		
		int numTemas = miRadio.insertaRecomendaciones(recom);
		assertEquals(5,numTemas);
		
//		System.out.println(miRadio);

	}

	@Test
	public void testInsertaRecomendacionesGenericas() {
		
		String[] recom = { "|", "Tema0", "Tema1","Tema2",
				 "|", "Tema1", "Tema3","Tema5","Tema12",
				 "|", "Tema2", "Tema4",
				 "|", "Tema3", "Tema4","Tema2","Tema8","Tema1",
				 "|", "Tema4", "Tema1","Tema2",
				 "|", "Tema5", "Tema4","Tema2","Tema0","Tema9","|"};
		
		int numTemas = miRadio.insertaRecomendaciones(recom);
		assertEquals(6,numTemas);
		
//		System.out.println(miRadio);
		
	}

	
	@Test
	public void testGeneraPlaylistSinRepetidos() {
		
		String[] playlist;
		
		testInsertaRecomendacionesGenericas();

		String[] control = {"Tema4","Tema1"};
		playlist = miRadio.generaPlaylist("Tema4", 2);
		
		for(int i=0; i<2; i++)
			assertEquals(control[i],playlist[i]);
		
	}
	
	@Test
	public void testGeneraPlaylistRepetidos() {
	
		String[] playlist;
		
		testInsertaRecomendacionesGenericas();
		
		playlist = miRadio.generaPlaylist("Tema2", 6);
		String[] control = {"Tema2","Tema4","Tema1","Tema3","Tema5","Tema12"};
		
		for(int i=0; i<6; i++)
			assertEquals(control[i],playlist[i]);

	}

	@Test
	public void testInsertaRecomendacionesHuecos() {
		
		String[] recom = { "|", "Tema0", "Tema1","Tema2",
				 "|", "Tema1", "Tema3","Tema4","Tema12",
				 "|", "Tema2", 
				 "|", "Tema3", "Tema4","Tema2","Tema8","Tema1",
				 "|", "Tema4", "Tema1","Tema2",
				 "|", "Tema5", "Tema4","Tema2","Tema8","Tema9",
				 "|", "Tema6","|"};
		
		int numTemas = miRadio.insertaRecomendaciones(recom);
		assertEquals(7,numTemas);
		
//		System.out.println(miRadio);
		
	}
	
	@Test
	public void testNoRecomendadas() {

		testInsertaRecomendacionesHuecos();
		String[] control = {"Tema0","Tema5","Tema6"};
		
		String[] sinRec = miRadio.noRecomendadas();
		
		assertEquals(control.length,sinRec.length);
		assertTrue(Arrays.asList(sinRec).containsAll(Arrays.asList(control)));
		
	}
	
}
