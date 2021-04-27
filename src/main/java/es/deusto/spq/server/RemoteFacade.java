package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Habitacion;
import es.deusto.spq.client.Reserva;

@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class RemoteFacade implements IRemoteFacade{

	private DBManager dbmanager = null;
	private Logger logger = Logger.getLogger(RemoteFacade.class.getName());

	public RemoteFacade() {
		this.dbmanager = DBManager.getInstance();
	}

	private static final long serialVersionUID = 1L;
	private static RemoteFacade instance;
	
	@POST
	@Path("/inicioSesion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response iniciarSesion(Cliente cliente) {
		Cliente user = dbmanager.getUsuario(cliente.getEmail());
		if(user!= null && user.getContrasenya().equals(cliente.getContrasenya())) {
			if(user.isEsAdmin()) {
				return Response.status(Response.Status.OK).build();
			}else {
				return Response.status(Response.Status.ACCEPTED).build();
			}	
		}return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	@POST
	@Path("/registro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarCliente(Cliente cliente) {
		Cliente c = dbmanager.getUsuario(cliente.getEmail());
		if(c== null) {
			dbmanager.store(cliente);
			return Response.status(Response.Status.OK).build();
		}return Response.status(Response.Status.BAD_REQUEST).build();
	}

	@GET
	@Path("/getUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Cliente encontrarCliente(@QueryParam("email") String email) {
		Cliente c = dbmanager.getUsuario(email);
		
		return c;
	}
	
	@GET
	@Path("/getUsuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Cliente> encontrarClientes() {
		List<Cliente> clientes = dbmanager.getClientes();
		 
		return clientes;
	}

	@GET
	@Path("/obtenerHabitacion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Habitacion encontrarHabitacion(@QueryParam("codigo") String codigo) {
		Habitacion h = dbmanager.getHabitacion(codigo);

		return h;
	}
	
	@GET
	@Path("/obtenerHabitaciones")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Habitacion> encontrarHabitaciones() {
		List<Habitacion> h = dbmanager.getHabitaciones();
	
		return h;
	}
	
	@GET
	@Path("/getReservas")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Reserva> encontrarReservas() {
		List<Reserva> r = dbmanager.getReservas();
		
		return r;
	}


	@POST
	@Path("/editarUsuario")
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response editarUsuario(Cliente user) {
			//dbmanager.actualizarDatosCliente(user.getDNI(), user.getNombre(), user.getApellido(), user.getContrasenya(), user.getEmail());
			dbmanager.update(user);
			return Response.status(Response.Status.OK).build();
		
	}

	public static RemoteFacade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFacade();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		
		return instance;
	}

	
	


}
