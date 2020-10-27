package se.su.dsv.inte.projektarbete.magic;

import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.characters.Character;

import java.util.Set;

/**
 * Class that represent a fire spell
 */
public class FireSpell extends Spell {

    // Instance Variables
    private int damage;

    private Set<ElementType> canAttack;

    // Constructors
    public FireSpell(String name, String description, int range, int manaCost, int damage, Set<ElementType> canAttack) {
        super(name, description, range, manaCost);

        // Verify
        if ( damage <= 0 ) {
            throw new IllegalArgumentException("Damage must be greater than zero.");
        }
        else if ( canAttack == null || canAttack.size() == 0 ) {
            throw new IllegalArgumentException("Can Attack must be set and contain values");
        }

        this.damage = damage;
        this.canAttack = canAttack;
    }

    // Methods

    /**
     * Get the damage that this spell does
     * @return int, the damage
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * Get the elements this spell can attack
     * @return Set<ElementType>, the elements this spell can attack
     */
    public Set<ElementType> getCanAttack() {
        return this.canAttack;
    }

    /**
     * Use this spell
     * @param source Character, the source
     * @param target Character, the target
     * @return boolean, true if the spell was successfully used, and false if it was not
     */
    @Override
    public boolean use(Character source, Character target) {
        // Control that I can attack this target
        if ( isTreatable(target) ) {

            // Am I in range
            if ( isWithinRange(source, target) ) {

                // Do I have enough mana
                if ( useWithMana(source) ) {

                    // Do damage
                    target.hurtWithMagic( this.damage );

                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Can this spell attack a given target
     * @param target Character, the target
     * @return boolean, true if it can be attacked and false if it cannot
     */
    private boolean isTreatable(Character target) {
        return this.canAttack.contains(target.getElementType());
    }

}
