package Repo;

import java.util.ArrayList;
import java.util.List;

import Domain.Estudiante;

public class RepoEstudiante {
	public static RepoEstudiante instancia;
	public List<Estudiante> estudiantes = new ArrayList<Estudiante>() {};
	
	public static RepoEstudiante getInstance() { // SINGLETON
		if(instancia == null) {
			instancia = new RepoEstudiante();
		}
		return instancia;
	}
	
	public void agregarEstudiante(Estudiante estudiante){
		estudiantes.add(estudiante);
	}
	public Estudiante dameUno() {
		return estudiantes.get(0);
	}
}
