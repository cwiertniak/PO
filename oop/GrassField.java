package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{

    private final List<Grass> grass = new LinkedList<>();

    public GrassField(int n){
        placeGrass(n);
    }

    @Override
    public Vector2d upperRight(){
        return getUpperRight();
    }

    private void placeGrass(int n){
        Random rand = new Random();
        //for(int i = 0; i < n; i++){
        int i = 0;
        while (i < n){
            Vector2d next = new Vector2d(rand.nextInt((int) sqrt(n * 10) + 1), rand.nextInt((int) sqrt(n * 10)) + 1);
            if(checkGrass(next)){
                grass.add(new Grass(next));
                i++;
            }
        }
    }

    private boolean checkGrass(Vector2d next){
        for(Grass g: grass){
            if(next.equals(g.getPosition())){
                return false;
            }
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
        for(Animal a: animals){
            if(a.getPosition().equals(position)){
                return false;
            }
        }
        if(position.x >= 0 && position.y >= 0 && position.x <= Integer.MAX_VALUE && position.y <= Integer.MAX_VALUE){
            return true;
        }
        return false;
    }
    @Override
    public boolean place(Animal zwierz){
        for(Animal a: animals){
            if(a.getPosition().equals(zwierz.getPosition())){
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
        for(Grass g: grass){
            if(g.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for(Animal a: animals){
            if(a.getPosition().equals(position)){
                return a.toString();
            }
        }
        for(Grass g: grass){
            if(g.getPosition().equals(position)){
                return g.toString();
            }
        }
        return null;
    }
}
