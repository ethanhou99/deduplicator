public class dedup {
    public static void main(String[] args){
        boolean DEBUG = false;

        if(!DEBUG) {
            // Main function starts here
            cmdLine info = new cmdLine();
            split sp = new split();


            info.printInstruction();
            info.readIn(args);
        }

        else{
            // test cases start here
            test.test(args);
        }
    }
}
