import java.util.Scanner;

public class cmdLine {
    public String opType;
    public String fileName;
    public String lockerPath;

    public void printInstruction() {
        System.out.println("================== Welcome to the De-duplicator ==================");
        System.out.println("* Input 'dedup -addFile [file] -locker [locker name]' to add file");
        System.out.println("* Input 'dedup -retrieveFile [file] -locker [locker name]' to retrieve file");
    }

    public void readIn(String[] input) {

        opType = input[0];
        fileName = input[1];
        lockerPath = System.getProperty("user.dir") +"/"+ input[3];
        //System.out.println(opType + " " + fileName + " " + lockerNum);
    }

    private void manageFunc(){
        if (opType == "-addFile") {

        }
        else if (opType == "-retrieveFile") {
        }
        else {
            System.out.println("Invalid Input");
        }
    }
}