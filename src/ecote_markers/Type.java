package ecote_markers;

//type of marker
public enum Type {
    OPEN {
        public String toString() {
            return "opening";
        }
    },
    CLOSE{
        public String toString() {
            return "closing";
        }
    }
}
