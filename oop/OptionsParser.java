package agh.ics.oop;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static ArrayList<MoveDirection> parse(String[] args){
    //public static List<MoveDirection> parse(String[] args){
        ArrayList<MoveDirection> moves = new ArrayList<MoveDirection>();
        for (String dir: args){
            switch (dir){
                case "f" -> moves.add(MoveDirection.FORWARD);
                case "forward" -> moves.add(MoveDirection.FORWARD);
                case "b" -> moves.add(MoveDirection.BACKWARD);
                case "backward" -> moves.add(MoveDirection.BACKWARD);
                case "l" -> moves.add(MoveDirection.LEFT);
                case "left" -> moves.add(MoveDirection.LEFT);
                case "r" -> moves.add(MoveDirection.RIGHT);
                case "right" -> moves.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(dir + " is not legal move specification");
            }
        }
        return moves;
    }
}
