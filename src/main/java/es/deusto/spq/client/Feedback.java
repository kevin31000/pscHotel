package es.deusto.spq.client;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Feedback {
	
	public enum Recomendacion {
		si, no
	}

	private String email;
	
	private String valoracion;
	private Recomendacion recomendacion;
	
	public Feedback(String email, String valoracion, Recomendacion recomendacion) {
		super();
		this.email = email;
		this.valoracion = valoracion;
		this.recomendacion = recomendacion;
	}
	
	public Feedback() {
		super();
		this.email = "";
		this.valoracion = "";
		this.recomendacion = null;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	public Recomendacion getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(Recomendacion recomendacion) {
		this.recomendacion = recomendacion;
	}

	@Override
	public String toString() {
		return "Feedback [email=" + email + ", valoracion=" + valoracion + ", recomendacion=" + recomendacion + "]";
	}
	
	
	
	

}
