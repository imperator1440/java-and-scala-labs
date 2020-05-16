package videos;


public class VideoWithCats extends Video {
    public VideoWithCats(int length, String name){
     this.setLength(length);
     this.setName(name);
    }
    public String toString()
    {
        return getName()+" котики";
    }
}
