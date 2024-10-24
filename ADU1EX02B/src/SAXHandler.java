import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {

    private List<Libro> listaLibros = null;
    private Libro libroActual = null;
    private StringBuilder data = null;

    // Método que se llama cuando empieza a analizar el XML
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("llibre")) {
            // Si se encuentra una nueva etiqueta <llibre>, creamos un nuevo objeto Libro
            libroActual = new Libro(null, null, null, null);
            if (listaLibros == null) {
                listaLibros = new ArrayList<>();
            }
        }
        // Inicializar el buffer para guardar el contenido de las etiquetas
        data = new StringBuilder();
    }

    // Método que se llama al encontrar contenido dentro de una etiqueta
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    // Método que se llama cuando termina de analizar una etiqueta
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (libroActual != null) {
            switch (qName) {
                case "titol":
                    libroActual = new Libro(data.toString(), libroActual.getAutor(), libroActual.getAny(), libroActual.getResum());
                    break;
                case "autor":
                    libroActual = new Libro(libroActual.getTitulo(), data.toString(), libroActual.getAny(), libroActual.getResum());
                    break;
                case "any":
                    libroActual = new Libro(libroActual.getTitulo(), libroActual.getAutor(), data.toString(), libroActual.getResum());
                    break;
                case "resum":
                    libroActual = new Libro(libroActual.getTitulo(), libroActual.getAutor(), libroActual.getAny(), data.toString());
                    break;
                case "llibre":
                    listaLibros.add(libroActual);
                    break;
            }
        }
    }

    // Obtener la lista de libros después de que el parsing haya terminado
    public List<Libro> getListaLibros() {
        return listaLibros;
    }
}
