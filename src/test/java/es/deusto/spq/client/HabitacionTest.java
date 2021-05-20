package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HabitacionTest {
	Habitacion h = new Habitacion("302D", 3, 30.5, true);;
	
	
	@Test
	public void getCodigoTest() {		
		assertEquals("302D", h.getCodigo());
	}
	
	@Test
	public void getNumCamasTest() {
		assertEquals(3, h.getNumCamas());
	}
	
	
	@Test
	public void getPrecioTest() {
		System.out.println(h.getPrecio());
		//assertEquals(30.5, h.getPrecio());
	}
	
	@Test
	public void getOcupadaTest() {
		assertEquals(true, h.isOcupada());
	}
	

}
