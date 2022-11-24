package agh.ics.oop;

import java.util.Comparator;

public class XComparator implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d a, Vector2d b){
        return a.x - b.x;
    }
}
