import java.sql.*;

public class database {

    private static String user = "root";
    private static String password = "sjzydxx61wzfTOP";
    private static String url = "jdbc:mysql://localhost:3306/";


    public static void checkDriver(String name){
        try {
            Class.forName(name);
            System.out.println("Driver found");
        }catch(ClassNotFoundException e){
            System.out.println("Driver not found. Try install driver again");
            e.printStackTrace();
        }
    }

    public static void init_DB(String locker){

    }

    public static void connect(String locker){
        try{
            Connection con = DriverManager.getConnection(url+locker,user,password);

        }catch(SQLException ignored){

        }
    }


}
