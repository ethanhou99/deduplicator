import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args){
        try{
            String filePath = "/Users/zifanwang/Downloads/Web_paraJacobi.ppt";
            String filePath2 = "/Users/zifanwang/Downloads/Web_paraJacobi1.ppt";
            String hash32 = md5.md5HashCode32(filePath);
            String hash321 = md5.md5HashCode32(filePath2);
            if (hash32.compareTo(hash321)==0){
                System.out.println("Same File!");
            }
            System.out.println(hash32);
            System.out.println(hash321);
            database.checkDriver("com.mysql.cj.jdbc.Driver");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void saveFile(String filepath){
        try{
            String hash = md5.md5HashCode32(filepath);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
