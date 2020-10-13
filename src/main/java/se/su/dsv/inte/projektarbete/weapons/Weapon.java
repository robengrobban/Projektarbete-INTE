package se.su.dsv.inte.projektarbete.weapons;

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

    // Constructors
    public Weapon(String name, String description, int baseDamage, int range, int durability) {

        // Check values
        if ( baseDamage <= 0 ) {
            throw new IllegalArgumentException("Base Damage cannot be less than or equal to zero.");
        }

        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
        this.range = range;
        this.durability = durability;
    }

    public Weapon(String name, String description, int baseDamage, int range) {
        this(name, description, baseDamage, range, 100);
    }

    // Methods
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public int getBaseDamage() {
        return this.baseDamage;
    }
    public int getRange() {
        return this.range;
    }
    public int getDurability() {
        return this.durability;
    }

}
