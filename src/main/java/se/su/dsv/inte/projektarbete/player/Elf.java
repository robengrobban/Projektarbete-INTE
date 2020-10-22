package se.su.dsv.inte.projektarbete.player;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

public class Elf extends Player{

    private final int PERCENT_ATTACK_MODIFIER;
    private final int PERCENT_MAGIC_ATTACK_MODIFIER;
    private final int PERCENT_DEFENCE_MODIFIER;
    private final int PERCENT_MAGIC_DEFENCE_MODIFIER;


    public Elf(String name) {
        super(name);
        PERCENT_ATTACK_MODIFIER = -5;
        PERCENT_MAGIC_ATTACK_MODIFIER = 15;
        PERCENT_DEFENCE_MODIFIER = -5;
        PERCENT_MAGIC_DEFENCE_MODIFIER = 10;
    }

    public Elf(String name, int health, int maxMana, int damage,
               int defence, int attack, int experience, int level, Armour armour, Weapon weapon) {
        super(name, health, maxMana, damage, defence, attack, experience, level, weapon, null, null,null);
        PERCENT_ATTACK_MODIFIER = -5;
        PERCENT_MAGIC_ATTACK_MODIFIER = 15;
        PERCENT_DEFENCE_MODIFIER = -5;
        PERCENT_MAGIC_DEFENCE_MODIFIER = 10;
    }

    public boolean attacked(Weapon weapon) {
        return damaged(weapon);
    }
}
