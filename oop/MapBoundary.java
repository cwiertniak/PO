package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    static Comparator xComparator = new XComparator();
    static Comparator yComparator = new YComparator();
    private static SortedSet<Vector2d> sortedX = new TreeSet<>(xComparator);
    private static SortedSet<Vector2d> sortedY = new TreeSet<>(yComparator);

    public MapBoundary(HashMap<Vector2d, Grass> hashGrass){
        for(Vector2d grass: hashGrass.keySet()){
            sortedX.add(grass);
            sortedY.add(grass);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        sortedX.remove(oldPosition);
        sortedY.remove(oldPosition);
        sortedX.add(newPosition);
        sortedY.add(newPosition);
    }

    public static void positionAdd(Vector2d position){
        sortedX.add(position);
        sortedY.add(position);
    }

    public Vector2d getUpper(){
        return new Vector2d(sortedX.last().x, sortedY.last().y);
    }

    public Vector2d getLower(){
        return new Vector2d(sortedX.first().x, sortedY.first().y);
    }
}
