package se.su.dsv.inte.projektarbete.characters;

import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Character {
    static final int DAMAGE_RANGE = 5;
    static final int UNARMED_DAMAGE = 5;
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int baseDamage;
    private int maxMana;
    private int currentMana;
    private Armour armour;
    private Weapon weapon;
    private ElementType elementType;

    /**
     * Constructor with full range of values
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
     * Constructor with full range of values
     * @param name String, name of Character
     * @param armour Armour, armour equipped by Character
     * @param weapon Weapon, weapon equipped by character
     */
    public Character(String name, ElementType elementType, Armour armour, Weapon weapon) {
        maxHealth = 100;
        currentHealth = maxHealth;
        maxMana = 100;
        currentMana = maxMana;
        this.name = name;
        this.armour = armour;
        this.weapon = weapon;
        this.elementType = elementType;
        if(this.weapon == null) {
            baseDamage = UNARMED_DAMAGE;
        }
        else {
            this.baseDamage = weapon.getTotalDamage();
        }
    }

    /**
     * Constructor with full range of values + custom health
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
        this.elementType = ElementType.LAND;
        // Verify max mana
        if ( maxMana < 0 ) {
            throw new IllegalArgumentException("Maximum mana cannot be negative");
        }
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    /**
     * Constructor with full range of values + custom health
     * @param name String, name of Character
     * @param armour Armour, armour equipped by Character
     * @param weapon Weapon, weapon equipped by character
     * @param health int, life of Character
     * @param maxMana int, maximum mana possible (>0)
     */
    public Character(String name, ElementType elementType, Armour armour, Weapon weapon, int health, int maxMana) {
        this(name, armour, weapon);
        this.maxHealth = health;
        this.currentHealth = health;
        this.elementType = elementType;
        // Verify max mana
        if ( maxMana < 0 ) {
            throw new IllegalArgumentException("Maximum mana cannot be negative");
        }
        this.maxMana = maxMana;
        this.currentMana = maxMana;
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
        // Control if the health is less than zero
        // TODO: DIE
        else if ( currentHealth < 0 ) {
            // I died :(

        }
    }

    /**
     * Calculates how the character is damaged by a weapon used to attack the player.
     * @param damage Damage dealt to the player.
     * @return True if still alive, else false.
     */
    public boolean damaged(int damage) {

        if (getArmour() != null) {
            int defence = getArmour().getTotalArmour();
            if (defence > damage/2) {
                defence = damage/2; //armour can protect at half the incoming damage at most.
            }
            damage -= defence;
            getArmour().deteriorate();
        }
        changeCurrentHealth(-damage);

        if (getCurrentHealth() <= 0)
            return false;
        else return true;
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
     * @return int, the current value of health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    public Armour getArmour() {
        return armour;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getBaseDamage() {
        return baseDamage;
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




}
