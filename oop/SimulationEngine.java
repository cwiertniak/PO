package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        List animals = RectangularMap.getAnimals
        for(Vector2d pos: positions){
            RectangularMap.animals.list.add(new Animal(map, pos));
        }
    }

    @Override
    public void run() {


    }
}
