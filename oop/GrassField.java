package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{

    //private final List<Grass> grass = new LinkedList<>();
    //private final Map<Vector2d, Grass> hashGrass = new HashMap<>();
    private MapBoundary boundary = new MapBoundary();
    private int grassCount;
    private Random rand = new Random();

    public GrassField(int n){
        this.grassCount = n;
        int i = 0;
        while (i < n){
            placeGrass(null);
            i++;
        }
    }
    /*public GrassField(int n){
        placeGrass(n);
        mapBoundary = new MapBoundary((HashMap<Vector2d, Grass>) hashGrass);
    }*/

    /*@Override
    public Vector2d upperRight(){
        return getUpperRight();
    }*/

    /*private void placeGrass(int n){
        Random rand = new Random();
        int i = 0;
        while (i < n){
            Vector2d next = new Vector2d(rand.nextInt((int) sqrt(n * 10) + 1), rand.nextInt((int) sqrt(n * 10)) + 1);
            if(checkGrass(next)){
                grass.add(new Grass(next));
                hashGrass.put(next, new Grass(next));
                i++;
            }
        }
    }*/

    public void place(Animal animal){
        boundary.add(animal.getPosition());
        animal.addObserver(boundary);
        super.place(animal);
    }

    private void placeGrass(Vector2d except){
        //Random rand = new Random();
        int randBound = (int) Math.round(Math.sqrt(grassCount * 10));
        int nextX = rand.nextInt(randBound);
        int nextY = rand.nextInt(randBound);

        Vector2d grassPos = new Vector2d(nextX, nextY);
        Grass newGrass;
        while (isOccupied(grassPos) || grassPos.equals(except)){
            nextX = rand.nextInt(randBound);
            nextY = rand.nextInt(randBound);
            grassPos = new Vector2d(nextX, nextY);
        }
        grassPos = new Vector2d(nextX, nextY);
        newGrass = new Grass(grassPos);
        mapElements.put(grassPos, newGrass);
        boundary.add(grassPos);
    }

    /*public void placeTestGrass(Vector2d position){
        n++;
        if(!isOccupied(position)){
            mapElements.put(position, new Grass(position));
            boundary.add(position);
        }
        else
            throw new IllegalArgumentException("Cannot place grass at " + position);
    }*/

    public Vector2d getUpBoundary(){
        upBoundary = boundary.getUpBoundary();
        return upBoundary;
    }

    public Vector2d getLowBoundary(){
        lowBoundary = boundary.getLowBoundary();
        return lowBoundary;
    }

    public String toString(){
        upBoundary = boundary.getUpBoundary();
        lowBoundary = boundary.getLowBoundary();
        return visualizer.draw(lowBoundary, upBoundary);
    }
    /*private boolean checkGrass(Vector2d next){
        if(hashGrass.containsKey(next)){
            return false;
        }
        return true;
    }*/

    /*private Vector2d getUpperRight(){
        int xMax = 0;
        int yMax = 0;

        for(Animal a: animals){
            if(a.getPosition().x > xMax){
                xMax = a.getPosition().x;
            }
            if(a.getPosition().y > yMax){
                yMax = a.getPosition().y;
            }
        }
        for(Grass g: grass){
            if(g.getPosition().x > xMax){
                xMax = g.getPosition().x;
            }
            if(g.getPosition().y > yMax){
                yMax = g.getPosition().y;
            }
        }
        return new Vector2d(xMax, yMax);
    }*/

    /*@Override
    public boolean canMoveTo(Vector2d position){
        if(hashAnimals.containsKey(position)){
            return false;
        }
        if(position.x >= 0 && position.y >= 0 && position.x <= Integer.MAX_VALUE && position.y <= Integer.MAX_VALUE){
            return true;
        }
        return false;
    }*/
    /*@Override
    public boolean place(Animal animal){
        if(hashAnimals.containsKey(animal.getPosition())){
            //return false;
            throw new IllegalArgumentException(animal.getPosition().toString() + " <- this position is taken");
        }
        return true;
    }*/

    /*@Override
    public boolean isOccupied(Vector2d position){
        if(hashAnimals.containsKey(position)){
            return true;
        }
        if(hashGrass.containsKey(position)){
            return true;
        }
        return false;
    }*/

    /*@Override
    public Object objectAt(Vector2d position){
        if(hashAnimals.containsKey(position)){
            return hashAnimals.get(position);
        }
        if(hashGrass.containsKey(position)){
            return hashGrass.get(position);
        }
        return null;
    }*/
}
