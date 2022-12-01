package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    //protected List<Animal> animals = new LinkedList<>();
    //protected Map<Vector2d, Animal> hashAnimals = new HashMap<>();
    //protected MapBoundary mapBoundary;
    protected Map<Vector2d, IMapElement> mapElements = new LinkedHashMap<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d upBoundary;
    protected Vector2d lowBoundary;

    /*public List<Animal> getAnimals(){
        return animals;
    }*/

    //protected abstract Vector2d upperRight();

    public Vector2d getUpBoundary(){
        return upBoundary;
    }

    public Vector2d getLowBoundary(){
        return lowBoundary;
    }

    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);
    }

    public void place(Animal animal){
        Vector2d position = animal.getPosition();
        if(canMoveTo(position)){
            mapElements.put(position, animal);
            animal.addObserver(this);
        }
        else {
            throw new IllegalArgumentException("Cannot place animal at " + position);
        }
        return;
    }

    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    public Object objectAt(Vector2d position){
        return mapElements.get(position);
    }

    /*public String toString(){
        MapVisualizer mapVis = new MapVisualizer(this);
        //return mapVis.draw(new Vector2d(0, 0), upperRight());
        return mapVis.draw(mapBoundary.getLowBoundary(), mapBoundary.getUpBoundary());
    }*/

    //@Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement current = mapElements.remove(oldPosition);
        mapElements.put(newPosition, current);
        /*Animal animal = hashAnimals.get(oldPosition);
        hashAnimals.remove(oldPosition);
        hashAnimals.put(newPosition, animal);*/
    }

    /*@Override
    public void add(Animal animal){
        if(place(animal)){
            animals.add(animal);
            hashAnimals.put(animal.getPosition(), animal);
            animal.addObserver(this.mapBoundary);
            MapBoundary.positionAdd(animal.getPosition());
        }
    }*/

    /*@Override
    public void run(List<MoveDirection> directions){
        int n = this.animals.size();
        for(int i = 0; i < directions.size(); i++){
            hashAnimals.remove(animals.get(i % n).getPosition());
            Vector2d oldPos = this.animals.get(i % n).getPosition();
            (this.animals.get(i % n)).move(directions.get(i));
            hashAnimals.put(animals.get(i % n).getPosition(), animals.get(i % n));
            (this.animals.get(i % n)).positionChanged(oldPos, animals.get(i % n).getPosition());
        }
    }*/
}
