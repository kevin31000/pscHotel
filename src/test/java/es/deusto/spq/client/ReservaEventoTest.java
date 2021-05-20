package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReservaEventoTest {
    private ReservaEvento re;

    @Before
	public void setUp() {
		re = new ReservaEvento("RE01", "E01", "test@test.es", 15, 12, 2030);
	}
	
	@Test
	public void getCodigoReservaEventoTest() {
		assertEquals("RE01", re.getCodigoReservaEvento());
	}

	@Test
	public void getCodigoEventoTest() {
		assertEquals("E01", re.getCodigoEvento());
	}

    @Test
	public void getEmailUsuarioTest() {
		assertEquals("test@test.es", re.getEmailUsuario());
	}

	@Test
	public void getDiaTest() {
		assertEquals(15, re.getDia());
	}

	@Test
	public void getMesTest() {
		assertEquals(12, re.getMes());
	}

	@Test
	public void getAnyoTest() {
		assertEquals(2030, re.getAnyo());
	}
}
