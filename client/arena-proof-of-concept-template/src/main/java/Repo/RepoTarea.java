package Repo;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import Domain.Tarea;

@Observable
public class RepoTarea {
	
	public static RepoTarea instancia;
	public List<Tarea> assignments = new ArrayList<Tarea>() {};
	
	public static RepoTarea getInstance() { // SINGLETON
		if(instancia == null) {
			instancia = new RepoTarea();
		}
		return instancia;
	}
	public void agregarTarea(Tarea tarea){
		assignments.add(tarea);
	}
	public List<Tarea> getTareas() {
		return assignments;
	}
	public void setTareas(List<Tarea> tareas) {
		this.assignments = tareas;
	}
}
