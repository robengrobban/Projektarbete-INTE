package se.su.dsv.inte.projektarbete.characters;

import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.map.Point;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.concurrent.ThreadLocalRandom;

public class Character {
    static final int DAMAGE_RANGE = 5;
    static final int UNARMED_DAMAGE = 5;
    static final int VISIBILITY_RANGE = 3;
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int baseDamage;
    private int maxMana;
    private int currentMana;
    private Armour armour;
    private Weapon weapon;
    private ElementType elementType;
    private Point point;

    /**
     * Constructor with basic values for name, armour and weapon.
     * @param name String, name of Character
     * @param armour Armour, armour equipped by Character
     * @param weapon Weapon, weapon equipped by character
     */
    public Character(String name, Armour armour, Weapon weapon) {
        maxHealth = 100;
        currentHealth = maxHealth;
        maxMana = 100;
        currentMana = maxMana;
        this.name = name;
        this.armour = armour;
        this.weapon = weapon;
        this.elementType = ElementType.LAND;
        if(this.weapon == null) {
            baseDamage = UNARMED_DAMAGE;
        }
        else {
            this.baseDamage = weapon.getTotalDamage();
        }
    }

    /**
     * Constructor with full range of values except life set to default.
     * @param name String, name of Character
     * @param elementType ElementType, element of the character
     * @param armour Armour, armour equipped by Character
     * @param weapon Weapon, weapon equipped by character
     */
    public Character(String name, ElementType elementType, Armour armour, Weapon weapon) {
        this(name, armour, weapon);
        this.elementType = elementType;
    }

    /**
     * Constructor with full range of values except for elementType, set to default land.
     * @param name String, name of Character
     * @param armour Armour, armour equipped by Character
     * @param weapon Weapon, weapon equipped by character
     * @param health int, life of Character
     * @param maxMana int, maximum mana possible (>0)
     */
    public Character(String name, Armour armour, Weapon weapon, int health, int maxMana) {
        this(name, armour, weapon);
        this.maxHealth = health;
        this.currentHealth = health;
        // Verify max mana
        if ( maxMana < 0 ) {
            throw new IllegalArgumentException("Maximum mana cannot be negative");
        }
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    /**
     * Constructor with full range of values
     * @param name String, name of Character
     * @param elementType ElementType, element of the character
     * @param armour Armour, armour equipped by Character
     * @param weapon Weapon, weapon equipped by character
     * @param health int, life of Character
     * @param maxMana int, maximum mana possible (>0)
     */
    public Character(String name, ElementType elementType, Armour armour, Weapon weapon, int health, int maxMana) {
        this(name, armour, weapon, health, maxMana);
        this.elementType = elementType;
    }


    /**
     * Set the point for this character
     * @param point Point, the point for this character
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     * Get the point of the Character
     * @return Point, the point of the character
     */
    public Point getPoint() {
        return this.point;
    }

    /**
     * Check if the Character is alive or not.
     * @return boolean, true if the Character is alive and false if it is not.
     */
    public boolean isAlive() {
        return currentHealth > 0;
    }

    /**
     * Get the element type of this character
     * @return ElementType, the element type
     */
    public ElementType getElementType() {
        return this.elementType;
    }

    /**
     * Set the element type of this character
     * @param elementType ElementType, the new element type
     */
    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    /**
     * Get the maximum mana
     * @return int, maximum mana
     */
    public int getMaxMana() {
        return this.maxMana;
    }

    /**
     * Get the current mana
     * @return int, the current mana
     */
    public int getCurrentMana() {
        return this.currentMana;
    }

    /**
     * Get the current health
     * @return int, the current health
     */
    public int getCurrentHealth() {
        return this.currentHealth;
    }

    /**
     * Get the name of this Character
     * @return String, the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the health value of this Character
     * @return int, the current max value of health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Gets the armour for the character
     * @return Current armour.
     */
    public Armour getArmour() {
        return armour;
    }

    /**
     * Gets the weapon for the character
     * @return Current weapon.
     */
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.baseDamage = weapon.getTotalDamage();
    }

    /**
     * Gets the base damage for the character
     * @return Current base damage.
     */
    public int getBaseDamage() {
        return baseDamage;
    }

    /**
     * Change the current mana of the character
     * @param diffMana int, the mana to be added to current
     * @return boolean, true if the mana was successfully changed, false if it was not
     */
    public boolean changeCurrentMana(int diffMana) {
        int oldCurrent = currentMana;

        currentMana += diffMana;

        // Control so that current mana is not greater than max mana
        if ( currentMana > maxMana ) {
            currentMana = maxMana;
        }
        // Control if the mana is less than zero
        else if ( currentMana < 0 ) {
            // Revert change
            currentMana = oldCurrent;

            return false;
        }
        return true;
    }

    /**
     * Change the current health of the character
     * @param diffHealth int, the health to be added to current
     */
    public void changeCurrentHealth(int diffHealth) {
        currentHealth += diffHealth;

        // Control so that the current health is not greater than max health
        if ( currentHealth > maxHealth ) {
            currentHealth = maxHealth;
        }
        // Control if the health is less than or equal to zero
        else if ( currentHealth <= 0 ) {
            // I died :(
            currentHealth = 0; // #dead
        }
    }

    /**
     * Hurts the character with damage with defence subtracted.
     * @param damage Base incoming damage.
     */
    public void hurt(int damage) {
        int defence = getTotalDefence(damage);
        damage -= defence;
        if (damage < 0) {
            damage = 0;
        }
        changeCurrentHealth(-damage);
    }

    public void hurtWithMagic(int damage) {
        int defence = getTotalMagicDefence(damage);
        damage -= defence;
        if (damage < 0) {
            damage = 0;
        }
        changeCurrentHealth(-damage);
    }

    private int getBaseDefence(int damage) {
        int defence = 0;
        if (getArmour() != null) {
            defence = getArmour().getTotalArmour();
            if (defence > damage/2) {
                defence = damage/2; //armour can protect at half the incoming damage at most.
            }
            getArmour().deteriorate();
        }
        return defence;
    }

    public int getTotalDefence(int damage) {
        return getBaseDefence(damage);
    }

    public int getTotalMagicDefence(int damage) {
        return getBaseDefence(damage);
    }

    /**
     * Generates an integer value between the range of baseDamage and baseDamage + DAMAGE_RANGE
     * @return random damage value
     */
    public int CalculateDamage() {
        int damage = ThreadLocalRandom.current().nextInt(baseDamage, baseDamage + DAMAGE_RANGE);
        System.out.println("Output damage: " + damage);
        return damage;
    }

    /**
     * @param target to check distance to from this.
     * @param range determines whether target is in within range depending on distance.
     * @return if target is with in range of this or not.
     */
    public boolean isWithinRange(Character target, int range) {
        int[] sourceCoordinates = this.point.getCoordinates();
        int[] targetCoordinates = target.point.getCoordinates();

        if (sourceCoordinates[0] == targetCoordinates[0]) {
            return Math.abs(sourceCoordinates[1] - targetCoordinates[1]) <= range;
        }
        else if (sourceCoordinates[1] == targetCoordinates[1]) {
            return Math.abs(sourceCoordinates[0] - targetCoordinates[0]) <= range;
        }
        else {
            return pythagoras(sourceCoordinates[0], sourceCoordinates[1], targetCoordinates[0], targetCoordinates[1]) <= range;
        }
    }

    /**
     * @param x1 x value of point of first point.
     * @param y1 y value of point of first point.
     * @param x2 x value of point of second point.
     * @param y2 y value of point of second point.
     * @return int, the length of the hypotenuse between the points.
     */
    private int pythagoras(int x1, int y1, int x2, int y2) {
        double a = Math.pow(Math.abs(y1 - y2), 2.0);
        double b = Math.pow(Math.abs(x1 - x2), 2.0);
        return (int) Math.sqrt(a + b);
    }
}
