package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    //static Comparator xComparator = new XComparator();
    //static Comparator yComparator = new YComparator();
    private static SortedSet<Vector2d> sortedX = new TreeSet<>(new XComparator());
    private static SortedSet<Vector2d> sortedY = new TreeSet<>(new YComparator());

    /*public MapBoundary(HashMap<Vector2d, Grass> hashGrass){
        for(Vector2d grass: hashGrass.keySet()){
            sortedX.add(grass);
            sortedY.add(grass);
        }
    }*/

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        sortedX.remove(oldPosition);
        sortedY.remove(oldPosition);
        sortedX.add(newPosition);
        sortedY.add(newPosition);
    }

    public void add(Vector2d position){
        sortedX.add(position);
        sortedY.add(position);
    }

    public void remove(Vector2d position){
        sortedX.remove(position);
        sortedY.remove(position);
    }

    public Vector2d getUpBoundary(){
        return new Vector2d(sortedX.last().x, sortedY.last().y);
        //return sortedX.last().upperRight(sortedY.last());
    }

    public Vector2d getLowBoundary(){
        return new Vector2d(sortedX.first().x, sortedY.first().y);
        //return sortedX.first().lowerLeft(sortedY.first());
    }
}
