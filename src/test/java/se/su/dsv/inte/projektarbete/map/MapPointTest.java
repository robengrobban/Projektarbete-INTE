package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.map.Tiles.TileType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MapPointTest {
    private static final TileType GROUND = new Ground();

    private static final Item[] ITEMS = {};
    private static final String CHEST_DESCRIPTION = "a chest";
    private static final InteractableObject CHEST = new Chest(ITEMS, CHEST_DESCRIPTION, new MapPoint(new Ground(), 0, 0));

    /**
     * Checks that correct type is returned.
     */
    @Test
    void correctTileIsSet() {
        MapPoint mapPoint = new MapPoint(GROUND, 0, 0);
        assertEquals(GROUND, mapPoint.getType());
    }

    /**
     * Checks that all points in map are assigned the coordinates
     */
    @Test
    void pointsCorrectCoordinates() {
        MapTest.TestMap map = new MapTest.TestMap();

        for (List<MapPoint> list : map.getMap()) {
            for (MapPoint mapPoint : list) {
                assertEquals(list.indexOf(mapPoint), mapPoint.getCoordinates()[0]);
                assertEquals(map.getMap().indexOf(list), mapPoint.getCoordinates()[1]);
            }
        }
    }

    /**
     * Checks that an exception is thrown when type is null.
     */
    @Test
    void nullTypeThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            MapPoint mapPoint = new MapPoint(null, 0, 0);
        });
    }
}
