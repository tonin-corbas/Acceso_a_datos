import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main43483430K {
    public static void main(String[] args) throws IOException {
        // Crear el archivo para trabajar
        File archivo = new File("C:\\Users\\tikum\\IdeaProjects\\Acceso_a_datos\\U1EX1.txt");

        // Verificar si el archivo existe y es legible
        if (archivo.isFile()) {
            System.out.println("El archivo es un archivo de texto.");
            AccesFileReader43483430K.Reader(archivo);
            AccesFileWriter43483430K.Writer(archivo);
        } else {
            System.out.println("El archivo no es un archivo de texto se asumirá que es una imagen jpg.");
            FileInputStream43483430K.InputStream(archivo);
            FileOutputStream43483430K.OutputStream(archivo);
        }

        // Revocar permisos de escritura y lectura del archivo original
        File43483430K quitadordepermisos = new File43483430K();
        quitadordepermisos.RevokePermissions(archivo);

        System.out.println("Intentando volver a copiar el archivo");

        // Intentar escribir nuevamente, debe fallar si no tiene permisos
        try {
            AccesFileWriter43483430K.Writer(archivo);
        } catch (Exception e) {
            System.out.println("No se puede copiar el archivo debido a la falta de permisos.");
        }
    }
}
