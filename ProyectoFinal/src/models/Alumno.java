package models;

import constants.Estado;

public class Alumno {
	private String nombres;
	private String apellidos;
	private String dni;
	private int edad;
	private	int	celular;
	private Estado estado;
	private static int codAlumnoCorrelativo = 202010000;
	private int codAlumno;
	
	//TODO: Enums para estado
	
	public Alumno(String nombres, String apellidos, String dni, int edad, int celular){
		this.setNombres(nombres);
		this.setApellidos(apellidos);
		this.dni = dni;
		this.setEdad(edad);
		this.setCelular(celular);
		this.estado = Estado.REGISTRADO;
		
		codAlumnoCorrelativo += 1;
		setCodAlumno(codAlumnoCorrelativo);
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}
	
	/*
	public void setDni(String dni) {
		this.dni = dni;
	}
	*/

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	
	@Override
	public String toString() {
		return String.valueOf(codAlumno);
	}
	
	
}