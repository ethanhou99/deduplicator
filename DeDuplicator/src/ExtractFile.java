import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

public class ExtractFile {
    private static void Merge(File output_file, ArrayList<File> files)
            throws IOException {
        if (output_file.isDirectory()){

        } else {
            try (FileOutputStream fos = new FileOutputStream(output_file);
                 BufferedOutputStream mergingStream = new BufferedOutputStream(fos)) {
                for (File f : files) {
                    Files.copy(f.toPath(), mergingStream);
                }

            }
        }
    }
    public static void Extract(String filename, String lockerPath,HashMap<String, ArrayList<String>> mata) throws IOException {
        if (mata.containsKey(filename)){
            File output_file = new File(filename);
            ArrayList<File> files = new ArrayList<>();
            for (String hash_file_name : mata.get(filename)){
                File input_file = new File(lockerPath+"/"+hash_file_name);
                files.add(input_file);
            }
            System.out.println(output_file);
            Merge(output_file, files);
            System.out.println("file successfully extracted");
        }
        else{
            System.out.println("File is not found in locker");
        }
    }

}