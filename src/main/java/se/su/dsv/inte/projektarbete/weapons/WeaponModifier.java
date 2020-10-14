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
        // TODO: Verify name och cost
        this.name = name;
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

}
