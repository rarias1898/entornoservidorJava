package com.ceu.ej15.service;

import java.util.List;

import com.ceu.ej15.model.Curso;
import com.ceu.ej15.model.Estudiante;

public interface CursoService {

	void addCurso(Curso c1);

	List<Curso> getCursos();

	void addEstudianteToCurso(Integer id, Estudiante e1);

	Curso getCursoById(Integer id);

	List<Curso> getCursoByWord(String string);

	void deleteEstudianteFromCurso(Integer id, Estudiante e1);

}
