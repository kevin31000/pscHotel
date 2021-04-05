package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.Reserva;

public class TestReserva {
	private Reserva r;
	
	@Before
	public void setUp() {
		r = new Reserva("reserva1", "habitacion1", 12, 6, 2019);
	}
	
	@Test
	public void testCodigoReserva() {
		assertEquals("reserva1", r.getCodigoReserva());
	}
	@Test
	public void testCodigoHabitacion() {
		assertEquals("habitacion1", r.getCodigoHabitacion());
	}
	@Test
	public void testDia() {
		assertEquals(12, r.getDia());
	}
	@Test
	public void testMes() {
		assertEquals(6, r.getMes());
	}
	@Test
	public void testAnyo() {
		assertEquals(2019, r.getAnyo());
	}

}
