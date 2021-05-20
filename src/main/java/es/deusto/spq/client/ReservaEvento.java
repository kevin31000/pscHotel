package es.deusto.spq.client;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class ReservaEvento {
    @PrimaryKey
    private String codigoReservaEvento;
    private String codigoEvento;
    private String emailUsuario;
    private int dia;
    private int mes;
    private int anyo;

    /** Constructor de la clase reservaEvento
     * @param codigoReserva
     * @param codigoHabitacion
     * @param emailUsuario
     * @param dia
     * @param mes
     * @param anyo
     */
    public ReservaEvento(String codigoReserva, String codigoEvento, String emailUsuario,int dia, int mes, int anyo) {
		this.codigoReservaEvento = codigoReserva;
		this.codigoEvento = codigoEvento;
		this.emailUsuario = emailUsuario;
		this.dia = dia;
		this.mes = mes;
        this.anyo = anyo;
	}

    public ReservaEvento() {
		this.codigoReservaEvento = "";
		this.codigoEvento = "";
		this.emailUsuario = "";
		this.dia = 0;
		this.mes = 0;
        this.anyo = 0;
	}

    public String getCodigoReservaEvento() {
		return codigoReservaEvento;
	}

	public void setCodigoReservaEvento(String codigoReservaEvento) {
		this.codigoReservaEvento = codigoReservaEvento;
	}

    public String getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(String codigoEvento) {
		this.codigoEvento = codigoEvento;
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
		return codigoReservaEvento;
	}
}
