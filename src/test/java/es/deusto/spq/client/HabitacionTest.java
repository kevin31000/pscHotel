package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HabitacionTest {
	Habitacion h;
	
	@Before
	public void setUp() {
		h = new Habitacion("302D", 3, 30.5, true);
	}
	
	@Test
	public void testGetCodigo() {		
		assertEquals("302D", h.getCodigo());
	}
	
	@Test
	public void testGetNumCamas() {
		assertEquals(3, h.getNumCamas());
	}
	
	
	@Test
	public void testGetPrecio() {
		System.out.println(h.getPrecio());
		//assertEquals(30.5, h.getPrecio());
	}
	
	@Test
	public void testGetOcupada() {
		assertEquals(true, h.isOcupada());
	}
	

}
