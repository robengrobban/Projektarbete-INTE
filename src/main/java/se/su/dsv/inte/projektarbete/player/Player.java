package se.su.dsv.inte.projektarbete.player;

import se.su.dsv.inte.projektarbete.weapons.Weapon;

public abstract class Player {

    private String name;

    private int health;
    private int damage;

    private int stamina;
    private int staminaUsed;

    private int defence;

    private int attack;

    private int experience;
    private int level;

    /**
     * Constructor for creating a new player with a new name.
     */
    public Player(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name must be set.");
        }
        level = 1;
        experience = 0;
    }

    /**
     * Constructor for re-creating a player (i.e. from a save file)
     * @param health Health for the player
     * @param damage damage done to the player
     * @param stamina stamina for the player
     * @param staminaUsed stamina used by the player
     * @param defence defence for the player
     * @param attack attack power for the player
     * @param experience experience points the player has
     * @param level current level of the player
     */
    public Player(String name, int health, int damage, int stamina, int staminaUsed, int defence, int attack, int experience, int level) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.stamina = stamina;
        this.staminaUsed = staminaUsed;
        this.defence = defence;
        this.attack = attack;
        this.experience = experience;
        this.level = level;
    }

    /**
     * Gets the name of the player.
     * @return Player name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the total health of the player.
     * @return Total health
     */
    public int getTotalHealth() {
        return health;
    }

    /**
     * Gets the remaining health of the player that it has at the moment.
     * @return Current health points.
     */
    public int getCurrentHealth() {
        return this.health - this.damage;
    }

    /**
     * Gets the stamina the player currently has
     * @return
     */
    public int getStamina() {
        return stamina - staminaUsed;
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

    /**
     * Calculates how the player is damaged by a weapon used to attack the player.
     * @param weapon Weapon the player is attacked with.
     * @return True if still alive, else false.
     */
    public boolean attacked(Weapon weapon) {
        return true;
    }
}
