package se.su.dsv.inte.projektarbete.armour;

import se.su.dsv.inte.projektarbete.weapons.SimpleDamageModifier;

/**
 * Class that represents a simple defense modifier
 */
public class SimpleDefenceModifier extends ArmourModifier {

    // Instance Variables
    private int defenceModifier;

    // Constructors
    /**
     * Constructor maximal
     * @param name String, the name of the modifier
     * @param cost int, the cost of the modifier
     * @param defenceModifier int, the defense modifier
     */
    public SimpleDefenceModifier(String name, int cost, int defenceModifier) {
        super(name, cost);

        if ( defenceModifier == 0 ) {
            throw new IllegalArgumentException("Defense modifier cannot be zero.");
        }
        this.defenceModifier = defenceModifier;
    }

    // Methods

    /**
     * Get the value of this modifier
     * @return int, the value
     */
    @Override
    public int getValue() {
        return super.getCost() + this.defenceModifier;
    }

    /**
     * Get the defense modifier
     * @return int, the defense modifier
     */
    @Override
    public int getBaseDefenceModifier() {
        return this.defenceModifier;
    }

    /**
     * Determine if two Simple Damage Modifiers are the same
     * @param o Object, other WeaponModifier
     * @return boolean, true if they are the same and false if they are different.
     */
    @Override
    public boolean equals(Object o) {
        if ( o instanceof SimpleDefenceModifier) {
            SimpleDefenceModifier other = (SimpleDefenceModifier) o;

            return super.equals(other) && this.defenceModifier == other.defenceModifier;
        }
        else {
            return super.equals(o);
        }
    }

}
