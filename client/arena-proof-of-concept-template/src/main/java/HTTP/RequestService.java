package HTTP;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.util.List;

import javax.ws.rs.core.MediaType;


public class RequestService {
    private Client client;
    private final String API = "localhost:9000";
    private String token;
    private static RequestService instancia;
    
    public void setToken(String token) {
	  this.token = token;  
	 }
    public static RequestService getInstance(){
	    if(instancia == null) {
	     instancia = new RequestService ();
	    }
	    return instancia;
	   }  
	    public String getToken() {
	  return token;
	 }
    //Inicializacion del cliente.
    public RequestService() {
        this.client = Client.create();
        //En la documentacion se puede ver como al cliente agregarle un ClientConfig
        //para agregarle filtros en las respuestas (por ejemplo, para loguear).
    }

    //Prueba de concepto de un parametro y los mensajes por separado para identificar los tipos de datos.
    public ClientResponse getInfo(String token, String Resource){
        WebResource recurso = this.client.resource(API).path(Resource);     
        WebResource.Builder builder = recurso.header("Authorization", "Bearer " + token).accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        return response;
    }
    public void actualizarEstudiante(String token, String estudianteSerializado) {
	    client.resource(API).path("student").header("Authorization", "Bearer " + token).accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, estudianteSerializado);
	}
	
}