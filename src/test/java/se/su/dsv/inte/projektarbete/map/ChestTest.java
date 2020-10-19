package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChestTest {
    private static final Item[] ITEMS = {/*TODO: Add items*/};
    private static final Item[] NO_ITEMS = {};

    private static final String VALID_DESCRIPTION = "a chest";
    private static final String INVALID_DESCRIPTION = null;

    @Test
    void createChestWithEmptyArray() {
        Chest chest = new Chest(ITEMS, VALID_DESCRIPTION);
        assertEquals(NO_ITEMS, chest.open());
    }

    @Test
    void createChestWithItems() {
        Chest chest = new Chest(NO_ITEMS, VALID_DESCRIPTION);
        assertEquals(ITEMS, chest.open());
    }

    @Test
    void emptyDescriptionThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
           Chest chest = new Chest(ITEMS, INVALID_DESCRIPTION);
        });
    }
}
