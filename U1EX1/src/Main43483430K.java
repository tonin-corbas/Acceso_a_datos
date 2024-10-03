import java.io.File;
import java.io.IOException;

public class Main43483430K {
    public static void main(String[] args) throws IOException {
        // Crear el archivo para trabajar
        File archivo = new File("U1EX1.txt");

        // Verificar si es un archivo binario o de texto
            if (File43483430K.isBinaryFile(archivo)) {
                System.out.println("El archivo es un archivo binario (JPG u otro tipo).");
                FileInputStream43483430K.InputStream(archivo);
                FileOutputStream43483430K.OutputStream(archivo);
            } else {
                System.out.println("El archivo es un archivo de texto.");
                AccesFileReader43483430K.Reader(archivo);
                AccesFileWriter43483430K.Writer(archivo);
            }

        // Revocar permisos de escritura del archivo
        File43483430K quitadordepermisos = new File43483430K();
        quitadordepermisos.RevokePermissions(archivo);

        System.out.println("Intentando volver a escribir en el archivo");

        //segunda ronda de escritura, esta vez sin permisos
        try {
            if (File43483430K.isBinaryFile(archivo)) {
                FileOutputStream43483430K.OutputStream(archivo);
            } else {
                AccesFileWriter43483430K.Writer(archivo);
            }
        } catch (Exception e) {
            System.out.println("No se puede escribir en el archivo debido a la falta de permisos.");
        }
        archivo.setWritable(true);
    }
}
