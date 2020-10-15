package se.su.dsv.inte.projektarbete.weapons;

/**
 * Interface for weapon modifiers
 * Used to create a new modifier for a weapon
 */
public abstract class WeaponModifier {

    // Instance Variables
    private String name;
    private int cost;

    // Constructor

    /**
     * Constructor for setting the base name
     * @param name String, modifier name
     */
    public WeaponModifier(String name, int cost) {

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
     * Get the modifiers values, are applied to weapon base damage
     * @return int, the base damage modification
     */
    public abstract int getBaseDamageModifier();

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
        if ( o instanceof WeaponModifier ) {
            WeaponModifier other = (WeaponModifier) o;

            return this.name.equals(other.name) && this.cost == other.cost;
        }
        else {
            return false;
        }
    }


}
