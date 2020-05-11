package ecote_markers;

public class AnalyseFile {
    //will use stack for opening/closing markers
    public static void findMarkers(String text){
        //go through whole text
        String markerName = "";
        int textLength = text.length();
        for(int i=0;i<textLength;i++){
            char c = text.charAt(i);
            if(c == '<'){
                //move to next char
                i++;
                //in between <> is marker name
                while(c != '>') {
                    c = text.charAt(i);
                    if(c == '>')
                        break;
                    markerName = markerName + c;
                    i++;//i jakos potem wyczyscic marker name
                }
            }
        }
    }

    //this one will be used in findMarkers
    //analyses a single marker
    private static void analyseMarker(Marker marker){
    }


}
