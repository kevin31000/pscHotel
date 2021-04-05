package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.Cliente;

public class TestCliente {
	
	private Cliente c;
	
	@Before
	public void setUp() {
		c = new Cliente("71234561D", "Sergio", "Lopez", "sergio@gmail.com", "123", false);
	}
	
	@Test
	public void testDNI() {
		assertEquals("71234561D", c.getDNI());
	}
	@Test
	public void testNombre() {
		assertEquals("Sergio", c.getNombre());
	}
	@Test
	public void testApellido() {
		assertEquals("Lopez", c.getApellido());
	}
	@Test
	public void testEmail() {
		assertEquals("sergio@gmail.com", c.getEmail());
	}
	@Test
	public void testContrasenya() {
		assertEquals("123", c.getContrasenya());
	}
	@Test
	public void testEsAdmin() {
		assertEquals(false, c.isEsAdmin());
	}
	
	
	

}
