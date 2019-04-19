import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SaveFolder {
    private HashMap<String, File> files = new HashMap<>();
    public void saveFolder(String path, String lockerName, MataData mataData, SplitFile sp, HashMap<String, ArrayList<String>> mata) {
       final File folder = new File(path);
        HashMap<String, File> allFile = fileList(folder);
        Iterator it = allFile.entrySet().iterator();
        while (it.hasNext()) {
            CmdLine info = new CmdLine();
            Map.Entry pair = (Map.Entry)it.next();
            String[] args = {"-addFile", pair.getKey().toString(), "-locker", lockerName};
            info.readIn(args);
            String filepath = pair.getValue().toString();
            save(filepath, info, mataData, sp, mata);
            it.remove();
        }
    }

    private HashMap<String, File> fileList(final File folder) {
        //System.out.println(folder);
        //System.out.println(folder.listFiles());
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                fileList(fileEntry);
            } else {
                files.put(fileEntry.getName(), fileEntry);
            }
        }
        return files;
    }

    private void save(String target, CmdLine info, MataData mataData, SplitFile sp, HashMap<String, ArrayList<String>> mata) {
        try {

            // File not saved in appointed locker
            if(!mata.containsKey(info.fileName)) {
                File file = new File(target);
                sp.splitFile(file, 1024, info.lockerPath);
                System.out.println(info.fileName);
                mataData.store(info.fileName, sp.hashCodes);
                mataData.write2f(info.lockerPath);
                System.out.println("File saved!");
            }

            // File with same name already saved
            else{
                System.out.println("[Error] A file with same name has already existed in the locker");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isFolder(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        String pwd = System.getProperty("user.dir")+"/";
//        CmdLine info = new CmdLine();
//        info.readIn(args);
//        String target = pwd + info.fileName;
//        SaveFolder sf = new SaveFolder();
//        sf.saveFolder(target);
//    }
}
