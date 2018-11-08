package JSON;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import Domain.Estudiante;

import Domain.Tarea;
import Repo.RepoEstudiante;

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

	 public static String serializar(Object entidad) {
	  String jsonResult = "";
	  try {
	   jsonResult = new ObjectMapper().writeValueAsString(entidad);
	  } catch (JsonProcessingException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  return jsonResult;
	 }
}