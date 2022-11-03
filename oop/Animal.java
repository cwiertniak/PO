package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public String toString(){
        return switch (this.orientation){
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
        };
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getPosition(){
        return position;
    }

    /*public boolean isAt(Vector2d position){
        return position.equals(position);
    }*/

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newposition = position.add(orientation.toUnitVector());
                if (this.map.canMoveTo(newposition)){
                    position = newposition;
                }
            }
            case BACKWARD -> {
                Vector2d newposition = position.subtract(orientation.toUnitVector());
                if (this.map.canMoveTo(newposition)){
                    position = newposition;
                }
            }

        }

    }
}
