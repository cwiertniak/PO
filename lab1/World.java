package agh.ics.oop;

public class World {

    static void run(Direction directions[]) {
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
    }
    public static void main(String[] args){
        System.out.println("system wystartował");

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
        System.out.println("system zakończył działanie");
    }
}
