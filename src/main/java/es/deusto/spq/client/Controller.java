package es.deusto.spq.client;


public class Controller {
	
	public ServiceLocator serviceLocator;
	
	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public int iniciarSesion(String email, String contrasenya){
		return serviceLocator.iniciarSesion(email, contrasenya);
	}

    public Habitacion getHabitacion(String codigo) {
        return serviceLocator.obtenerHabitacion(codigo);
    }

}
