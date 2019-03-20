public class database {
    public static boolean checkDriver(String name){
        try{
            Class.forName(name);
            System.out.println("Driver found");
            return true;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Cannot find the Driver. Try install mysql/connector J");
            return false;
        }
    }
    /*
    public static boolean search(String key){

    }*/

    public static void insert(String hash, String path){

    }

    public static void delete(String hash){

    }
}
