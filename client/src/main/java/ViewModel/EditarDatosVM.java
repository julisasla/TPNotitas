package ViewModel;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import Domain.Estudiante;
import Domain.Tarea;
import Repo.RepoEstudiante;

@Observable
public class EditarDatosVM {

	public String getNombre() {
		return RepoEstudiante.getInstance().dameUno().getFirst_name();
	}
	public void setNombre(String nombre) {
		RepoEstudiante.getInstance().dameUno().setFirst_name(nombre);
	}
	public String getApellido() {
		return RepoEstudiante.getInstance().dameUno().getLast_name();
	}
	public void setApellido(String apellido) {
		RepoEstudiante.getInstance().dameUno().setLast_name(apellido);
	}
	public String getLegajo() {
		return RepoEstudiante.getInstance().dameUno().getCode();
	}
	public void setLegajo(String legajo) {
		RepoEstudiante.getInstance().dameUno().setCode(legajo);
	}
	public String getUsuarioGit() {
		return RepoEstudiante.getInstance().dameUno().getGithub_user();
	}
	public void setUsuarioGit(String usuarioGit) {
		RepoEstudiante.getInstance().dameUno().setGithub_user(usuarioGit);
	}
	/*public List<Tarea> getTareas() {
		return RepoEstudiante.getInstance().dameUno().getTareas();
	}

	public void setTareas(List<Tarea> tareas) {
		RepoEstudiante.getInstance().dameUno().setTareas(tareas);
	}*/
}