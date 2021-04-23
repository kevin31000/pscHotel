package es.deusto.spq.server;

import java.util.List;
import javax.ws.rs.core.Response;
import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Habitacion;

public interface IRemoteFacade {
	public Response iniciarSesion(Cliente cliente);
	public Response registrarCliente(Cliente cliente);
	public Cliente encontrarCliente(String email);
	public List<Cliente> encontrarClientes();
	public Habitacion encontrarHabitacion(String codigo); 
	public List<Habitacion> encontrarHabitaciones();
	public Response editarUsuario(Cliente user);
}
