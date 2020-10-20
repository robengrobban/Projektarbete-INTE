package se.su.dsv.inte.projektarbete.player;

import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

public abstract class Player extends Character {

    private int defence;
    private int magicalDefence;
    private int attack;
    private int magicalAttack;

    private int experience;
    private int level;

    private PlayerClass playerClass;

    private Item[] inventory;

    /**
     * Constructor for creating a new player with a new name.
     */
    public Player(String name) {
        super(name, null, null,10, 20);
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name must be set.");
        }
        level = 1;
        experience = 0;
    }

    /**
     * Constructor for re-creating a player (i.e. from a save file)
     * @param health Health for the player
     * @param maxMana int, maximum mana for the player
     * @param defence defence for the player
     * @param attack attack power for the player
     * @param experience experience points the player has
     * @param level current level of the player
     */
    public Player(String name, int health, int maxMana, int damage, int defence,
                  int attack, int experience, int level, Weapon weapon, Armour armour) {
        super(name, armour, weapon, health, maxMana);

        this.defence = defence;
        this.attack = attack;
        this.experience = experience;
        this.level = level;
        changeCurrentHealth(-damage);
    }

    /**
     * Gets the total health of the player.
     * @return Total health
     */
    public int getTotalHealth() {
        return getMaxHealth();
    }

    /**
     * Gets the experience the player currently has.
     * @return
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Gets the level the player currently is on.
     * @return Current player level.
     */
    public int getLevel() {
        return level;
    }

    public void attack(Character attacked) {
        if (getWeapon().usable()) { //TODO: Should use "canattack, need to be implemented elementtype in enemy
            attacked.damaged(getWeapon().getTotalDamage() + attack);
            getWeapon().deteriorate();
        }
    }
}
