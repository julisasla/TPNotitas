package server.controller;

import spark.Response;
import spark.Spark;
import Domain.Estudiante;
import Domain.Tarea;
import json.JSONParser;
import repositorio.RepoAlumnos;
import spark.Request;

public class TareaController {

	private static final JSONParser<Tarea> parserTareas = new JSONParser<Tarea>();
	
	
	public static String getTareas(Request req, Response res) {
		
		return "a";
	}

}
