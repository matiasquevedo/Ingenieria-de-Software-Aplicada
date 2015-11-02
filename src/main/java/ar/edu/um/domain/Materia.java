package ar.edu.um.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "materias", catalog = "creditos")
public class Materia  implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	@Size(min=2, max=8)
	private String legajo;
	@NotNull
	@Size(min=2, max=100)
	private String nombre;
	
	@ManyToOne()
	@JoinColumn(name = "carreras_id")
	private Carrera carrera;
	
	@NotNull
	private Integer creditos;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditos == null) ? 0 : creditos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((legajo == null) ? 0 : legajo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		if (creditos == null) {
			if (other.creditos != null)
				return false;
		} else if (!creditos.equals(other.creditos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (legajo == null) {
			if (other.legajo != null)
				return false;
		} else if (!legajo.equals(other.legajo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Materia [id=" + id + ", legajo=" + legajo + ", nombre=" + nombre + ", creditos=" + creditos + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCreditos() {
		return creditos;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	

}
