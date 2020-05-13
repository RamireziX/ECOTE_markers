package ecote_markers;

import java.util.Stack;

public class AnalyseFile {

    //finds markers and checks nesting and closing
    public static void findMarkers(String text){
        StringBuilder markerName = new StringBuilder();
        int lineOfOccurence = 1;
        Type typeOfMarker = Type.OPEN;
        //stack for nesting check
        Stack<Marker> stack = new Stack<>();
        //go through whole text
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            //marker found
            if(c == '<'){
                //move to next char
                i++;
                c = text.charAt(i);
                //check if it's a closing marker
                if(c == '/'){
                    typeOfMarker = Type.CLOSE;
                    i++;
                }
                //in between <> is marker name
                while(true) {
                    c = text.charAt(i);
                    //loop until end of marker is found
                    if (c == '>')
                        break;
                    markerName.append(c);
                    i++;
                }
                //create new marker
                Marker marker = new Marker(
                        lineOfOccurence, markerName.toString(), typeOfMarker);
                //analyse nesting
                //handle closing marker
                if(marker.getType() == Type.CLOSE){
                    //proper nesting/closing, pop
                    if(marker.getName().equals(stack.peek().getName()))
                        stack.pop();
                }

                //handle opening marker
                else {
                    //analyse marker's correctness
                    //only for opening
                    //if closing has wrong name, nesting/closing error
                    analyseMarker(marker);
                    //push only opening markers
                    stack.push(marker);
                }
                //clear for next marker name
                //and reset type
                markerName = new StringBuilder();
                typeOfMarker = Type.OPEN;
            }
            //newline character found
            else if(c == '\n')
                lineOfOccurence ++;
        }
        //stack should always be empty at the end
        //if not empty, there are markers without closing
        //or not properly nested
        if(!stack.empty())
            InputOutput.addTextToDescription(Consts.ERR_BAD_NESTING);
        //no markers found
        if(Marker.noOfMarkers == 0) {
            System.out.print(Consts.MSG_FILE);
            System.out.print(Main.FILENAME);
            System.out.print(Consts.MSG_NO_MARKERS);
            System.exit(0);
        }
    }

    //analyses a single marker
    private static void analyseMarker(Marker marker){
        char[] specialChars = {'/', '*', '!', '@' , '#', '$', '%', '&',
                '(', ')', '-', '+', '=', '~', '`', '{', '}', '[', ']',
                ';', ':', '\'', '\"', '\\', '|', ',', '.', '<', '>',
                '?', '\n', '\t', ' '};
        //check if marker is empty
        if(marker.getName().isEmpty()) {
            InputOutput.addTextToDescription(Consts.ERR_IN_LINE);
            InputOutput.addTextToDescription(marker.getLineOfOccurence() + " -");
            InputOutput.addTextToDescription(Consts.ERR_EMPTY_NAME);
        }
        //check if marker contains special characters (except for '_')
        for (char specialChar : specialChars) {
            if (marker.getName().contains(String.valueOf(specialChar))) {
                InputOutput.addTextToDescription(Consts.ERR_IN_LINE);
                InputOutput.addTextToDescription(marker.getLineOfOccurence() +
                        " - " + "'" + marker.getName() + "':");
                InputOutput.addTextToDescription(Consts.ERR_WRONG_NAME);
            }
        }
    }


}
