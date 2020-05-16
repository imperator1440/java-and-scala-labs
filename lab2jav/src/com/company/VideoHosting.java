package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import videos.Video;

import java.util.Vector;

public class VideoHosting  {
    Vector<Video> videoVector;
    Vector<Playlist> playlistVector;
    VideoHosting(){
        videoVector = new Vector<>();
        playlistVector = new Vector<>();
    }

    public Vector<Playlist> getPlaylistVector() {
        return playlistVector;
    }

    public Vector<Video> getVideoVector() {
        return videoVector;
    }

    public void addVideo(Video newVideo)
    {

        getVideoVector().add(newVideo);
    }

    public String playVideo()
    {
        return("    Пошло воспроизведение");
    }

    public ObservableList<String> listVideo()
   {
       ObservableList<String> addElem = FXCollections.observableArrayList();
       for (int i = 0; i < getVideoVector().size(); i++) {
           addElem.add(getVideoVector().elementAt(i).getName() + "    " + getVideoVector().elementAt(i).getLength());
       }
       return addElem;
    }
}
