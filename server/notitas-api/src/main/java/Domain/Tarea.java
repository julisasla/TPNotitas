package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Tarea {
	
	@JsonIgnore
	@Id @GeneratedValue
	private Long id;

	private String descripcion;
	
	private String nombre;

	public Tarea(String nombre, String descripcion) {
		this.descripcion = descripcion;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}