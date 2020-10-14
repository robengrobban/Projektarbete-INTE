package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
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
