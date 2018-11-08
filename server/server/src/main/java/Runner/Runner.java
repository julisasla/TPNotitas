package Runner;

import java.util.List;
import Domain.Estudiante;
import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class Runner {
	public static void main(String[] args) {
		//new Fixture().run();
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		List<Estudiante> Estudiantes = 
				entityManager
				.createQuery("from Estudiante")
				.getResultList();
		
		for (Estudiante Estudiante : Estudiantes) {
			System.out.println(Estudiante.getNombre());
		}
	}
}