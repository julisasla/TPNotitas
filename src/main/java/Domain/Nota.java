package Domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nota {

	@Id @GeneratedValue
	private Long id;
	
	private tipoNota tipoNota;
	private String calificacion;
	
	public String getTipoNota() {
		return tipoNota.tipoNota();
	}
	public Boolean estaAprobado() {
		return tipoNota.estaAprobado(calificacion);
	}
	public void setTipoNota(tipoNota tipoNota) {
		this.tipoNota = tipoNota;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public Nota(tipoNota tipoNota, String calificacion) {
		this.tipoNota = tipoNota;
		this.calificacion = calificacion;
	}
}
