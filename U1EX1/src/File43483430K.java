import java.io.File;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.attribute.PosixFilePermission;
//import java.util.HashSet;
//import java.util.Set;

public class File43483430K {
    public static void RevokePermissions() throws IOException {
        File file = new File("U1EX1.txt");
        file.setReadable(false, false);
        if (file.setReadable(false, false)){
            System.out.println("Los permisos se han revocado exitosamente.");
        }else {
            System.out.println("No se han podido revocar los permisos.");
        }
    }
}
