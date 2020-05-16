package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        VBox group = new VBox();
        TextField denominatorTf = new TextField();
        TextField numeratorTf = new TextField();
        Button divide = new Button("Поделить");
        Text denominator = new Text("Делитель");
        Text numerator = new Text("Делимое");
        Text quotient = new Text("Частное:  ");
        Text balance = new Text("Остаток:  ");
        Text quotientAns = new Text();
        Text balanceAns = new Text();

        divide.setOnAction(actionEvent -> {
            int numberCounterOfNumerator = 0;
            int numberCounterOfDenominator = 0;
            String numeratorSt = numeratorTf.getText();
            String denominatorSt = denominatorTf.getText();
            for (int i = 0; i < numeratorSt.length(); i++) {
                if(Character.isDigit(numeratorSt.charAt(i))){
                    numberCounterOfNumerator++;
                }
            }
            for (int i = 0; i < denominatorSt.length(); i++) {
                if(Character.isDigit(denominatorSt.charAt(i))){
                    numberCounterOfDenominator++;
                }
            }
            if(numberCounterOfNumerator<numeratorSt.length() ||   numberCounterOfDenominator  < denominatorSt.length()
                    || numeratorSt.length()==0 || denominatorSt.length()==0) {
                quotientAns.setText("Ошибка");
                balanceAns.setText("Ошибка");
            }else{
                int numeratorValue = Integer.parseInt(numeratorTf.getText());
                int denominatorValue = Integer.parseInt(denominatorTf.getText());
                quotientAns.setText("" + numeratorValue / denominatorValue);
                balanceAns.setText("" + numeratorValue % denominatorValue);}

        });

        group.setSpacing(10);

        HBox numeratorBox = new HBox(numerator, numeratorTf);
        numeratorBox.setSpacing(4);
        group.getChildren().add(numeratorBox);

        HBox denominatorBox = new HBox(denominator, denominatorTf, divide);
        denominatorBox.setSpacing(2);
        group.getChildren().add(denominatorBox);


        HBox quo = new HBox(quotient, quotientAns);
        quo.setSpacing(2);

        HBox balanceBox = new HBox(balance, balanceAns);
        balanceBox.setSpacing(2);

        HBox answer = new HBox(quo, balanceBox);
        answer.setSpacing(70);
        group.getChildren().add(answer);

        group.translateXProperty().set(15);
        group.translateYProperty().set(15);
        Scene scene = new Scene(group, 300, 120);
        stage.setResizable(false);
        scene.setFill(Color.rgb(244, 244, 244));
        stage.setScene(scene);
        stage.setTitle("Вариант 30");
        stage.show();
    }
}