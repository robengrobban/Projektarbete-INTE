package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.map.Tiles.Door;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private static final int HIGHER_LIMIT = 10;
    private static final int LOWER_LIMIT = 4;

    private static final int MIN_DOOR_AMOUNT = Map.MIN_DOOR_AMOUNT;
    private static final int MAX_DOOR_AMOUNT = Map.MAX_DOOR_AMOUNT;

    private static final int MIN_INTERACTABLEOBJECT_AMOUNT = Map.MIN_INTERACTABLEOBJECT_AMOUNT;
    private static final int MAX_INTERACTABLEOBJECT_AMOUNT = Map.MAX_INTERACTABLEOBJECT_AMOUNT;

    private static class TestMap extends Map {
        public TestMap() {
            super();
        }

        ArrayList<ArrayList<Point>> getMap() {
            return map;
        }
    }

    @Test
    void randomMapCreated() {
        Map map = new Map();
        assertTrue(LOWER_LIMIT <= map.getXSize() || map.getXSize() <= HIGHER_LIMIT);
        assertTrue(LOWER_LIMIT <= map.getYSize() || map.getYSize() <= HIGHER_LIMIT);
    }

    /**
     * Checks that a map does not have to few or too many of elements
     */
    @Test
    void mapContainsCorrectComponents() {
        Map map = new Map();
        System.out.println(map.getDoorAmount());
        System.out.println(map.getInteractableObjectAmount());
        assertTrue(map.getDoorAmount() >= MIN_DOOR_AMOUNT && map.getDoorAmount() <= MAX_DOOR_AMOUNT);
        assertTrue(map.getInteractableObjectAmount() >= MIN_INTERACTABLEOBJECT_AMOUNT && map.getInteractableObjectAmount() <= MAX_INTERACTABLEOBJECT_AMOUNT);
    }

    /**
     * Checks that doors are only placed along the edge.
     */
    @Test
    void doorsOnlyPlacedAlongWall() {
        TestMap testMap = new TestMap();
        assertTrue(noDoorsWithInWall(testMap.getMap(), testMap.getXSize(), testMap.getYSize()));
    }

    private boolean noDoorsWithInWall(ArrayList<ArrayList<Point>> testMapContent, int maxX, int maxY) {
        for (ArrayList<Point> list : testMapContent) {
            for (Point point : list) {
                if (!isEdgeTile(list.indexOf(point), testMapContent.indexOf(list), maxX, maxY) && point.getType() instanceof Door) {
                    System.out.println(testMapContent.indexOf(list) + " " + list.indexOf(point));
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEdgeTile(int currentX, int currentY, int maxX, int maxY) {
        return currentX == 0 || currentY == 0 || currentX + 1 == maxX || currentY + 1 == maxY;
    }

    /**
     * Test the constructor so as the map has the correct size.
     */
    @Test
    void mapWithSpecifiedValuesIsCreated() {
        int xSize = 5;
        int ySize = 10;

        Map map = new Map(xSize, ySize);
        assertEquals(ySize, map.getYSize());
        assertEquals(xSize, map.getXSize());
    }

    /**
     * Test the constructor when specified value less than 1.
     */
    @Test
    void constructorWithSpecifiedValuesThroesExceptionWhenLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
           Map map = new Map(0, 0);
        });
    }

    /**
     * Test the constructor to ensure randomized value is within specified range.
     */
    @Test
    void mapWithValuesWithinRangeIsCreated() {
        int xMin = 2;
        int xMax = 5;
        int yMin = 3;
        int yMax = 6;

        Map map = new Map(xMin, xMax, yMin, yMax);
        assertTrue(xMin <= map.getXSize() || map.getXSize() <= xMax);
        assertTrue(yMin <= map.getYSize() || map.getYSize() <= yMax);
    }

    /**
     * Test the constructor when specified min value less than 1.
     */
    @Test
    void constructorWithRangeValuesThrowsExceptionWhenLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            int xMin = 0;
            int xMax = 2;
            int yMin = 4;
            int yMax = 6;

            Map map = new Map(xMin, xMax, yMin, yMax);
        });
    }

    /**
     * Test the constructor when min and max are equal
     */
    @Test
    void constructorWithRangeValuesThrowsExceptionWhenMinAndMaxAreEqual() {
        assertThrows(IllegalArgumentException.class, () -> {
            int xMin = 5;
            int xMax = 5;
            int yMin = 4;
            int yMax = 8;

            Map map = new Map(xMin, xMax, yMin, yMax);
        });
    }

    /**
     * Checks that all points in map are assigned the coordinates
     */
    @Test
    void pointsCorrectCoordinates() {
        TestMap map = new TestMap();

        for (ArrayList<Point> list : map.getMap()) {
            for (Point point : list) {
                assertEquals(list.indexOf(point), point.getCoordinates()[0]);
                assertEquals(map.getMap().indexOf(list), point.getCoordinates()[1]);
            }
        }
    }
}
