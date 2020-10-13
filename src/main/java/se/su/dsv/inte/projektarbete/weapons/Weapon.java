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
    /**
     * Constructor with full range of values
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     * @param durability int, the current durability (0-100)
     */
    public Weapon(String name, String description, int baseDamage, int range, int durability) {

        // Verify base damage value
        if ( baseDamage <= 0 ) {
            throw new IllegalArgumentException("Base Damage cannot be less than or equal to zero.");
        }

        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
        this.range = range;
        this.durability = durability;
    }

    /**
     * Constructor with minimal range of values
     * @param name String, the name
     * @param description String, the description
     * @param baseDamage int, the base damage dealt (>0)
     * @param range int, the range of weapon (>0)
     */
    public Weapon(String name, String description, int baseDamage, int range) {
        this(name, description, baseDamage, range, 100);
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

}
