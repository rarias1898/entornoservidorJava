package com.ceu.ej12.service;

import java.util.List;

import com.ceu.ej12.model.Autor;

public interface AutorService {

	List<Autor> getAutores();

	void addAutor(Autor a1);
}
