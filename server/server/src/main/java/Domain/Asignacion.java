package Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import Domain.Tarea;

@Entity
@JsonPropertyOrder({ "title", "description", "grades" })
public class Asignacion {

	@Id @GeneratedValue
	@JsonIgnore
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL) //no se si está bien modeado esto pero bueno... ahi ta
	@JsonIgnore
	private Tarea tarea;
	
	public Asignacion() {
		super();
	}

	@ElementCollection
	@JsonProperty("grades")
	private List<String> notas;	
	
	@JsonProperty("title")
	String nombre;
	
	@JsonProperty("description")
	public String getDescripcion() {
		return tarea.getDescripcion();
	}
	
	public Asignacion(Tarea tarea) {
		this.tarea = tarea;
		this.notas = new ArrayList<>();
	}
	
	public List<String> getNotas() {
		return notas;
	}

	public void setNotas(List<String> notas) {
		this.notas = notas;
	}
	public Asignacion(String nombre, Tarea tarea) {
		this.nombre = nombre;
		this.tarea = tarea;
		this.notas = new ArrayList<>();
	}
}
