package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SimulationEngine implements IEngine, Runnable{

    private ArrayList<MoveDirection> directions;
    private ArrayList<Animal> animals = new ArrayList<>();
    private App app;

    public SimulationEngine(ArrayList<MoveDirection> directions, IWorldMap map, Vector2d[] positions, App app){
        this.app = app;
        this.directions = directions;
        for(Vector2d pos: positions){
            Animal animal = new Animal(map, pos);
            map.place(animal);
            this.animals.add(animal);
        }
    }

    public void run() {
        int moveDelay = 300;
        int n = animals.size();
        int i = 0;
        Animal current = animals.get(i);
        Platform.runLater(() -> app.showMap());
        for(MoveDirection dir: directions){
            try{Thread.sleep(moveDelay);}
            catch (InterruptedException ex){System.out.println("Simulation has stopped");}
            Platform.runLater(() -> app.showMap());
            current.move(dir);
            i = ((i + 1) % n);
            current = animals.get(i);
        }
    }

    /*public void setDirections(ArrayList<MoveDirection> directions){
        this.directions = directions;
    }*/


    //private IWorldMap map;
    //private Vector2d[] positions;

    /*public SimulationEngine(List<MoveDirection> directions, IWorldMap map, Vector2d[] positions){

        this.directions = directions;
        for(Vector2d pos: positions){
            Animal animal = new Animal(map, pos);
            map.place(animal);
            this.animals.add(animal);
        }
    }*/

    /*@Override
    public void run(){
        int n = animals.size();
        int i = 0;
        Animal current = animals.get(0);
        for(MoveDirection dir: directions){
            current.move(dir);
            i = ((i + 1) % n);
            current = animals.get(i);
        }
    }*/
}
