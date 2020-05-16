package com.company;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {

        User user = new User();
        VideoHosting videoHost = new VideoHosting();
        CheckBox catsCB = new CheckBox("Котики");
        catsCB.fire();
        CheckBox dogsCB = new CheckBox("Собачки");
        CheckBox musicallyCB = new CheckBox("Музыкальное видео");
        TextField nameTf = new TextField();
        nameTf.setPromptText("Название видео");
        TextField lengthTf = new TextField();
        lengthTf.setPromptText("Длинна");
        TextField playlistNameTf = new TextField();
        playlistNameTf.setPromptText("Название плейлиста");
        Button addVideoBt = new Button("Создать видео");
        ListView<String> videosList = new ListView<>();
        videosList.setPrefSize(570, 150);
        MultipleSelectionModel<String> videoSelectionModel = videosList.getSelectionModel();
        ListView<String> playlistsList = new ListView<>();
        playlistsList.setPrefSize(570, 150);
        MultipleSelectionModel<String> playlistSelectionModel = playlistsList.getSelectionModel();
        Button watchVideo = new Button("Смотреть видео");
        Button delVideo = new Button("Удалить видео");
        Button createPlaylist = new Button("Создать плейлист");
        Button addVideoToPlaylist = new Button("Добавить в плейлист");
        Button watchPlaylist = new Button("Воспроизвести плейлист");
        Text state = new Text();

        catsCB.setOnAction(actionEvent -> {
            if (catsCB.isSelected()) {
                dogsCB.setSelected(false);
                musicallyCB.setSelected(false);
            }
            if(!catsCB.isSelected()) catsCB.setSelected(true);
        });

        dogsCB.setOnAction(actionEvent -> {
            if (dogsCB.isSelected()) {
                catsCB.setSelected(false);
                musicallyCB.setSelected(false);
            }
            if(!dogsCB.isSelected()) dogsCB.setSelected(true);
        });

        musicallyCB.setOnAction(actionEvent -> {
            if (musicallyCB.isSelected()) {
                catsCB.setSelected(false);
                dogsCB.setSelected(false);
            }
            if(!musicallyCB.isSelected()) musicallyCB.setSelected(true);
        });

        addVideoBt.setOnAction(actionEvent -> {
                user.createVideo(lengthTf.getText(), nameTf.getText(), videoHost, catsCB, dogsCB, musicallyCB);
                videosList.setItems(videoHost.listVideo());
        });

        watchVideo.setOnAction(actionEvent -> {
            user.watchVideo(videoHost.videoVector.elementAt(videoSelectionModel.getSelectedIndex()), state, videoSelectionModel);
            videosList.getSelectionModel().clearSelection();
        });

        delVideo.setOnAction(actionEvent -> {
            user.deleteVideo(videosList, state, videoHost, videoSelectionModel);
            videosList.getSelectionModel().clearSelection();
        });

        createPlaylist.setOnAction(actionEvent -> {
            playlistsList.setItems(user.createPlaylist(videoHost, playlistNameTf, videoSelectionModel));
        });

        addVideoToPlaylist.setOnAction(actionEvent -> {
            user.addVideoToPlaylist(videoSelectionModel, playlistSelectionModel, videoHost);
        });

        watchPlaylist.setOnAction(actionEvent -> {
            videoHost.playlistVector.elementAt(playlistSelectionModel.getSelectedIndex()).playPlaylist(videoHost,
                    playlistSelectionModel, state);
        });

        BooleanBinding videoNameValid = Bindings.createBooleanBinding(()->{
            return !nameTf.getText().isEmpty();
        }, nameTf.textProperty());

        BooleanBinding videoLengthValid = Bindings.createBooleanBinding(()->{
            int counterOfAlphabetic = 0;
            for (int i = 0; i < lengthTf.getText().length(); i++) {
                        if (Character.isAlphabetic(lengthTf.getText().charAt(i))) {
                            counterOfAlphabetic++;
                }
            }
            return !lengthTf.getText().isEmpty() && !(counterOfAlphabetic > 0);
        }, lengthTf.textProperty());

        BooleanBinding playlistTFValid = Bindings.createBooleanBinding(()->{
            return !playlistNameTf.getText().isEmpty();
        }, playlistNameTf.textProperty());

        BooleanBinding videoListValid = Bindings.createBooleanBinding(()->{
            return !videoSelectionModel.isEmpty();
        }, videoSelectionModel.selectedItemProperty());

        BooleanBinding playlistListValid = Bindings.createBooleanBinding(()->{
            return !playlistSelectionModel.isEmpty();
        }, playlistSelectionModel.selectedItemProperty());

        addVideoBt.disableProperty().bind(videoNameValid.not().or(videoLengthValid.not()));

        createPlaylist.disableProperty().bind(playlistTFValid.not().or(videoListValid.not()));

        addVideoToPlaylist.disableProperty().bind(playlistListValid.not().or(videoListValid.not()));

        watchPlaylist.disableProperty().bind(playlistListValid.not());

        watchVideo.disableProperty().bind(videoListValid.not());

        delVideo.disableProperty().bind(videoListValid.not());

        HBox listVideo = new HBox(videosList);

        HBox typeOfVideo = new HBox(catsCB, dogsCB, musicallyCB);
        typeOfVideo.setSpacing(10);

        HBox input = new HBox(nameTf, lengthTf, addVideoBt);
        input.setSpacing(15);

        HBox actionButtons = new HBox(watchVideo, delVideo);
        actionButtons.setSpacing(10);

        HBox createPlaylistHB = new HBox(playlistNameTf, createPlaylist, addVideoToPlaylist, watchPlaylist);
        createPlaylistHB.setSpacing(10);

        HBox playlistCheck = new HBox(playlistsList);

        HBox myState = new HBox(state);

        VBox group = new VBox();
        group.getChildren().addAll(typeOfVideo, input, listVideo, actionButtons, createPlaylistHB, playlistCheck, myState);
        group.setSpacing(10);

        group.translateXProperty().set(15);
        group.translateYProperty().set(15);

        Scene scene = new Scene(group, 600, 800);
        stage.setResizable(false);
        scene.setFill(Color.rgb(244, 244, 244));
        stage.setScene(scene);
        stage.setTitle("Вариант 30");
        stage.show();
    }
}
