package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class RectangularMap extends AbstractWorldMap{//implements IWorldMap{
    //private int width;
    //private int height;
    //private List<Animal> animals = new LinkedList<>();

    /*public RectangularMap(int x, int y){
        this.width = x;
        this.height = y;
    }*/
    public RectangularMap(int width, int height){
        this.upBoundary = new Vector2d(width, height);
        this.lowBoundary = new Vector2d(0, 0);
    }
    /*public List<Animal> getAnimals(){
        return animals;
    }*/

    public String toString(){
        return visualizer.draw(lowBoundary, upBoundary);
    }

    public boolean canMoveTo(Vector2d position){
        return super.canMoveTo(position)&&position.follows(lowBoundary)&&position.precedes(upBoundary);
    }
    /*public void toString(IWorldMap map){
        MapVisualizer mapVis = new MapVisualizer(map);
        System.out.println(mapVis.draw(new Vector2d(0, 0), new Vector2d(width, height)));
    }*/



    /*public void add(Animal animal){
        if(place(animal)){
            animals.add(animal);
        }
    }*/

    /*public Vector2d upperRight(){
        return new Vector2d(width, height);
    }*/

    /*@Override
    public void run(List<MoveDirection> directions){
        int n = animals.size();
        for(int i = 0; i < directions.size(); i++){
            (animals.get(i % n)).move(directions.get(i));
        }
    }*/


    /*@Override
    public boolean canMoveTo(Vector2d position){
        if(isOccupied(position)){
            return false;
        }
        if(position.x >= 0 && position.x <= width && position.y >= 0 && position.y <= height){
            return true;
        }
        return false;
    }*/

    /*@Override
    public boolean place(Animal animal){
        if(hashAnimals.containsKey(animal.getPosition())){
            throw new IllegalArgumentException(animal.getPosition().toString() + " <- this position is taken");
        }
        return true;
    }*/

    /*@Override
    public boolean isOccupied(Vector2d position){
        if(hashAnimals.containsKey(position)){
            return true;
        }
        return false;
    }*/

    /*@Override
    public Object objectAt(Vector2d position){
        if(hashAnimals.containsKey(position)){
            return hashAnimals.get(position);
        }
        return null;
    }*/

}
