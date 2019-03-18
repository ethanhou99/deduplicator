import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;


public class md5 {
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
     * get hash code(md5) of a file
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
            BigInteger bigInt = new BigInteger(1, md5Bytes);//1代表绝对值
            return bigInt.toString(16);//转换为16进制
        } catch (Exception e) {
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

            //转换并返回包含16个元素字节数组,返回数值范围为-128到127
            byte[] md5Bytes  = md.digest();
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;//解释参见最下方
                if (val < 16) {
                    /**
                     * 如果小于16，那么val值的16进制形式必然为一位，
                     * 因为十进制0,1...9,10,11,12,13,14,15 对应的 16进制为 0,1...9,a,b,c,d,e,f;
                     * 此处高位补0。
                     */
                    hexValue.append("0");
                }
                //这里借助了Integer类的方法实现16进制的转换
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 方法md5HashCode32 中     ((int) md5Bytes[i]) & 0xff   操作的解释：
     * 在Java语言中涉及到字节byte数组数据的一些操作时，经常看到 byte[i] & 0xff这样的操作，这里就记录总结一下这里包含的意义：
     * 1、0xff是16进制（十进制是255），它默认为整形，二进制位为32位，最低八位是“1111 1111”，其余24位都是0。
     * 2、&运算: 如果2个bit都是1，则得1，否则得0；
     * 3、byte[i] & 0xff：首先，这个操作一般都是在将byte数据转成int或者其他整形数据的过程中；使用了这个操作，最终的整形数据只有低8位有数据，其他位数都为0。
     * 4、这个操作得出的整形数据都是大于等于0并且小于等于255的
     */


}

