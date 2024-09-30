import java.io.File;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.attribute.PosixFilePermission;
//import java.util.HashSet;
//import java.util.Set;

public class File43483430K {
    public void RevokePermissions() throws IOException {
        File file = new File("CopiaFile.txt");
        file.setReadable(false, false);
    }
}
