package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ChestTest {
    private static final Item[] ITEMS = { new Weapon("Weapon", "desc", 5, 5, new HashSet<>(Collections.singletonList(ElementType.LAND))), new Armour("Medium", "desc",ArmourType.MEDIUM, 1) };
    private static final Item[] NO_ITEMS = {};
    private static final String VALID_DESCRIPTION = "a chest";
    private static final MapPoint MAP_POINT = new MapPoint(new Ground(), 0, 0);

    /**
     * Chest created containing no items, checks that empty array is returned.
     */
    @Test
    void createChestWithEmptyArray() {
        Chest chest = new Chest(NO_ITEMS, VALID_DESCRIPTION, MAP_POINT);
        assertTrue(sameItems(NO_ITEMS, chest.open()));
    }

    /**
     * Chest created contains items, checks if same weapon are returned
     */
    @Test
    void createChestWithItems() {
        Chest chest = new Chest(ITEMS, VALID_DESCRIPTION, MAP_POINT);
        assertTrue(sameItems(ITEMS, chest.open()));
    }

    /**
     * @param a first array.
     * @param b second array.
     * @return whether or not the arrays contain the same items.
     */
    private boolean sameItems(Item[] a, Item[] b) {
        if (a.length == 0 && b.length == 0)
            return true;

        int i = 0;
        for (Item item : a) {
            if (!item.equals(b[i])) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * Checks that a chest that as been opened does not contain any items.
     */
    @Test
    void openingAChestEmptiesIt() {
        Chest chest = new Chest(ITEMS, VALID_DESCRIPTION, MAP_POINT);
        chest.open();
        assertEquals(0, chest.open().length);
    }
}
