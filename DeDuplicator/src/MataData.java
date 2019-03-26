import java.util.*;
import java.io.*;

public class MataData {
    private HashMap<String, ArrayList<String>> matadata = new HashMap<>();
    private HashMap<String, Integer> block_cnt= new HashMap<>();

    public void store(String fname, ArrayList<String> fmd5) {
        matadata.put(fname, fmd5);
        for (String md5 : fmd5) {
            if (block_cnt.containsKey(md5))
                block_cnt.put(md5, block_cnt.get(md5) + 1);
            else
                block_cnt.put(md5, 1);
        }
    }
    public void print_mata() {
        System.out.println("==========matadata============");
        for (Map.Entry<String, ArrayList<String>> entry : matadata.entrySet()) {
            System.out.print("filename: "+ entry.getKey() + "\tcontent(in Md5 Hash):");
            ArrayList<String> con = matadata.get(entry.getKey());
            for (String md5: con) {
                System.out.print(md5);
                System.out.print(", ");
            }
            System.out.println();
        }
    }
    public void print_cnt() {
        System.out.println("==========block_count============");
        for (Map.Entry<String, Integer> entry : block_cnt.entrySet())
            System.out.println("Block_Hash: " + entry.getKey() + ", number: " + entry.getValue());
    }

    public void write2f(String lockerPath) {
        String mfname = lockerPath + "/mata";
        String bfname = lockerPath + "/b_cnt";
        try {
            FileOutputStream mata =
                    new FileOutputStream(mfname);
            ObjectOutputStream mataStream = new ObjectOutputStream(mata);
            mataStream.writeObject(matadata);
            mataStream.close();
            mata.close();
            System.out.println("Serialized MataData is saved in " + mfname);
            FileOutputStream cnt_list =
                    new FileOutputStream(bfname);
            ObjectOutputStream cntStream = new ObjectOutputStream(cnt_list);
            cntStream.writeObject(block_cnt);
            cntStream.close();
            cnt_list.close();
            System.out.println("Serialized BlockList is saved in " + bfname);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public HashMap<String, ArrayList<String>> readmataf(String lockerPath) {
        String mataname = lockerPath + "/mata";
        HashMap<String, ArrayList<String>> map = null;
        try
        {
            FileInputStream fis = new FileInputStream(mataname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
//----------------------pretty print for testing---------------
        System.out.println("Deserialized HashMap..");
        // Display content using Iterator
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key: "+ mentry.getKey() + " & Value: ");
            System.out.println(mentry.getValue());
        }
        return map;
    }

    public HashMap<String, Integer> readcntf(String lockerPath) {
        String cntfname = lockerPath + "/b_cnt";
        HashMap<String, Integer> map = null;
        try
        {
            FileInputStream fis = new FileInputStream(cntfname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
//----------------------pretty print for test---------------
        System.out.println("Deserialized HashMap..");
        // Display content using Iterator
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key: "+ mentry.getKey() + " & Value: ");
            System.out.println(mentry.getValue());
        }
        return map;
    }

}
