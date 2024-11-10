package com.ceu.ej3.model;

import jakarta.persistence.*;

@Entity
@Table(name="vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "anyo")
    private int anyo;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "estado")
    private String estado;

    @Column(name = "kilometraje")
    private Double kilometraje;

    public Vehiculo() {
        super();
    }

    public Vehiculo(int id, String marca, String modelo, int anyo, String matricula, String estado, Double kilometraje) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
        this.matricula = matricula;
        this.estado = estado;
        this.kilometraje = kilometraje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        this.kilometraje = kilometraje;
    }
}
