package es.deusto.spq.client;

import es.deusto.spq.client.gui.VentanaInicioSesion;

/** La clase principal. 
 * Lanza la clase de VentanaInicioSesion y crea el serviceLocator y el controller.
 * @author Sergio
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		ServiceLocator servicelocator = new ServiceLocator();
		
		Controller controller = new Controller(servicelocator);

		VentanaInicioSesion inicio = new VentanaInicioSesion(controller);

		inicio.setVisible(true);

	}
	
	

}
