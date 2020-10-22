package se.su.dsv.inte.projektarbete.player;

import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.magic.FireSpell;
import se.su.dsv.inte.projektarbete.magic.Spell;
import se.su.dsv.inte.projektarbete.quest.Quest;
import se.su.dsv.inte.projektarbete.quest.QuestManager;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Character {

    private int defence;
    private int magicalDefence;
    private int attack;
    private int magicalAttack;

    private int experience;
    private int level; //Max 20

    private QuestManager questManager;
    private PlayerClass playerClass;
    private ArrayList<Spell> spells;

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
        questManager = new QuestManager(new ArrayList<Quest>());
        playerClass = null;
        spells = new ArrayList<Spell>();
        defence = 2;
        attack = 2;
        magicalAttack= 2;
        magicalDefence = 2;
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
                  int attack, int magicalDefence, int magicalAttack, int experience, int level, Weapon weapon,
                  Armour armour, PlayerClass playerClass, ArrayList<Spell> spells) {
        super(name, armour, weapon, health, maxMana);

        this.defence = defence;
        this.attack = attack;
        this.magicalDefence = magicalDefence;
        this.magicalAttack = magicalAttack;
        this.experience = experience;
        this.level = level;
        changeCurrentHealth(-damage);
        this.playerClass = playerClass;
        questManager = new QuestManager(new ArrayList<Quest>());
        if (spells == null)
            spells = new ArrayList<Spell>();
        else
            this.spells = spells;
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

    public int getTotalAttack() {
        if (playerClass != null)
            return attack + playerClass.getAttackModifier();
        else return attack;
    }

    public int getTotalMagicAttack() {
        if (playerClass != null)
            return magicalAttack + playerClass.getMagicAttackModifier();
        else return  magicalAttack;
    }

    public int getTotalDefence() {
        if (playerClass != null)
            return defence + playerClass.getDefenceModifier();
        else return defence;
    }

    public int getTotalMagicDefence() {
        if (playerClass != null)
            return magicalDefence + playerClass.getMagicDefenceModifier();
        else return  magicalDefence;
    }

    public Spell getSpell(int index) {
        if (index < 0 || index > 10 || index > spells.size() - 1) {
            throw new IllegalArgumentException("index out of range");
        }
        return spells.get(index);
    }

    /**
     * Attacks a character with a weapon if it has one, else with base attack.
     * @param attacked
     */
    public void attack(Character attacked) {
        if (getWeapon() != null && getWeapon().usable() && getWeapon().canAttack(attacked.getElementType())) {
            attacked.hurt(getWeapon().getTotalDamage() + getTotalAttack());
            getWeapon().deteriorate();
        }
    }

    public boolean damaged(Weapon weapon) {
        super.hurt(weapon.getTotalDamage() - getTotalDefence());
        return super.isAlive();
    }

    public boolean damaged(FireSpell spell) {
        super.hurt(spell.getDamage() - getTotalMagicDefence());
        return super.isAlive();
    }

    /**
     * Adds a spell if spell list is not full (10 spells)
     * @param spell
     * @return
     */
    public boolean addSpell(Spell spell) {
        if (spells.contains(spell))
            throw new IllegalArgumentException();

        final int MAX_SPELL_COUNT = 10;
        if (spells.size() < MAX_SPELL_COUNT) {
            spells.add(spell);
            return true;
        }
        return false;
    }

    public void replaceSpell(Spell newSpell, int replacedIndex) {
        spells.set(replacedIndex, newSpell);
    }

    /**
     * Adds experience to the player. If it's enough to level up the player one or more levels, levelUp method is called.
     * @param experience Experience points to be added to the player.
     */
    public void addExperience(int experience) {
        final int LEVEL_UP_THRESHOLD = 50;
        this.experience += experience;

        if (this.experience / LEVEL_UP_THRESHOLD > this.level - 1) {
            int levelsToLevelUp = (this.experience - (this.level - 1) * LEVEL_UP_THRESHOLD) / LEVEL_UP_THRESHOLD;
            for(int i = 0; i < levelsToLevelUp; i++) {
                levelUp();
            }
        }
    }

    /**
     * Levels up the player if at max level 19, increasing level and stats.
     */
    public void levelUp() {
        final int LEVEL_CAP = 20;
        if (level < LEVEL_CAP) {
            level++;
            attack +=2;
            defence +=2;
            changeCurrentHealth(2);
        }
    }
}
