package ecote_markers;

public class OutputDisplay {
    private static String errorsDescription = "";

    public static void printResult(){
        //correct structure message
        if(errorsDescription.isEmpty()){
            System.out.print(Consts.MSG_FILE);
            System.out.print(Main.FILENAME);
            System.out.print(Consts.MSG_CORRECT_FILE);
        }
        //error message with details
        else
        System.err.print(errorsDescription);
    }

    public static void addTextToDescription(String text){
       errorsDescription = errorsDescription.concat(text);
    }

    public static String getErrorsDescription() {
        return errorsDescription;
    }

    public static void setErrorsDescription(String errorsDescription) {
        OutputDisplay.errorsDescription = errorsDescription;
    }
}
