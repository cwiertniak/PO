package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new LinkedList<>();

    public List<Animal> getAnimals(){
        return animals;
    }

    protected abstract Vector2d upperRight();

    public String toString(){
        MapVisualizer mapVis = new MapVisualizer(this);
        return mapVis.draw(new Vector2d(0, 0), upperRight());
    }

    @Override
    public void add(Animal animal){
        if(place(animal)){
            animals.add(animal);
        }
    }

    @Override
    public void run(List<MoveDirection> directions){
        int n = this.animals.size();
        for(int i = 0; i < directions.size(); i++){
            (this.animals.get(i % n)).move(directions.get(i));
        }
    }
}
