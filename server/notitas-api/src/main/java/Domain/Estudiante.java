package Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import Domain.Tarea;
import Domain.Asignacion;

@Entity
@JsonPropertyOrder({ "code", "first_name", "last_name", "github_user" })
public class Estudiante {

	@Id @GeneratedValue
	@JsonIgnore
	private Long id;
	
	public Estudiante() {
		super();
	}

	@JsonProperty("code")
	private String legajo;
	
	@JsonProperty("first_name")
	private String nombre;
	
	@JsonProperty("last_name")
	private String apellido;
	
	@JsonProperty("github_user")
	private String githubUser;
	
	@OneToMany
	@JoinColumn(name = "estudiante_id")
	@JsonProperty(access = Access.READ_ONLY, value = "assignments")
	private List<Asignacion> asignaciones = new ArrayList<>();
	
	public Estudiante(String legajo, String nombre, String apellido, String githubUser) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.githubUser = githubUser;
		this.apellido = apellido;
	}
	
	public Long getId() {
		return id;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGithubUser() {
		return githubUser;
	}

	public void setGithubUser(String githubUser) {
		this.githubUser = githubUser;
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	
	public void setAsignacion(Asignacion asignacion) {
		this.asignaciones.add(asignacion);
	}
	
	public void agregarAsignacion(Asignacion asignacion) {
		asignaciones.add(asignacion);		
	}

	public void modificarEstudiante(Estudiante estudiante) {
		nombre = estudiante.getNombre();
		apellido = estudiante.getApellido();
		legajo = estudiante.getLegajo();
		githubUser = estudiante.getGithubUser();
	}
	


}