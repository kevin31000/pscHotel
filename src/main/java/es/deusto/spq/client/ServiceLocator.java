package es.deusto.spq.client;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

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

	public int iniciarSesion(String email, String contrasenya) {
		WebTarget webTarget1 = webTarget.path("server/inicioSesion");
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		Cliente c = new Cliente();
		c.setEmail(email);
		c.setContrasenya(contrasenya);

		Response response = invocationBuilder.post(Entity.entity(c, MediaType.APPLICATION_JSON));
		if (response.getStatus() == Status.OK.getStatusCode()) {
			return 1;

		} else if (response.getStatus() == Status.ACCEPTED.getStatusCode()) {
			return 2;
		}
		return 0;
	}

	public ArrayList<Habitacion> obtenerHabitaciones() {
		WebTarget webTarget2 = webTarget.path("server/obtenerHabitaciones");
		Invocation.Builder invocationBuilder = webTarget2.request(MediaType.APPLICATION_JSON);

		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		for (int i = 1; i < 51; i++) {
			Habitacion h = new Habitacion();
			h.setCodigo("h" + Integer.toString(i));
			
			Response response = invocationBuilder.post(Entity.entity(h, MediaType.APPLICATION_JSON));
			try {
				if (response.getEntity() != null) {
					h = (Habitacion) response.getEntity();
					habitaciones.add(h);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return habitaciones;
	}

	public ArrayList<Reserva> obtenerReservas() {
		WebTarget webTarget3 = webTarget.path("server/obtenerReservas");
		Invocation.Builder invocationBuilder = webTarget3.request(MediaType.APPLICATION_JSON);

		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		for (int i = 1; i < 51; i++) {
			Reserva r = new Reserva();
			r.setCodigoReserva("r" + Integer.toString(i));
			
			Response response = invocationBuilder.post(Entity.entity(r, MediaType.APPLICATION_JSON));
			try {
				if (response.getEntity() != null) {
					r = (Reserva) response.getEntity();
					reservas.add(r);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return reservas;
	}

    public Habitacion obtenerHabitacion(String codigo) {
        WebTarget webTarget4 = webTarget.path("server/obtenerHabitacion");
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		Habitacion h = new Habitacion();
		h.setCodigo(codigo);

		Response response = invocationBuilder.post(Entity.entity(h, MediaType.APPLICATION_JSON));
		h = (Habitacion) response.getEntity();

		return h;
    }
}
