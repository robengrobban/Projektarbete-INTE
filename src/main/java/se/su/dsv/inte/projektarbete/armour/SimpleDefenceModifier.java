package se.su.dsv.inte.projektarbete.armour;

/**
 * Class that represents a simple defense modifier
 */
public class SimpleDefenceModifier extends ArmourModifier {

    // Instance Variables
    private int defenseModifier;

    // Constructors
    /**
     * Constructor maximal
     * @param name String, the name of the modifier
     * @param cost int, the cost of the modifier
     * @param defenseModifier int, the defense modifier
     */
    public SimpleDefenceModifier(String name, int cost, int defenseModifier) {
        super(name, cost);

        if ( defenseModifier == 0 ) {
            throw new IllegalArgumentException("Defense modifier cannot be zero.");
        }
        this.defenseModifier = defenseModifier;
    }

    // Methods

    /**
     * Get the worth of this modifier
     * @return int, the worth
     */
    @Override
    public int getWorth() {
        return super.getWorth() + this.defenseModifier;
    }

    /**
     * Get the defense modifier
     * @return int, the defense modifier
     */
    @Override
    public int getBaseDefenseModifier() {
        return this.defenseModifier;
    }

}
