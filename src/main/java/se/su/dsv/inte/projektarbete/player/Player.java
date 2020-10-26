package se.su.dsv.inte.projektarbete.player;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.magic.Spell;
import se.su.dsv.inte.projektarbete.quest.Quest;
import se.su.dsv.inte.projektarbete.quest.QuestManager;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.ArrayList;

/**
 * Class representing a base player that is to be extended with a specific player race.
 */
public abstract class Player extends Character {

    private int defence;
    private int magicalDefence;
    private int attack;
    private int magicalAttack;

    private int experience;
    private int level; //Max 20

    private QuestManager questManager;
    private PlayerClass playerClass;
    /**
     * Race modifier used to modify physical/magic attack and defence.
     */
    private RaceModifier raceModifier;
    private ArrayList<Spell> spells;
    private int spellLimit;

    /**
     * Constructor for creating a new player with a new name.
     */
    public Player(String name, int attackMod, int magicAttackMod, int defenceMod, int magicDefenceMod) {
        super(name, null, null,10, 20);
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name must be set.");
        }
        level = 1;
        experience = 0;
        questManager = new QuestManager(new ArrayList<Quest>());
        addPlayerClass(null);
        setRaceModifier(attackMod, magicAttackMod, defenceMod, magicDefenceMod);
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
                  Armour armour, PlayerClass playerClass, ArrayList<Spell> spells,
                  int attackMod, int magicAttackMod, int defenceMod, int magicDefenceMod) {
        super(name, armour, weapon, health, maxMana);

        this.defence = defence;
        this.attack = attack;
        this.magicalDefence = magicalDefence;
        this.magicalAttack = magicalAttack;
        this.experience = experience;
        this.level = level;
        changeCurrentHealth(-damage);
        addPlayerClass(playerClass);
        setRaceModifier(attackMod, magicAttackMod, defenceMod, magicDefenceMod);
        questManager = new QuestManager(new ArrayList<Quest>());
        if (spells == null)
            this.spells = new ArrayList<Spell>();
        else
            this.spells = spells;
    }

    private void setRaceModifier(int attackMod, int magicAttackMod, int defenceMod, int magicDefenceMod) {
        raceModifier = new RaceModifier(attackMod, magicAttackMod, defenceMod, magicDefenceMod);
    }

    /**
     * Gets the total health of the player.
     * @return Total health
     */
    public int getTotalHealth() {
        return getMaxHealth();
    }

    /**
     * Gets the total attack of the player
     * @return total calculated attack.
     */
    public int getTotalAttack() {
        if (playerClass != null)
            return attack + playerClass.getAttackModifier();
        else return raceModifier.modifyAttack(attack);
    }

    /**
     * Gets the total magic attack of the player
     * @return total calculated magic attack.
     */
    public int getTotalMagicAttack() {
        if (playerClass != null)
            return magicalAttack + playerClass.getMagicAttackModifier();
        else return  raceModifier.modifyMagicAttack(magicalAttack);
    }

    /**
     * Overrides to get total defence from character with added magicDefence and defence modifyer if player
     * has a job player class.
     * @param damage Base damage dealt to the player.
     * @return Total defence for the player.
     */
    @Override
    public int getTotalDefence(int damage) {
        int defence = super.getTotalDefence(damage) + this.defence;
        if (playerClass != null)
            defence += playerClass.getDefenceModifier();
       return raceModifier.modifyDefence(defence);
    }

    /**
     * Overrides to get total magic defence from character with added magicDefence and magicdefence modifyer if player
     * has a job player class.
     * @param damage Base damage dealt to the player.
     * @return Total magic defence for the player.
     */
    @Override
    public int getTotalMagicDefence(int damage) {
        int defence = super.getTotalMagicDefence(damage) + this.magicalDefence;
        if (playerClass != null)
            defence += playerClass.getMAGIC_DEFENCE_MODIFIER();
        return raceModifier.modifyMagicDefence(defence);
    }

    /**
     * Retrieves a spell for the index if it exists.
     * @param index Index of the spell to be retrieved.
     * @return Requested spell.
     */
    public Spell getSpell(int index) {
        if (index < 0 || index > 10 || index >= spells.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        return spells.get(index);
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
     * Gets the number of spells the player has.
     * @return Number of current spells.
     */
    public int getSpellCount() {
        return spells.size();
    }

    /**
     * Attacks a character with a weapon if it has one, else with base attack.
     * @param attacked
     */
    public void attack(Character attacked) {
        if (getWeapon() != null && getWeapon().usable() && getWeapon().canAttack(attacked.getElementType()) && this.isWithinRange(attacked, getWeapon().getRange())) {
            attacked.hurt(getWeapon().getTotalDamage() + getTotalAttack());
            getWeapon().deteriorate();
        }
    }

    /**
     * Damages the player and returns if player is alive after that or not.
     * @param weapon
     * @return
     */
    public boolean damaged(Weapon weapon) {
        super.hurt(weapon.getTotalDamage());
        return super.isAlive();
    }

    /**
     * Checks if the player can use a spell based on player class.
     * @return
     */
    public boolean canUseMagic() {
        if (playerClass != null) {
            return playerClass.canUseMagic();
        }
        return false;
    }

    /**
     * Adds a player class (job - magician, warrior etc.) which modifies stats.
     * @param playerClass
     */
    public void addPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
        if (playerClass != null && playerClass.canUseMagic()) {
            spellLimit = 10;
            //:TODO - should modify the list of spells.
        }
        else if (canUseMagic()){
            spellLimit = 3;
        }
    }

    /**
     * Adds a spell if spell list is not full (10 spells)
     * @param spell
     * @return
     */
    public boolean addSpell(Spell spell) {
        if (canUseMagic())
        {
            if (spells.contains(spell))
                throw new IllegalArgumentException();

            if (spells.size() < spellLimit) {
                spells.add(spell);
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Replaces a spell with another spell at selected index.
     * @param newSpell New spell to replace the old.
     * @param replacedIndex Index for the spell to be replaced (as selected in a list with matching positions).
     */
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
