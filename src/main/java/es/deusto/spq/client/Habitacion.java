package es.deusto.spq.client;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Habitacion {
	@PrimaryKey
	private String codigo;
	private int numCamas;
	private double precio;
	private boolean ocupada;
	
	public Habitacion(String codigo, int numCamas, double precio, boolean ocupada) {
		super();
		this.codigo = codigo;
		this.numCamas = numCamas;
		this.precio = precio;
		this.ocupada = ocupada;
	}
	
	public Habitacion() {
		super();
		this.codigo = "";
		this.numCamas = 0;
		this.precio = 0;
		this.ocupada = false;
	}
	
	public Habitacion(Habitacion h) {
		super();
		this.codigo = h.codigo;
		this.numCamas = h.numCamas;
		this.precio = h.precio;
		this.ocupada = h.ocupada;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	@Override
	public String toString() {
		return "Habitacion [codigo=" + codigo + ", numCamas=" + numCamas + ", precio=" + precio + ", ocupada=" + ocupada
				+ "]";
	}
	
}
