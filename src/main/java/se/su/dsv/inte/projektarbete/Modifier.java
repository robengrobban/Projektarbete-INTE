package se.su.dsv.inte.projektarbete;

import se.su.dsv.inte.projektarbete.weapons.WeaponModifier;

/**
 * Class to represent a modifier at the highest level.
 */
public abstract class Modifier {

    // Instance Variables
    private String name;
    private int cost;

    // Constructor
    /**
     * Constructor for the modifier
     * @param name String, modifier name
     * @param cost int, modifier cost
     */
    public Modifier(String name, int cost) {

        // Verify name
        if ( name == null || name.trim().equals("") ) {
            throw new IllegalArgumentException("Name needs to be set.");
        }
        // Verify cost
        else if ( cost <= 0 ) {
            throw new IllegalArgumentException("Cost need to be bigger than zero.");
        }

        this.name = name.trim();
        this.cost = cost;
    }

    // Methods
    /**
     * Get the modifier name
     * @return String, the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the cost of this modifier
     * @return
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Calculate the worth (in gold) for this modifier
     * @return int, the worth (in gold)
     */
    public int getWorth() {
        return this.cost;
    }

    /**
     * Determine if two WeaponModifiers are the same.
     * @param o Object, other WeaponModifier
     * @return boolean, true if they are the same and false if they are different.
     */
    @Override
    public boolean equals(Object o) {
        if ( o instanceof Modifier) {
            Modifier other = (Modifier) o;

            return this.name.equals(other.name) && this.cost == other.cost;
        }
        else {
            return false;
        }
    }

}
