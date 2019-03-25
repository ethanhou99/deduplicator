import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class split {

    public static ArrayList<String> hashCodes = new ArrayList<>();

    public static void splitFile(File f,int sizeOfFiles,String lockerPath) throws IOException {
        int counter = 0;

        // bytes as basic unit 1MB = 2^10 kb = 2^20 b
        // basic unit for sizeOfFiles is kb
        sizeOfFiles *= 1024;

        byte[] buffer = new byte[sizeOfFiles];
        String FileName = f.getName();

        try (FileInputStream fis = new FileInputStream(f);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            int bytesAmount = 0;
            while ((bytesAmount = bis.read(buffer)) > 0) {

                // filename : filePartName
                //String filePartName = String.format("%s %03d", FileName, counter++);
                String filePartName = md5.md5HashCode32(buffer);
                File newFile = new File(lockerPath, filePartName);
                hashCodes.add(filePartName);
                try (FileOutputStream out = new FileOutputStream(newFile)) {
                    out.write(buffer, 0, bytesAmount);
                }
            }
        }
    }
}