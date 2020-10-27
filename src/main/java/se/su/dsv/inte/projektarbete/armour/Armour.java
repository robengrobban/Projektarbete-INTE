package se.su.dsv.inte.projektarbete.armour;

import se.su.dsv.inte.projektarbete.Item;

/**
 * Class that represents a piece of armour
 */
public class Armour extends Item {

    // Instance Variables
    private ArmourType type;
    private int baseDefence;
    private int durability;

    private ArmourModifier modifier;

    // Constructors

    /**
     * Maximum constructor
     * @param name String, name for this armour
     * @param description String, description for this armour
     * @param type ArmourType, the type of armour.
     * @param baseDefence int, base defence for this amour (>0)
     * @param durability int, durability (0-100)
     * @param modifier ArmourModifier, modifier for this armour
     */
    public Armour(String name, String description, ArmourType type, int baseDefence, int durability, ArmourModifier modifier) {
        super(name, description);

        // Verify base defence
        if ( baseDefence <= 0 ) {
            throw new IllegalArgumentException("Base Defence cannot be less than or equal to zero.");
        }
        // Verify durability
        else if ( durability < 0 || durability > 100 ) {
            throw new IllegalArgumentException("Durability needs to be in the range (0-100)");
        }

        this.type = type;
        this.baseDefence = baseDefence;
        this.durability = durability;
        this.modifier = modifier;
    }

    /**
     * Minimal constructor
     * @param name String, name for this armour
     * @param description String, description for this armour
     * @param type ArmourType, the type of armour
     * @param baseDefence int, base defence for this armour (>0)
     */
    public Armour(String name, String description, ArmourType type, int baseDefence) {
        this(name, description, type, baseDefence, 100, null);
    }

    /**
     * Minimal constructor with durability
     * @param name String, name for this amour
     * @param description String, description for this armour
     * @param type ArmourType, the type of armour
     * @param baseDefence int, base defence for this armour (>0)
     * @param durability int, durability (0-100)
     */
    public Armour(String name, String description, ArmourType type, int baseDefence, int durability) {
        this(name, description, type, baseDefence, durability, null);
    }

    /**
     * Minimal constructor with modifier
     * @param name String, name for this armour
     * @param description String, description for this armour
     * @param type ArmourType, the type of armour
     * @param baseDefence int, base defence for this armour (>0)
     * @param modifier ArmourModifier, modifier for this armour
     */
    public Armour(String name, String description, ArmourType type, int baseDefence, ArmourModifier modifier) {
        this(name, description, type, baseDefence, 100, modifier);
    }

    // Methods

    /**
     * Set the modifier
     * @param modifier ArmourModifier, the modifier
     */
    public void setModifier(ArmourModifier modifier) {
        this.modifier = modifier;
    }

    /**
     * Remove modifier
     */
    public void removeModifier() {
        this.modifier = null;
    }

    /**
     * Get the armour type
     * @return ArmourType, the current type
     */
    public ArmourType getType() {
        return this.type;
    }

    /**
     * Get the armour base defence
     * @return int, the current base defence
     */
    public int getBaseDefence() {
        return this.baseDefence;
    }

    /**
     * Get the armour durability
     * @return int, the current durability
     */
    public int getDurability() {
        return this.durability;
    }

    /**
     * Get the armour modifier
     * @return ArmourModifier, the current modifier
     */
    public ArmourModifier getModifier() {
        return this.modifier;
    }

    /**
     * Calculate the total armour
     * @return int, the total armour
     */
    public int getTotalArmour() {
        int sum = this.modifyArmorAfterModifier( this.getBaseArmour() );

        if ( this.durability <= 50 && this.durability != 0 ) {
            sum *= 0.5;
        }
        else if ( this.durability == 0 ) {
            sum = 0;
        }

        return sum;
    }

    /**
     * Deteriorate the armour, if possible
     */
    public void deteriorate() {
        if ( this.durability != 0 ) {
            this.durability--;
        }
    }

    /**
     * Calculate the worth of the armour
     * @return int, the value
     */
    @Override
    public int getValue() {
        int sum = this.modifyValueAfterModifier(this.getBaseValue());

        // Truncation expected
        sum *= this.durability/100.0;

        return sum;
    }

    /**
     * Test if two pieces of armour are the same
     * @param o Object, the other object
     * @return boolean, true if the are the same and false is they are different
     */
    @Override
    public boolean equals(Object o) {
        if ( o instanceof Armour ) {
            Armour other = (Armour) o;

            // Check if same name
            boolean sameItem = super.equals(other);

            // Check if same type
            boolean sameType = this.type.equals(other.type);

            // Check if same base defence
            boolean sameBaseDefence = this.baseDefence == other.baseDefence;

            // Check if same durability
            boolean sameDurability = this.durability == other.durability;

            // Check if same modifer
            boolean sameModifier = (this.modifier == null && other.modifier == null) || (this.modifier.equals(other.modifier));

            return sameItem && sameType && sameBaseDefence && sameDurability && sameModifier;
        }
        else {
            return false;
        }
    }

    /**
     * Get the base value of this item
     * @return int, the base value. Will be modified
     */
    private int getBaseValue() {
        return this.baseDefence * this.type.getFactor();
    }

    /**
     * Modifies the value with regards to the weapon modifier
     * @param value int, the value to be modified
     * @return int, the modified value
     */
    private int modifyValueAfterModifier(int value) {
        if ( this.modifier != null ) {
            return value += this.modifier.getValue();
        }
        else {
            return value;
        }
    }

    /**
     * Get the base armour of this armour piece
     * @return int, the base armour. Will be modified
     */
    private int getBaseArmour() {
        return this.baseDefence * this.type.getFactor();
    }

    /**
     * Modifies the armour with regards to the armour modifier
     * @param armour int, the value to be modified
     * @return int, the modified value
     */
    private int modifyArmorAfterModifier(int armour) {
        if ( this.modifier != null ) {
            return this.modifier.calculateBaseDefenceModification(armour);
        }
        else {
            return armour;
        }
    }

}
