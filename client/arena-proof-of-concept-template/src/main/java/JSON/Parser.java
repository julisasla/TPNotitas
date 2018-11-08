package JSON;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

import Domain.Estudiante;
import Domain.Nota;
import Domain.Tarea;

public class Parser {
	
    public static <Type> Type deserialize(String json, TypeReference<Type> type){
		  Type deserialized = null;
		  try {
		   deserialized = new ObjectMapper().readValue(json, type);
		  } catch (JsonParseException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (JsonMappingException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  return deserialized;
		 }
    
	 public static Estudiante deserializarEstudiante(String json) {
		  return deserialize(json, new TypeReference<Estudiante>() {});
	 }
	 public static List<Tarea> deseralizarLista(String json){
		 return deserialize(json, new TypeReference<List<Tarea>>() {});
	 }
	 public static Tarea deseralizarTarea(String json){
		 return deserialize(json, new TypeReference<Tarea>() {});
	 }
	 public static Nota deserializarNota(String json) {
	   	  return deserialize(json, new TypeReference<Nota>() {});
 	 }

	 public static String serializarEstudiante(Estudiante estudiante) {
	  String jsonResult = "";
	  try {
	   jsonResult = new ObjectMapper().writeValueAsString(estudiante);
	  } catch (JsonProcessingException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  return jsonResult;
	 }
}
