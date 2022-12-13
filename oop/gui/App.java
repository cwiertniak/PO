package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {
    AbstractWorldMap map;
    GridPane gridPane;
    Vector2d upperBound;
    Vector2d lowerBound;

    public void start(Stage primaryStage) {
        Vector2d[] positions = {new Vector2d(2, 3), new Vector2d(4, 5)};
        gridPane = new GridPane();
        TextField textField = new TextField();
        Button button = new Button("Start");
        VBox vBox = new VBox(textField, button);
        HBox hBox = new HBox(vBox, gridPane);
        Scene scene = new Scene(hBox, 800, 600);
        gridPane.setAlignment(Pos.TOP_CENTER);
        primaryStage.setScene(scene);
        primaryStage.show();
        button.setOnAction((event -> {
            map = new GrassField(20);
            String args = textField.getText();
            lowerBound = map.getLowBoundary();
            upperBound = map.getUpBoundary();
            SimulationEngine engine =
                    new SimulationEngine(new OptionsParser().parse(textField.getText().split(" ")), map, positions, this);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        }));
    }

    public void showMap(){
        gridPane.setGridLinesVisible(false);
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getChildren().clear();
        gridPane.setGridLinesVisible(true);
        makeGrid(gridPane, lowerBound, upperBound);
        addElements(gridPane, lowerBound, upperBound);
    }

    private void makeGrid(GridPane gridPane, Vector2d lowBoundary, Vector2d upBoundary){

        Label label;
        gridPane.getColumnConstraints().add(new ColumnConstraints(40));
        label = new Label("y/x");
        gridPane.addColumn(0, label);
        GridPane.setHalignment(label, HPos.CENTER);

        int i = 1;
        int n = upperBound.x - lowerBound.x + 2;
        while (i < n){
            label = new Label(String.valueOf(lowerBound.x + i - 1));
            gridPane.getColumnConstraints().add(new ColumnConstraints(40));
            gridPane.addColumn(i, label);
            GridPane.setHalignment(label, HPos.CENTER);
            i++;
        }

        int j = 1;
        int m = upperBound.y - lowerBound.y + 2;
        while (j < m){
            gridPane.addRow(j);
            gridPane.getRowConstraints().add(new RowConstraints(40));
            label = new Label(String.valueOf(upperBound.y - j + 1));
            gridPane.add(label, 0, j);
            GridPane.setHalignment(label, HPos.CENTER);
            j++;
        }
    }
    private void addElements(GridPane gridPane, Vector2d lowerBound, Vector2d upperBound){
        int n = upperBound.x - lowerBound.x + 2;
        int m = upperBound.y - lowerBound.y + 2;
        int j = 1;
        while (j < m){
            int i = 1;
            VBox vBox;
            while (i < n){
                Vector2d position = new Vector2d(lowerBound.x + i - 1, upperBound.y - j + 1);
                if (map.isOccupied(position)){
                    vBox = new GuiElementBox((IMapElement) map.objectAt(position)).getVBox();
                    GridPane.setHalignment(vBox, HPos.CENTER);
                    gridPane.add(vBox, i, j);
                }
                i++;
            }
            j++;
        }
    }

    /*public void start(Stage primaryStage){
        //primaryStage.show();
        /*ArrayList<MoveDirection> directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
        GrassField map = new GrassField(15);
        Animal animal1 = new Animal(map, new Vector2d(3, 2));
        map.place(animal1);
        Animal animal2 = new Animal(map, new Vector2d(1, 2));
        map.place(animal2);
        System.out.println(map);

        Vector2d upperBound = map.getUpBoundary();
        Vector2d lowerBound = map.getLowBoundary();

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        //Label label = new Label("Zwierzak");
        Label label;

        Scene scene = new Scene(gridPane, 400, 400);
        gridPane.getColumnConstraints().add(new ColumnConstraints(20));
        gridPane.addColumn(0, new Label("y/x"));

        int i = 1;
        int n = upperBound.x - lowerBound.x + 2;
        while (i < n){
            label = new Label(String.valueOf(lowerBound.x + i - 1));
            gridPane.getColumnConstraints().add(new ColumnConstraints(20));
            gridPane.addColumn(i, label);
            GridPane.setHalignment(label, HPos.CENTER);
            i++;
        }

        int j = 1;
        int m = upperBound.y - lowerBound.y + 2;
        while (j < m){
            gridPane.addRow(j);
            label = new Label(String.valueOf(upperBound.y - j + 1));
            gridPane.add(label, 0, j);
            GridPane.setHalignment(label, HPos.CENTER);

            i = 1;
            while (i < n){
                Vector2d position = new Vector2d(lowerBound.x + i - 1, upperBound.y - j + 1);
                if(map.isOccupied(position)){
                    label = new Label(map.objectAt(position).toString());
                    gridPane.add(label, i, j);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
                i++;
            }
            j++;
        }

        gridPane.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/



}
