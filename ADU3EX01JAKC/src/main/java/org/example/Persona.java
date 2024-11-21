package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
    @Id
    private String nombre;
    private int edad;
    private String email;

    public Persona() {
    }

    public Persona(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdat() {
        return edad;
    }

    public void setEdat(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                '}';
    }
}

