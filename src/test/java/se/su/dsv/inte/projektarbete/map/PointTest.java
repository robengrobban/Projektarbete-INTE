package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.map.Tiles.TileType;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    private static final TileType GROUND = new Ground();

    private static final Item[] ITEMS = {};
    private static final String CHEST_DESCRIPTION = "a chest";
    private static final InteractableObject CHEST = new Chest(ITEMS, CHEST_DESCRIPTION);

    /**
     * Checks that correct type is returned.
     */
    @Test
    void correctTileIsSet() {
        Point point = new Point(GROUND);
        assertEquals(GROUND, point.getType());
    }

    /**
     * Checks that all points in map are assigned the coordinates
     */
    @Test
    void pointsCorrectCoordinates() {
        MapTest.TestMap map = new MapTest.TestMap();

        for (ArrayList<Point> list : map.getMap()) {
            for (Point point : list) {
                assertEquals(list.indexOf(point), point.getCoordinates()[0]);
                assertEquals(map.getMap().indexOf(list), point.getCoordinates()[1]);
            }
        }
    }
}
