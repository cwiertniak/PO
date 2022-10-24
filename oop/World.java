package agh.ics.oop;

public class World {

    /*static void run(Direction directions[]) {
        System.out.println("zwierzak idzie do przodu");
        for(Direction direction: directions) {
            switch (direction) {
                case FORWARD:
                    System.out.println("Do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Do tyłu");
                    break;
                case LEFT:
                    System.out.println("W lewo");
                    break;
                case RIGHT:
                    System.out.println("W prawo");
                    break;
            }
        }
    }*/
    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1,-3);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,2);
        System.out.println(position2);

        System.out.println(position1.add(position2));
        System.out.println(position1.toString());

        System.out.println(position1.follows(position2));
        System.out.println(position1.precedes(position2));

        System.out.println(position1.upperRight(position2));
        System.out.println(position1.lowerLeft(position2));

        System.out.println(position1.opposite());
        System.out.println(position1.equals(position2));
        Vector2d position3 = new Vector2d(1,-3);
        System.out.println(position1.equals(position3));

        MapDirection dir = MapDirection.SOUTH;
        MapDirection nextdir = dir.next();
        System.out.println(nextdir);

        MapDirection prevdir = dir.previous();
        System.out.println(prevdir);

        MapDirection unitdir = MapDirection.NORTH;
        System.out.println(unitdir.toUnitVector());

        /*System.out.println("system wystartował");
        int n = args.length;
        Direction[] directions = new Direction[n];
        for (int i = 0; i < n; i++) {
            switch (args[i]) {
                case "f":
                    directions[i] = Direction.FORWARD;
                    break;
                case "b":
                    directions[i] = Direction.BACKWARD;
                    break;
                case "l":
                    directions[i] = Direction.LEFT;
                    break;
                case "r":
                    directions[i] = Direction.RIGHT;
                    break;
            }
        }
        run(directions);
        System.out.println("system zakończył działanie");*/
    }
}
