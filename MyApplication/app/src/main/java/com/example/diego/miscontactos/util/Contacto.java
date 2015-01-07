package com.example.diego.miscontactos.util;

/**
 * Created by Diego on 07/01/2015.
 */
public class Contacto {
    private String nombre,direccion,email,telefono;

    public Contacto(String nombre, String direccion, String email, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    //<editor-fold desc="GETTER METHODS">
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
    //</editor-fold>

    //<editor-fold desc="SETTERS METHODS">
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //</editor-fold>
}
