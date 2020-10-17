package se.su.dsv.inte.projektarbete;

/**
 * Abstract Class that represents an item at the heights level.
 */
public abstract class Item {

    // Instance Variables
    private String name;
    private String description;

    // Constructors
    public Item(String name, String description) {

        // Verify name
        if ( name == null || name.trim().equals("") ) {
            throw new IllegalArgumentException("Name must be set.");
        }
        // Verify description
        else if ( description == null || description.trim().equals("") ) {
            throw new IllegalArgumentException("Description must be set.");
        }

        this.name = name.trim();
        this.description = description.trim();
    }

    // Methods

    /**
     * Get the items name
     * @return String, the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the items description
     * @return String, the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the worth of this item
     * @return int, the worth
     */
    public abstract int getValue();

    /**
     * Determine if two Items are the same.
     * @param o Object, other Item
     * @return boolean, true if they are the same and false if they are different.
     */
    @Override
    public boolean equals(Object o) {
        if ( o instanceof Item) {
            Item other = (Item) o;

            return this.name.equals(other.name) && this.description.equals(other.description);
        }
        else {
            return false;
        }
    }

}
