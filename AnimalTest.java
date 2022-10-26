package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    public void orientationCheck(){
        Animal zwierz1 = new Animal();
        Animal zwierz2 = new Animal();

        assertEquals(zwierz1.getOrientation(), MapDirection.NORTH);
        assertEquals(zwierz2.getOrientation(), MapDirection.NORTH);

        zwierz1.move(MoveDirection.RIGHT);
        zwierz2.move(MoveDirection.LEFT);

        assertEquals(zwierz1.getOrientation(), MapDirection.EAST);
        assertEquals(zwierz2.getOrientation(), MapDirection.WEST);

        zwierz1.move(MoveDirection.RIGHT);
        zwierz2.move(MoveDirection.LEFT);

        assertEquals(zwierz1.getOrientation(), MapDirection.SOUTH);
        assertEquals(zwierz2.getOrientation(), MapDirection.SOUTH);

        zwierz1.move(MoveDirection.RIGHT);
        zwierz2.move(MoveDirection.LEFT);

        assertEquals(zwierz1.getOrientation(), MapDirection.WEST);
        assertEquals(zwierz2.getOrientation(), MapDirection.EAST);
    }

    @Test
    public void positionCheck(){
        Animal zwierz1 = new Animal();
        Animal zwierz2 = new Animal();
        Animal zwierz3 = new Animal();
        Animal zwierz4 = new Animal();

        zwierz1.move(MoveDirection.FORWARD);
        zwierz2.move(MoveDirection.BACKWARD);
        zwierz3.move(MoveDirection.RIGHT);
        zwierz3.move(MoveDirection.FORWARD);
        zwierz4.move(MoveDirection.LEFT);
        zwierz4.move(MoveDirection.FORWARD);

        assertEquals(zwierz1.getPosition().toString(), "(2,3)");
        assertEquals(zwierz2.getPosition().toString(), "(2,1)");
        assertEquals(zwierz3.getPosition().toString(), "(3,2)");
        assertEquals(zwierz4.getPosition().toString(), "(1,2)");
    }

    @Test
    public void insideMapCheck(){
        Animal zwierz1 = new Animal();

        zwierz1.move(MoveDirection.FORWARD);
        zwierz1.move(MoveDirection.FORWARD);
        zwierz1.move(MoveDirection.RIGHT);
        zwierz1.move(MoveDirection.FORWARD);
        zwierz1.move(MoveDirection.FORWARD);
        zwierz1.move(MoveDirection.FORWARD);

        assertEquals(zwierz1.getPosition().toString(), "(4,4)");

        zwierz1.move(MoveDirection.LEFT);
        zwierz1.move(MoveDirection.FORWARD);

        assertEquals(zwierz1.getPosition().toString(), "(4,4)");
    }

}
