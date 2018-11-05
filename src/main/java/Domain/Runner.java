package Domain;

import java.util.List;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class Runner {
	public static void main(String[] args) {
		//new Fixture().run();
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		List<Estudiante> estudiantes = 
				entityManager
				.createQuery("from Estudiante")
				.getResultList();
		
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante.getFirst_name());
		}
	}
}
