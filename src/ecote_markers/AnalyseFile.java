package ecote_markers;

import java.util.Stack;

public class AnalyseFile {
    //TODO: pierdzieli sie jak sa te same nazwy markerow i nie wie czy sa bad nested czy not closed
    //można to ogarnąć jakoś przy sprawdzania nestowania, może rzeczywiście te has closing
    //albo jednak upakować te no closing i incorrect nesting w jeden błąd
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
                //analyse marker's correctness
                analyseMarker(marker);
                //analyse nesting
                //handle closing marker
                if(marker.getType() == Type.CLOSE){
                    if(marker.getName().equals(stack.peek().getName())) {
                        stack.pop();
                    }
                    else {
                        //potem jakos to dodac to raportu
                        //z wszystkimi bledami
                        //do raportu daj marker name z top stacka
                        //bo to jest "jego" błąd -> no właśnie niekoniecznie prawda
                        OutputDisplay.addTextToDescription(Consts.ERR_IN_LINE);
                        OutputDisplay.addTextToDescription(
                                Integer.toString(stack.peek().getLineOfOccurence()));
                        OutputDisplay.addTextToDescription("'"+stack.peek().getName()+"'");
                        OutputDisplay.addTextToDescription(Consts.ERR_BAD_NESTING);
                        //System.out.println(Consts.ERR_BAD_CLOSING);
                        //pop too, because we still want to process
                        //the rest of the markers
                        stack.pop();
                    }
                }
                //handle opening marker
                else {
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
        // może gdzieś indziej sprawdzać stack size
        /*if(!stack.empty()){
            for(int i=0;i<stack.size();i++){
                OutputDisplay.addTextToDescription(Consts.ERR_IN_LINE);
                //tu wez line of occurence z markera z top stacku debilu
                OutputDisplay.addTextToDescription(
                        Integer.toString(stack.peek().getLineOfOccurence()));
                OutputDisplay.addTextToDescription("'"+stack.peek().getName()+"'");
                OutputDisplay.addTextToDescription(Consts.ERR_NO_CLOSING);
                stack.pop();
            }
        }*/
    }

    //analyses a single marker
    private static void analyseMarker(Marker marker){
    }


}
