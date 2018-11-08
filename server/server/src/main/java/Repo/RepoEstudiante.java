package Repo;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import Domain.Estudiante;

public class RepoEstudiante implements TransactionalOps,  WithGlobalEntityManager {
 private static RepoEstudiante instancia; 
 protected EntityManager em = entityManager();
 
  
	 public static RepoEstudiante getInstance() {
		if (instancia == null) {
		    instancia = new RepoEstudiante();
		}
		return instancia;
	}
	 
	public Estudiante obtenerEstudiante(long id) {
		return em.find(Estudiante.class, id);
	}
}