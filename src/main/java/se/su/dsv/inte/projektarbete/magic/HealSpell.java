package se.su.dsv.inte.projektarbete.magic;

import se.su.dsv.inte.projektarbete.characters.Character;

/**
 * Class that represents a healing spell
 */
public class HealSpell extends Spell {

    // Instance Variables
    private int healing;

    // Constructors
    /**
     * Constructor maximal
     * @param name String, spell name
     * @param description String, spell description
     * @param range int, spell range
     * @param manaCost int, mana cost of spell usage
     */
    public HealSpell(String name, String description, int range, int manaCost, int healing) {
        super(name, description, range, manaCost);

        // Verify healing
        if ( healing <= 0 ) {
            throw new IllegalArgumentException("Healing must be greater than zero.");
        }
        this.healing = healing;
    }

    // Methods

    /**
     * Get the amount of healing this healing spell does
     * @return int, the amount of healing
     */
    public int getHealing() {
        return this.healing;
    }

    /**
     * Use this spell
     * @param source Character, the source
     * @param target Character, the target
     * @return boolean, true if the spell was successfully used, and false if it was not
     */
    @Override
    public boolean use(Character source, Character target) {
        if ( source.isWithinRange(target, this.getRange()) ) {
            // Try to remove mana
            if (source.changeCurrentMana(-getManaCost())) {

                // Heal target
                target.changeCurrentHealth(this.healing);

                // Healing successful
                return true;

            }
        }
        // Was not able to use
        return false;
    }
}
