package Domain;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Observable
public class Estudiante {
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	
	@JsonProperty("assignments")
	private List<Tarea> tareas;
	
	
	public Estudiante() {
		
	}
	public Estudiante(String code, String first_name, String last_name, String github_user) {
		this.code = code;
		this.first_name = first_name;
		this.last_name = last_name;
		this.github_user = github_user;
	}
	
	public void asignarTarea(Tarea tarea) {
		if(tarea != null) {
			tareas.add(tarea);
		}

	}
	public void editarDatos(String newCode, String newFirstName, String newLastName, String newGitUser) {
		this.setCode(newCode);
		this.setFirst_name(newFirstName);
		this.setLast_name(newLastName);
		this.setGithub_user(newGitUser);
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
    @Override
	public String toString() {
	    return new StringBuffer(" Legajo : ").append(this.code)
	            .append(" Nombre : ").append(this.first_name)
	            .append(" Apellido : ").append(this.last_name).append(" Usuario Git : ")
	            .append(this.github_user).toString();
	}

}
