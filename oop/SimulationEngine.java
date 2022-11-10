package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private List<MoveDirection> directions;
    private IWorldMap map;
    private Vector2d[] positions;
    private List<Animal> animals = new LinkedList<>();

    public SimulationEngine(List<MoveDirection> directions, IWorldMap map, Vector2d[] positions){

        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for(Vector2d pos: positions){
            animals.add(new Animal(map, pos));
            map.add(new Animal(map, pos));
        }
    }

    @Override
    public void run(){
        int n = positions.length;
        for(int i = 0; i < directions.size(); i++){
            (animals.get(i % n)).move(directions.get(i));
        }
    }
}
