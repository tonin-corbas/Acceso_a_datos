import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del parser para procesar el XML usando DOM
        OpenDOM parser = new OpenDOM();

        // Especificar la ruta del archivo XML
        String path = "C:\\Users\\tikum\\IdeaProjects\\Acceso_a_datos\\ADU1EX02A\\Llibres.xml";

        // Obtener la lista de libros a partir del XML
        List<Libro> listaLibro = parser.LeerArchivo(path);

        // Mostrar la información de cada libro en la consola
        for (Libro libro : listaLibro) {
            System.out.println(libro);
        }
    }
}
