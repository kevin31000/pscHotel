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

	@Test
	public void testSetCodigoReserva() {
		r.setCodigoReserva("Reserva2");
		assertEquals("Reserva2", r.getCodigoReserva());
	}
	@Test
	public void testSetCodigoHabitacion() {
		r.setCodigoHabitacion("Habitacion2");
		assertEquals("Habitacion2", r.getCodigoHabitacion());
	}
	@Test
	public void testSetDia() {
		r.setDia(13);
		assertEquals(12, r.getDia());
	}
	@Test
	public void testSetMes() {
		r.setMes(12);
		assertEquals(12, r.getMes());
	}
	@Test
	public void testSetAnyo() {
		r.setAnyo(2021);
		assertEquals(2021, r.getAnyo());
	}
}
