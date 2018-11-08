package Domain;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Nota {
	
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
