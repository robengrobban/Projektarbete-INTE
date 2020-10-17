package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    private static final TileType GROUND = TileType.GROUND;

    private static final Item[] ITEMS = {};
    private static final String CHEST_DESCRIPTION = "a chest";
    private static final InteractableObject CHEST = new Chest(ITEMS, CHEST_DESCRIPTION);

    /**
     * Test the constructor so correct TileType is set on point.
     */
    @Test
    void correctTileIsSet() {
        Point point = new Point(GROUND);
        assertEquals(GROUND, point.getType());
    }

    /**
     * Test the constructor so correct InteractableObject is set on point.
     */
    @Test
    void constructorSetsInteractableObject() {
        Point point = new Point(GROUND, CHEST);
        assertEquals(CHEST, point.getInteractableObject());
    }

    /**
     * Test the constructor so a point with no interactableObject throws exception when accessed.
     */
    @Test
    void pointWithNoInteractableObjectThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            Point point = new Point(GROUND);
            point.getInteractableObject();
        });
    }

    /**
     * Test the constructor so object is removed.
     */
    @Test
    void pointWithRemovedInteractableObjectThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            Point point = new Point(GROUND, CHEST);
            point.removeIntractableObject();
            point.getInteractableObject();
        });
    }
}
