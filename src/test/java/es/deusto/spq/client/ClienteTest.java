package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.Cliente;

public class ClienteTest {
	
	private Cliente c = new Cliente("71234561D", "Sergio", "Lopez", "sergio@gmail.com", "123", false);;
	
	
	@Test
	public void getDNITest() {
		assertEquals("71234561D", c.getDNI());
	}
	@Test
	public void getNombreTest() {
		assertEquals("Sergio", c.getNombre());
	}
	@Test
	public void getApellidoTest() {
		assertEquals("Lopez", c.getApellido());
	}
	@Test
	public void getEmailTest() {
		assertEquals("sergio@gmail.com", c.getEmail());
	}
	@Test
	public void getContrasenyaTest() {
		assertEquals("123", c.getContrasenya());
	}
	@Test
	public void getEsAdminTest() {
		assertEquals(false, c.isEsAdmin());
	}

	
	

}
