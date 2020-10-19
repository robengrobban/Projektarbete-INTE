package se.su.dsv.inte.projektarbete.characters;

import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapons.Weapon;

import java.util.Random;

public class Character {
    static final int DAMAGE_RANGE = 5;
    static Random rnd = new Random();
    private CharacterStateController controller;
    private String name;
    private int health;
    private int baseDamage;
    private ThreatLevel threatLevel;
    private Item loot;
    private Armour armour;
    private Weapon weapon;

    /**
     * Constructor with full range of values
     * @param name String, name of Character
     * @param state State, the starting state of Character
     * @param loot Item, items carried by Character
     * @param armour Armour, armour equipped by Character
     * @param weapon Weapon, weapon equipped by character
     */
    public Character(String name, State state, Item loot, Armour armour, Weapon weapon) {
        health = 100;
        controller = new CharacterStateController(state);
        this.name = name;
        this.loot = loot;
        this.armour = armour;
        this.weapon = weapon;
        this.baseDamage = weapon.getTotalDamage();
    }

    /**
     * Constructor with no Weapon but Armour
     * @param name String, name of Character
     * @param state State, the starting state of Character
     * @param loot Item, items carried by Character
     * @param armour Armour, armour equipped by Character
     */
    public Character(String name, State state, Item loot, Armour armour) {
        this(name, state, loot, armour, null);
    }

    /**
     * Constructor with no Armour but Weapon
     * @param name String, name of Character
     * @@param state State, the starting state of Character
     * @param loot Item, items carried by Character
     * @param weapon Weapon, weapon equipped by character
     */
    public Character(String name, State state, Item loot, Weapon weapon) {
        this(name, state, loot, null, weapon);
    }

    /**
     * Constructor without Armour and Weapon, damage is defined by user instead
     * @param name String, name of Character
     * @param state State, the starting state of Character
     * @param loot Item, items carried by Character
     * @param baseDamage int, base value of damage done by Character
     */
    public Character(String name, State state, Item loot, int baseDamage) {
        this(name, state, loot, null, null);
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

    /*public Item loot() {
        return Item;
    }*/
}
