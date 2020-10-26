package se.su.dsv.inte.projektarbete.player;

import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

public class Elf extends Player{

    /**
     * Constructor with only a name as parameter.
     * @param name
     */
    public Elf(String name) {
        super(name, 5, 10, -15, 15);
    }

    /**
     * Constructor with full values.
     * @param name Name of the elf.
     * @param health Max health of the elf
     * @param maxMana Max mana of the elf.
     * @param damage Damage done currently to the elf.
     * @param defence Base defence of the elf.
     * @param attack Base physical attack the elf has.
     * @param magicDefence Base magic defence of the elf.
     * @param magicAttack Base magic attack the elf has.
     * @param experience Current total experience the elf has.
     * @param level Current level of the elf.
     * @param armour Current armour the elf wears.
     * @param weapon Current weapon the elf holds.
     */
    public Elf(String name, int health, int maxMana, int damage,
               int defence, int attack, int magicDefence, int magicAttack, int experience, int level, Armour armour, Weapon weapon) {
        super(name, health, maxMana, damage, defence, attack, magicDefence, magicAttack, experience, level, weapon, armour,
                null, null, -5, 10, -15, 15);
    }

    /**
     * Returns if player can use magic or not. Elf can always use magic.
     * @return Always true for elf.
     */
    public boolean canUseMagic() {
        return true;
    }
}
