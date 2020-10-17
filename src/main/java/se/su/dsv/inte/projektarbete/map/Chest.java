package se.su.dsv.inte.projektarbete.map;

import se.su.dsv.inte.projektarbete.Item;

public class Chest extends InteractableObject {
    private final Item[] items;

    public Chest(Item[] items, String description) {
        super(description);
        this.items = items;
    }

    public Item[] open() {
        return items;
    }
}
