import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void test(String[] args){

        String testFile = System.getProperty("user.dir")+"/sublinear-big-data1.pptx";
        String testFile2 = System.getProperty("user.dir")+"/sublinear-big-data-1.pptx";
        String fileName = "sublinear-big-data1.pptx";

        CmdLine info = new CmdLine();
        SplitFile sp = new SplitFile();
        MataData mataData = new MataData();


        System.out.println("****************Test Tools****************\n");

        try{
            String hash32 = Tools.md5HashCode32(testFile);
            String hash32_1 = Tools.md5HashCode32(testFile2);
            if (hash32.compareTo(hash32_1)==0){
                System.out.println("Same File!");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("****************Test CmdLine****************\n");
        info.readIn(args);
        System.out.println(info.lockerPath);
        System.out.println(info.fileName);


        System.out.println("****************Test SplitFile****************\n");
        try{
            sp.splitFile(new File(testFile),1024,info.lockerPath);
            System.out.println(sp.hashCodes);
        } catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("****************Test MataData****************\n");
        mataData.store(fileName,sp.hashCodes);
        mataData.print_mata();
        mataData.print_cnt();
        mataData.write2f(info.lockerPath);
        mataData.readcntf(info.lockerPath);
        mataData.readmataf(info.lockerPath);

    }
}
