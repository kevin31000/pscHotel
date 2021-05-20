package es.deusto.spq.client;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Clase que hace de conexion entre el ServiceLocator y las GUI.
 * 
 * @author Sergio
 *
 */
public class Controller {

	public ServiceLocator serviceLocator;

	/**
	 * Es el constructor de la clase Controller.
	 * 
	 * @param serviceLocator El ServiceLocator con el que se conectará
	 */
	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	/**
	 * Método para iniciar sesión con un email y una contraseña. Llama al método con
	 * el mismo nombre del ServiceLocator
	 * 
	 * @param email       Email con el que el usuario va a iniciar sesión.
	 * @param contrasenya Contraseña con la que el usuario va a iniciar sesión.
	 * @return Un int que es 0 en caso de que haya habido error o el usuario sea
	 *         incorrecto, 1 en caso de que no sea un gestor y 2 en caso de que lo
	 *         sea
	 */
	public int iniciarSesion(String email, String contrasenya) {
		return serviceLocator.iniciarSesion(email, contrasenya);
	}

	/**
	 * Método para encontrar un usuario por email
	 * 
	 */
	public Cliente getUsuario(String email) {
		return serviceLocator.getUsuario(email);
	}

	public Reserva getReserva(String codigoReserva) {
		return serviceLocator.getReserva(codigoReserva);
	}

	/**
	 * Método para registrar un usuario nuevo
	 * 
	 * @param DNI         DNI del usuario a registrar
	 * @param nombre      Nombre del usuario a registrar
	 * @param apellido    Apellido del usuario a registrar
	 * @param email       Email del usuario a registrar
	 * @param contrasenya Contraseña del usuario a registrar
	 * @param esAdmin     Booleano de si es admin o no
	 * @return Devuelve un booleano el cual es true si no ha habido ningún error.
	 */
	public boolean anadirCliente(String DNI, String nombre, String apellido, String email, String contrasenya,
			boolean esAdmin) {
		return serviceLocator.anadirCliente(DNI, nombre, apellido, email, contrasenya, esAdmin);
	}

	/**
	 * Método para registrar una nueva reserva
	 * 
	 * @param codigoReserva    codigo de la reserva a registrar
	 * @param codigoHabitacion codigo de la habitacion que sera reservada
	 * @param emailUsuario     email del usuario que reserva
	 * @param dia              dia de la reserva
	 * @param mes              mes de la reserva
	 * @param anyo             anyo de la reserva
	 * @return Devuelve un booleano el cual es true si no ha habido ningún error.
	 */
	public boolean anadirReserva(String codigoReserva, String codigoHabitacion, String emailUsuario, int dia, int mes,
			int anyo) {
		return serviceLocator.anadirReserva(codigoReserva, codigoHabitacion, emailUsuario, dia, mes, anyo);
	}

	/**
	 * Método para obtener la habitaciones del hotel
	 * 
	 * @param codigo Código de la habitación
	 * @return Devuelve la habitación seleccionada
	 */
	public Habitacion getHabitacion(String codigo) {
		return serviceLocator.obtenerHabitacion(codigo);
	}

	/**
	 * Método para encontrar un usuario por email
	 * 
	 */
	public List<Habitacion> obtenerHabitaciones() {
		return serviceLocator.obtenerHabitaciones();
	}

	public List<Cliente> obtenerClientes() {
		return serviceLocator.obtenerClientes();
	}

	public List<Reserva> obtenerReservas() {
		return serviceLocator.obtenerReservas();
	}

	public boolean editarUsuario(Cliente user) {
		if (serviceLocator.editarUsuario(user).getStatus() == Status.OK.getStatusCode()) {
			return true;
		}
		return false;
	}

	public Response borrarCliente(Cliente cliente) {
		return serviceLocator.borrarCliente(cliente);
	}

	public Response borrarReserva(Reserva reserva) {
		return serviceLocator.borrarReserva(reserva);
	}

	public boolean anadirEvento(String codigo, String nombre, String descripcion, int dia, int mes, int anyo,
			String hora, int numMaxPersonas) {
		return serviceLocator.anadirEvento(codigo, nombre, descripcion, dia, mes, anyo, hora, numMaxPersonas);
	}

	public Response borrarEvento(Evento evento) {
		return serviceLocator.borrarEvento(evento);
	}

	public Evento getEvento(String codigo) {
		return serviceLocator.obtenerEvento(codigo);
	}

	public List<Evento> getEventos() {
		return serviceLocator.obtenerEventos();
	}

	public boolean anadirReservaEvento(String codigoReservaEvento, String codigoEvento, String emailUsuario,
	int dia, int mes, int anyo) {
		return serviceLocator.anadirReservaEvento(codigoReservaEvento, codigoEvento, emailUsuario, dia, mes, anyo);
	}

	public ReservaEvento getReservaEvento(String codigo) {
		return serviceLocator.obtenerReservaEvento(codigo);
	}

	public List<ReservaEvento> getReservasEvento() {
		return serviceLocator.obtenerReservasEvento();
	}

}
