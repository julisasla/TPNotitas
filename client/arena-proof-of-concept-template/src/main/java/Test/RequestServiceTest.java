package Test;

import com.sun.jersey.api.client.ClientResponse;

import Domain.Estudiante;
import Domain.Tarea;
import HTTP.RequestService;
import JSON.Parser;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by niko118 on 5/1/16.
 */
public class RequestServiceTest {

    RequestService requester;

    @Before
    public void setUp() throws Exception {
        this.requester = new RequestService();
    }

    @Test
    public void respuestaAlumno() throws Exception {
        //Se solicita todos los datos de un libro por su isbn.
        ClientResponse response = this.requester.getInfo("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho", "student");
        assertEquals(response.getStatus(), 200);
        String json = response.getEntity(String.class);
        Estudiante estudiante = Parser.deserializarEstudiante(json);
        assertEquals("111222333", estudiante.getCode());
    }
    @Test
    public void respuestaNotas() throws Exception {
        ClientResponse response2 = requester.getInfo("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho", "student/assignments");
        String json2 = response2.getEntity(String.class);
        Estudiante asignaciones = Parser.deserializarEstudiante(json2);
        List<Tarea> tareas = asignaciones.getTareas();
        assertEquals("TPA1", tareas.get(0).getTitle());
    }
}