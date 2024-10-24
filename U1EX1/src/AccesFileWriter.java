import java.io.*;

public class AccesFileWriter {
    public static void Writer(File archivo) throws IOException {
        // Verificar si el archivo tiene permisos de escritura antes de intentar escribir
        if (!archivo.canWrite()) {
            System.out.println("No se puede escribir en el archivo debido a la falta de permisos.");
            return;
        }

        // Proceder con la copia si hay permisos de escritura en el archivo
        try {
            RandomAccessFile raf = new RandomAccessFile(archivo, "r");
            String destino = "CopiaFile.txt";
            Fileclass archivocopia = new Fileclass(destino);
            FileOutputStream copyFos = new FileOutputStream(archivocopia);
            String line;

            while ((line = raf.readLine()) != null) {
                copyFos.write(line.getBytes());
                copyFos.write("\n".getBytes());
            }
            raf.close();
            copyFos.close();
            System.out.println("Archivo copiado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo.");
        }
    }
}
