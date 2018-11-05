package server.controller;

import spark.Response;
import spark.Spark;
import Domain.Estudiante;
import json.JSONParser;
import repositorio.RepoAlumnos;
import spark.Request;

public class EstudianteController {
	
	private static final JSONParser<Estudiante> parserEstudiantes = new JSONParser<Estudiante>();
	
	private static Estudiante obtenerEstudainteSiExiste(String token) {
		Estudiante estudiante = RepoAlumnos.getInstance().obtenerXtoken(token);
		
		if (estudiante == null) {
			Spark.halt(401, "Me mandaste cualquier cosaa, no te hagas el gil");
		}
		
		return estudiante;		
	}
	
	public static String getAlumno(Request req, Response res) {
		
		Estudiante estudiante = obtenerEstudainteSiExiste(req.headers("Authorization").replace("Bearer ", ""));		
		return parserEstudiantes.objectToJson(estudiante);
	}
	
	public static String modificarAlumno(Request req, Response res) {
		Estudiante estudianteActual = obtenerEstudainteSiExiste(req.headers("Authorization").replace("Bearer ", ""));		
		Estudiante estudianteNuevo = parserEstudiantes.jsonToObject("", Estudiante.class);
		
		estudianteActual.setFirst_name(estudianteNuevo.getFirst_name());
		estudianteActual.setLast_name(estudianteNuevo.getLast_name());
		estudianteActual.setGithub_user(estudianteNuevo.getGithub_user());
		
		return null;
	}
}
