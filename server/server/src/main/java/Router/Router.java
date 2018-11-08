package Router;

import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.before;
import static spark.Spark.staticFiles;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.auth0.jwt.JWT;

import Controller.EstudianteController;

import Security.InvalidTokenException;
import Security.SecurityService;

public class Router implements TransactionalOps, WithGlobalEntityManager {
	
	EntityManager em = entityManager();
	
	public void configure() {		
		SecurityService securityService = new SecurityService();
		
		Spark.before((req, res) -> {
			if (req.requestMethod() != "GET") {
				beginTransaction();
			}
			
			try {
				Long userId = securityService.user(req.headers("Authorization").replace("Bearer ", ""));
				req.session().attribute("Estudiante", userId); //aca estabas creando la session "IdEstudiante"
			} catch (InvalidTokenException e) {
				if (req.requestMethod() != "GET") {
					rollbackTransaction();
				}
				Spark.halt(401, "<h1>Hiciste algo mal en el request</a>");
			}
		});
		
		Spark.get("/", (req, res) -> "Hello world!");
		
		Spark.get("/student", EstudianteController::getEstudiante);
		
		Spark.patch("/student", EstudianteController::modificarEstudiante);
		
		Spark.get("/student/assignments", EstudianteController::getAsignaciones);
		
		Spark.after((req, res) -> {
			if(req.requestMethod() != "GET") {
				try {
					commitTransaction();
					em.clear();
				} catch (RollbackException e) {
					rollbackTransaction();
				}				
			}
		});
	}
}
