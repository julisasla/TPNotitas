package Controller;

import spark.Response;
import spark.Route;
import spark.Spark;

import com.fasterxml.jackson.core.JsonParser;

import Domain.Estudiante;
import JSON.Parser;
import Repo.RepoEstudiante;
import Security.SecurityService;
import spark.Request;

public class EstudianteController {
	
	private static String idSession = "Estudiante";
	
	private static Estudiante obtenerEstudianteSiExiste(Long id) {
		Estudiante alumno = RepoEstudiante.getInstance().obtenerEstudiante(id);
		
		if (alumno == null) {
			Spark.halt(401, "No es un alumno valido");
		}
		
		return alumno;		
	}
	
	private static long sesionEstudiante(Request req) {
		return req.session().attribute(idSession); //Aca pedias la session Estudiante
	}

	public static String getAsignaciones(Request req, Response res) {
		
		Estudiante estudiante = obtenerEstudianteSiExiste(sesionEstudiante(req));		
		return Parser.serializar(estudiante.getAsignaciones());
	}
	
	public static String getEstudiante(Request req, Response res) {
		
		Estudiante estudiante = obtenerEstudianteSiExiste(sesionEstudiante(req));		
		return Parser.serializar(estudiante);
	}
	
	public static String modificarEstudiante(Request req, Response res) {
		Estudiante estudianteActual = obtenerEstudianteSiExiste(sesionEstudiante(req));		
		Estudiante estudianteNuevo = Parser.deserializarEstudiante(req.body());
		
		estudianteActual.modificarEstudiante(estudianteNuevo);
		return "ok";
	}

}
