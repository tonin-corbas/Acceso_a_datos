import java.io.File;
import java.io.IOException;

public class File43483430K {
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