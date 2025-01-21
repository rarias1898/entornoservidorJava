package com.ceu.ej15.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej15.model.Curso;
import com.ceu.ej15.model.Estudiante;
import com.ceu.ej15.repository.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository repository;

	@Override
	@Transactional
	public void addCurso(Curso c1) {
		repository.save(c1);
		
	}

	@Override
	public List<Curso> getCursos() {
		return repository.getCursos();
	}

	@Override
	@Transactional
	public void addEstudianteToCurso(Integer id, Estudiante e1) {
		Curso curso = getCursoById(id);
		if (curso != null) {
			curso.getEstudiantes().add(e1);
			repository.save(curso);
		}
		
	}

	@Override
	public Curso getCursoById(Integer id) {
		return repository.getCursoById(id);
	}

	@Override
	public List<Curso> getCursoByWord(String string) {
		return repository.getCursoByWord(string);
	}

	@Override
	@Transactional
	public void deleteEstudianteFromCurso(Integer id, Estudiante e1) {
		
		Curso curso = getCursoById(id);
		
		//estu mapeado
		
		curso.getEstudiantes().remove(e1);
		repository.save(curso);
		
	}
}
