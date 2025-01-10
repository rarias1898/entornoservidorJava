package com.ceu.ej12.repository;

import java.util.List;

import com.ceu.ej12.model.Autor;

public interface AutorRepository {

	List<Autor> getAutores();

	void addAutor(Autor a1);

}
