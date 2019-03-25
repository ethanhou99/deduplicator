import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        // test md5 case
        try{
            String filePath = "/Users/zifanwang/Downloads/Web_paraJacobi.ppt";
            String filePath2 = "/Users/zifanwang/Downloads/Web_paraJacobi1.ppt";
            String hash32 = md5.md5HashCode32(filePath);
            String hash321 = md5.md5HashCode32(filePath2);
            if (hash32.compareTo(hash321)==0){
                System.out.println("Same File!");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        // test cmdLine
        cmdLine info = new cmdLine();
        info.readIn(args);
        System.out.println(info.lockerPath);
        System.out.println(info.fileName);
        System.out.println(info.opType);


        // test split
        try{
            String testFile = System.getProperty("user.dir")+"/sublinear-big-data-1.pptx";
            ArrayList<String> files = split.splitFile(new File(testFile),1024,info.lockerPath);
            System.out.println(files);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
