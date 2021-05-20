package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Reserva;

public class RemoteFacadeTest {
	RemoteFacade remote;
	Cliente cliente;
	Cliente cliente2;
	
	@Rule 
	public ContiPerfRule i = new ContiPerfRule();

	@Test
	public void registrarClienteTest() {
		remote = RemoteFacade.getInstance();
		cliente = new Cliente("a", "a", "a", "a", "a", false);
		assertEquals(Status.OK.getStatusCode(), remote.registrarCliente(cliente).getStatus());
	}
	
	@Test
	@PerfTest(invocations = 10, threads =2)
	public void encontrarClientesTest() {
		remote = RemoteFacade.getInstance();
		assertNotNull(remote.encontrarClientes());
	}
	
	@Test
	public void encontrarClienteTest() {
		remote = RemoteFacade.getInstance();
		assertNotNull(remote.encontrarCliente("test@test.es"));
	}
	
	@Test
	public void encontrarHabitacionesTest() {
		remote = RemoteFacade.getInstance();
		assertNotNull(remote.encontrarHabitaciones());
	}
	
	@Test
	public void encontrarHabitacionTest() {
		remote = RemoteFacade.getInstance();
		assertNull(remote.encontrarHabitacion("H99"));
	}
	
	
	@Test
	public void encontrarReservaTest() {
		remote = RemoteFacade.getInstance();
		assertNull(remote.encontrarReserva("R25"));
	}
	
	@Test
	public void encontrarReservasTest() {
		remote = RemoteFacade.getInstance();
		assertNotNull(remote.encontrarReservas());
	}
	
	@Test
	public void encontrarEventoTest() {
		remote = RemoteFacade.getInstance();
		assertNull(remote.encontrarEvento("E99"));
	}
	
	
	@Test
	public void encontrarEventosTest() {
		remote = RemoteFacade.getInstance();
		assertNotNull(remote.encontrarEventos());
	}
	
	@Test
	public void encontrarReservaEventoTest() {
		remote = RemoteFacade.getInstance();
		assertNull(remote.encontrarEvento("RE56"));
	}

	@Test
	public void encontrarReservasEventoTest() {
		remote = RemoteFacade.getInstance();
		assertNotNull(remote.encontrarReservasEvento());
	}

}
