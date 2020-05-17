package ecote_markers;

import java.util.Scanner;

public class InputOutput {
    private static String errorsDescription = "";

    public static String inputFilePath(){
        System.out.print(Consts.MSG_INPUT_FILE);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

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
        //to avoid multiple lines of the same message
        //(happens when checking nesting)
        if(!errorsDescription.contains(text))
             errorsDescription = errorsDescription.concat(text);
    }

    public static void removeTextFromDescription(String text){
        if(errorsDescription.contains(text))
            errorsDescription = errorsDescription.replace(text, "");
    }

    public static String getErrorsDescription() {
        return errorsDescription;
    }

    public static void setErrorsDescription(String errorsDescription) {
        InputOutput.errorsDescription = errorsDescription;
    }
}
