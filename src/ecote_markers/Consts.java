package ecote_markers;

//constants for the program
public final class Consts {
    //errors
    public static final String ERR_NO_FILE = "No file submitted!";
    public static final String ERR_FILE_NOT_FOUND = "File not found!";
    public static final String ERR_WRONG_FILETYPE = "Only text (.txt) files allowed!";
    public static final String ERR_IN_LINE = "Error: in line ";//+ lineNumber
    public static final String ERR_WRONG_NAME = " name contains a special character ";
    public static final String ERR_EMPTY_NAME = " marker name is empty ";
    public static final String ERR_BAD_NESTING = " marker is not properly nested\n";
    public static final String ERR_NO_CLOSING = " marker is not closed\n";
    public static final String ERR_NO_OPENING = " closing marker without opening\n";

    //messages
    public static final String MSG_NO_MARKERS = ": no markers found!";
    public static final String MSG_MARKER_TYPE = "(marker type: ";
    public static final String MSG_FILE = "File: ";//+ filename
    public static final String MSG_CORRECT_FILE = " has a correct structure of markers";
    public static final String MSG_INPUT_FILE = "Write path to a text (.txt) file\n(you can use path" +
            " \".\\input_files\\[filename]\" to use one of the test files already prepared):\n";

    public static final char[] SPECIAL_CHARS = {'/', '*', '!', '@' , '#', '$', '%', '&',
            '(', ')', '-', '+', '=', '~', '`', '{', '}', '[', ']',
            ';', ':', '\'', '\"', '\\', '|', ',', '.', '<', '>',
            '?', '\n', '\t', ' '};

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
    public static final String TOO_MANY_CLOSINGS = "./input_files/too_many_closings.txt";
    public static final String HUGE_XML_OK = "./input_files/huge_xml_ok.txt";
    public static final String HUGE_XML_WRONG = "./input_files/huge_xml_wrong.txt";
    public static final String VERY_BIG_XML = "./input_files/very_big_xml.txt";
}
