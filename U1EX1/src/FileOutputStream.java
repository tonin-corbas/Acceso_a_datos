import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileOutputStream {
    public static void OutputStream(File archivo) throws IOException {
        // Verificar si el archivo tiene permisos de escritura antes de intentar escribir
        if (!archivo.canWrite()) {
            System.out.println("No se puede escribir en el archivo JPG debido a la falta de permisos.");
            return;
        }

        // Proceder con la copia del archivo JPG
        try (FileInputStream fis = new FileInputStream(archivo);
             java.io.FileOutputStream fos = new java.io.FileOutputStream("CopiaImagen.jpg")) {

            byte[] almacen = new byte[1024];
            int bytesLeidos;
            while ((bytesLeidos = fis.read(almacen)) != -1) {
                fos.write(almacen, 0, bytesLeidos);
            }
            System.out.println("Archivo JPG copiado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo JPG.");
        }
    }
}
