package es.deusto.spq.client;


public class Controller {
	
	public ServiceLocator serviceLocator;
	
	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public int iniciarSesion(String email, String contrasenya){
		return serviceLocator.iniciarSesion(email, contrasenya);
	}
	
	public boolean anadirCliente(String DNI, String nombre, String apellido, String email, String contrasenya, boolean esAdmin){
		return serviceLocator.anadirCliente(email, nombre, apellido, email, contrasenya, esAdmin);
	}

    public Habitacion getHabitacion(String codigo) {
        return serviceLocator.obtenerHabitacion(codigo);
    }

}
