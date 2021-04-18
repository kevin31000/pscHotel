package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ControllerTest {
	
	ServiceLocator servicelocator;
	Controller controller;
	Habitacion habitacion;
	
	@Before
    public void setUp(){
		servicelocator = new ServiceLocator();
		controller = new Controller(servicelocator);
	}
	
	/*@Test
    public void iniciarSesionTest(){	
		assertEquals(controller.iniciarSesion("test@test.es", "test"), 1);
	}
	
	@Test
    public void registrarUsuarioTest(){	
		assertEquals(controller.anadirCliente("a", "a", "a", "a", "a", false), true);
	}
	
	@Test
    public void getHabitacionTest(){	
		assertEquals(controller.getHabitacion("H1").getCodigo(), "H1");
	}*/

}
