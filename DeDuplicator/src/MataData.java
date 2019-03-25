import java.util.*;

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

}

