package com.ceu.ej12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej12.model.Autor;
import com.ceu.ej12.model.Libro;
import com.ceu.ej12.repository.AutorRepository;

import jakarta.transaction.Transactional;

@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	private AutorRepository repository;

	@Override
	public List<Autor> getAutores() {
		return repository.getAutores();
	}

	@Override
	@Transactional
	public void addAutor(Autor a1) {
		 repository.addAutor(a1);
	}

	@Override
	public Autor getAutorById(int id) {
		return repository.getAutorById(id);
	}

	@Override
	@Transactional
	public Autor updateAutor(int id, Autor modifAutor) {
		Autor autor1 = getAutorById(id);
		
		autor1.setNombre(modifAutor.getNombre());
		
		return repository.updateAutor(autor1);
	}

	@Override
	@Transactional
	public void deleteAutor(int id) {
		Autor autor = getAutorById(id);
		
		if (autor != null) {
			repository.deleteAutor(autor);
		}
		
	}

	@Override
	@Transactional
	public void addLibroToAutor(int id, Libro l1) {
		Autor autor = getAutorById(id);
		
		if (autor != null) {
			autor.getListaLibros().add(l1);
			updateAutor(autor.getId(), autor);
		}
		
	}

	@Override
	@Transactional
	public void deleteLibroFromAutor(int id, int id2) {
		Autor autor = getAutorById(id);
		
		autor.setListaLibros(autor.getListaLibros().stream().filter(x -> x.getId() != id2).toList());
		updateAutor(autor.getId(), autor);
	}

	

}
