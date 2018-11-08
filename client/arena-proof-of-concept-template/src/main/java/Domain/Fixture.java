package Domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

import HTTP.RequestService;
import JSON.Parser;
import Login.Loggeo;
import Repo.RepoEstudiante;

public class Fixture {
	public static void initialize() throws JsonParseException, JsonMappingException, IOException {
		//final ObjectMapper JSON_MAPPER = new ObjectMapper();
		Loggeo.getInstance().registrarToken(111222333, "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
		/*ArrayList <Nota> notas = new ArrayList<Nota>();
		notas.add(new Nota (new NotaNumerica(),"9"));

		ArrayList <Nota> notas2 = new ArrayList<Nota>();
		notas2.add(new Nota (new NotaConceptual(),"M"));
		
		RepoTarea.getInstance().agregarTarea(new Tarea("Fisica",tipoTarea.PARCIAL, notas));
		RepoTarea.getInstance().agregarTarea(new Tarea("AM2",tipoTarea.TP, notas2));
		
		RepoEstudiante.getInstance().agregarEstudiante(new Estudiante("guille","verdile","159391-2","guilleverdile", RepoTarea.getInstance().getTareas()));*/
		
		
		RequestService requester = new RequestService();;
        ClientResponse response = requester.getInfo("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho", "student");
        String json = response.getEntity(String.class);
        Estudiante estudianteSinTareas = Parser.deserializarEstudiante(json);
        
        ClientResponse response2 = requester.getInfo("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho", "student/assignments");
        String json2 = response2.getEntity(String.class);
        Estudiante estudianteConTareas = Parser.deserializarEstudiante(json2);
        
        /*ArrayList<Tarea> tareas = JSON_MAPPER.readValue(json2,
                JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Tarea.class));*/
        
        estudianteConTareas.setCode(estudianteSinTareas.getCode());
        estudianteConTareas.setFirst_name((estudianteSinTareas.getFirst_name()));
        estudianteConTareas.setLast_name(estudianteSinTareas.getLast_name());
        estudianteConTareas.setGithub_user(estudianteSinTareas.getGithub_user());
        RepoEstudiante.getInstance().agregarEstudiante(estudianteConTareas);
	}
}
