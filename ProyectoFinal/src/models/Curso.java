package models;

public class Curso implements Comparable<Curso>{
	//private static int codCursoCorrelativo = 1000;
	private int codCurso;
	private String asignatura;
	private int ciclo;
	private int creditos;
	private int horas;
	
	
	public Curso(int codCurso,String asignatura, int ciclo,int creditos, int horas) {
		this.setAsignatura(asignatura);
		this.setCiclo(ciclo);
		this.setCreditos(creditos);
		this.setHoras(horas);
		
		//codCursoCorrelativo += 1;
		this.setCodCurso(codCurso);
	}
	
	@Override
	public int compareTo(Curso otroCurso) {
		return Integer.compare(codCurso, otroCurso.codCurso);
	}


	public String getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}


	public int getCodCurso() {
		return codCurso;
	}


	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}


	public int getCiclo() {
		return ciclo;
	}


	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}


	public int getCreditos() {
		return creditos;
	}


	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
	public String toString() {
		return String.valueOf(codCurso);
	}
	
}
