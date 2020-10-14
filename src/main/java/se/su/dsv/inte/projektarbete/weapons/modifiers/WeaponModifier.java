package se.su.dsv.inte.projektarbete.weapons.modifiers;

/**
 * Interface for weapon modifiers
 * Used to create a new modifier for a weapon
 */
public interface WeaponModifier {

    /**
     * Get the modifiers values, are applied to weapon base damage
     * @return int, the base damage modification
     */
    int getBaseDamageModifier();

}
