package es.deusto.spq.client;

import java.util.List;

/**Clase que hace de conexion entre el ServiceLocator y las GUI.
 * @author Sergio
 *
 */
public class Controller {
	
	public ServiceLocator serviceLocator;
	
	/**Es el constructor de la clase Controller. 
	 * @param serviceLocator El ServiceLocator con el que se conectará
	 */
	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	/**Método para iniciar sesión con un email y una contraseña.
	 * Llama al método con el mismo nombre del ServiceLocator
	 * @param email Email con el que el usuario va a iniciar sesión.
	 * @param contrasenya Contraseña con la que el usuario va a iniciar sesión.
	 * @return Un int que es 0 en caso de que haya habido error o el usuario sea incorrecto, 1 en caso de que no sea un gestor y 2 en caso de que lo sea
	 */
	public int iniciarSesion(String email, String contrasenya){
		return serviceLocator.iniciarSesion(email, contrasenya);
	}
	
	/**Método para encontrar un usuario por email
	 
	 */
	public Cliente getUsuario(String email){
		return serviceLocator.getUsuario(email);
	}
	
	public List<Cliente> getUsuarios(){
		return serviceLocator.getUsuarios();
	}
	
	/**Método para registrar un usuario nuevo
	 * @param DNI DNI del usuario a registrar 
	 * @param nombre Nombre del usuario a registrar 
	 * @param apellido Apellido del usuario a registrar 
	 * @param email Email del usuario a registrar 
	 * @param contrasenya Contraseña del usuario a registrar 
	 * @param esAdmin Booleano de si es admin o no 
	 * @return Devuelve un booleano el cual es true si no ha habido ningún error.
	 */
	public boolean anadirCliente(String DNI, String nombre, String apellido, String email, String contrasenya, boolean esAdmin){
		return serviceLocator.anadirCliente(DNI, nombre, apellido, email, contrasenya, esAdmin);
	}

    /**Método para obtener la habitaciones del hotel 
     * @param codigo Código de la habitación 
     * @return Devuelve la habitación seleccionada
     */
    public Habitacion getHabitacion(String codigo) {
        return serviceLocator.obtenerHabitacion(codigo);
    }
    
	/**Método para encontrar un usuario por email
	 
	 */
    public List<Habitacion> obtenerHabitaciones(){
    	return serviceLocator.obtenerHabitaciones();
    }
}
