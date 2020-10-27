package se.su.dsv.inte.projektarbete.magic;

import se.su.dsv.inte.projektarbete.characters.Character;

/**
 * Class that represents a spell.
 */
public abstract class Spell {

    // Instance Variables
    private String name;
    private String description;

    private int range;

    private int manaCost;

    // Constructors

    /**
     * Constructor maximal
     * @param name String, spell name
     * @param description String, spell description
     * @param range int, spell range
     * @param manaCost int, mana cost of spell usage
     */
    public Spell(String name, String description, int range, int manaCost) {

        // Verify name
        if ( name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("The name must be set.");
        }
        // Verify description
        else if ( description == null || description.isEmpty()) {
            throw new IllegalArgumentException("The description must be set.");
        }
        // Verify range
        else if ( range <= 0 ) {
            throw new IllegalArgumentException("Range must be greater than zero.");
        }
        // Verify mana cost
        else if ( manaCost <= 0 ) {
            throw new IllegalArgumentException("Mana Cost must be greater than zero.");
        }

        this.name = name.trim();
        this.description = description.trim();
        this.range = range;
        this.manaCost = manaCost;
    }

    // Methods

    /**
     * Use this spell
     * @param source Character, the source
     * @param target Character, the target
     * @return boolean, true if the spell was successfully used, and false if it was not
     */
    public abstract boolean use(Character source, Character target);

    /**
     * Get spell name
     * @return String, the spell name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the spell description
     * @return String, the spell description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the spell range
     * @return int, the spell range
     */
    public int getRange() {
        return this.range;
    }

    /**
     * Get the spell mana cost
     * @return int, mana cost
     */
    public int getManaCost() {
        return this.manaCost;
    }

    /**
     * Check if two spells are equal or not to each other
     * @param o Object, the object to test towards
     * @return boolean, true if the spells are equal and false if they are not.
     */
    @Override
    public boolean equals(Object o) {
        if ( o instanceof Spell ) {
            Spell other = (Spell) o;

            // Check same name
            boolean sameName = this.name.equals(other.name);

            // Check same description
            boolean sameDescription = this.description.equals(other.description);

            // Check same range
            boolean sameRange = this.range == other.range;

            // Check same mana cost
            boolean sameManaCost = this.manaCost == other.manaCost;

            return sameName && sameDescription && sameRange && sameManaCost;
        }
        else {
            return false;
        }
    }

    /**
     * Is a target within range of a source
     * @param source Character, the source
     * @param target Character, the target
     * @return boolean, true if it is within range
     */
    protected boolean isWithinRange(Character source, Character target) {
        return source.isWithinRange(target, this.getRange());
    }

    /**
     * Use the spell with mana
     * @param source Character, the source of the spell
     * @return boolean, true if Character was able to use this spell with mana
     */
    protected boolean useWithMana(Character source) {
        return source.changeCurrentMana(-this.getManaCost());
    }

}
