package com.company;

import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.text.Text;
import videos.Video;

import java.util.Vector;

public class Playlist {
    Vector<Video> playlistVideoVector;
    String name;
    Playlist(String name){
        this.name = name ;
        playlistVideoVector = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public Vector<Video> getPlaylistVideoVector() {
        return playlistVideoVector;
    }

    public Playlist addVideo(Video video){
       this.getPlaylistVideoVector().add(video);
       return this;
    }

    public void playPlaylist(VideoHosting videoHost, MultipleSelectionModel playlistSelectionModel, Text state){
        int index=0;
        String videos="\n";
        while (videoHost.getPlaylistVector().elementAt(playlistSelectionModel.getSelectedIndex()).getPlaylistVideoVector().size()>index) {
            videos += nextVideo(index, playlistSelectionModel, videoHost) + "\n";
            index++;
        }
        state.setText("Смотрим видео: " + videos);
    }

    private String nextVideo(int index, MultipleSelectionModel playlistSelectionModel, VideoHosting videoHost){
        return videoHost.getPlaylistVector().elementAt(playlistSelectionModel.getSelectedIndex()).getPlaylistVideoVector().elementAt(index).toString();
    }
}
