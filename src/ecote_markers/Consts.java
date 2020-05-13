package ecote_markers;

//constants for the program
public final class Consts {
    //errors
    public static final String ERR_NO_FILE = "No file submitted!";
    public static final String ERR_FILE_NOT_FOUND = "File not found!";
    public static final String ERR_WRONG_FILETYPE = "Only text (.txt) files allowed!";
    public static final String ERR_IN_LINE = "Error: in line ";//+ lineNumber
    public static final String ERR_WRONG_NAME = " name contains a special character\n";
    public static final String ERR_EMPTY_NAME = " marker name is empty\n";
    public static final String ERR_BAD_NESTING = "Error: file contains markers that" +
            " are improperly nested or not closed\n";

    //messages
    public static final String MSG_NO_MARKERS = ": no markers found!";
    public static final String MSG_FILE = "File: ";//+ filename
    public static final String MSG_CORRECT_FILE = " has a correct structure of markers";

    //filepaths for testing
    public static final String NO_TEXT_OK = "./input_files/no_text_ok.txt";
    public static final String WRONG_PATH = "./input_files/file1.txt";
    public static final String WRONG_FILE = "./input_files/wrong_file.exe";
    public static final String EMPTY_FILE = "./input_files/empty.txt";
    public static final String SIMPLE_OK = "./input_files/simple_ok.txt";
    public static final String SIMPLE_WRONG_NAME = "./input_files/simple_wrong_name.txt";
    public static final String NO_CLOSING = "./input_files/no_closing.txt";
    public static final String NESTED_OK = "./input_files/nested_ok.txt";
    public static final String NESTED_WRONG = "./input_files/nested_wrong.txt";
    public static final String EMPTY_NAME = "./input_files/empty_name.txt";
    public static final String MULTIPLE_LINES_OK = "./input_files/multiple_lines_ok.txt";
    public static final String BIG_XML_OK = "./input_files/big_xml.txt";
    public static final String BIG_XML_BAD_CLOSINGS = "./input_files/big_xml_bad_closings.txt";
}
