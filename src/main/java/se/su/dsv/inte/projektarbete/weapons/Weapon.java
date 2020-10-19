package se.su.dsv.inte.projektarbete.weapons;

import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.Item;

import java.util.HashSet;

/**
 * Class to represent a weapon at the highest level.
 */
public class Weapon extends Item {

    // Instance variables
    private int baseDamage;
    private int range;
    private int durability;

    private HashSet<ElementType> canAttack;
    private WeaponModifier modifier;

    // Constructors
    /**
     * Constructor with full range of values
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     * @param canAttack HashSet<ElementType>, alla the element types that this weapon can attack
     * @param durability int, the current durability (0-100)
     * @param modifier WeaponModifier, the modifiers for this weapon
     */
    public Weapon(String name, String description, int baseDamage, int range, HashSet<ElementType> canAttack, int durability, WeaponModifier modifier) {
        super(name, description);

        // Verify base damage value
        if ( baseDamage <= 0 ) {
            throw new IllegalArgumentException("Base Damage cannot be less than or equal to zero.");
        }
        // Verify range value
        else if ( range <= 0 ) {
            throw new IllegalArgumentException("Range cannot be less than or equal to zero.");
        }
        // Verify can attack elements
        else if ( canAttack == null || canAttack.size() == 0 ) {
            throw new IllegalArgumentException("List with elements that the weapon can attack must have enum values");
        }
        // Verify durability values
        else if ( durability < 0 || durability > 100 ) {
            throw new IllegalArgumentException("Durability cannot be less than zero or greater then one hundred.");
        }

        this.baseDamage = baseDamage;
        this.range = range;
        this.canAttack = canAttack;
        this.durability = durability;
        this.modifier = modifier;
    }

    /**
     * Constructor with no modifier but durability
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     * @param canAttack HashSet<ElementType>, alla the element types that this weapon can attack
     * @param durability int, the current durability (0-100)
     */
    public Weapon(String name, String description, int baseDamage, int range, HashSet<ElementType> canAttack, int durability) {
        this(name, description, baseDamage, range, canAttack, durability, null);
    }

    /**
     * Constructor with no durability but modifier
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     * @param canAttack HashSet<ElementType>, alla the element types that this weapon can attack
     * @param modifier WeaponModifier, the modifier for that weapon
     */
    public Weapon(String name, String description, int baseDamage, int range, HashSet<ElementType> canAttack, WeaponModifier modifier) {
        this(name, description, baseDamage, range, canAttack, 100, modifier);
    }

    /**
     * Constructor with minimal range of values
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     * @param canAttack HashSet<ElementType>, alla the element types that this weapon can attack
     */
    public Weapon(String name, String description, int baseDamage, int range, HashSet<ElementType> canAttack) {
        this(name, description, baseDamage, range, canAttack, 100, null);
    }

    // Methods

    /**
     * Set modifier
     * @param modifier WeaponModifier, the modifier to set
     */
    public void setModifier(WeaponModifier modifier) {
        this.modifier = modifier;
    }

    /**
     * Get the base damage
     * @return int, the base damage
     */
    public int getBaseDamage() {
        return this.baseDamage;
    }

    /**
     * Get the range
     * @return int, the range
     */
    public int getRange() {
        return this.range;
    }

    /**
     * Get the durability
     * @return int, the durability
     */
    public int getDurability() {
        return this.durability;
    }

    /**
     * Get the element types this weapon can attack
     * @return HashSet<ElementType, the elements this weapon can attack
     */
    public HashSet<ElementType> getCanAttack() {
        return this.canAttack;
    }

    /**
     * Get the weapon modifier
     * @return WeaponModifier, the modifier
     */
    public WeaponModifier getModifier() {
        return this.modifier;
    }

    /**
     * Check if weapon can attack element type or not
     * @return boolean, true if it can be used to attack that target and false if it cannot.
     */
    public boolean canAttack(ElementType target) {
        return this.canAttack.contains(target);
    }

    /**
     * Get the total damage that this Weapon does
     * @return int, the total damage dealt by weapon
     */
    public int getTotalDamage() {
        if ( this.modifier != null ) {
            return this.modifier.calculateBaseDamageModification( this.baseDamage );
        }
        else {
            return this.baseDamage;
        }
    }

    /**
     * Calculate the value for this weapon
     * @return int, the value
     */
    @Override
    public int getValue() {
        int value = this.baseDamage + this.range + this.canAttack.size();

        if ( this.modifier != null ) {
            value += this.modifier.getValue();
        }

        // Truncation expected
        value *= durability/100.0;

        return value;
    }

    /**
     * Deteriorate the weapon
     */
    public void deteriorate() {
        if ( this.durability != 0 ) {
            durability--;
        }
    }

    /**
     * Determine if the weapon is usable or not
     * @return boolean, true if the weapon is usable or false if it is not usable
     */
    public boolean usable() {
        // If the weapon has durability, it can be used
        return this.getDurability() > 0;
    }

    /**
     * Test if two Weapons are the same or not.
     * @param o Object, the other weapon.
     * @return boolean, true if they are the same weapon and false if they are different weapons.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Weapon) {
            Weapon other = (Weapon) o;

            // Check if same Item
            boolean sameItem = super.equals(other);

            // Check if same base damage
            boolean sameBaseDamage = this.baseDamage == other.baseDamage;

            // Check if same range
            boolean sameRange = this.range == other.range;

            // Check if same durability
            boolean sameDurability = this.durability == other.durability;

            // Check if same can attack
            boolean sameCanAttack = this.canAttack.equals(other.canAttack);

            // Check if same modifier
            boolean sameModifier = (this.modifier == null && other.modifier == null) || (this.modifier.equals(other.modifier));

            return sameItem && sameBaseDamage && sameRange && sameDurability && sameCanAttack && sameModifier;
        } else {
            return false;
        }
    }


}
