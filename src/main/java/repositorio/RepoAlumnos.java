package repositorio;

import javax.persistence.NoResultException;

import Domain.Estudiante;

public class RepoAlumnos extends RepoEnDB<Estudiante> {
	private static RepoAlumnos instancia;	

	public RepoAlumnos(String tabla, Class<Estudiante> entidad) {
		super(tabla);
		this.tabla = tabla;
	}
  
	public static RepoAlumnos getInstance() {
		if (instancia == null) {
			instancia = new RepoAlumnos("Alumno", Estudiante.class);
		}
		return instancia;
	}
	
	public Estudiante obtenerXtoken(String token) {
		try {
			return (Estudiante) em.createQuery("FROM Alumno a WHERE a.secretCode = :token", Estudiante.class).setParameter("token", token).getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}