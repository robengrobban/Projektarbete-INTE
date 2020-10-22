package se.su.dsv.inte.projektarbete.player;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

public class Human extends Player{

    public Human(String name) {
        super(name);
    }

    public Human(String name, int health, int maxMana, int damage,
               int defence, int attack, int experience, int level, Armour armour, Weapon weapon) {
        super(name, health, maxMana, damage, defence, attack, experience, level, weapon, armour, null, null);
    }

    public boolean attacked(Weapon weapon) {
        return damaged(weapon);
    }
}
