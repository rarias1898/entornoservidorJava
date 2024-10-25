package com.ceu.ej15.models;

import java.util.List;

public class Cancion {
	private int id;
	private String titulo;
	private List<Artista> artista;
	
	public Cancion(int id, String titulo, List<Artista> artista) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Artista> getArtista() {
		return artista;
	}

	public void setArtista(List<Artista> artista) {
		this.artista = artista;
	}
	
	
}
