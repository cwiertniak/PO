package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{

    private final List<Grass> grass = new LinkedList<>();
    private final Map<Vector2d, Grass> hashGrass = new HashMap<>();

    public GrassField(int n){
        placeGrass(n);
    }

    @Override
    public Vector2d upperRight(){
        return getUpperRight();
    }

    private void placeGrass(int n){
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
    }

    private boolean checkGrass(Vector2d next){
        /*for(Grass g: grass){
            if(next.equals(g.getPosition())){
                return false;
            }
        }*/
        if(hashGrass.containsKey(next)){
            return false;
        }
        return true;
    }

    private Vector2d getUpperRight(){
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
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        /*for(Animal a: animals){
            if(a.getPosition().equals(position)){
                return false;
            }
        }*/
        if(hashAnimals.containsKey(position)){
            return false;
        }
        if(position.x >= 0 && position.y >= 0 && position.x <= Integer.MAX_VALUE && position.y <= Integer.MAX_VALUE){
            return true;
        }
        return false;
    }
    @Override
    public boolean place(Animal animal){
        /*for(Animal a: animals){
            if(a.getPosition().equals(animal.getPosition())){
                return false;
            }
        }*/
        if(hashAnimals.containsKey(animal.getPosition())){
            return false;
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        /*for(Animal a: animals){
            if(a.getPosition().equals(position)){
                return true;
            }
        }
        for(Grass g: grass){
            if(g.getPosition().equals(position)){
                return true;
            }
        }*/
        if(hashAnimals.containsKey(position)){
            return true;
        }
        if(hashGrass.containsKey(position)){
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        /*for(Animal a: animals){
            if(a.getPosition().equals(position)){
                return a.toString();
            }
        }
        for(Grass g: grass){
            if(g.getPosition().equals(position)){
                return g.toString();
            }
        }*/
        if(hashAnimals.containsKey(position)){
            return hashAnimals.get(position);
        }
        if(hashGrass.containsKey(position)){
            return hashGrass.get(position);
        }
        return null;
    }
}
