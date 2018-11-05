package Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import Domain.Tarea;

@Entity
public class Estudiante {

	@Id @GeneratedValue
	private Long id;
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	
	@OneToMany
	@JoinColumn(name = "alumno_id")
	private List<Tarea> tareas = new ArrayList<>();
	
	@SuppressWarnings("unused")
	private Estudiante() {}
	
	public Estudiante(String code, String first_name, String last_name, String github_user) {
		this.code = code;
		this.first_name = first_name;
		this.last_name = last_name;
		this.github_user = github_user;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> assignments) {
		this.tareas = assignments;
	}

	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGithub_user() {
		return github_user;
	}
	public void setGithub_user(String github_user) {
		this.github_user = github_user;
	}


}
