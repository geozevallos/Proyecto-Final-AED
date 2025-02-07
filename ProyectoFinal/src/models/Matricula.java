package models;

public class Matricula {
	private static int numMatriculaCorrelativo = 100000;
	private int numMatricula;
	private int codAlumno;
	private int codCurso;
	private String fecha;
	private String hora;
	
	public Matricula(int codAlumno, int codCurso) {
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		numMatriculaCorrelativo += 1;
		this.numMatricula = numMatriculaCorrelativo;
	}

	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
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
