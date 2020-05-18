package ecote_markers;

public class Main {

    //to avoid manual input uncomment this and comment the line below
    public static final String FILENAME = Consts.VERY_BIG_XML;
    //public static final String FILENAME = InputOutput.inputFilePath();

    public static void run(){
        String textFromFile = ReadFile.readFile(FILENAME);
        AnalyseFile.findMarkers(textFromFile);
        InputOutput.printResult();
    }

    public static void main(String[] args) {
        Main.run();
    }
}
