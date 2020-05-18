package ecote_markers;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//TODO: findMarkers is too long, make some helper methods to reduce duplicate code
public class AnalyseFile {

    //finds markers and checks nesting and closing
    public static void findMarkers(String text){
        StringBuilder markerName = new StringBuilder();
        int lineOfOccurence = 1;
        Type typeOfMarker = Type.OPEN;
        //stack for nesting check
        Stack<Marker> stack = new Stack<>();
        //keep track of markers that are never closed
        List<Marker> notClosed = new LinkedList<>();
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
                //analyse marker's correctness (special characters etc)
                analyseMarker(marker);
                //analyse nesting
                //handle closing marker
                if(marker.getType() == Type.CLOSE) {
                    if (!stack.isEmpty()) {
                        //proper nesting/closing, pop
                        if (marker.getName().equals(stack.peek().getName())) {
                            notClosed.remove(stack.peek());
                            stack.pop();
                        }
                        //check, if and where improper nesting happened
                        //or if no closing marker
                        else {
                            Stack<Marker> tempStack = (Stack<Marker>) stack.clone();
                            while (!tempStack.isEmpty()) {
                                tempStack.pop();
                                //closing marker with no opening
                                if (tempStack.isEmpty()) {
                                    InputOutput.addTextToDescription(Consts.ERR_IN_LINE +
                                            marker.getLineOfOccurence()
                                            + " - " + "'" +
                                            marker.getName() + "':" +
                                            Consts.ERR_NO_OPENING);
                                    break;
                                }
                                //found closing, with improper nesting
                                else if (marker.getName().equals(tempStack.peek().getName())) {
                                    InputOutput.addTextToDescriptionNoRepeat(Consts.ERR_IN_LINE +
                                            stack.peek().getLineOfOccurence()
                                            + " - " + "'" +
                                            stack.peek().getName() + "':" +
                                            Consts.ERR_BAD_NESTING);
                                    notClosed.remove(tempStack.peek());
                                    break;
                                }//no closing found, stays on notClosed list
                            }
                        }
                    }
                    else{
                        //closing marker without opening (when stack was emptied)
                        InputOutput.addTextToDescription(Consts.ERR_IN_LINE +
                                marker.getLineOfOccurence()
                                + " - " + "'" +
                                marker.getName() + "':" +
                                Consts.ERR_NO_OPENING);
                    }
                }
                //handle opening marker
                else {
                    //push only opening markers
                    stack.push(marker);
                    //assume it's not closed yet
                    notClosed.add(marker);
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
       //there are markers that have no closing in whole file
        if(!notClosed.isEmpty()){
            for(Marker marker : notClosed) {
                //when is not closed, its also not properly nested
                //however, no need to print this error
                InputOutput.removeTextFromDescription(Consts.ERR_IN_LINE +
                        marker.getLineOfOccurence() + " - " + "'" +
                        marker.getName() + "':" + Consts.ERR_BAD_NESTING);
                InputOutput.addTextToDescriptionNoRepeat(Consts.ERR_IN_LINE +
                        marker.getLineOfOccurence() + " - " + "'" +
                        marker.getName() + "':" + Consts.ERR_NO_CLOSING);
            }
        }
        //no markers found at all
        if(Marker.noOfMarkers == 0) {
            System.out.print(Consts.MSG_FILE);
            System.out.print(Main.FILENAME);
            System.out.print(Consts.MSG_NO_MARKERS);
            System.exit(0);
        }
    }

    //methods used in findMarkers

    //analyses a single marker
    private static void analyseMarker(Marker marker){
        char[] specialChars = {'/', '*', '!', '@' , '#', '$', '%', '&',
                '(', ')', '-', '+', '=', '~', '`', '{', '}', '[', ']',
                ';', ':', '\'', '\"', '\\', '|', ',', '.', '<', '>',
                '?', '\n', '\t', ' '};
        //check if marker is empty
        if(marker.getName().isEmpty()) {
            InputOutput.addTextToDescriptionNoRepeat(Consts.ERR_IN_LINE +
                    marker.getLineOfOccurence() + " -" + Consts.ERR_EMPTY_NAME +
                    Consts.MSG_MARKER_TYPE + marker.getType().toString() + ")\n");
        }
        //check if marker contains special characters (except for '_')
        for (char specialChar : specialChars) {
            if (marker.getName().contains(String.valueOf(specialChar))) {
                InputOutput.addTextToDescriptionNoRepeat(Consts.ERR_IN_LINE +
                        marker.getLineOfOccurence() + " - " + "'" +
                        marker.getName() + "':" + Consts.ERR_WRONG_NAME +
                        Consts.MSG_MARKER_TYPE + marker.getType().toString() + ")\n");
            }
        }
    }


}
