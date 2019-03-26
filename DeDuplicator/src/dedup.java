import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class dedup {
    private static String pwd = System.getProperty("user.dir")+"/";

    public static void main(String[] args){

        boolean DEBUG = true;

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
                if (!Tools.checkExist(target)) {
                    System.out.println("[Error] Target file "+info.fileName+ " not found at current path: " + pwd);
                }
                else {
                    try {
                        File file = new File(target);
                        sp.splitFile(file, 1024, info.lockerPath);

                        // File not saved in appointed locker
                        if(!mata.containsKey(info.fileName)) {
                            mataData.store(info.fileName, sp.hashCodes);
                            mataData.write2f(info.lockerPath);
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
            if(info.opType.compareTo("-retrieveFile")==0){
                try{
                    ExtractFile.Extract(info.fileName,info.lockerPath,mata);
                } catch(IOException e){
                    e.printStackTrace();
                }
            }

            else{

            }

        }

        else{
            // Test cases start here
            System.out.println("===================Running Test Cases===================");
            Test.test(args);
        }
    }
}
