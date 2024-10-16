package com.ceu.ej14.models;

public class Actor {
	private int id;
	private String nombre;
	private String nacionalidad;
	
	public Actor(int id, String nombre, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
}
