package ecote_markers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ReadFile {
    public static String readFile(String pathToFile) {
        String textFromFile = null;
            try(BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
                textFromFile = reader.lines().
                        collect(Collectors.joining(System.lineSeparator()));
            }
            catch (IOException e) {
                System.err.println(Consts.ERR_FILE_NOT_FOUND);
                System.exit(0);
            }
        return textFromFile;
    }
}
