package com.ceu.ej14.models;

import java.time.LocalDate;
import java.util.List;

public class Pelicula {
	private int id;
	private String titulo;
	private String director;
	private LocalDate flanzamiento;
	private int duracion;
	private List<Actor> actor;

	public Pelicula(int id, String titulo, String director, LocalDate flanzamiento, int duracion, List<Actor> actor) {
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.flanzamiento = flanzamiento;
		this.duracion = duracion;
		this.actor = actor;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public LocalDate getFlanzamiento() {
		return flanzamiento;
	}

	public void setFlanzamiento(LocalDate flanzamiento) {
		this.flanzamiento = flanzamiento;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public List<Actor> getActor() {
		return actor;
	}

	public void setActor(List<Actor> actor) {
		this.actor = actor;
	}
}
