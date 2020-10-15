package se.su.dsv.inte.projektarbete.weapons;

/**
 * Class that represents an increase in base damage
 */
public class SimpleDamageModifier extends WeaponModifier {

    // Instance variables
    private int damageModifier;

    // Constructors
    public SimpleDamageModifier(String name, int cost, int damageModifier) {
        super(name, cost);

        // Verify damage modifier
        if ( damageModifier == 0 ) {
            throw new IllegalArgumentException("Damage modifier cannot be zero.");
        }
        this.damageModifier = damageModifier;
    }

    // Methods

    /**
     * Get the modifying damage. Should be added to the base damage
     * @return int, modifying damage
     */
    @Override
    public int getBaseDamageModifier() {
        return this.damageModifier;
    }

    /**
     * Calculate the worth (in gold) for this modifier
     * @return int, the worth (in gold)
     */
    @Override
    public int getWorth() {
        return super.getCost() + this.damageModifier;
    }

    /**
     * Determine if two Simple Damage Modifiers are the same
     * @param o Object, other WeaponModifier
     * @return boolean, true if they are the same and false if they are different.
     */
    @Override
    public boolean equals(Object o) {
        if ( o instanceof SimpleDamageModifier ) {
            SimpleDamageModifier other = (SimpleDamageModifier) o;

            return super.equals(other) && this.damageModifier == other.damageModifier;
        }
        else {
            return super.equals(o);
        }
    }
}
