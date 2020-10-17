package se.su.dsv.inte.projektarbete.map;

import se.su.dsv.inte.projektarbete.Item;

public class Chest extends InteractableObject {
    private final Item[] items;

    /**
     * @param items Chest content.
     * @param description object description.
     */
    public Chest(Item[] items, String description) {
        super(description);
        this.items = items;
    }

    /**
     * @return items.
     */
    public Item[] open() {
        return items;
    }
}
