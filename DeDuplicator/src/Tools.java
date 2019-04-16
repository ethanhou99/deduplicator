import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class Tools {

    public static void makeExist(String filepath) {
        File file=new File(filepath);

        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static boolean checkExist(String filepath) {
        File file=new File(filepath);
        if (!file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean checkFile(String directory){
        File file =new File(directory);
        if(file.exists()){
            if(file.isDirectory()){
                return true;
            }
        }
        return false;
    }

    public static String md5HashCode(String filePath) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(filePath);
        return md5HashCode(fis);
    }

    /**
     * Make sure hash code 32 bits
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    public static String md5HashCode32(String filePath) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(filePath);
        return md5HashCode32(fis);
    }

    /**
     * get hash code(Tools) of a file
     * @param fis input stream
     * @return
     */
    public static String md5HashCode(InputStream fis) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // slice the object file into blocks size 1M
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            fis.close();
            byte[] md5Bytes  = md.digest();
            BigInteger bigInt = new BigInteger(1, md5Bytes);// 1 for abs()
            return bigInt.toString(16);// convert to hex
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String md5HashCode32(byte[] buffer){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(buffer,0,buffer.length);
            byte[] md5Bytes = md.digest();
            StringBuffer hexValue = new StringBuffer();
            for(int i =0;i<md5Bytes.length;i++){
                int val =((int)md5Bytes[i]) & 0xff;
                if(val<16){
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();

        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            return "";
        }
    }

    public static String md5HashCode32(InputStream fis) {
        try {
            //Md5 converter could also change to SHA-1,SHA-256
            MessageDigest md = MessageDigest.getInstance("MD5");

            // slice the object file into blocks size 1M
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            fis.close();

            byte[] md5Bytes  = md.digest();
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static boolean findStringInFile(String path, String subString) throws IOException {

        File file = new File(path);
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), "ASCII");
        BufferedReader bufferedReader = new BufferedReader(read);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(subString)) {
                return true;
            }
        }
        return false;
    }

}

