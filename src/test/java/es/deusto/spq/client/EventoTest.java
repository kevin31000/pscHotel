package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EventoTest {
    Evento e;

    @Before
	public void setUp() {
		e = new Evento("E01", "Cena de gala", "", 1, 1, 2021, "5:00", 50);
	}
	
	@Test
	public void getCodigoTest() {		
		assertEquals("E01", e.getCodigo());
	}
	
    @Test
	public void getNombreTest() {		
		assertEquals("Cena de gala", e.getNombre());
	}

    @Test
	public void getDescripcionTest() {		
		assertEquals("", e.getDescripcion());
	}

    @Test
	public void getDiaTest() {
		System.out.println(e.getDia());
		assertEquals(1, e.getDia());
	}

    @Test
	public void getMesTest() {
		System.out.println(e.getMes());
		assertEquals(1, e.getMes());
	}

    @Test
	public void getAnyoTest() {
		System.out.println(e.getAnyo());
		assertEquals(2021, e.getAnyo());
	}

	@Test
	public void getHoraTest() {
		assertEquals("5:00", e.getHora());
	}
	
	@Test
	public void getNumMaxPersonasTest() {
		assertEquals(50, e.getNumMaxPersonas());
	}
}
