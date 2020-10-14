package se.su.dsv.inte.projektarbete.weapons;

import se.su.dsv.inte.projektarbete.ElementType;

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

    private ElementType[] canAttackElementTypes;
    private WeaponModifier modifier;

    // Constructors
    /**
     * Constructor with full range of values
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     * @param canAttackElementTypes ElementType[], alla the element types that this weapon can attack
     * @param durability int, the current durability (0-100)
     * @param modifier WeaponModifier, the modifiers for this weapon
     */
    public Weapon(String name, String description, int baseDamage, int range, ElementType[] canAttackElementTypes, int durability, WeaponModifier modifier) {

        // TODO: Verify String name
        // TODO: Verify String description

        // Verify base damage value
        if ( baseDamage <= 0 ) {
            throw new IllegalArgumentException("Base Damage cannot be less than or equal to zero.");
        }
        // Verify range value
        else if ( range <= 0 ) {
            throw new IllegalArgumentException("Range cannot be less than or equal to zero.");
        }
        // Verify can attack elements
        else if ( canAttackElementTypes == null || canAttackElementTypes.length == 0 ) {
            throw new IllegalArgumentException("List with elements that the weapon can attack must have enum values");
        }
        // Verify durability values
        else if ( durability < 0 || durability > 100 ) {
            throw new IllegalArgumentException("Durability cannot be less than zero or greater then one hundred.");
        }

        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
        this.range = range;
        this.canAttackElementTypes = canAttackElementTypes;
        this.durability = durability;
        this.modifier = modifier;
    }

    /**
     * Constructor with no modifier but durability
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     * @param canAttackElementTypes ElementType[], alla the element types that this weapon can attack
     * @param durability int, the current durability (0-100)
     */
    public Weapon(String name, String description, int baseDamage, int range, ElementType[] canAttackElementTypes, int durability) {
        this(name, description, baseDamage, range, canAttackElementTypes, durability, null);
    }

    /**
     * Constructor with no durability but modifier
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     * @param canAttackElementTypes ElementType[], alla the element types that this weapon can attack
     * @param modifier WeaponModifier, the modifier for that weapon
     */
    public Weapon(String name, String description, int baseDamage, int range, ElementType[] canAttackElementTypes, WeaponModifier modifier) {
        this(name, description, baseDamage, range, canAttackElementTypes, 100, modifier);
    }

    /**
     * Constructor with minimal range of values
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     * @param canAttackElementTypes ElementType[], alla the element types that this weapon can attack
     */
    public Weapon(String name, String description, int baseDamage, int range, ElementType[] canAttackElementTypes) {
        this(name, description, baseDamage, range, canAttackElementTypes, 100, null);
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
     * @return ElementType[], the elements this weapon can attack
     */
    public ElementType[] getCanAttackElementTypes() {
        return this.canAttackElementTypes;
    }

    /**
     * Get the weapon modifier
     * @return WeaponModifier, the modifier
     */
    public WeaponModifier getModifier() {
        return this.modifier;
    }

}
