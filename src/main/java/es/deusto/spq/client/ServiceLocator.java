package es.deusto.spq.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;


/**Clase para la conexión entre el Controller y el RemoteFacade del servidor
 * @author Sergio
 *
 */
public class ServiceLocator {

	private Client cliente;
	private WebTarget webTarget;
	private static Logger logger = Logger.getLogger(ServiceLocator.class.getName());

	public ServiceLocator() {
		cliente = ClientBuilder.newClient();
		webTarget = cliente.target(cogerUrl());
	}

	public static String cogerUrl() {
		GetProperties properties = new GetProperties();
		String url = "";

		try {
			url = properties.getURL();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return url;

	}
	
	/**Método para registrar usuario.
	 * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	 * @param DNI DNI del usuario a registrar 
	 * @param nombre Nombre del usuario a registrar 
	 * @param apellido Apellido del usuario a registrar 
	 * @param email Email del usuario a registrar 
	 * @param contrasenya Contraseña del usuario a registrar 
	 * @param esAdmin Booleano de si es admin o no 
	 * @return Devuelve un booleano el cual es true si no ha habido ningún error.
	 */
	public boolean anadirCliente(String DNI, String nombre, String apellido, String email, String contrasenya, boolean esAdmin) {
		WebTarget registerUserWebTarget = webTarget.path("server/registro");
		Cliente c = new Cliente();
		c.setDNI(DNI);
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setEmail(email);
		c.setContrasenya(contrasenya);
		c.setEsAdmin(false);
		
		Entity<Cliente> entity = Entity.entity(c, MediaType.APPLICATION_JSON);
		Response response = registerUserWebTarget.request().post(entity);
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: " + response.getStatus());
			return false;
		} else {
			logger.info("User correctly registered");
			return true;
		}
	}
	
	public Response borrarCliente(Cliente cliente) {
		WebTarget webTarget1 = webTarget.path("server/borrarUsuario");	
		Entity<Cliente> entity = Entity.entity(cliente, MediaType.APPLICATION_JSON);
		Response response = webTarget1.request().post(entity);
		return response;
	}

	/**Método para registrar una nueva reserva
	 * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	 * @param codigoReserva codigo de la reserva a registrar 
	 * @param codigoHabitacion codigo de la habitacion que sera reservada
	 * @param emailUsuario email del usuario que reserva
	 * @param dia dia de la reserva 
	 * @param mes mes de la reserva 
	 * @param anyo anyo de la reserva 
	 * @return Devuelve un booleano el cual es true si no ha habido ningún error.
	 */
	public boolean anadirReserva(String codigoReserva, String codigoHabitacion, String emailUsuario, int dia, int mes, int anyo) {
		WebTarget registerUserWebTarget = webTarget.path("server/registroReserva");
		Reserva r = new Reserva();
		r.setCodigoReserva(codigoReserva);
		r.setCodigoHabitacion(codigoHabitacion);
		r.setEmailUsuario(emailUsuario);
		r.setDia(dia);
		r.setMes(mes);
		r.setAnyo(anyo);
		
		Entity<Reserva> entity = Entity.entity(r, MediaType.APPLICATION_JSON);
		Response response = registerUserWebTarget.request().post(entity);
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: " + response.getStatus());
			return false;
		} else {
			logger.info("Reservation correctly registered");
			return true;
		}
	}

	/** Método para iniciar sesión.
	 * Llama al método con el mismo nombre del RemoteFacade a través de la URL establecida.
	 * @param email Email del usuario con el que iniciar sesión.
	 * @param contrasenya Contraseña del usuario con el que iniciar sesión.
	 * @returnUn Devuelve un int que es 0 en caso de que haya habido error o el usuario sea incorrecto, 1 en caso de que no sea un gestor y 2 en caso de que lo sea 
	 */
	public int iniciarSesion(String email, String contrasenya) {
		WebTarget webTarget1 = webTarget.path("server/inicioSesion");
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		Cliente c = new Cliente();
		c.setEmail(email);
		c.setContrasenya(contrasenya);

		Response response = invocationBuilder.post(Entity.entity(c, MediaType.APPLICATION_JSON));
		if (response.getStatus() == Status.OK.getStatusCode()) {
			return 2;

		} else if (response.getStatus() == Status.ACCEPTED.getStatusCode()) {
			return 1;
		}
		return 0;
	}

    public Habitacion obtenerHabitacion(String codigo) {
        WebTarget webTarget4 = webTarget.path("server/obtenerHabitacion").queryParam("codigo", codigo);
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		Habitacion h = new Habitacion();
		h.setCodigo(codigo);


		GenericType<Habitacion> genericType = new GenericType<Habitacion>() {};
		h = webTarget4.request(MediaType.APPLICATION_JSON).get(genericType);
		
		return h;
    }
    
	public List<Habitacion> obtenerHabitaciones() {
        WebTarget webTarget4 = webTarget.path("server/obtenerHabitaciones");
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		List<Habitacion> habitaciones = new ArrayList<Habitacion>();

		GenericType<List<Habitacion>> genericType = new GenericType<List<Habitacion>>() {};
		habitaciones = webTarget4.request(MediaType.APPLICATION_JSON).get(genericType);

		return habitaciones;
    }

	public Cliente getUsuario(String email) {
        WebTarget webTarget4 = webTarget.path("server/getUsuario").queryParam("email", email);
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		Cliente c = new Cliente();
		c.setEmail(email);

		GenericType<Cliente> genericType = new GenericType<Cliente>() {};
		c = webTarget4.request(MediaType.APPLICATION_JSON).get(genericType);

		return c;
    }

	public Reserva getReserva(String codigoReserva) {
        WebTarget webTarget4 = webTarget.path("server/getReserva").queryParam("codigoReserva", codigoReserva);
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		Reserva r = new Reserva();
		r.setCodigoReserva(codigoReserva);

		GenericType<Reserva> genericType = new GenericType<Reserva>() {};
		r = webTarget4.request(MediaType.APPLICATION_JSON).get(genericType);

		return r;
    }
	
	public List<Cliente> obtenerClientes() {
        WebTarget webTarget4 = webTarget.path("server/getUsuarios");
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		List<Cliente> clientes = new ArrayList<Cliente>();

		GenericType<List<Cliente>> genericType = new GenericType<List<Cliente>>() {};
		clientes = webTarget4.request(MediaType.APPLICATION_JSON).get(genericType);

		return clientes;
    }
	
	public List<Reserva> obtenerReservas() {
        WebTarget webTarget4 = webTarget.path("server/getReservas");
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		List<Reserva> reservas = new ArrayList<Reserva>();

		GenericType<List<Reserva>> genericType = new GenericType<List<Reserva>>() {};
		reservas = webTarget4.request(MediaType.APPLICATION_JSON).get(genericType);

		return reservas;
    }

	public Response editarUsuario(Cliente user) {
		WebTarget webTarget1 = webTarget.path("server/editarUsuario");	
		Entity<Cliente> entity = Entity.entity(user, MediaType.APPLICATION_JSON);
		Response response = webTarget1.request().post(entity);
		return response;
	}

}
