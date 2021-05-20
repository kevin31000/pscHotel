package es.deusto.spq.client;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Evento {
	@PrimaryKey
	private String codigo;
	private String nombre;
	private String descripcion;
	private int dia;
    private int mes;
    private int anyo;
    private String hora;
	private int numMaxPersonas;
	
	public Evento(Evento e) {
		super();
		this.codigo = e.codigo;
		this.nombre = e.nombre;
		this.descripcion = e.descripcion;
		this.dia = e.dia;
		this.mes = e.mes;
		this.anyo = e.anyo;
		this.hora = e.hora;
		this.numMaxPersonas = e.numMaxPersonas;
	}

	public Evento(String codigo, String nombre, String descripcion, int dia, int mes, int anyo, String hora,
			int numMaxPersonas) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
		this.hora = hora;
		this.numMaxPersonas = numMaxPersonas;
	}
	
	public Evento() {
		super();
		this.codigo = "";
		this.nombre = "";
		this.descripcion = "";
		this.dia = 0;
		this.mes = 0;
		this.anyo = 0;
		this.hora = "";
		this.numMaxPersonas = 0;
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getNumMaxPersonas() {
		return numMaxPersonas;
	}

	public void setNumMaxPersonas(int numMaxPersonas) {
		this.numMaxPersonas = numMaxPersonas;
	}

	@Override
	public String toString() {
		return "Evento " + codigo + " " + nombre + "." + dia + "/" + mes + "/" + anyo + ", " + hora +", " +numMaxPersonas;
	}
	
	

}
