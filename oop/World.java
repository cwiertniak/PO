package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.List;

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
        try {
            String[] dirs = {"b", "f", "b", "f", "b", "f"};
            //String[] dirs = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            //String[] dirs = {"f", "b", "f", "b"};
            //String[] dirs = {"b", "f", "b", "f", "b", "f"};
            List<MoveDirection> directions = new OptionsParser().parse(dirs);
            IWorldMap map = new GrassField(10);
            /*Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();*/
            map.add(new Animal(map));
            map.add(new Animal(map, new Vector2d(3, 4)));
            map.add(new Animal(map, new Vector2d(5, 7)));
            //map.add(new Animal(map, new Vector2d(10, 10)));
            //map.add(new Animal(map, new Vector2d(3, 4)));
            map.run(directions);
            System.out.println(map.toString());
            Application.launch(App.class, args);
        }
        catch(IllegalArgumentException ex){
            System.out.println("This process has ended due to:" + ex);
        }

        /*String[] arguments = {"r", "f", "lewo", "forward", "f", "E", "f", "f", "b", "b", "l"};
        Animal zwierz = new Animal();
        List<MoveDirection> moves = OptionsParser.parse(arguments);
        for (MoveDirection dir: moves){
            zwierz.move(dir);
        }
        System.out.println(zwierz.toString());*/
        /*Vector2d position1 = new Vector2d(1,-3);
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
        System.out.println(unitdir.toUnitVector());*/

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
