package com.ej9_11.model;

public class Direccion {

    private String calle;
    private String codPostal;
    private String ciudad;

    public Direccion(String calle, String codPostal, String ciudad) {
        this.calle = calle;
        this.codPostal = codPostal;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
