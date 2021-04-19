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
	@Test
	public void testSetDNI() {
		c.setDNI("79185279M");
		assertEquals("79185279M", c.getDNI());
	}
	@Test
	public void testSetNombre() {
		c.setNombre("Mikel");
		assertEquals("Mikel", c.getNombre());
	}
	@Test
	public void testSetApellido() {
		c.setApellido("Gonzalez");
		assertEquals("Gonzalez", c.getApellido());
	}
	@Test
	public void testSetEmail() {
		c.setEmail("mikel@gmail.com");
		assertEquals("mikel@gmail.com", c.getEmail());
	}
	@Test
	public void testSetContrasenya() {
		c.setContrasenya("1234");
		assertEquals("1234", c.getContrasenya());
	}
	@Test
	public void testSetEsAdmin() {
		c.setEsAdmin(true);
		assertEquals(true, c.isEsAdmin());
	}
	
	

}
