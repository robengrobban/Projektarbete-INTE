package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private static final int HIGHER_MAP_SIZE_LIMIT = Map.getHigherMapSizeLimit();
    private static final int LOWER_MAP_SIZE_LIMIT = Map.getLowerMapSizeLimit();

    private static final int MIN_DOOR_AMOUNT = Map.getMinDoorAmount();
    private static final int MAX_DOOR_AMOUNT = Map.getMaxDoorAmount();

    private static final int MIN_CHEST_AMOUNT = Map.getMinChestAmount();
    private static final int MAX_CHEST_AMOUNT = Map.getMaxChestAmount();

    static class TestMap extends Map {
        public TestMap() {
            super();
        }

        /**
         * @return map
         */
        List<List<MapPoint>> getMap() {
            return map;
        }

        /**
         * @return interactableObjects
         */
        List<InteractableObject> getInteractableObjects() { return interactableObjects; }

        /**
         * Sets door amount to 0.
         */
        void setDoorAmountToZero() {
            doorAmount = 0;
        }
    }

    /**
     * Checks that a random map is created within the default range.
     */
    @Test
    void randomMapCreated() {
        Map map = new Map();
        assertTrue(LOWER_MAP_SIZE_LIMIT <= map.getXSize() || map.getXSize() <= HIGHER_MAP_SIZE_LIMIT);
        assertTrue(LOWER_MAP_SIZE_LIMIT <= map.getYSize() || map.getYSize() <= HIGHER_MAP_SIZE_LIMIT);
    }

    /**
     * Checks that the last tile is assigned a door when the map otherwise does not have any doors.
     */
    @Test
    void ifDoorsUnderLimitAtLastTileADoorIsAdded() {
        TestMap testMap = new TestMap();
        testMap.setDoorAmountToZero();
        System.out.println(testMap.getDoorAmount());
        assertTrue(testMap.generateObject(0, 2, 1, 3, new MapPoint(new Ground(), 0, 2)) instanceof Door);
    }

    /**
     * Checks that a map does not have to few or too many of elements
     */
    @Test
    void mapContainsCorrectComponents() {
        Map map = new Map();
        assertTrue(map.getDoorAmount() >= MIN_DOOR_AMOUNT && map.getDoorAmount() <= MAX_DOOR_AMOUNT);
        assertTrue(map.getChestAmount() >= MIN_CHEST_AMOUNT && map.getChestAmount() <= MAX_CHEST_AMOUNT);
    }

    /**
     * Checks that doors are only placed along the edge.
     */
    @Test
    void doorsOnlyPlacedAlongWall() {
        TestMap testMap = new TestMap();
        assertTrue(noDoorsWithInWall(testMap, testMap.getXSize(), testMap.getYSize()));
    }

    private boolean noDoorsWithInWall(TestMap map, int maxX, int maxY) {
        List<InteractableObject> objects = map.getInteractableObjects();
        for (InteractableObject object : objects) {
            int x = object.getPoint().getCoordinates()[0];
            int y = object.getPoint().getCoordinates()[1];

            if (!isEdgeTile(x, y, maxX, maxY) && object instanceof Door) {
                return false;
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
}
