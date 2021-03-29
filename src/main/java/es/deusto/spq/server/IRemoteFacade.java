package es.deusto.spq.server;

import javax.ws.rs.core.Response;

import es.deusto.spq.client.Cliente;

public interface IRemoteFacade {
	public Response iniciarSesion(Cliente cliente);
}
