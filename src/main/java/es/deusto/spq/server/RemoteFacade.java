package es.deusto.spq.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import es.deusto.spq.client.Cliente;

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
			if(cliente.isEsAdmin()) {
				return Response.status(Response.Status.ACCEPTED).build();
			}else {
				return Response.status(Response.Status.OK).build();
			}	
		}return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	@POST
	@Path("/registro")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarCliente(Cliente cliente) {
		Cliente c = dbmanager.getUsuario(cliente.getEmail());
		if(c== null) {
			dbmanager.store(c);
			return Response.status(Response.Status.OK).build();
		}return Response.status(Response.Status.BAD_REQUEST).build();
	}

	

}
