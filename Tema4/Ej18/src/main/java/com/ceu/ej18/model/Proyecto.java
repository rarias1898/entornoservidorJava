package com.ceu.ej18.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "persona_proyecto",
	 joinColumns = {@JoinColumn(name = "id_proyecto")},
	 inverseJoinColumns = {@JoinColumn(name = "id_persona")})
	private List<Persona> personas;
	 
	public Proyecto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proyecto(String nombre) {
		super();
		this.nombre = nombre;
		this.personas = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", personas=" + personas + "]";
	}
}
