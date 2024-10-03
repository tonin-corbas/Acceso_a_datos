import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class File43483430K {
    public static boolean isBinaryFile(File archivo) throws IOException {
        // Leer los primeros 1024 bytes del archivo
        try (FileInputStream fis = new FileInputStream(archivo)) {
            byte[] almacen = new byte[1024];
            int bytesleidos = fis.read(almacen);
            int i = 0;

            // Si no hay contenido, se asume que no es binario
            if (bytesleidos == -1) {
                return false;
            }
            // Lee los bytes uno a uno
            while (i < bytesleidos){
                i++;
            }
        }
        return false;
    }

    // Revocar permisos de escritura del archivo original
    public void RevokePermissions(File archivo) throws IOException {
        try {
            // Revocar permisos de escritura
            archivo.setWritable(false);
            System.out.println("Permisos de escritura revocados para el archivo original.");
        } catch (Exception e) {
            System.out.println("No se pudo revocar los permisos de escritura.");
        }
    }
}