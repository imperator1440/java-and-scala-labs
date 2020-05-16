package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Vector;

public class Main extends Application {

    FlyControlCenter center ;

    @Override
    public void stop()
    {
        center.closeAll();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }

    public void start(Stage stage){
        Button addAirplane = new Button("Создать самолёт");
        Text info = new Text("Состояние полос:");
        Vector<Text> state = new Vector<>();
        for (int i = 0; i < 5; i++){

            state.addElement(new Text("Полоса " + (i + 1) + ": Свободна"));
        }

        center = new FlyControlCenter();

        addAirplane.setOnAction(actionEvent -> {

            if(center.isRunwayFree())
            {
                Airplanes airplane = new Airplanes(center, state);
                center.addAirplane(airplane);
            }

        });



        VBox group = new VBox();
        group.getChildren().addAll(addAirplane, info);
        for (int i = 0; i < state.size(); i++) {
            group.getChildren().add(state.elementAt(i));
        }
        group.setSpacing(10);

        group.translateXProperty().set(15);
        group.translateYProperty().set(15);


        Scene scene = new Scene(group, 150, 250);
        stage.setResizable(false);
        scene.setFill(Color.rgb(244, 244, 244));
        stage.setScene(scene);
        stage.setTitle("Вариант 30");
        stage.show();

    }
}
