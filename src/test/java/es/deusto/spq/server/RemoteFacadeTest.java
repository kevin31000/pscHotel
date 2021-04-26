package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Response.Status;

import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.client.Cliente;

public class RemoteFacadeTest {
	RemoteFacade remote;
	Cliente cliente;
	
	@Rule 
	public ContiPerfRule i = new ContiPerfRule();

	@Test
	public void registrarClienteTest() {
		remote = RemoteFacade.getInstance();
		cliente = new Cliente("a", "a", "a", "a", "a", false);
		assertEquals(Status.OK.getStatusCode(), remote.registrarCliente(cliente).getStatus());
	}
	
	@Test
	public void encontrarClientesTest() {
		remote = RemoteFacade.getInstance();
		assertNotNull(remote.encontrarClientes());
	}
	
	@Test
	public void encontrarHabitacionesTest() {
		remote = RemoteFacade.getInstance();
		assertNotNull(remote.encontrarHabitaciones());
	}
}
