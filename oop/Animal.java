package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString(){
        return (orientation.toString() + position.toString());
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
                if (newposition.x >= 0 && newposition.x <= 4 && newposition.y >= 0 && newposition.y <= 4){
                    position = newposition;
                }
            }
            case BACKWARD -> {
                Vector2d newposition = position.subtract(orientation.toUnitVector());
                if (newposition.x >= 0 && newposition.x <= 4 && newposition.y >= 0 && newposition.y <= 4){
                    position = newposition;
                }
            }

        }

    }
}
