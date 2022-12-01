package agh.ics.oop;

public class Grass extends AbstractMapElement{

    private Vector2d position;

    public Grass(Vector2d initialPosition){
        this.position = initialPosition;
    }

    public Vector2d getPosition(){
        return position;
    }

    public String toString(){
        return "*";
    }

    public String getImagePath(){
        return "src/main/resources/grass.png";
    }

    public String getLabel(){
        return "Grass";
    }
}
