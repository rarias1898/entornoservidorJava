package com.ceu.ej15.models;

import java.time.LocalDate;
import java.util.List;

public class Album {
	private int id;
	private String titulo;
	private String artistaPrincipal;
	private LocalDate anioLanzamiento;
	private List<Cancion> cancion;
	
	public Album(int id, String titulo, String artistaPrincipal, LocalDate anioLanzamiento, List<Cancion> cancion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.artistaPrincipal = artistaPrincipal;
		this.anioLanzamiento = anioLanzamiento;
		this.cancion = cancion;
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

	public String getArtistaPrincipal() {
		return artistaPrincipal;
	}

	public void setArtistaPrincipal(String artistaPrincipal) {
		this.artistaPrincipal = artistaPrincipal;
	}

	public LocalDate getAnioLanzamiento() {
		return anioLanzamiento;
	}

	public void setAnioLanzamiento(LocalDate anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}

	public List<Cancion> getCancion() {
		return cancion;
	}

	public void setCancion(List<Cancion> cancion) {
		this.cancion = cancion;
	}
	
	
	
}
