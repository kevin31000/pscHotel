package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.Reserva;

public class ReservaTest {
	private Reserva r;
	
	@Before
	public void setUp() {
		r = new Reserva("reserva1", "habitacion1", "test@test.es", 12, 6, 2019);
	}
	
	@Test
	public void getCodigoReservaTest() {
		assertEquals("reserva1", r.getCodigoReserva());
	}
	@Test
	public void getCodigoHabitacionTest() {
		assertEquals("habitacion1", r.getCodigoHabitacion());
	}
	@Test
	public void getDiaTest() {
		assertEquals(12, r.getDia());
	}
	@Test
	public void getMesTest() {
		assertEquals(6, r.getMes());
	}
	@Test
	public void getAnyoTest() {
		assertEquals(2019, r.getAnyo());
	}


}
