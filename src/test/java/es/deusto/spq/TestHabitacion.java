package es.deusto.spq;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.deusto.spq.client.Habitacion;

public class TestHabitacion {

	@Test
	public void testCodigo() {
		Habitacion h = new Habitacion("302D", 3, 30.5, true);
		
		assertEquals("302D", h.getCodigo());
	}
	
	@Test
	public void testNumCamas() {
		Habitacion h = new Habitacion("302D", 3, 30.5, true);
		
		assertEquals(3, h.getNumCamas());
	}
	
	
	@Test
	public void testPrecio() {
		Habitacion h = new Habitacion("302D", 3, 30.5, true);
		System.out.println(h.getPrecio());
		//assertEquals(30.5, h.getPrecio());
	}
	
	@Test
	public void testOcupada() {
		Habitacion h = new Habitacion("302D", 3, 30.5, true);
		
		assertEquals(true, h.isOcupada());
	}

}
