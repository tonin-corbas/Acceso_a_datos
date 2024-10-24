package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear un contexto JAXB para las clases Llibres y Libro
            JAXBContext context = JAXBContext.newInstance(Libros.class);

            // Crear un Unmarshaller para convertir el archivo XML a objetos Java
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Leer el archivo XML y convertirlo en objetos Java
            File archivoXML = new File("C:\\Users\\tikum\\IdeaProjects\\Acceso_a_datos\\ADU1EX02C\\Llibres.xml");
            Libros llibres = (Libros) unmarshaller.unmarshal(archivoXML);

            // Imprimir la lista de libros en la consola
            for (Libro llibre : llibres.getLibros()) {
                System.out.println(llibre);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
