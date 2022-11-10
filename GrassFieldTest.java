package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    void moveOutOfMapCheck() {
        String[] dirs = {"l", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(dirs);
        IWorldMap map = new GrassField(3);
        Animal animal = new Animal(map, new Vector2d(0,0));
        map.add(animal);
        map.run(directions);
        assertEquals(new Vector2d(0,0), animal.getPosition());
    }

    @Test
    void moveToPositionCheck() {
        String[] dirs = {"f","r","f"};
        List<MoveDirection> directions = new OptionsParser().parse(dirs);
        IWorldMap map = new GrassField(5);
        Animal animal = new Animal(map, new Vector2d(2,2));
        map.add(animal);
        map.run(directions);
        assertEquals(new Vector2d(3,3), animal.getPosition());
    }

    @Test
    void addToOccupiedPositionCheck() {
        String[] dirs = {"f","b"};
        List<MoveDirection> directions = new OptionsParser().parse(dirs);
        IWorldMap map = new GrassField(5);
        Animal animal1 = new Animal(map, new Vector2d(4,4));
        map.add(animal1);
        Animal animal2 = new Animal(map, new Vector2d(4,4));
        map.add(animal2);
        map.run(directions);
        assertEquals(new Vector2d(4, 4), animal1.getPosition());
    }

    @Test
    void occupiedByAnimalCheck(){
        IWorldMap map = new GrassField(0);
        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.add(animal);
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(0, 0)));
    }

    @Test
    void occupiedByGrassCheck(){
        IWorldMap map = new GrassField(1);
        int count = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(map.isOccupied(new Vector2d(i, j))){
                    count++;
                }
            }
        }
        assertEquals(1, count);
    }
}
