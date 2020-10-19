package se.su.dsv.inte.projektarbete.characters;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapons.Weapon;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Character {
    static final int DAMAGE_RANGE = 5;
    static final int UNARMED_DAMAGE = 5;
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
     */
    public Character(String name, Armour armour, Weapon weapon, int health) {
        this(name, armour, weapon);
        this.health = health;
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
