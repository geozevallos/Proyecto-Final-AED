package services;

import java.util.ArrayList;
//import java.util.List;

import models.Alumno; 

public class AlumnoServices {
	
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	
	public AlumnoServices() {
		
		Alumno alumno1 = new Alumno("Jorge Ernesto", "Zevallos Rivera", "47854589", 30, 985458957);
		Alumno alumno2 = new Alumno("José Armando", "Collantes Diaz", "42254589", 23, 985799999);
		
		alumnos.add(alumno1);
		alumnos.add(alumno2);
	}
	
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	
	public boolean addAlumno(Alumno nuevoAlumno) {
		// 1: Success, 0: Error
		ArrayList<String> dnis = new ArrayList<String>();
		
		for (Alumno alumno : alumnos) {
			dnis.add(alumno.getDni());
		}
		
		if(dnis.contains(nuevoAlumno.getDni())) {
			return false;
		} else {
			alumnos.add(nuevoAlumno);
			return true;
		}
	}
	
	
	public void deleteAlumno(int codigo) {
		Alumno alumnoAEliminar = getAlumnoByCodigo(codigo);
		
		if(alumnoAEliminar == null) {
			System.out.println("EL ALUMNO NO EXISTE");
			return;
		}
		
		if(alumnoAEliminar.getEstado().getCodigo() != 0) {
			System.out.println("EL ALUMNO NO PUEDE SER ELIMINADO");
			return;
		}
		
		alumnos.remove(alumnoAEliminar);
	}
	
	
	public Alumno getAlumnoByCodigo(int codigo) {
		for (Alumno alumno : alumnos) {
			int codAlumno = alumno.getCodAlumno();
			if(codAlumno == codigo) {
				return alumno;
			}
		}
		return null;
	}

}
