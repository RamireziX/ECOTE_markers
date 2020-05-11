package ecote_markers;

//constants for the program
public final class Consts {
    //errors
    public static final String ERR_NO_FILE = "No file submitted!";
    public static final String ERR_FILE_NOT_FOUND = "File not found!";
    public static final String ERR_WRONG_FILETYPE = "Only text (.txt) files allowed!";
    public static final String ERR_IN_LINE = "Error: in line ";//+ lineNumber
    public static final String ERR_WRONG_NAME = " name contains a special character";
    public static final String ERR_EMPTY_NAME = " marker name is empty";
    public static final String ERR_NO_CLOSING = " does not have a closing";
    public static final String ERR_BAD_NESTING = " is incorrectly nested";

    //messages
    public static final String MSG_NO_MARKERS = ": no markers found!";
    public static final String MSG_FILE = "File: ";//+ filename
    public static final String MSG_CORRECT_FILE = " has a correct structure of markers";

    //filepaths for testing (potem może przerobić na relative filepath)
    public static final String NO_TEXT_OK =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\no_text_ok.txt";
    public static final String WRONG_PATH =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_filezzzzzz\\file1.txt";
    public static final String WRONG_FILE =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\wrong_file.exe";
    public static final String EMPTY_FILE =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\empty.txt";
    public static final String SIMPLE_OK =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\simple_ok.txt";
    public static final String SIMPLE_WRONG_NAME =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\simple_wrong_name.txt";
    public static final String NO_CLOSING =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\no_closing.txt";
    public static final String NESTED_OK =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\nested_ok.txt";
    public static final String NESTED_WRONG =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\nested_wrong.txt";
    public static final String EMPTY_NAME =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\empty_name.txt";
    public static final String MULTIPLE_LINES_OK =
            "C:\\Users\\Olek\\Desktop\\ECOTE_markers\\input_files\\multiple_lines_ok.txt";
}
