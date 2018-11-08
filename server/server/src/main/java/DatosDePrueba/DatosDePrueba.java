package DatosDePrueba;

import java.util.Arrays;

import javax.persistence.EntityManager;


import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import Domain.Estudiante;
import Domain.Asignacion;
import Domain.Tarea;
import Security.SecurityService;

public class DatosDePrueba implements TransactionalOps, WithGlobalEntityManager{
	public void cargarDatos() {
		EntityManager em = entityManager();
		
		Estudiante Estudiante = new Estudiante ("159391-2", "Julian", "Saslavsky", "julisasla");
		Asignacion am2 = new Asignacion("am2",new Tarea("Primer parcial", "Este es un primer parcial"));	
		am2.setNotas(Arrays.asList("5", "8"));
		withTransaction(() -> {
			em.persist(am2);
			Estudiante.setAsignacion(am2);
			em.persist(Estudiante);
			
			System.out.println(new SecurityService().generateTokenFor(Estudiante.getId()));
		});
	}
}

