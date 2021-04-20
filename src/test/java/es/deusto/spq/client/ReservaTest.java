package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.Reserva;

public class ReservaTest {
	private Reserva r;
	
	@Before
	public void setUp() {
		r = new Reserva("reserva1", "habitacion1", 12, 6, 2019);
	}
	
	@Test
	public void testGetCodigoReserva() {
		assertEquals("reserva1", r.getCodigoReserva());
	}
	@Test
	public void testGetCodigoHabitacion() {
		assertEquals("habitacion1", r.getCodigoHabitacion());
	}
	@Test
	public void testGetDia() {
		assertEquals(12, r.getDia());
	}
	@Test
	public void testGetMes() {
		assertEquals(6, r.getMes());
	}
	@Test
	public void testGetAnyo() {
		assertEquals(2019, r.getAnyo());
	}


}
