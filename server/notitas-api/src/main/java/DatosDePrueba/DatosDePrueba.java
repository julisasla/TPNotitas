package DatosDePrueba;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;


import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import Domain.Estudiante;
import Domain.Asignacion;
import Domain.Tarea;
import Security.SecurityService;

public class DatosDePrueba implements TransactionalOps, WithGlobalEntityManager{
	public void init() {
		EntityManager em = entityManager();
		
		Estudiante Estudiante = new Estudiante ("159391-2", "Julian", "Saslavsky", "julisasla");
//		Asignacion dds = new Asignacion("DDS",new Tarea("Tp Arena", "Este es un TP importante"));	
//		dds.setNotas(Arrays.asList("4", "10"));
		withTransaction(() -> {
//			em.persist(dds);
			em.persist(Estudiante);
//			Estudiante.setAsignacion(dds);
			
			System.out.println(new SecurityService().generateTokenFor(Estudiante.getId()));
		});
	}
}

