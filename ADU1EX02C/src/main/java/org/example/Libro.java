package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "llibre")
public class Libro {

    private String titulo;
    private String autor;
    private String any;
    private String resum;

    // Constructor vacío requerido por JAXB
    public Libro() {}

    public Libro(String titulo, String autor, String any, String resum) {
        this.titulo = titulo;
        this.autor = autor;
        this.any = any;
        this.resum = resum;
    }

    @XmlElement(name = "titol")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlElement(name = "autor")
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @XmlElement(name = "any")
    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }

    @XmlElement(name = "resum")
    public String getResum() {
        return resum;
    }

    public void setResum(String resum) {
        this.resum = resum;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nAño: " + any + "\nResumen: " + resum + "\n------------------------";
    }
}

