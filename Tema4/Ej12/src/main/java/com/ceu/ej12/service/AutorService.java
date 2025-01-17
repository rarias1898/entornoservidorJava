package com.ceu.ej12.service;

import java.util.List;

import com.ceu.ej12.model.Autor;
import com.ceu.ej12.model.Libro;

public interface AutorService {

	List<Autor> getAutores();

	void addAutor(Autor a1);

	Autor getAutorById(int id);

	Autor updateAutor(int id, Autor modifAutor);

	void deleteAutor(int id);

	void addLibroToAutor(int id, Libro l1);

	void deleteLibroFromAutor(int id, int id2);
}
