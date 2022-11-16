package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(){
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public String toString(){
        return switch (this.orientation){
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
        };
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getPosition(){
        return position;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newposition = position.add(orientation.toUnitVector());
                if (this.map.canMoveTo(newposition)){
                    position = newposition;
                }
            }
            case BACKWARD -> {
                Vector2d newposition = position.subtract(orientation.toUnitVector());
                if (this.map.canMoveTo(newposition)){
                    position = newposition;
                }
            }
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer: this.observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
