public class database {
    public static void checkDriver(String name){
        try {
            Class.forName(name);
            System.out.println("Driver found");
        }catch(ClassNotFoundException e){
            System.out.println("Driver not found. Try install driver again");
            e.printStackTrace();
        }
    }
}
