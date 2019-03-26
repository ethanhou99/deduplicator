public class CmdLine {

    public String opType;

    public String fileName;
    public String lockerPath;
    public static boolean isNewPath = false;

    public void readIn(String[] input) {

        opType = input[0];
        fileName = input[1];
        lockerPath = System.getProperty("user.dir") +"/"+ input[3];
        manageFunc();

    }

    private void manageFunc(){
        if (opType.compareTo("-addFile")==0) {
            if(!Tools.checkExist(lockerPath)){
                Tools.makeExist(lockerPath);
                isNewPath = true;
            }
        }
        else if (opType.compareTo("-retrieveFile")==0) {
            if(!Tools.checkExist(lockerPath)){
                System.out.println("[Error]Appointed locker not found");
            }
        }
        else {
            System.out.println("Invalid Input");
        }
    }
}