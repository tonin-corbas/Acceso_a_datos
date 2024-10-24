import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AccesFileReader {
    public static void Reader(File archivo) {
        try {
            FileReader lectorarchivo = new FileReader(archivo);
            BufferedReader almacenReader = new BufferedReader(lectorarchivo);
            String line;
            while ((line = almacenReader.readLine()) != null) {
                System.out.println(line);
            }
            almacenReader.close();
        } catch (IOException e) {
            System.out.println("No tienes permitido leer este archivo.");
        }
    }
}
