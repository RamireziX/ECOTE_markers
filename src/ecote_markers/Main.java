package ecote_markers;

public class Main {

    //public static final String FILENAME = Consts.BIG_XML_OK;
    public static final String FILENAME = InputOutput.inputFilePath();

    public static void run(){
        String textFromFile = ReadFile.readFile(FILENAME);
        AnalyseFile.findMarkers(textFromFile);
        InputOutput.printResult();
    }

    public static void main(String[] args) {
        Main.run();
    }
}
