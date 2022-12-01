package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GuiElementBox {

    private ImageView imageView;
    private Label label;
    private VBox vBox;

    GuiElementBox(IMapElement element){
        try {
            createElement(element);
        }
        catch (FileNotFoundException ex){
            System.out.println("File not found: " + ex);
        }
    }

    public void createElement(IMapElement element) throws FileNotFoundException{
        Image image = new Image(new FileInputStream(element.getImagePath()));
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        label = new Label(element.getLabel());

        vBox = new VBox();
        vBox.getChildren().addAll(imageView, label);
    }

    public VBox getVBox(){
        return vBox;
    }
}
