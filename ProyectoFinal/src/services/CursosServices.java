package services;

import java.util.ArrayList;
import java.util.Collections;

import models.Curso;



public class CursosServices {
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public CursosServices() {
		Curso curso1 = new Curso(1000, "Computación", 1, 24, 4);
		Curso curso2 = new Curso(2001, "Matemática", 0, 24, 4);
		
		cursos.add(curso1);
		cursos.add(curso2);
	}
	
	public ArrayList<Curso> getCursos() {
		Collections.sort(cursos);
		return cursos;
	}
	
	public boolean addCurso(Curso nuevoCurso) {
		// 1: Success, 0: Error
		ArrayList<Integer> codigos = new ArrayList<Integer>();
		
		for (Curso curso : cursos) {
			codigos.add(curso.getCodCurso());
		}
		
		if(codigos.contains(nuevoCurso.getCodCurso())) {
			return false;
		} else {
			cursos.add(nuevoCurso);
			return true;
		}
	}
	
	public boolean deleteCurso(Curso cursoAEliminar) {
		// 1: Success, 0: Error
		//TODO: Implementar validación para eliminar
		// Un curso puede eliminarse sólo cuando ningún alumno esté matriculado en él
		cursos.remove(cursoAEliminar);
		return true;
	}
}
