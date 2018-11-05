package Domain;

public class NotaConceptual extends tipoNota {
	
	public boolean estaAprobado(String calificacion) {
		return calificacion != "M";
	}

	public String tipoNota() {
		// TODO Auto-generated method stub
		return "Conceptual";
	}
}
