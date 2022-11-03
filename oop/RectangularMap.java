package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class RectangularMap implements IWorldMap{
    private int width;
    private int height;
    private List<Animal> animals = new LinkedList<>();

    public RectangularMap(int x, int y){
        this.width = x;
        this.height = y;
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public void toString(IWorldMap map){
        MapVisualizer mapvis = new MapVisualizer(map);
        System.out.println(mapvis.draw(new Vector2d(0, 0), new Vector2d(width, height)));
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(isOccupied(position)){
            return false;
        }
        if(position.x >= 0 && position.x <= width && position.y >= 0 && position.y <= height){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal){
        for(Animal a: animals){
            if(a.getPosition().equals(animal.getPosition())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        for(Animal a: animals){
            if(a.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        if(isOccupied(position)){
            for(Animal a: animals){
                if(a.getPosition().equals(position)){
                    return a.toString();
                }
            }
        }
        return null;
    }

}