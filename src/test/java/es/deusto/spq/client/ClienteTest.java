package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.Cliente;

public class ClienteTest {
	
	private Cliente c;
	
	@Before
	public void setUp() {
		c = new Cliente("71234561D", "Sergio", "Lopez", "sergio@gmail.com", "123", false);
	}
	
	@Test
	public void testGetDNI() {
		assertEquals("71234561D", c.getDNI());
	}
	@Test
	public void testGetNombre() {
		assertEquals("Sergio", c.getNombre());
	}
	@Test
	public void testGetApellido() {
		assertEquals("Lopez", c.getApellido());
	}
	@Test
	public void testGetEmail() {
		assertEquals("sergio@gmail.com", c.getEmail());
	}
	@Test
	public void testGetContrasenya() {
		assertEquals("123", c.getContrasenya());
	}
	@Test
	public void testGetEsAdmin() {
		assertEquals(false, c.isEsAdmin());
	}

	
	

}
