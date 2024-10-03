import java.io.*;

public class AccesFileWriter43483430K {
    public static void Writer(File archivo) throws IOException {
        // Verificar si el archivo tiene permisos de escritura antes de intentar escribir
        if (!archivo.canWrite()) {
            System.out.println("No se puede escribir en el archivo debido a la falta de permisos.");
            return;
        }

        // Proceder con la copia si el archivo es escribible
        try {
            RandomAccessFile raf = new RandomAccessFile(archivo, "r");  // Abrir en modo lectura
            String destino = "CopiaFile.txt";
            File archivocopia = new File(destino);
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
            e.printStackTrace();
        }
    }
}
