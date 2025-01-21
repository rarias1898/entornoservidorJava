package com.ceu.ej15.repository;

import java.util.List;

import com.ceu.ej15.model.Curso;

public interface CursoRepository {

	void save(Curso c1);

	List<Curso> getCursos();

	Curso getCursoById(Integer id);

	List<Curso> getCursoByWord(String string);

}
