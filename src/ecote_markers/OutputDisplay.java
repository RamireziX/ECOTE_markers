package ecote_markers;

public class OutputDisplay {
    //either error description, or "everything is fine"
    private static String result;

    public static void printResult(){
        //jeśli result pusty, print "everything is chill bro"
        System.out.println(result);
    }

    public static void addTextToResult(String text){

    }

    public static String getResult() {
        return result;
    }

    public static void setResult(String result) {
        OutputDisplay.result = result;
    }
}
