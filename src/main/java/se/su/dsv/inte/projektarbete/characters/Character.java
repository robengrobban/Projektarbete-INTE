package se.su.dsv.inte.projektarbete.characters;

import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapons.Weapon;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public abstract class Character {
    static final int DAMAGE_RANGE = 5;
    static Random rnd = new Random();
    private String name;
    private int health;
    private int baseDamage;
    private Armour armour;
    private Weapon weapon;

    /**
     * Constructor with full range of values
     * @param name String, name of Character
     * @param armour Armour, armour equipped by Character
     * @param weapon Weapon, weapon equipped by character
     */
    public Character(String name, Armour armour, Weapon weapon) {
        health = 100;
        this.name = name;
        this.armour = armour;
        this.weapon = weapon;
        this.baseDamage = weapon.getTotalDamage();
    }

    /**
     * Constructor with full range of values + custom health
     * @param name String, name of Character
     * @param armour Armour, armour equipped by Character
     * @param weapon Weapon, weapon equipped by character
     */
    public Character(String name, Armour armour, Weapon weapon, int health) {
        this.health = health;
        this.name = name;
        this.armour = armour;
        this.weapon = weapon;
        this.baseDamage = weapon.getTotalDamage();
    }

    /**
     * Constructor with no Weapon but Armour
     * @param name String, name of Character
     * @param armour Armour, armour equipped by Character
     */
    public Character(String name, Armour armour) {
        this(name, armour, null);
    }

    /**
     * Constructor with no Armour but Weapon
     * @param name String, name of Character
     * @param weapon Weapon, weapon equipped by character
     */
    public Character(String name, Weapon weapon) {
        this(name, null, weapon);
    }

    /**
     * Constructor without Armour and Weapon, damage is defined by user instead
     * @param name String, name of Character
     * @param baseDamage int, base value of damage done by Character
     */
    public Character(String name, int baseDamage) {
        this(name, null, new Weapon("Weapon", "desc", 5, 5, new HashSet<ElementType>(Collections.singletonList(ElementType.LAND)))); //TODO, NULL gav error - Zacke
        this.baseDamage = baseDamage;
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
    public int getHealth() {
        return health;
    }

    /**
     * Generates an integer value between the range of baseDamage and baseDamage + DAMAGE_RANGE
     * @return random damage value
     */
    public int CalculateDamage() {
        return rnd.nextInt(baseDamage + DAMAGE_RANGE) + baseDamage;
    }
}
