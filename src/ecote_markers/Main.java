package ecote_markers;

public class Main {

    public static final String FILENAME = Consts.BIG_XML_OK;

    public static void run(){
        String textFromFile = ReadFile.readFile(FILENAME);
        AnalyseFile.findMarkers(textFromFile);
        OutputDisplay.printResult();
    }

    public static void main(String[] args) {
        Main.run();
    }
}
