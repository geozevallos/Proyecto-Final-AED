package models;

public class Retiro {
	private int numRetiro;
	private int numMatricula;
	private String fecha;
	private String hora;
	private static int numRetiroCorrelativo = 200000;
	
	// TODO: Validar como se crea fecha y hora
	public Retiro(int numMatricula) {
		this.numMatricula = numMatricula;
		
		numRetiroCorrelativo += 1;
		setNumRetiro(numRetiroCorrelativo);
	}

	public int getNumRetiro() {
		return numRetiro;
	}

	public void setNumRetiro(int numRetiro) {
		this.numRetiro = numRetiro;
	}

	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
