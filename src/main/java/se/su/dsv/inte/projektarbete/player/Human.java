package se.su.dsv.inte.projektarbete.player;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

/**
 * Class representing a human player with a specific race modifier.
 */
public class Human extends Player{

    /**
     * Constructor with only a name as parameter.
     * @param name Name of the human player
     */
    public Human(String name) {
        super(name, 10, -5, 10, -5);
    }

    /**
     * Constructor with full values.
     * @param name Name of the human.
     * @param health Max health of the human
     * @param maxMana Max mana of the human.
     * @param damage Damage done currently to the human.
     * @param defence Base defence of the human.
     * @param attack Base physical attack the human has.
     * @param magicDefence Base magic defence of the human.
     * @param magicAttack Base magic attack the human has.
     * @param experience Current total experience the human has.
     * @param level Current level of the human.
     * @param armour Current armour the human wears.
     * @param weapon Current weapon the human holds.
     */
    public Human(String name, int health, int maxMana, int damage,
               int defence, int attack, int magicDefence, int magicAttack, int experience, int level, Armour armour, Weapon weapon) {
        super(name, health, maxMana, damage, defence, attack, magicDefence, magicAttack, experience, level, weapon, armour, null, null,
                10, -5, 10, -5);
    }
}
