package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;


public class ControllerTest {
	
	ServiceLocator servicelocator = new ServiceLocator();;
	Controller controller = new Controller(servicelocator);
	Habitacion habitacion;
	private static Cliente c = new Cliente("123", "nombre", "apellido", "email", "contrasenya", true);
	
	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Test
    public void iniciarSesionTest(){	
		assertEquals(controller.iniciarSesion("test@test.es", "test"), 1);
	}
	
	@Test
    public void registrarUsuarioTest(){	
		String DNI_usuario = c.getDNI();
		String nombre_usuario = c.getNombre();
		String apellido_usuario = c.getApellido();
		String email_usuario = c.getEmail();
		String contrasenya_usuario = c.getContrasenya();
		controller.anadirCliente(DNI_usuario, nombre_usuario, apellido_usuario, email_usuario, contrasenya_usuario, false);
		
	}
	
//	@Test
//    public void getHabitacionTest(){	
//		assertEquals(controller.getHabitacion("H1").getCodigo(), "H1");
//	}
	
	@Test
	public void obtenerHabitacionesTest() {
		List<Habitacion> habitaciones = controller.obtenerHabitaciones();
		for (Habitacion habitacion : habitaciones) {
			Assert.assertNotNull(habitacion);
			
		}
	}
	
	
	@Test
	public void obtenerClientesTest() {
		List<Cliente> clientes = controller.obtenerClientes();
		for (Cliente cliente : clientes) {
			Assert.assertNotNull(cliente);
			
		}
	}
	
	@Test
	public void obtenerReservasTest() {
		List<Reserva> reservas = controller.obtenerReservas();
		for (Reserva reserva : reservas) {
			Assert.assertNotNull(reserva);
			
		}
	}
	
	
	

}