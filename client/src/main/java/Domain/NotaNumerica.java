package Domain;

public class NotaNumerica implements tipoNota {
	
	
	public boolean estaAprobado(String calificacion) {
		return Integer.parseInt(calificacion) > 6;
	}
	public String tipoNota() {
		// TODO Auto-generated method stub
		return "Numerica";
	}
}
