package ViewModel;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import Domain.Nota;
import Domain.Tarea;
import Domain.tipoNota;
import Domain.tipoTarea;
import Repo.RepoEstudiante;
import Repo.RepoTarea;

@Observable
public class MostrarTareasVM {
	
	public List<Tarea> getTareas() {
		return RepoEstudiante.getInstance().dameUno().getTareas();
	}
	@SuppressWarnings("unchecked")
	public ArrayList<String> getId() {
		return (ArrayList<String>) this.getTareas().stream().map(tarea->tarea.getId());
	}
	@SuppressWarnings("unchecked")
	public ArrayList<String> getTitle() {
		return (ArrayList<String>) this.getTareas().stream().map(tarea->tarea.getTitle());
	}
	@SuppressWarnings("unchecked")
	public ArrayList<tipoNota> getDescription() {
		return (ArrayList<tipoNota>) this.getTareas().stream().map(tarea->tarea.getDescription());
	}
	/*@SuppressWarnings("unchecked")
	public ArrayList<String> getCalificacion() {
		return (ArrayList<String>) this.getTareas().stream().map(tarea->tarea.getCalificacion());
	}
	
	public ArrayList<String> getAprobo() {
		return (ArrayList<String>) this.getTareas().stream().map(tarea->tarea.getAprobo());
	}*/
	
}
