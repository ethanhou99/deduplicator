import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void test(String[] args){

        String testFile = System.getProperty("user.dir")+"/sublinear-big-data1.pptx";
        String testFile2 = System.getProperty("user.dir")+"/sublinear-big-data-1.pptx";
        String fileName = "sublinear-big-data1.pptx";

        cmdLine info = new cmdLine();
        split sp = new split();
        MataData mataData = new MataData();

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


        // test split
        try{
            sp.splitFile(new File(testFile),1024,info.lockerPath);
            System.out.println(sp.hashCodes);
        } catch(IOException e){
            e.printStackTrace();
        }

        // test MataData
        mataData.store(fileName,sp.hashCodes);
        mataData.print_mata();
        mataData.print_cnt();
        mataData.write2f(info.lockerPath);

    }
}
