import java.io.*;

public class AccesFileWriter43483430K {
    public static void Writer() throws IOException {
        try {
            File file = new File("U1EX1.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            String destino = "CopiaFile.txt";
            File copyFile = new File(destino);
            FileOutputStream copyFos = new FileOutputStream(copyFile);

            String line;
            while ((line = raf.readLine()) != null) {
                copyFos.write(line.getBytes());
                copyFos.write("\n".getBytes());
            }

            raf.close();
            copyFos.close();
            System.out.println("Archivo copiado exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}