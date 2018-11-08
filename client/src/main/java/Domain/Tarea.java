package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.model.annotations.Observable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Observable
public class Tarea {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("grades")
	private List<Nota> grades;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List getGrades() {
		return grades;
	}
	public void setGrades(List grades) {
		this.grades = grades;
	}
	/*public String getAprobo() {
		if(grades.get(grades.size()-1).estaAprobado()) {
			return "Si";
		}else {
			return "No";
		}
	}
	public String getTipoNota(){
		return grades.get(grades.size()-1).getTipoNota();
	}
	public String getCalificacion(){
		return grades.get(grades.size()-1).getCalificacion();
	}*/
}
