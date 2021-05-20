package es.deusto.spq.server;

import java.util.List;

import javax.ws.rs.core.Response;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Evento;
import es.deusto.spq.client.Habitacion;
import es.deusto.spq.client.Reserva;
import es.deusto.spq.client.ReservaEvento;

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
	public Response registroEvento(Evento evento);
	public Response borrarEvento(Evento evento);
	public Evento encontrarEvento(String codigo);
	public List<Evento> encontrarEventos();
	public Response registrarReservaEvento(ReservaEvento e);
	public ReservaEvento encontrarReservaEvento(String codigo);
	public List<ReservaEvento> encontrarReservasEvento();
}
