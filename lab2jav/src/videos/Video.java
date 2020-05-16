package videos;

public abstract class Video {
    protected String name;
    protected int length;
    Video(){}
    public void setName(String name) {
        this.name = name;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public String getName() {
        return name;
    }
}
