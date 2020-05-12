package ecote_markers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReadFile {
    public static String readFile(String pathToFile) {
        String textFromFile = null;
        //empty filename
        if(pathToFile.isEmpty()) {
            System.err.print(Consts.ERR_NO_FILE);
            System.exit(0);
        }
        //check, if file is .txt or not
        if(pathToFile.endsWith(".txt")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
                textFromFile = reader.lines().
                        collect(Collectors.joining(System.lineSeparator()));
            //file not found
            } catch (IOException e) {
                System.err.print(Consts.ERR_FILE_NOT_FOUND);
                System.exit(0);
            }
        }
        //not a txt file
        else {
            System.err.print(Consts.ERR_WRONG_FILETYPE);
            System.exit(0);
        }
        return textFromFile;
    }
}
