import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear un SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Crear un SAXParser
            SAXParser saxParser = factory.newSAXParser();

            // Crear una instancia de nuestro manejador
            SAXHandler handler = new SAXHandler();

            // Especificar la ruta del archivo XML
            String path = "C:\\Users\\tikum\\IdeaProjects\\Acceso_a_datos\\ADU1EX02B\\Llibres.xml";

            // Parsear el archivo XML usando SAX
            saxParser.parse(new File(path), handler);

            // Obtener la lista de libros desde el manejador
            List<Libro> listaLibros = handler.getListaLibros();

            // Mostrar la información de cada libro en la consola
            for (Libro libro : listaLibros) {
                System.out.println(libro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
