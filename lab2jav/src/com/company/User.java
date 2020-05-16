package com.company;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import videos.MusicallyVideo;
import videos.Video;
import videos.VideoWithCats;
import videos.VideoWithDogs;


public class User {
    User() {
    }

    public void createVideo(String length, String name, VideoHosting addNewVideo, CheckBox cats,
                            CheckBox dogs, CheckBox musically) {
        if (cats.isSelected()) {
            VideoWithCats newVideoWithCats = new VideoWithCats(Integer.parseInt(length), name);
            addNewVideo.addVideo(newVideoWithCats);
        }
        if (dogs.isSelected()) {
            VideoWithDogs newVideoWithDogs = new VideoWithDogs(Integer.parseInt(length), name);
            addNewVideo.addVideo(newVideoWithDogs);
        }
        if (musically.isSelected()) {
            MusicallyVideo newMusicallyVideo = new MusicallyVideo(Integer.parseInt(length), name);
            addNewVideo.addVideo(newMusicallyVideo);
        }
    }

    public void watchVideo(Video video, Text state, MultipleSelectionModel<String> videoSelectionModel) {
        VideoHosting play = new VideoHosting();
        state.setText("Смотрим видео: " + video.getName() + "   " + video.getLength() + play.playVideo());
    }

    public void deleteVideo(ListView<String> list, Text state, VideoHosting videoHost,
                            MultipleSelectionModel<String> videoSelectionModel) {
        if (!videoSelectionModel.isEmpty()) {
            videoHost.getVideoVector().remove(videoSelectionModel.getSelectedIndex());
            list.getItems().remove(videoSelectionModel.getSelectedItem());
            state.setText("Состояние: Видео удалено");
        }
    }

    public ObservableList<String> createPlaylist(VideoHosting videoHost, TextField playlistNameTf,
                                                 MultipleSelectionModel<String> videoSelectionModel) {
        ObservableList<String> addElem = FXCollections.observableArrayList();
        Playlist playlist = new Playlist(playlistNameTf.getText());
        videoHost.getPlaylistVector().add(playlist);
        if (!videoSelectionModel.isEmpty()) {
            playlist.getPlaylistVideoVector().add(videoHost.getVideoVector().elementAt(videoSelectionModel.getSelectedIndex()));
            for (int i = 0; i < videoHost.getPlaylistVector().size(); i++) {
                addElem.add(videoHost.getPlaylistVector().elementAt(i).name);
            }
        }
        return addElem;
    }

    public void addVideoToPlaylist(MultipleSelectionModel<String> videoSelectionModel
            , MultipleSelectionModel<String> playlistSelectionModel, VideoHosting videoHost) {
        if (!videoSelectionModel.isEmpty() && !playlistSelectionModel.isEmpty()) {
            videoHost.getPlaylistVector().elementAt(playlistSelectionModel.getSelectedIndex()).addVideo(videoHost.getVideoVector().elementAt(videoSelectionModel.getSelectedIndex()));
        }
    }
}