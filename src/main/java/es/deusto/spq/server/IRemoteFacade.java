package es.deusto.spq.server;

import java.util.List;
import javax.ws.rs.core.Response;
import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Habitacion;
import es.deusto.spq.client.Reserva;

public interface IRemoteFacade {
	public Response iniciarSesion(Cliente cliente);
	public Response registrarCliente(Cliente cliente);
	public Cliente encontrarCliente(String email);
	public Reserva encontrarReserva(String codigoReserva);
	public List<Cliente> encontrarClientes();
	public Habitacion encontrarHabitacion(String codigo); 
	public List<Habitacion> encontrarHabitaciones();
	public Response editarUsuario(Cliente user);
	public List<Reserva> encontrarReservas();
	public Response borrarReserva(Reserva reserva);
	public Response registrarReserva(Reserva reserva);
}
