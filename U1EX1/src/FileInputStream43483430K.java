import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream43483430K {
        public static void InputStream(File archivo) throws IOException {
            // Verificar si el archivo tiene permisos de lectura antes de intentar leerlo
            if (!archivo.canRead()) {
                System.out.println("No se puede leer el archivo JPG debido a la falta de permisos.");
                return;
            }

            // Leer el archivo JPG usando FileInputStream
            try (FileInputStream fis = new FileInputStream(archivo)) {
                System.out.println("Leyendo el archivo JPG...");

                byte[] almacen = new byte[1024];
                int bytesLeidos;
                while ((bytesLeidos = fis.read(almacen)) != -1) {
                    System.out.println("Leídos " + bytesLeidos + " bytes.");
                }

                System.out.println("Lectura del archivo JPG completada.");
            } catch (IOException e) {
                System.out.println("Error al leer el archivo JPG.");
            }
        }
    }
