package es.deusto.spq.client;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/** Clase para la creacion de reservas
 * @author Sergio
 *
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Reserva {
    @PrimaryKey
    private String codigoReserva;
    private String codigoHabitacion;
    private String emailUsuario;
    private int dia;
    private int mes;
    private int anyo;

    /** Constructor de la clase reservas
     * @param codigoReserva
     * @param codigoHabitacion
     * @param emailUsuario
     * @param dia
     * @param mes
     * @param anyo
     */
    public Reserva(String codigoReserva, String codigoHabitacion, String emailUsuario,int dia, int mes, int anyo) {
		this.codigoReserva = codigoReserva;
		this.codigoHabitacion = codigoHabitacion;
		this.emailUsuario = emailUsuario;
		this.dia = dia;
		this.mes = mes;
        this.anyo = anyo;
	}

    public Reserva() {
		this.codigoReserva = "";
		this.codigoHabitacion = "";
		this.emailUsuario = "";
		this.dia = 0;
		this.mes = 0;
        this.anyo = 0;
	}

    public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

    public String getCodigoHabitacion() {
		return codigoHabitacion;
	}

	public void setCodigoHabitacion(String codigoHabitacion) {
		this.codigoHabitacion = codigoHabitacion;
	}
	
    public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

    public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

    public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
    }

	@Override
	public String toString() {
		return codigoReserva;
	}
}