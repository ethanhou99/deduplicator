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


        System.out.println("****************test md5****************\n");

        try{
            String hash32 = md5.md5HashCode32(testFile);
            String hash32_1 = md5.md5HashCode32(testFile2);
            if (hash32.compareTo(hash32_1)==0){
                System.out.println("Same File!");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("****************test cmdLine****************\n");
        info.readIn(args);
        System.out.println(info.lockerPath);
        System.out.println(info.fileName);


        System.out.println("****************test split****************\n");
        try{
            sp.splitFile(new File(testFile),1024,info.lockerPath);
            System.out.println(sp.hashCodes);
        } catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("****************test MataData****************\n");
        mataData.store(fileName,sp.hashCodes);
        mataData.print_mata();
        mataData.print_cnt();
        mataData.write2f(info.lockerPath);
        mataData.readcntf(info.lockerPath);
        mataData.readmataf(info.lockerPath);

    }
}
