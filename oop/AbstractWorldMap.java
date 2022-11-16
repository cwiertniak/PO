package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new LinkedList<>();
    protected Map<Vector2d, Animal> hashAnimals = new HashMap<>();

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
            hashAnimals.put(animal.getPosition(), animal);
        }
    }

    @Override
    public void run(List<MoveDirection> directions){
        int n = this.animals.size();
        for(int i = 0; i < directions.size(); i++){
            hashAnimals.remove(animals.get(i % n).getPosition());
            (this.animals.get(i % n)).move(directions.get(i));
            hashAnimals.put(animals.get(i % n).getPosition(), animals.get(i % n));
        }
    }
}
