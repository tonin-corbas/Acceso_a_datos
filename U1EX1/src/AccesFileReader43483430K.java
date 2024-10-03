import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AccesFileReader43483430K {
    public static void Reader(File archivo) {
        try {
            FileReader lectorarchivo = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(lectorarchivo);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("No tienes permitido leer este archivo.");
        }
    }
}
