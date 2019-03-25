import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args){

        String testFile = System.getProperty("user.dir")+"/sublinear-big-data1.pptx";
        String testFile2 = System.getProperty("user.dir")+"/sublinear-big-data-1.pptx";

        cmdLine info = new cmdLine();
        split sp = new split();

        // test md5 case
        try{
            String hash32 = md5.md5HashCode32(testFile);
            String hash32_1 = md5.md5HashCode32(testFile2);
            if (hash32.compareTo(hash32_1)==0){
                System.out.println("Same File!");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        // test cmdLine
        info.readIn(args);
        System.out.println(info.lockerPath);
        System.out.println(info.fileName);
        System.out.println(info.opType);


        // test split
        try{
            sp.splitFile(new File(testFile),1024,info.lockerPath);
            System.out.println(sp.hashCodes);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
