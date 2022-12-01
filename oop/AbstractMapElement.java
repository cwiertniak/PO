package agh.ics.oop;

public abstract class AbstractMapElement implements IMapElement{

    protected Vector2d position;

    public Vector2d getPosition(){
        return this.position;
    }
    public String getLabel(){
        return this.position.toString();
    }
}
