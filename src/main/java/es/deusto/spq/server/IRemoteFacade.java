package es.deusto.spq.server;

import javax.ws.rs.core.Response;

import es.deusto.spq.client.Cliente;

public interface IRemoteFacade {
	public Response iniciarSesion(Cliente cliente);
	public Response registrarCliente(Cliente cliente);
	public Cliente encontrarCliente(String email);
	public Response editarUsuario(Cliente user);
}
