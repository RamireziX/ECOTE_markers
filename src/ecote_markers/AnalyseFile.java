package ecote_markers;

import java.util.Stack;

public class AnalyseFile {
    public static void findMarkers(String text){
        StringBuilder markerName = new StringBuilder();
        int lineOfOccurence = 1;
        Type typeOfMarker = Type.OPEN;
        //stack for nesting check
        Stack<Marker> stack = new Stack<>();
        int textLength = text.length();

        //go through whole text
        for(int i=0;i<textLength;i++){
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
                    //tez sprawdzic newline do line of occurence
                    //loop until end of marker is found
                    if (c == '>')
                        break;
                    markerName.append(c);
                    i++;
                }
                //create new marker
                Marker marker = new Marker(
                        lineOfOccurence, markerName.toString(), typeOfMarker);
                //handle closing marker
                if(marker.getType() == Type.CLOSE){
                    if(marker.getName().equals(stack.peek().getName())) {
                        stack.pop();
                        System.out.println("todo bien");
                    }
                    else {
                        //potem jakos to dodac to raportu
                        //z wszystkimi bledami
                        System.out.println(Consts.ERR_BAD_NESTING);
                        //tez pop bo sprawdzamy reszte stacku
                        stack.pop();
                    }
                }
                //handle opening marker
                else {
                    //push only opening markers
                    stack.push(marker);
                }
                //clear for next marker name
                markerName = new StringBuilder();
            }
        }
    }

    //this one will be used in findMarkers
    //analyses a single marker
    private static void analyseMarker(Marker marker){
    }


}
