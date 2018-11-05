package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tarea {
	
	@Id @GeneratedValue
	private Long id;
	
	private String title;
	
	private String description;
	
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