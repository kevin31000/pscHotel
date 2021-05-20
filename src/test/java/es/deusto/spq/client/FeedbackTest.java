package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.Feedback.Recomendacion;


/**
 * Test de la clase Feedback
 *
 * @author sergi
 *
 */
public class FeedbackTest {

	private Feedback f;

	/**
	 * Crea un nuevo feedback
	 */
	@Before
	public void setUp() {
		f = new Feedback("test@test.es","5", Recomendacion.si);
	}

	/**
	 * Comprueba que getEmail() funciona correctamente devolviendo el usuario del
	 * feedback
	 */
	@Test
	public void testEmail() {
		f.setEmail("test@test.es");
		assertEquals("test@test.es", f.getEmail());
	}

	/**
	 * Comprueba que getValoracion() funciona correctamente devolviendo la
	 * valoracion del feedback
	 */
	@Test
	public void testValoracion() {
		f.setValoracion("5");
		assertEquals("5", f.getValoracion());
	}

	/**
	 * Comprueba que getRecomendacion() funciona correctamente devolviendo el si o
	 * el no de la recomendacion
	 */
	@Test
	public void testRecomendacion() {
		f.setRecomendacion(Recomendacion.si);
		assertEquals(Recomendacion.si, f.getRecomendacion());
	}


	/**
	 * Comprueba el método toString() de la clase Feedback
	 */
	@Test
	public void metodoToString() {

		
		f.setEmail("test@test.es");
		f.setValoracion("5");
		f.setRecomendacion(Recomendacion.si);

		System.out.println(f.toString());

		assertEquals("Feedback [email=test@test.es, valoracion=5, recomendacion=si]", f.toString());
	}
}