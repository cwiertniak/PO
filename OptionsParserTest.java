package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {
    @Test
    public void parserCheck(){
        Animal zwierz1 = new Animal();
        Animal zwierz2 = new Animal();
        String[] args = {"forward", "f", "e", "r", "backward", "b", "x", "right", "f", "l", "f", "left", "z"};
        List<MoveDirection> moves = OptionsParser.parse(args);

        for (MoveDirection move: moves){
            zwierz1.move(move);
        }

        zwierz2.move(MoveDirection.FORWARD);
        zwierz2.move(MoveDirection.FORWARD);
        zwierz2.move(MoveDirection.RIGHT);
        zwierz2.move(MoveDirection.BACKWARD);
        zwierz2.move(MoveDirection.BACKWARD);
        zwierz2.move(MoveDirection.RIGHT);
        zwierz2.move(MoveDirection.FORWARD);
        zwierz2.move(MoveDirection.LEFT);
        zwierz2.move(MoveDirection.FORWARD);
        zwierz2.move(MoveDirection.LEFT);

        assertEquals(zwierz1.getPosition(), zwierz2.getPosition());
        assertEquals(zwierz1.getOrientation(), zwierz2.getOrientation());
    }
}
