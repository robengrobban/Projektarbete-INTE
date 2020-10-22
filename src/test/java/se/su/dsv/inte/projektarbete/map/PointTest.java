package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.map.Tiles.TileType;

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
     * Checks that correct type and object is returned.
     */
    @Test
    void constructorSetsInteractableObject() {
        Point point = new Point(GROUND, CHEST, 0, 0);
        assertEquals(CHEST, point.getInteractableObject());
    }

    /**
     * Checks that null is returned when no object present.
     */
    @Test
    void pointWithNoInteractableObjectReturnsNull() {
        Point point = new Point(GROUND);
        assertNull(point.getInteractableObject());
    }

    /**
     * Checks that object is set to null.
     */
    @Test
    void pointWithRemovedInteractableObjectThrowsException() {
        Point point = new Point(GROUND, CHEST, 0, 0);
        point.removeIntractableObject();
        assertNull(point.getInteractableObject());
    }
}
