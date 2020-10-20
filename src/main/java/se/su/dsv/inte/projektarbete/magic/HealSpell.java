package se.su.dsv.inte.projektarbete.magic;

import se.su.dsv.inte.projektarbete.characters.Character;

/**
 * Class that represents a healing spell
 */
public class HealSpell extends Spell {

    // Instance Variables


    // Constructors

    /**
     * Constructor maximal
     * @param name String, spell name
     * @param description String, spell description
     * @param range int, spell range
     * @param manaCost int, mana cost of spell usage
     */
    public HealSpell(String name, String description, int range, int manaCost) {
        super(name, description, range, manaCost);
    }

    // Methods

    /**
     * Use this spell
     * @param source Character, the source
     * @param target Character, the target
     * @return boolean, true if the spell was successfully used, and false if it was not
     */
    @Override
    public boolean use(Character source, Character target) {
        return true;
    }
}
