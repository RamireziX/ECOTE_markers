package ecote_markers;

public class Main {

    public static void run(){
        String textFromFile =
                ReadFile.readFile(/*Consts.NO_TEXT_OK*/Consts.NESTED_OK);
        AnalyseFile.findMarkers(textFromFile);
    }

    public static void main(String[] args) {
        Main.run();
    }
}
