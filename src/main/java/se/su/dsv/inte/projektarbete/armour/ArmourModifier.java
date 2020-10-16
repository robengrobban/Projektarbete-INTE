package se.su.dsv.inte.projektarbete.armour;

import se.su.dsv.inte.projektarbete.Modifier;

/**
 * Abstract Class that represents a armour modifier.
 */
public abstract class ArmourModifier extends Modifier {

    // Constructor
    /**
     * Constructor for the modifier
     * @param name String, modifier name
     * @param cost int, modifier cost
     */
    public ArmourModifier(String name, int cost) {
        super(name, cost);
    }

    // Methods
    /**
     * Method to get the base defense modifier.
     * @return int, the defense modifier.
     */
    public abstract int getBaseDefenceModifier();

}
