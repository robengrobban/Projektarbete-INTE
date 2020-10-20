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

    @Test
    void correctTileIsSet() {
        Point point = new Point(GROUND);
        assertEquals(GROUND, point.getType());
    }

    @Test
    void constructorSetsInteractableObject() {
        Point point = new Point(GROUND, CHEST);
        assertEquals(CHEST, point.getInteractableObject());
    }

    @Test
    void pointWithNoInteractableObjectThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            Point point = new Point(GROUND);
            point.getInteractableObject();
        });
    }

    @Test
    void pointWithRemovedInteractableObjectThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            Point point = new Point(GROUND, CHEST);
            point.removeIntractableObject();
            point.getInteractableObject();
        });
    }
}
