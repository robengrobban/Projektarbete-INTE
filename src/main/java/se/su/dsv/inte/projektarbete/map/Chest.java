package se.su.dsv.inte.projektarbete.map;

import se.su.dsv.inte.projektarbete.Item;
import java.util.Arrays;

/**
 * Representing a chest containing an array of items.
 */
public class Chest extends InteractableObject {
    /**
     * The content of the chest.
     */
    private final Item[] items;

    /**
     * @param items Chest content.
     * @param description object description.
     */
    public Chest(Item[] items, String description, MapPoint mapPoint) {
        super(description, mapPoint);
        this.items = items;
    }

    /**
     * @return items.
     */
    public Item[] open() {
        Item[] tmp = items;
        Arrays.fill(items, null);
        return tmp;
    }
}
