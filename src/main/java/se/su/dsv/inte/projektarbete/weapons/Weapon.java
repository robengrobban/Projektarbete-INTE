package se.su.dsv.inte.projektarbete.weapons;

import se.su.dsv.inte.projektarbete.ElementType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Class to represent a weapon at the highest level.
 */
public class Weapon {

    // Instance variables
    private String name;
    private String description;

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
     * @param canAttack HashSet<ElementType, alla the element types that this weapon can attack
     * @param durability int, the current durability (0-100)
     * @param modifier WeaponModifier, the modifiers for this weapon
     */
    public Weapon(String name, String description, int baseDamage, int range, HashSet<ElementType> canAttack, int durability, WeaponModifier modifier) {

        // Verify name
        if ( name == null || name.trim().equals("") ) {
            throw new IllegalArgumentException("Name must be set.");
        }
        // Verify description
        else if ( description == null || description.trim().equals("") ) {
            throw new IllegalArgumentException("Description must be set.");
        }
        // Verify base damage value
        else if ( baseDamage <= 0 ) {
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

        this.name = name.trim();
        this.description = description.trim();
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
     * @param canAttack HashSet<ElementType, alla the element types that this weapon can attack
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
     * @param canAttack HashSet<ElementType, alla the element types that this weapon can attack
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
     * @param canAttack HashSet<ElementType, alla the element types that this weapon can attack
     */
    public Weapon(String name, String description, int baseDamage, int range, HashSet<ElementType> canAttack) {
        this(name, description, baseDamage, range, canAttack, 100, null);
    }


    // Methods
    /**
     * Get weapon name
     * @return String, the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get weapon description
     * @return String, the description
     */
    public String getDescription() {
        return this.description;
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
     * Test if two Weapons are the same or not.
     * @param o Object, the other weapon.
     * @return boolean, true if they are the same weapon and false if they are different weapons.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Weapon) {
            Weapon other = (Weapon) o;

            // Check if same name
            boolean sameName = this.name.equals(other.name);

            // Check if same description
            boolean sameDescription = this.description.equals(other.description);

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

            return sameName && sameDescription && sameBaseDamage && sameRange && sameDurability && sameCanAttack && sameModifier;
        } else {
            return false;
        }
    }


}
