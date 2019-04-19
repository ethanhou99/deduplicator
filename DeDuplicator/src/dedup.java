import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class dedup {
    private static String pwd = System.getProperty("user.dir")+"/";

    public static void main(String[] args){
        SaveFolder sf = new SaveFolder();
        boolean DEBUG = false;

        HashMap<String, ArrayList<String>> mata = new HashMap<>();
        HashMap<String, Integer> b_cnt = new HashMap<>();

        if(!DEBUG) {
            // Main function starts here

            // Initialize objects
            CmdLine info = new CmdLine();
            SplitFile sp = new SplitFile();
            MataData mataData = new MataData();
            info.readIn(args);

            String target = pwd + info.fileName;

            if (!info.isNewPath) {
                // Not a new locker;
                // Load matadata & block info
                mata = mataData.readmataf(info.lockerPath);
                b_cnt = mataData.readcntf(info.lockerPath);
            }
            else {
                System.out.println("A new locker!");
            }

            // Add targetFile into locker
            if (info.opType.compareTo("-addFile") == 0) {
                if (!Tools.checkValid(target)) {
                    System.out.println("[Error] Target file "+info.fileName+ " not found at current path: " + pwd);
                }
                else if(sf.isFolder(target)) {
                    System.out.println(target);
                    sf.saveFolder(target, args[3], mataData, sp, mata);
                } else {
                    try {
                        // File not saved in appointed locker
                        if(!mata.containsKey(info.fileName)) {
                            File file = new File(target);
                            sp.splitFile(file, 1024, info.lockerPath);
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

            }

            // Retrieve targetFile
            else if(info.opType.compareTo("-retrieveFile")==0){
                try{
                    ExtractFile.Extract(info.fileName,info.lockerPath,mata);
                } catch(IOException e){
                    e.printStackTrace();
                }
            }

            // Substring match
            else if(info.opType.compareTo("-findSubString")==0){
                ArrayList<String> subFiles = new ArrayList<>();
                System.out.println("\nCurrent files saved in the locker with substring '" + info.fileName + "':");
                long start = System.currentTimeMillis();
                for(String slice: b_cnt.keySet()){
                    String curPath = info.lockerPath + "/" + slice;
                    try {
                        if (Tools.findStringInFile(curPath, info.fileName)){
                            subFiles.add(slice);
                        }
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
                for(String file: mata.keySet()){
                    ArrayList<String> tmp = mata.get(file);
                    for(String md5: subFiles){
                        if(tmp.indexOf(md5)!=-1){
                            System.out.println(file);
                            break;
                        }
                    }
                }
                double end = ((double)System.currentTimeMillis() - (double)start)/1000;
                System.out.println("\n------------------------------------------------------");
                System.out.println("Search finished in "+end+"s");
            }

        }

        else{
            // Test cases start here
            System.out.println("===================Running Test Cases===================");
            Test.test(args);
        }
    }
}
