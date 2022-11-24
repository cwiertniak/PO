package agh.ics.oop.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage primaryStage){
        //primaryStage.show();
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Label label = new Label("Zwierzak");
        Scene scene = new Scene(label, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
