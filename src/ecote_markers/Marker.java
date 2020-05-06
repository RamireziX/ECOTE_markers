package ecote_markers;

public class Marker {
    private int id, lineOfOccurence;
    private String name;
    private Type type;

    public Marker(int id, int lineOfOccurence, String name, Type type) {
        this.id = id;
        this.lineOfOccurence = lineOfOccurence;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLineOfOccurence() {
        return lineOfOccurence;
    }

    public void setLineOfOccurence(int lineOfOccurence) {
        this.lineOfOccurence = lineOfOccurence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
