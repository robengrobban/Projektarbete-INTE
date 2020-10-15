package se.su.dsv.inte.projektarbete.weapons;

import se.su.dsv.inte.projektarbete.Modifier;

/**
 * Abstract Class that represents a weapon modifier
 */
public abstract class WeaponModifier extends Modifier {

    // Constructor
    /**
     * Constructor for the modifier
     * @param name String, modifier name
     * @param cost int, modifier cost
     */
    public WeaponModifier(String name, int cost) {
        super(name, cost);
    }

    // Methods
    /**
     * Get the modifiers values, are applied to weapon base damage
     * @return int, the base damage modification
     */
    public abstract int getBaseDamageModifier();

}
