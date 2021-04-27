package es.deusto.spq.client;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**Clase para la creación de clientes
 * @author Sergio
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Cliente {
	
	@PrimaryKey
	private String DNI;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenya;
	private boolean esAdmin;
	
	/** Constructor del cliente 
	 * @param DNI Dni del cliente
	 * @param nombre Nombre del cliente
	 * @param apellido Apellido del cliente
	 * @param email Email del cliente
	 * @param contrasenya Contraseña del cliente
	 * @param esAdmin Booleano del si es admin o no 
	 */
	public Cliente(String DNI, String nombre, String apellido, String email, String contrasenya, boolean esAdmin) {
		super();
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenya = contrasenya;
		this.esAdmin = esAdmin;
	}
	
	public Cliente() {
		super();
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		this.DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	

	@Override
	public String toString() {
		return  email;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
