import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Crear el archivo para trabajar
        File archivo = new File("U1EX1.txt");

        // Verificar si es un archivo binario o de texto
            if (Fileclass.isBinaryFile(archivo)) {
                System.out.println("El archivo es un archivo binario (JPG u otro tipo).");
                FileInputStream.InputStream(archivo);
                FileOutputStream.OutputStream(archivo);
            } else {
                System.out.println("El archivo es un archivo de texto.");
                AccesFileReader.Reader(archivo);
                AccesFileWriter.Writer(archivo);
            }

        // Revocar permisos de escritura del archivo
        Fileclass quitadordepermisos = new Fileclass();
        quitadordepermisos.RevokePermissions(archivo);

        System.out.println("Intentando volver a escribir en el archivo");

        //segunda ronda de escritura, esta vez sin permisos
        try {
            if (Fileclass.isBinaryFile(archivo)) {
                FileOutputStream.OutputStream(archivo);
            } else {
                AccesFileWriter.Writer(archivo);
            }
        } catch (Exception e) {
            System.out.println("No se puede escribir en el archivo debido a la falta de permisos.");
        }
        archivo.setWritable(true);
    }
}
