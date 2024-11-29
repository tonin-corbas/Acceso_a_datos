package org.example;

import javax.persistence.Entity; // Anotación para marcar esta clase como una entidad JPA
import javax.persistence.Id; // Anotación para identificar la clave primaria

@Entity // Marca esta clase como una entidad para la base de datos
public class Persona {
    @Id // Define el campo 'nombre' como la clave primaria
    private String nombre;
    private int edad; // Campo para almacenar la edad de la persona
    private String email; // Campo para almacenar el email de la persona

    public Persona() {
    }

    // Constructor para inicializar los datos de una persona
    public Persona(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    // Métodos getter y setter para cada atributo
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
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
        return "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'';
    }
}
