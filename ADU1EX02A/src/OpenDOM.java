import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OpenDOM {

    public List<Libro> LeerArchivo(String filePath) {
        List<Libro> listaLibro = new ArrayList<>();

        try {
            // Crear un DocumentBuilderFactory y configurar para utilizar DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Cargar y parsear el archivo XML
            File archivoXML = new File(filePath);
            Document document = builder.parse(archivoXML);

            document.getDocumentElement().normalize();

            // Obtener los elementos 'llibre' del archivo XML
            NodeList listaLibros = document.getElementsByTagName("llibre");

            // Iterar a través de cada nodo 'llibre' para extraer la información
            for (int i = 0; i < listaLibros.getLength(); i++) {
                Node nodo = listaLibros.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    // Usar los métodos DOM para obtener los valores de cada elemento
                    String titulo = elemento.getElementsByTagName("titol").item(0).getTextContent();
                    String autor = elemento.getElementsByTagName("autor").item(0).getTextContent();
                    String any = elemento.getElementsByTagName("any").item(0).getTextContent();
                    String resum = elemento.getElementsByTagName("resum").item(0).getTextContent();

                    // Crear un objeto de tipo Libro43483430K y agregarlo a la lista
                    Libro libro = new Libro(titulo, autor, any, resum);
                    listaLibro.add(libro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaLibro;
    }
}
