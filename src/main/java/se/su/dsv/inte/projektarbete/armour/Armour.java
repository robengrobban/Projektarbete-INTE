package se.su.dsv.inte.projektarbete.armour;

/**
 * Class that represents a piece of armour
 */
public class Armour {

    // Instance Variables
    private String name;
    private String description;

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

        // TODO: Verify input

        this.name = name;
        this.description = description;
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
     * Get the armour name
     * @return String, the current name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the armour description
     * @return String, the current description
     */
    public String getDescription() {
        return this.description;
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
     * Test if two pieces of armour are the same
     * @param o Object, the other object
     * @return boolean, true if the are the same and false is they are different
     */
    @Override
    public boolean equals(Object o) {
        if ( o instanceof Armour ) {
            Armour other = (Armour) o;

            // Check if same name
            boolean sameName = this.name.equals(other.name);

            // Check if same description
            boolean sameDescription = this.description.equals(other.description);

            // Check if same type
            boolean sameType = this.type.equals(other.type);

            // Check if same base defence
            boolean sameBaseDefence = this.baseDefence == other.baseDefence;

            // Check if same durability
            boolean sameDurability = this.durability == other.durability;

            // Check if same modifer
            boolean sameModifier = (this.modifier == null && other.modifier == null) || (this.modifier.equals(other.modifier));

            return sameName && sameDescription && sameType && sameBaseDefence && sameDurability && sameModifier;
        }
        else {
            return false;
        }
    }

}
