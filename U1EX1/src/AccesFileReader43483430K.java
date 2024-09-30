import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AccesFileReader43483430K {
    public static void Reader(){
        try {
            File originalFile = new File("U1EX1.txt");
            try {
                FileReader fileReader = new FileReader(originalFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("No tienes permitido leer este archivo");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
